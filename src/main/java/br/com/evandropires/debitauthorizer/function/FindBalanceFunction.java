package br.com.evandropires.debitauthorizer.function;

import com.google.gson.JsonObject;

import java.math.BigDecimal;

/**
 * Created by evandro on 11/11/2018.
 */
public class FindBalanceFunction {
	public static JsonObject main(JsonObject params) {
		Integer agency = params.get("agency").getAsInt();
		Integer account = params.get("account").getAsInt();

		JsonObject response = new JsonObject();
		response.addProperty("agency", agency);
		response.addProperty("account", account);
		response.addProperty("name", "John Cena");
		response.addProperty("status", "ACTIVE");
		response.addProperty("balance", new BigDecimal(100));
		return response;
	}

}
