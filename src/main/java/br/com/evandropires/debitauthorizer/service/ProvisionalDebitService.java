package br.com.evandropires.debitauthorizer.service;

import java.math.BigDecimal;

/**
 * Created by evandro on 14/11/2018.
 */
public class ProvisionalDebitService {

	private ProvisionalDebitProvider provider;

	public ProvisionalDebitService(ProvisionalDebitProvider provider) {
		this.provider = provider;
	}

	public void addProvisionalDebit(Integer agency, Integer account, BigDecimal debitValue) {
		if (debitValue == null || BigDecimal.ZERO.compareTo(debitValue) >= 0) {
			throw new RuntimeException("Debit value must be greater than zero.");
		}
		provider.getProvisionalDebitDAO().addProvisionalDebit(agency, account, debitValue);
	}

}
