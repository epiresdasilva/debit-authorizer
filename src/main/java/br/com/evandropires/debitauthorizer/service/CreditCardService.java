package br.com.evandropires.debitauthorizer.service;

import br.com.evandropires.debitauthorizer.entity.DebitCardEntity;
import com.google.gson.JsonObject;

/**
 * Created by evandro on 14/11/2018.
 */
public class CreditCardService {

	private CreditCardProvider provider;

	public CreditCardService(CreditCardProvider provider) {
		this.provider = provider;
	}

	public JsonObject findCreditCard(Long cardNumber) {
		DebitCardEntity debitCard = provider.getCreditCardDAO().findCreditCard(cardNumber);
		if (debitCard == null) {
			return null;
		}
		JsonObject response = new JsonObject();
		response.addProperty("agency", debitCard.getAgency());
		response.addProperty("account", debitCard.getAccountNumber());
		response.addProperty("cardNumber", debitCard.getCardnumber());
		response.addProperty("status", debitCard.getStatus().name());
		return response;
	}

}
