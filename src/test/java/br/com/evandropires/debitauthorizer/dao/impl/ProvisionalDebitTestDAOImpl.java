package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.ProvisionalDebitDAO;

import java.math.BigDecimal;

/**
 * Created by evandro on 14/11/2018.
 */
public class ProvisionalDebitTestDAOImpl implements ProvisionalDebitDAO {

	@Override
	public Long addProvisionalDebit(Integer agency, Integer account, BigDecimal debitValue) {
		return null;
	}

	@Override
	public void registerProvisionalDebit(Long id) {
	}
}
