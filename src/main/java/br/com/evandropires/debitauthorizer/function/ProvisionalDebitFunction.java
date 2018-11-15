package br.com.evandropires.debitauthorizer.function;

import com.google.gson.JsonObject;

import java.math.BigDecimal;

/**
 * Created by evandro on 11/11/2018.
 */
public class ProvisionalDebitFunction {
	public static JsonObject main(JsonObject params) {
		Integer agency = params.get("agency").getAsInt();
		Integer account = params.get("account").getAsInt();
		BigDecimal debitValue = params.get("debitValue").getAsBigDecimal();

		JsonObject response = new JsonObject();
		response.addProperty("agency", agency);
		response.addProperty("account", account);
		response.addProperty("debitValue", debitValue);
		return response;
	}

}
