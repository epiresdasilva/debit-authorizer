package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.CreditCardDAO;
import br.com.evandropires.debitauthorizer.model.DebitCard;
import org.javalite.activejdbc.Base;

/**
 * Created by evandro on 14/11/2018.
 */
public class CreditCardDAOImpl implements CreditCardDAO {

	@Override
	public DebitCard findCreditCard(Long cardNumber) {
		Base.open();
		DebitCard debitCard = DebitCard.findFirst("cardnumber = ?", cardNumber);
		if (debitCard == null) {
			return null;
		}
		Base.close();
		return debitCard;
	}
}
