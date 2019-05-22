package br.com.evandropires.debitauthorizer.function;

import br.com.evandropires.debitauthorizer.service.ProvisionalDebitProvider;
import br.com.evandropires.debitauthorizer.service.ProvisionalDebitService;
import com.google.gson.JsonObject;

import java.math.BigDecimal;

/**
 * Created by evandro on 11/11/2018.
 */
public class ProvisionalDebitSumPendingFunction {
	public static JsonObject main(JsonObject params) {
		Integer agency = params.get("agency").getAsInt();
		Integer account = params.get("account").getAsInt();
		ProvisionalDebitProvider provisionalDebitProvider = new ProvisionalDebitProvider();
		BigDecimal sum = new ProvisionalDebitService(provisionalDebitProvider).sumPendingDebits(agency, account);
		params.addProperty("sum", sum);
		return params;
	}

	public static void main(String[] args) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("agency", "111");
		jsonObject.addProperty("account", "123");
		System.out.println(new ProvisionalDebitSumPendingFunction().main(jsonObject));
	}

}
