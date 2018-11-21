package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.ProvisionalDebitDAO;
import br.com.evandropires.debitauthorizer.model.ProvisionalDebit;
import org.javalite.activejdbc.Base;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by evandro on 14/11/2018.
 */
public class ProvisionalDebitDAOImpl implements ProvisionalDebitDAO {

	@Override
	public Long addProvisionalDebit(Integer agency, Integer account, BigDecimal debitValue) {
		Base.open();

		ProvisionalDebit provisionalDebit = new ProvisionalDebit();
		try {
			Base.openTransaction();

			provisionalDebit.set("accountnumber", account);
			provisionalDebit.set("agency", agency);
			provisionalDebit.set("debitvalue", debitValue);
			provisionalDebit.setTimestamp("debitdate", new Date());
			provisionalDebit.set("status", "PENDING");
			provisionalDebit.insert();

			Base.commitTransaction();
		} catch (Exception e) {
			Base.rollbackTransaction();
			e.printStackTrace();
		} finally {
			Base.close();
		}

		return provisionalDebit.getLongId();
	}

	@Override
	public void registerProvisionalDebit(Long id) {
		Base.open();

		try {
			Base.openTransaction();

			ProvisionalDebit provisionalDebit = new ProvisionalDebit().findById(id);
			provisionalDebit.set("status", "REGISTERED");
			provisionalDebit.save();

			Base.commitTransaction();
		} catch (Exception e) {
			Base.rollbackTransaction();
			e.printStackTrace();
		} finally {
			Base.close();
		}
	}
}
