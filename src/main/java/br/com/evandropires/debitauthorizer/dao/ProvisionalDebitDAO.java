package br.com.evandropires.debitauthorizer.dao;

import java.math.BigDecimal;

/**
 * Created by evandro on 14/11/2018.
 */
public interface ProvisionalDebitDAO {

	void addProvisionalDebit(Integer agency, Integer account, BigDecimal debitValue);

}
