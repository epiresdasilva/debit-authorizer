const composer = require('@ibm-functions/composer')

module.exports = composer.sequence(
    composer.merge(
        params => { params.debitValue },
        composer.action('debitauthorizer-dev-findCreditCard')
    ),
    composer.if(
        params => { params.value = params.status === 'ACTIVE' },
        composer.if(
            composer.sequence(
                composer.merge(
                    params => { params.debitValue},
                    composer.action('debitauthorizer-dev-findBalance'),
                ),
                params => { params.value = params.balance - params.debitValue >= 0 }
            ),
            composer.action('debitauthorizer-dev-provisionalDebit'),
            params => { params.message = 'failure'}
        ),
        params => { params.message = 'failure' }
    )
)


