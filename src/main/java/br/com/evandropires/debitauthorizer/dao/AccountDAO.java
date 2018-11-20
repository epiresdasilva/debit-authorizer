package br.com.evandropires.debitauthorizer.dao;

import br.com.evandropires.debitauthorizer.model.Account;
import com.google.gson.JsonObject;

/**
 * Created by evandro on 14/11/2018.
 */
public interface AccountDAO {

	Account findAccount(Integer agency, Integer account);

}
