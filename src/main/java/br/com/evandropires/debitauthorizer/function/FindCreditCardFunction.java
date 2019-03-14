package br.com.evandropires.debitauthorizer.function;

import br.com.evandropires.debitauthorizer.service.CreditCardProvider;
import br.com.evandropires.debitauthorizer.service.CreditCardService;
import com.google.gson.JsonObject;

/**
 * Created by evandro on 11/11/2018.
 */
public class FindCreditCardFunction {
	public static JsonObject main(JsonObject params) {
		Long cardNumber = params.get("cardNumber").getAsLong();
		CreditCardProvider creditCardProvider = new CreditCardProvider();
		return new CreditCardService(creditCardProvider).findCreditCard(cardNumber);
	}

	public static void main(String[] args) {
		JsonObject payload = new JsonObject();
		payload.addProperty("cardNumber", 123456);
		System.out.print(new FindCreditCardFunction().main(payload));
	}
}
