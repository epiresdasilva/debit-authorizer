package br.com.evandropires.debitauthorizer.dao;

import com.google.gson.JsonObject;

import java.math.BigDecimal;

/**
 * Created by evandro on 14/11/2018.
 */
public interface BalanceDAO {

	JsonObject findBalance(Integer agency, Integer account);

	void provisionalDebit(Integer agency, Integer account, BigDecimal debitValue);

}
