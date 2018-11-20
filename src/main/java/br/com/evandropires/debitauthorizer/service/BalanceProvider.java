package br.com.evandropires.debitauthorizer.service;

import br.com.evandropires.debitauthorizer.dao.BalanceDAO;
import br.com.evandropires.debitauthorizer.dao.impl.BalanceDAOImpl;

/**
 * Created by evandro on 14/11/2018.
 */
public class BalanceProvider {

	private BalanceDAO balanceDAO = new BalanceDAOImpl();
	private AccountService accountService = new AccountService(new AccountProvider());

	public BalanceDAO getBalanceDAO() {
		return balanceDAO;
	}

	public void setBalanceDAO(BalanceDAO balanceDAO) {
		this.balanceDAO = balanceDAO;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
}
