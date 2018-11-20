package br.com.evandropires.debitauthorizer.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

import java.math.BigDecimal;

/**
 * Created by evandro on 18/11/2018.
 */
@Table("balance")
@CompositePK({"agency", "accountnumber"})
public class Balance extends Model {

	public Balance() {}

	public Integer getAgency(){
		return getInteger("agency");
	}

	public Long getAccountNumber(){
		return getLong("accountnumber");
	}

	public BigDecimal getBalanceValue(){
		return getBigDecimal("balancevalue");
	}

}
