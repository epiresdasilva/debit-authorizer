package br.com.evandropires.debitauthorizer.service;

import br.com.evandropires.debitauthorizer.dao.BalanceDAO;

/**
 * Created by evandro on 14/11/2018.
 */
public class BalanceProvider {

	private BalanceDAO balanceDAO;

	public BalanceDAO getBalanceDAO() {
		return balanceDAO;
	}

	public void setBalanceDAO(BalanceDAO balanceDAO) {
		this.balanceDAO = balanceDAO;
	}
}
