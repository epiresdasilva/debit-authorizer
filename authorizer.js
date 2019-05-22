const composer = require('@ibm-functions/composer')

module.exports = composer.sequence(
    composer.merge(
        params => { params.debitValue },
        composer.action('debitauthorizer/findCreditCard')
    ),
    composer.if(
        params => { params.value = params.status === 'ACTIVE' },
        composer.if(
            composer.sequence(
                composer.merge(
                    params => { params.debitValue},
                    composer.action('debitauthorizer/findBalance'),
                ),
                params => { params.value = params.balance - params.debitValue >= 0 }
            ),
            composer.sequence(
                composer.action('debitauthorizer/provisionalDebit'),
                composer.async(
                    'debitauthorizer/transactionAdd',
                    'debitauthorizer/provisionalDebitRegister',
                    params => { params.operationValue = params.debitValue*-1 },
                    'debitauthorizer/balanceOperation'
                ),
                params => { params.message = 'AUTHORIZED'}
            ),
            params => { params.message = 'NON AUTHORIZED'}
        ),
        params => { params.message = 'NON AUTHORIZED' }
    )
)


