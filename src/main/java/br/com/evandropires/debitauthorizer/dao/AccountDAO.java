package br.com.evandropires.debitauthorizer.dao;


import br.com.evandropires.debitauthorizer.entity.AccountEntity;

/**
 * Created by evandro on 14/11/2018.
 */
public interface AccountDAO {

	AccountEntity findAccount(Integer agency, Integer account);

}
