package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.BalanceDAO;
import com.google.gson.JsonObject;

import java.math.BigDecimal;

/**
 * Created by evandro on 14/11/2018.
 */
public class BalanceDAOImpl implements BalanceDAO {

	@Override
	public JsonObject findBalance(Integer agency, Integer account) {
		JsonObject response = new JsonObject();
		response.addProperty("agency", agency);
		response.addProperty("account", account);
		response.addProperty("name", "John Cena");
		response.addProperty("status", "ACTIVE");
		response.addProperty("balance", new BigDecimal(100));
		return response;
	}

	@Override
	public void provisionalDebit(Integer agency, Integer account, BigDecimal debitValue) {
		//TODO
	}
}
