package br.com.evandropires.debitauthorizer.dao;

import br.com.evandropires.debitauthorizer.entity.DebitCardEntity;

/**
 * Created by evandro on 14/11/2018.
 */
public interface CreditCardDAO {

	DebitCardEntity findCreditCard(Long cardNumber);
}
