package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.BalanceDAO;
import br.com.evandropires.debitauthorizer.model.Balance;
import org.javalite.activejdbc.Base;

/**
 * Created by evandro on 14/11/2018.
 */
public class BalanceDAOImpl implements BalanceDAO {

	@Override
	public Balance findBalance(Integer agency, Integer accountNumber) {
		Base.open();
		Balance balance = Balance.findFirst("agency = ? and accountnumber = ?", agency, accountNumber);
		Base.close();
		return balance;
	}

}
