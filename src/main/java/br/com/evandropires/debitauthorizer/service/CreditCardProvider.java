package br.com.evandropires.debitauthorizer.service;

import br.com.evandropires.debitauthorizer.dao.CreditCardDAO;

/**
 * Created by evandro on 14/11/2018.
 */
public class CreditCardProvider {

	private CreditCardDAO creditCardDAO;

	public CreditCardDAO getCreditCardDAO() {
		return creditCardDAO;
	}

	public void setCreditCardDAO(CreditCardDAO creditCardDAO) {
		this.creditCardDAO = creditCardDAO;
	}
}
