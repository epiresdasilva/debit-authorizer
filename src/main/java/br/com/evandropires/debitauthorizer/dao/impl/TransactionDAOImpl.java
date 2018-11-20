package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.TransactionDAO;
import br.com.evandropires.debitauthorizer.model.Transaction;
import org.javalite.activejdbc.Base;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by evandro on 14/11/2018.
 */
public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public void addTransaction(Integer agency, Integer account, BigDecimal debitValue) {
		Base.open();

		try {
			Base.openTransaction();

			Transaction transaction = new Transaction();
			transaction.set("accountnumber", account);
			transaction.set("agency", agency);
			transaction.set("transactionvalue", debitValue);
			transaction.setTimestamp("transactiondate", new Date());
			transaction.insert();

			Base.commitTransaction();
		} catch (Exception e) {
			Base.rollbackTransaction();
			e.printStackTrace();
		} finally {
			Base.close();
		}
	}

}
