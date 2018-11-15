package br.com.evandropires.debitauthorizer.service;

import com.google.gson.JsonObject;

import java.math.BigDecimal;

/**
 * Created by evandro on 14/11/2018.
 */
public class BalanceService {

	private BalanceProvider provider;

	public BalanceService(BalanceProvider provider) {
		this.provider = provider;
	}

	public JsonObject findBalance(Integer agency, Integer account) {
		return provider.getBalanceDAO().findBalance(agency, account);
	}

	public void provisionalDebit(Integer agency, Integer account, BigDecimal debitValue) {
		provider.getBalanceDAO().provisionalDebit(agency, account, debitValue);
	}
}
