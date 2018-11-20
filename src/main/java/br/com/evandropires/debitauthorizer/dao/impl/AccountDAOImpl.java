package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.AccountDAO;
import br.com.evandropires.debitauthorizer.model.Account;
import org.javalite.activejdbc.Base;

/**
 * Created by evandro on 14/11/2018.
 */
public class AccountDAOImpl implements AccountDAO {

	@Override
	public Account findAccount(Integer agency, Integer accountNumber) {
		Base.open();
		Account account = Account.findFirst("agency = ? and accountnumber = ?", agency, accountNumber);
		Base.close();
		return account;
	}

}
