const composer = require('@ibm-functions/composer')

module.exports = composer.merge(
    'debitauthorizer/findBalance',
    'debitauthorizer/provisionalDebitSumPending',
    params => { params.balance = params.balance - params.sum }
)


