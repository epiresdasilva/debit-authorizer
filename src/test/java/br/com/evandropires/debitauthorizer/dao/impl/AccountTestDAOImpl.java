package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.AccountDAO;
import br.com.evandropires.debitauthorizer.model.Account;
import br.com.evandropires.debitauthorizer.util.BaseTestUtil;
import org.javalite.activejdbc.Base;

/**
 * Created by evandro on 14/11/2018.
 */
public class AccountTestDAOImpl implements AccountDAO {

	@Override
	public Account findAccount(Integer agency, Integer accountNumber) {
		try {
			BaseTestUtil.open();

			if (agency == 999 && accountNumber == 999) {
				return null;
			} else if (agency == 888 && accountNumber == 888) {
				Account account = new Account()
						.setInteger("agency", agency)
						.setInteger("accountnumber", accountNumber)
						.setString("name", "Tim McGraw")
						.setString("status", "INACTIVE");
				return account;
			}

			Account account = new Account()
					.setInteger("agency", agency)
					.setInteger("accountnumber", accountNumber)
					.setString("name", "Keith Urban")
					.setString("status", "ACTIVE");

			return account;
		} finally {
			Base.close();
		}
	}

}
