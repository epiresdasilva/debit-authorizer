package br.com.evandropires.debitauthorizer.service;

import br.com.evandropires.debitauthorizer.model.Account;
import br.com.evandropires.debitauthorizer.model.Balance;
import com.google.gson.JsonObject;

/**
 * Created by evandro on 14/11/2018.
 */
public class BalanceService {

	private BalanceProvider provider;

	public BalanceService(BalanceProvider provider) {
		this.provider = provider;
	}

	public JsonObject findBalance(Integer agency, Integer accountNumber) {
		Account account = provider.getAccountService().findAccount(agency, accountNumber);
		if (account == null) {
			throw new RuntimeException("Account not exists.");
		}
		Balance balance = provider.getBalanceDAO().findBalance(agency, accountNumber);
		JsonObject response = new JsonObject();
		response.addProperty("agency", account.getAgency());
		response.addProperty("account", account.getAccountNumber());
		response.addProperty("name", account.getName());
		response.addProperty("status", account.getStatus());
		response.addProperty("balance", balance.getBalanceValue());
		return response;
	}
}
