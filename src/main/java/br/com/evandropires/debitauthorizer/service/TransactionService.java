package br.com.evandropires.debitauthorizer.service;

import java.math.BigDecimal;

/**
 * Created by evandro on 14/11/2018.
 */
public class TransactionService {

	private TransactionProvider provider;

	public TransactionService(TransactionProvider provider) {
		this.provider = provider;
	}

	public void addTransaction(Integer agency, Integer account, BigDecimal debitValue) {
		if (debitValue == null || BigDecimal.ZERO.compareTo(debitValue) >= 0) {
			throw new RuntimeException("Debit value must be greater than zero.");
		}
		provider.getTransactionDAO().addTransaction(agency, account, debitValue);
	}

}
