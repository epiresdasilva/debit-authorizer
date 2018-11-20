package br.com.evandropires.debitauthorizer.dao;

import br.com.evandropires.debitauthorizer.model.Balance;

/**
 * Created by evandro on 14/11/2018.
 */
public interface BalanceDAO {

	Balance findBalance(Integer agency, Integer account);

}
