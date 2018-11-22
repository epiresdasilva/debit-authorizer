package br.com.evandropires.debitauthorizer.dao;

import br.com.evandropires.debitauthorizer.jooq.tables.records.DebitcardRecord;

/**
 * Created by evandro on 14/11/2018.
 */
public interface CreditCardDAO {

	DebitcardRecord findCreditCard(Long cardNumber);
}
