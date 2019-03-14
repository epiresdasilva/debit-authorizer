package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.BalanceDAO;
import br.com.evandropires.debitauthorizer.entity.BalanceEntity;

import java.math.BigDecimal;

/**
 * Created by evandro on 14/11/2018.
 */
public class BalanceTestDAOImpl implements BalanceDAO {

	@Override
	public BalanceEntity findBalance(Integer agency, Integer account) {
		if (agency == 999 && account == 999) {
			return null;
		} else if (agency == 888 && account == 888) {
			BalanceEntity balanceRecord = new BalanceEntity();
			balanceRecord.setAgency(agency);
			balanceRecord.setAccountNumber(account);
			balanceRecord.setValue(BigDecimal.ZERO);
			return balanceRecord;
		}

		BalanceEntity balanceRecord = new BalanceEntity();
		balanceRecord.setAgency(agency);
		balanceRecord.setAccountNumber(account);
		balanceRecord.setValue(new BigDecimal(100));
		return balanceRecord;
	}
}
