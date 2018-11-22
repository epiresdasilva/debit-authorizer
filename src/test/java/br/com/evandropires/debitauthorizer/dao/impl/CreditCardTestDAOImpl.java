package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.CreditCardDAO;
import br.com.evandropires.debitauthorizer.jooq.tables.records.DebitcardRecord;

import java.math.BigDecimal;

/**
 * Created by evandro on 14/11/2018.
 */
public class CreditCardTestDAOImpl implements CreditCardDAO {

	@Override
	public DebitcardRecord findCreditCard(Long cardNumber) {
		if (cardNumber == 888888L) {
			DebitcardRecord debitcardRecord = new DebitcardRecord();
			debitcardRecord.setAgency(888);
			debitcardRecord.setAccount(888);
			debitcardRecord.setCardnumber(new BigDecimal(cardNumber));
			debitcardRecord.setStatus("INACTIVE");
			return debitcardRecord;
		} else if (cardNumber != 123456L) {
			return null;
		}
		DebitcardRecord debitcardRecord = new DebitcardRecord();
		debitcardRecord.setAgency(123);
		debitcardRecord.setAccount(456);
		debitcardRecord.setCardnumber(new BigDecimal(cardNumber));
		debitcardRecord.setStatus("ACTIVE");
		return debitcardRecord;
	}
}
