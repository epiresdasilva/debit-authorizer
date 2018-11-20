package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.CreditCardDAO;
import br.com.evandropires.debitauthorizer.model.DebitCard;
import com.google.gson.JsonObject;
import org.javalite.activejdbc.Base;

/**
 * Created by evandro on 14/11/2018.
 */
public class CreditCardDAOImpl implements CreditCardDAO {

	@Override
	public JsonObject findCreditCard(Long cardNumber) {
		Base.open();

		DebitCard debitCard = DebitCard.findFirst("cardnumber = ?", cardNumber);
		if (debitCard == null) {
			return null;
		}

		JsonObject response = new JsonObject();
		response.addProperty("agency", debitCard.getAgency());
		response.addProperty("account", debitCard.getAccount());
		response.addProperty("cardNumber", debitCard.getCardNumber());
		response.addProperty("status", debitCard.getStatus());

		Base.close();

		return response;
	}
}
