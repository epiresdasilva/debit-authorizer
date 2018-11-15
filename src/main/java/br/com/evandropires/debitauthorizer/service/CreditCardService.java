package br.com.evandropires.debitauthorizer.service;

import com.google.gson.JsonObject;

/**
 * Created by evandro on 14/11/2018.
 */
public class CreditCardService {

	private CreditCardProvider provider;

	public CreditCardService(CreditCardProvider provider) {
		this.provider = provider;
	}

	public JsonObject findCreditCard(String cardNumber) {
		return provider.getCreditCardDAO().findCreditCard(cardNumber);
	}

}
