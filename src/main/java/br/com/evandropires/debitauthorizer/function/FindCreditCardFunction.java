package br.com.evandropires.debitauthorizer.function;

import br.com.evandropires.debitauthorizer.dao.impl.CreditCardDAOImpl;
import br.com.evandropires.debitauthorizer.service.CreditCardProvider;
import br.com.evandropires.debitauthorizer.service.CreditCardService;
import com.google.gson.JsonObject;

/**
 * Created by evandro on 11/11/2018.
 */
public class FindCreditCardFunction {
	public static JsonObject main(JsonObject params) {
		String cardNumber = params.get("cardNumber").getAsString();

		CreditCardProvider creditCardProvider = new CreditCardProvider();
		creditCardProvider.setCreditCardDAO(new CreditCardDAOImpl());
		return new CreditCardService(creditCardProvider).findCreditCard(cardNumber);
	}

}
