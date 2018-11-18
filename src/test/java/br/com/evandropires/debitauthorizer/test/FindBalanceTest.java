package br.com.evandropires.debitauthorizer.test;

import br.com.evandropires.debitauthorizer.dao.impl.BalanceDAOImpl;
import br.com.evandropires.debitauthorizer.dao.impl.BalanceTestDAOImpl;
import br.com.evandropires.debitauthorizer.service.BalanceProvider;
import br.com.evandropires.debitauthorizer.service.BalanceService;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by evandro on 18/11/2018.
 */
@RunWith(JUnit4.class)
public class FindBalanceTest {

	@Test
	public void findValidBalance() {
		Integer agency = 123;
		Integer account = 456;

		BalanceProvider balanceProvider = new BalanceProvider();
		balanceProvider.setBalanceDAO(new BalanceTestDAOImpl());
		JsonObject response = new BalanceService(balanceProvider).findBalance(agency, account);
		Assert.assertTrue(response.has("agency"));
		Assert.assertTrue(response.has("account"));
		Assert.assertTrue(response.has("name"));
		Assert.assertTrue(response.has("status"));
		Assert.assertTrue(response.has("balance"));
		Assert.assertEquals("ACTIVE", response.get("status").getAsString());
	}

	@Test
	public void findInvalidBalance() {
		Integer agency = 999;
		Integer account = 999;

		BalanceProvider balanceProvider = new BalanceProvider();
		balanceProvider.setBalanceDAO(new BalanceTestDAOImpl());
		JsonObject response = new BalanceService(balanceProvider).findBalance(agency, account);
		Assert.assertNull(response);
	}

	@Test
	public void findInativeBalance() {
		Integer agency = 888;
		Integer account = 888;

		BalanceProvider balanceProvider = new BalanceProvider();
		balanceProvider.setBalanceDAO(new BalanceTestDAOImpl());
		JsonObject response = new BalanceService(balanceProvider).findBalance(agency, account);
		Assert.assertEquals("INACTIVE", response.get("status").getAsString());
	}

}
