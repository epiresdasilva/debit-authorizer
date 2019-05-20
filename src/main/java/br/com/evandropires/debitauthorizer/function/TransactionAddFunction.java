package br.com.evandropires.debitauthorizer.function;

import br.com.evandropires.debitauthorizer.service.TransactionProvider;
import br.com.evandropires.debitauthorizer.service.TransactionService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.math.BigDecimal;
import java.util.Iterator;

/**
 * Created by evandro on 11/11/2018.
 */
public class TransactionAddFunction {
	public static JsonObject main(JsonObject params) {
		TransactionProvider transactionProvider = new TransactionProvider();
		TransactionService transactionService = new TransactionService(transactionProvider);
		Integer agency = params.get("agency").getAsInt();
		Integer account = params.get("account").getAsInt();
		BigDecimal debitValue = params.get("debitValue").getAsBigDecimal();
		transactionService.addTransaction(agency, account, debitValue);
		return params;
	}
}
