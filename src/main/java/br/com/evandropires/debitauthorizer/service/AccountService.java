package br.com.evandropires.debitauthorizer.service;

import br.com.evandropires.debitauthorizer.entity.AccountEntity;

/**
 * Created by evandro on 14/11/2018.
 */
public class AccountService {

	private AccountProvider provider;

	public AccountService(AccountProvider provider) {
		this.provider = provider;
	}

	public AccountEntity findAccount(Integer agency, Integer account) {
		return provider.getAccountDAO().findAccount(agency, account);
	}

}
