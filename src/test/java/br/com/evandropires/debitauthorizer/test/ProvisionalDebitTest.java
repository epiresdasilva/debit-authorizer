package br.com.evandropires.debitauthorizer.test;

import br.com.evandropires.debitauthorizer.dao.impl.BalanceDAOImpl;
import br.com.evandropires.debitauthorizer.service.BalanceProvider;
import br.com.evandropires.debitauthorizer.service.BalanceService;
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

		BalanceProvider balanceProvider = new BalanceProvider();
		balanceProvider.setBalanceDAO(new BalanceDAOImpl());
		new BalanceService(balanceProvider).provisionalDebit(agency, account, debitValue);
	}

}
