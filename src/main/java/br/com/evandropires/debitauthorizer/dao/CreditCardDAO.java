package br.com.evandropires.debitauthorizer.dao;

import br.com.evandropires.debitauthorizer.model.DebitCard;

/**
 * Created by evandro on 14/11/2018.
 */
public interface CreditCardDAO {

	DebitCard findCreditCard(Long cardNumber);
}
