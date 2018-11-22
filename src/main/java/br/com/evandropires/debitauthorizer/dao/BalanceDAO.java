package br.com.evandropires.debitauthorizer.dao;

import br.com.evandropires.debitauthorizer.jooq.tables.records.BalanceRecord;

/**
 * Created by evandro on 14/11/2018.
 */
public interface BalanceDAO {

	BalanceRecord findBalance(Integer agency, Integer account);

}
