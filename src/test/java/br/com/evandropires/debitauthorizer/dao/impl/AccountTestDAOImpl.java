package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.AccountDAO;
import br.com.evandropires.debitauthorizer.jooq.tables.records.AccountRecord;

/**
 * Created by evandro on 14/11/2018.
 */
public class AccountTestDAOImpl implements AccountDAO {

	@Override
	public AccountRecord findAccount(Integer agency, Integer accountNumber) {
		if (agency == 999 && accountNumber == 999) {
			return null;
		} else if (agency == 888 && accountNumber == 888) {
			AccountRecord accountRecord = new AccountRecord();
			accountRecord.setAgency(agency);
			accountRecord.setAccountnumber(accountNumber);
			accountRecord.setName("Tim McGraw");
			accountRecord.setStatus("INACTIVE");
			return accountRecord;
		}

		AccountRecord accountRecord = new AccountRecord();
		accountRecord.setAgency(agency);
		accountRecord.setAccountnumber(accountNumber);
		accountRecord.setName("Keith Urban");
		accountRecord.setStatus("ACTIVE");
		return accountRecord;
	}

}
