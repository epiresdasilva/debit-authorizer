package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.CreditCardDAO;
import br.com.evandropires.debitauthorizer.model.DebitCard;
import br.com.evandropires.debitauthorizer.util.BaseTestUtil;
import org.javalite.activejdbc.Base;

/**
 * Created by evandro on 14/11/2018.
 */
public class CreditCardTestDAOImpl implements CreditCardDAO {

	@Override
	public DebitCard findCreditCard(Long cardNumber) {
		try {
			BaseTestUtil.open();
			if (cardNumber == 888888L) {
				return new DebitCard().setInteger("agency", 888)
						.setInteger("account", 888)
						.setLong("cardnumber", cardNumber)
						.setString("status", "INACTIVE");
			} else if (cardNumber != 123456L) {
				return null;
			}
			return new DebitCard().setInteger("agency", 123)
					.setInteger("account", 456)
					.setLong("cardnumber", cardNumber)
					.setString("status", "ACTIVE");
		} finally {
			Base.close();
		}
	}
}
