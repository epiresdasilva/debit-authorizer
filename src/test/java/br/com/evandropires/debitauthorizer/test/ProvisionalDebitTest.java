package br.com.evandropires.debitauthorizer.test;

import br.com.evandropires.debitauthorizer.dao.impl.ProvisionalDebitTestDAOImpl;
import br.com.evandropires.debitauthorizer.service.ProvisionalDebitProvider;
import br.com.evandropires.debitauthorizer.service.ProvisionalDebitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

/**
 * Created by evandro on 18/11/2018.
 */
@RunWith(JUnit4.class)
public class ProvisionalDebitTest {

	@Test
	public void validDebit() {
		Integer agency = 123;
		Integer account = 456;
		BigDecimal debitValue = new BigDecimal(50);

		ProvisionalDebitProvider provisionalDebitProvider = new ProvisionalDebitProvider();
		provisionalDebitProvider.setProvisionalDebitDAO(new ProvisionalDebitTestDAOImpl());
		new ProvisionalDebitService(provisionalDebitProvider).addProvisionalDebit(agency, account, debitValue);
	}

	@Test(expected = RuntimeException.class)
	public void invalidDebitNullValue() {
		Integer agency = 123;
		Integer account = 456;
		BigDecimal debitValue = null;

		ProvisionalDebitProvider provisionalDebitProvider = new ProvisionalDebitProvider();
		provisionalDebitProvider.setProvisionalDebitDAO(new ProvisionalDebitTestDAOImpl());
		new ProvisionalDebitService(provisionalDebitProvider).addProvisionalDebit(agency, account, debitValue);
	}

	@Test(expected = RuntimeException.class)
	public void invalidDebitZeroValue() {
		Integer agency = 123;
		Integer account = 456;
		BigDecimal debitValue = BigDecimal.ZERO;

		ProvisionalDebitProvider provisionalDebitProvider = new ProvisionalDebitProvider();
		provisionalDebitProvider.setProvisionalDebitDAO(new ProvisionalDebitTestDAOImpl());
		new ProvisionalDebitService(provisionalDebitProvider).addProvisionalDebit(agency, account, debitValue);
	}

	@Test(expected = RuntimeException.class)
	public void invalidDebitNegativeValue() {
		Integer agency = 123;
		Integer account = 456;
		BigDecimal debitValue = new BigDecimal(-1);

		ProvisionalDebitProvider provisionalDebitProvider = new ProvisionalDebitProvider();
		provisionalDebitProvider.setProvisionalDebitDAO(new ProvisionalDebitTestDAOImpl());
		new ProvisionalDebitService(provisionalDebitProvider).addProvisionalDebit(agency, account, debitValue);
	}

}
