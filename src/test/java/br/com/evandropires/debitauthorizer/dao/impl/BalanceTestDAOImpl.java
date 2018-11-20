package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.BalanceDAO;
import br.com.evandropires.debitauthorizer.model.Balance;
import br.com.evandropires.debitauthorizer.util.BaseTestUtil;
import com.google.gson.JsonObject;
import org.javalite.activejdbc.Base;

import java.math.BigDecimal;

/**
 * Created by evandro on 14/11/2018.
 */
public class BalanceTestDAOImpl implements BalanceDAO {

	@Override
	public Balance findBalance(Integer agency, Integer account) {
		try {
			BaseTestUtil.open();

			if (agency == 999 && account == 999) {
				return null;
			} else if (agency == 888 && account == 888) {
				Balance balance = new Balance()
						.setInteger("agency", agency)
						.setInteger("accountnumber", account)
						.setBigDecimal("balancevalue", BigDecimal.ZERO);
				return balance;
			}

			Balance balance = new Balance()
					.setInteger("agency", agency)
					.setInteger("accountnumber", account)
					.setBigDecimal("balancevalue", new BigDecimal(100));

			return balance;
		} finally {
			Base.close();
		}
	}
}
