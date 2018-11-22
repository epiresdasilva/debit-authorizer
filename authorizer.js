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
            composer.async(
                composer.action('debitauthorizer/provisionalDebit'),
                composer.function(({ agency, account, debitValue, id }) => ({ value: "{\"agency\": "+agency+", \"account\": "+account+", \"debitValue\": "+debitValue+", \"id\": "+id+" }" })),
                composer.action('EventStreams/messageHubProduce')
            ),
            params => { params.message = 'failure'}
        ),
        params => { params.message = 'failure' }
    )
)


