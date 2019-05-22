package br.com.evandropires.debitauthorizer.dao;

import br.com.evandropires.debitauthorizer.entity.BalanceEntity;

import java.math.BigDecimal;

/**
 * Created by evandro on 14/11/2018.
 */
public interface BalanceDAO {

	BalanceEntity findBalance(Integer agency, Integer account);
	void updateBalance(Integer agency, Integer accountNumber, BigDecimal operationValue);

}
