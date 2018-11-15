package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.CreditCardDAO;
import com.google.gson.JsonObject;

/**
 * Created by evandro on 14/11/2018.
 */
public class CreditCardDAOImpl implements CreditCardDAO {

	@Override
	public JsonObject findCreditCard(String cardNumber) {
		JsonObject response = new JsonObject();
		response.addProperty("agency", 123);
		response.addProperty("account", 456);
		response.addProperty("cardNumber", cardNumber);
		response.addProperty("status", "ACTIVE");
		return response;
	}
}
