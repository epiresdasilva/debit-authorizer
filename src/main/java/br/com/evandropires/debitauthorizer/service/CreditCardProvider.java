package br.com.evandropires.debitauthorizer.service;

import br.com.evandropires.debitauthorizer.dao.CreditCardDAO;
import br.com.evandropires.debitauthorizer.dao.impl.CreditCardDAOImpl;

/**
 * Created by evandro on 14/11/2018.
 */
public class CreditCardProvider {

	private CreditCardDAO creditCardDAO = new CreditCardDAOImpl();

	public CreditCardDAO getCreditCardDAO() {
		return creditCardDAO;
	}

	public void setCreditCardDAO(CreditCardDAO creditCardDAO) {
		this.creditCardDAO = creditCardDAO;
	}
}
