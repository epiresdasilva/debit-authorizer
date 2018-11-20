package br.com.evandropires.debitauthorizer.service;

import br.com.evandropires.debitauthorizer.dao.AccountDAO;
import br.com.evandropires.debitauthorizer.dao.impl.AccountDAOImpl;

/**
 * Created by evandro on 14/11/2018.
 */
public class AccountProvider {

	private AccountDAO accountDAO = new AccountDAOImpl();

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
}
