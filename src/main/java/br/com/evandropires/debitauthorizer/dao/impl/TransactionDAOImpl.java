package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.TransactionDAO;

import java.math.BigDecimal;

/**
 * Created by evandro on 14/11/2018.
 */
public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public void addTransaction(Integer agency, Integer account, BigDecimal debitValue) {
//		try (Connection conn = ConnectionUtil.newConnection()) {
//			DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
//			create.insertInto(Transaction.TRANSACTION)
//					.set(Transaction.TRANSACTION.ACCOUNTNUMBER, account)
//					.set(Transaction.TRANSACTION.AGENCY, agency)
//					.set(Transaction.TRANSACTION.TRANSACTIONVALUE, debitValue)
//					.set(Transaction.TRANSACTION.TRANSACTIONDATE, new Timestamp(new Date().getTime()))
//					.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
	}

}
