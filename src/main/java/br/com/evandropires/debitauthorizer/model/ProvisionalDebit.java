package br.com.evandropires.debitauthorizer.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by evandro on 18/11/2018.
 */
@Table("provisionaldebit")
public class ProvisionalDebit extends Model {

	static {
		validatePresenceOf("agency", "accountnumber", "debitvalue", "debitdate", "status");
	}

	public ProvisionalDebit() {}

	public Integer getAgency(){
		return getInteger("agency");
	}

	public Integer getAccountNumber(){
		return getInteger("accountnumber");
	}

	public BigDecimal getValue(){
		return getBigDecimal("debitvalue");
	}

	public Date getDate(){
		return getDate("debitdate");
	}

	public String getStatus(){
		return getString("status");
	}

}
