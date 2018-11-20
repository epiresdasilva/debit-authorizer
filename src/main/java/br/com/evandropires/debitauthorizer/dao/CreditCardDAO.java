package br.com.evandropires.debitauthorizer.dao;

import com.google.gson.JsonObject;

/**
 * Created by evandro on 14/11/2018.
 */
public interface CreditCardDAO {

	JsonObject findCreditCard(Long cardNumber);
}
