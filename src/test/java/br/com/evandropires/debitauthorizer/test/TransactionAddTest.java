package br.com.evandropires.debitauthorizer.test;

import br.com.evandropires.debitauthorizer.dao.impl.TransactionTestDAOImpl;
import br.com.evandropires.debitauthorizer.service.TransactionProvider;
import br.com.evandropires.debitauthorizer.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

/**
 * Created by evandro on 18/11/2018.
 */
@RunWith(JUnit4.class)
public class TransactionAddTest {

	@Test
	public void validDebit() {
		Integer agency = 123;
		Integer account = 456;
		BigDecimal debitValue = new BigDecimal(50);

		TransactionProvider transactionProvider = new TransactionProvider();
		transactionProvider.setTransactionDAO(new TransactionTestDAOImpl());
		new TransactionService(transactionProvider).addTransaction(agency, account, debitValue);
	}

	@Test(expected = RuntimeException.class)
	public void invalidDebitNullValue() {
		Integer agency = 123;
		Integer account = 456;
		BigDecimal debitValue = null;

		TransactionProvider transactionProvider = new TransactionProvider();
		transactionProvider.setTransactionDAO(new TransactionTestDAOImpl());
		new TransactionService(transactionProvider).addTransaction(agency, account, debitValue);
	}

	@Test(expected = RuntimeException.class)
	public void invalidDebitZeroValue() {
		Integer agency = 123;
		Integer account = 456;
		BigDecimal debitValue = BigDecimal.ZERO;

		TransactionProvider transactionProvider = new TransactionProvider();
		transactionProvider.setTransactionDAO(new TransactionTestDAOImpl());
		new TransactionService(transactionProvider).addTransaction(agency, account, debitValue);
	}

	@Test(expected = RuntimeException.class)
	public void invalidDebitNegativeValue() {
		Integer agency = 123;
		Integer account = 456;
		BigDecimal debitValue = new BigDecimal(-1);

		TransactionProvider transactionProvider = new TransactionProvider();
		transactionProvider.setTransactionDAO(new TransactionTestDAOImpl());
		new TransactionService(transactionProvider).addTransaction(agency, account, debitValue);
	}

}
