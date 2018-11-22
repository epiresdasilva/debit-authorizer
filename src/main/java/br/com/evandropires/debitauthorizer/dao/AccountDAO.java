package br.com.evandropires.debitauthorizer.dao;


import br.com.evandropires.debitauthorizer.jooq.tables.records.AccountRecord;

/**
 * Created by evandro on 14/11/2018.
 */
public interface AccountDAO {

	AccountRecord findAccount(Integer agency, Integer account);

}
