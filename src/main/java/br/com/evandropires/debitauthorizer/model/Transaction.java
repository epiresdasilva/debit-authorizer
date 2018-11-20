package br.com.evandropires.debitauthorizer.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by evandro on 18/11/2018.
 */
@Table("transaction")
public class Transaction extends Model {

	static {
		validatePresenceOf("agency", "accountnumber", "transactionvalue", "transactiondate");
	}

	public Transaction() {}

	public Integer getAgency(){
		return getInteger("agency");
	}

	public Integer getAccountNumber(){
		return getInteger("accountnumber");
	}

	public BigDecimal getValue(){
		return getBigDecimal("transactionvalue");
	}

	public Date getDate(){
		return getDate("transactiondate");
	}

}
