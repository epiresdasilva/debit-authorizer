package br.com.evandropires.debitauthorizer.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

/**
 * Created by evandro on 18/11/2018.
 */
@Table("debitcard")
@CompositePK({"cardnumber"})
public class DebitCard extends Model {

	public DebitCard() {}

	public Long getCardNumber(){
		return getLong("cardnumber");
	}

	public Integer getAgency(){
		return getInteger("agency");
	}

	public Integer getAccount(){
		return getInteger("account");
	}

	public String getStatus(){
		return getString("status");
	}

}
