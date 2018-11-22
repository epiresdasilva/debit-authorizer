package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.BalanceDAO;
import br.com.evandropires.debitauthorizer.jooq.tables.records.BalanceRecord;

import java.math.BigDecimal;

/**
 * Created by evandro on 14/11/2018.
 */
public class BalanceTestDAOImpl implements BalanceDAO {

	@Override
	public BalanceRecord findBalance(Integer agency, Integer account) {
		if (agency == 999 && account == 999) {
			return null;
		} else if (agency == 888 && account == 888) {
			BalanceRecord balanceRecord = new BalanceRecord();
			balanceRecord.setAgency(agency);
			balanceRecord.setAccountnumber(account);
			balanceRecord.setBalancevalue(BigDecimal.ZERO);
			return balanceRecord;
		}

		BalanceRecord balanceRecord = new BalanceRecord();
		balanceRecord.setAgency(agency);
		balanceRecord.setAccountnumber(account);
		balanceRecord.setBalancevalue(new BigDecimal(100));
		return balanceRecord;
	}
}
