package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.TransactionDAO;

import java.math.BigDecimal;

/**
 * Created by evandro on 14/11/2018.
 */
public class TransactionTestDAOImpl implements TransactionDAO {

	@Override
	public void addTransaction(Integer agency, Integer account, BigDecimal debitValue) {
	}

}
