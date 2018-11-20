package br.com.evandropires.debitauthorizer.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

/**
 * Created by evandro on 18/11/2018.
 */
@Table("account")
@CompositePK({"agency", "accountnumber"})
public class Account extends Model {

	public Account() {}

	public Integer getAgency(){
		return getInteger("agency");
	}

	public Long getAccountNumber(){
		return getLong("accountnumber");
	}

	public String getName(){
		return getString("name");
	}

	public String getStatus(){
		return getString("status");
	}

}
