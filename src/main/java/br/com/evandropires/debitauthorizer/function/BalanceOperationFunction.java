package br.com.evandropires.debitauthorizer.function;

import br.com.evandropires.debitauthorizer.service.BalanceProvider;
import br.com.evandropires.debitauthorizer.service.BalanceService;
import com.google.gson.JsonObject;

import java.math.BigDecimal;

/**
 * Created by evandro on 11/11/2018.
 */
public class BalanceOperationFunction {

	public static JsonObject main(JsonObject params) {
		Integer agency = params.get("agency").getAsInt();
		Integer account = params.get("account").getAsInt();
		BigDecimal operationValue = params.get("operationValue").getAsBigDecimal();
		BalanceProvider balanceProvider = new BalanceProvider();
		new BalanceService(balanceProvider).updateBalance(agency, account, operationValue);
		return params;
	}

	public static void main(String[] args) {
		JsonObject payload = new JsonObject();
		payload.addProperty("agency", 111);
		payload.addProperty("account", 123);
		payload.addProperty("operationValue", new BigDecimal(-2));
		System.out.print(new BalanceOperationFunction().main(payload));
	}
}
