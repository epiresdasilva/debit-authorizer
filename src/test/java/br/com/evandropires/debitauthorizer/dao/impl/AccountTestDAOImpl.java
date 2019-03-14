package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.AccountDAO;
import br.com.evandropires.debitauthorizer.entity.AccountEntity;

/**
 * Created by evandro on 14/11/2018.
 */
public class AccountTestDAOImpl implements AccountDAO {

	@Override
	public AccountEntity findAccount(Integer agency, Integer accountNumber) {
		if (agency == 999 && accountNumber == 999) {
			return null;
		} else if (agency == 888 && accountNumber == 888) {
			AccountEntity accountRecord = new AccountEntity();
			accountRecord.setAgency(agency);
			accountRecord.setAccountNumber(accountNumber);
			accountRecord.setName("Tim McGraw");
			accountRecord.setStatus(AccountEntity.AccountStatus.INACTIVE);
			return accountRecord;
		}

		AccountEntity accountRecord = new AccountEntity();
		accountRecord.setAgency(agency);
		accountRecord.setAccountNumber(accountNumber);
		accountRecord.setName("Keith Urban");
		accountRecord.setStatus(AccountEntity.AccountStatus.ACTIVE);
		return accountRecord;
	}

}
