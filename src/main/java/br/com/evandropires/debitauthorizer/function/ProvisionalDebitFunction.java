package br.com.evandropires.debitauthorizer.function;

import br.com.evandropires.debitauthorizer.dao.impl.BalanceDAOImpl;
import br.com.evandropires.debitauthorizer.service.BalanceProvider;
import br.com.evandropires.debitauthorizer.service.BalanceService;
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

		BalanceProvider balanceProvider = new BalanceProvider();
		balanceProvider.setBalanceDAO(new BalanceDAOImpl());
		new BalanceService(balanceProvider).provisionalDebit(agency, account, debitValue);

		return params;
	}

}
