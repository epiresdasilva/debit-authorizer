const composer = require('@ibm-functions/composer')

module.exports = composer.if(
        composer.sequence(
          composer.action('credit-card-online-debit-dev-findCreditCard'),
          params => { params.value = params.status === 'ACTIVE' }
        ),
        composer.if(
          composer.sequence(
              composer.merge(
                params => { params.debitValue},
                composer.action('credit-card-online-debit-dev-findBalance'),
              ),
              params => { params.value = params.balance - params.debitValue >= 0 }
          ),
          composer.action('credit-card-online-debit-dev-provisionalDebit'),
          params => { params.message = 'failure'}
        ),
        params => { params.message = 'failure' }
    )
