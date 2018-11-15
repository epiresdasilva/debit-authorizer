package br.com.evandropires.debitauthorizer.function;

import com.google.gson.JsonObject;

/**
 * Created by evandro on 11/11/2018.
 */
public class FindCreditCardFunction {
	public static JsonObject main(JsonObject params) {
		String cardNumber = params.get("cardNumber").getAsString();

		JsonObject response = new JsonObject();
		response.addProperty("agency", 123);
		response.addProperty("account", 456);
		response.addProperty("cardNumber", cardNumber);
		response.addProperty("status", "ACTIVE");
		return response;
	}

}
