package br.com.evandropires.debitauthorizer.service;

import br.com.evandropires.debitauthorizer.dao.TransactionDAO;
import br.com.evandropires.debitauthorizer.dao.impl.TransactionDAOImpl;

/**
 * Created by evandro on 14/11/2018.
 */
public class TransactionProvider {

	private TransactionDAO transactionDAO = new TransactionDAOImpl();

	public TransactionDAO getTransactionDAO() {
		return transactionDAO;
	}

	public void setTransactionDAO(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}
}
