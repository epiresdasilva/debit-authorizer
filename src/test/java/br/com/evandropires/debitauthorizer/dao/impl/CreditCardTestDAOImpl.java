package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.CreditCardDAO;
import br.com.evandropires.debitauthorizer.entity.DebitCardEntity;

/**
 * Created by evandro on 14/11/2018.
 */
public class CreditCardTestDAOImpl implements CreditCardDAO {

	@Override
	public DebitCardEntity findCreditCard(Long cardNumber) {
		if (cardNumber == 888888L) {
			DebitCardEntity debitcardRecord = new DebitCardEntity();
			debitcardRecord.setAgency(888);
			debitcardRecord.setAccountNumber(888);
			debitcardRecord.setCardnumber(cardNumber.intValue());
			debitcardRecord.setStatus(DebitCardEntity.DebitCardStatus.INACTIVE);
			return debitcardRecord;
		} else if (cardNumber != 123456L) {
			return null;
		}
		DebitCardEntity debitcardRecord = new DebitCardEntity();
		debitcardRecord.setAgency(123);
		debitcardRecord.setAccountNumber(456);
		debitcardRecord.setCardnumber(cardNumber.intValue());
		debitcardRecord.setStatus(DebitCardEntity.DebitCardStatus.ACTIVE);
		return debitcardRecord;
	}
}
