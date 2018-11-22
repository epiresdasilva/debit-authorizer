package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.BalanceDAO;
import br.com.evandropires.debitauthorizer.dao.util.ConnectionUtil;
import br.com.evandropires.debitauthorizer.jooq.tables.records.BalanceRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static br.com.evandropires.debitauthorizer.jooq.tables.Balance.BALANCE;

/**
 * Created by evandro on 14/11/2018.
 */
public class BalanceDAOImpl implements BalanceDAO {

	@Override
	public BalanceRecord findBalance(Integer agency, Integer accountNumber) {
		try (Connection conn = ConnectionUtil.newConnection()) {
			DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
			return (BalanceRecord) create.select().from(BALANCE).where(BALANCE.AGENCY.eq(agency)).and(BALANCE.ACCOUNTNUMBER.eq(accountNumber)).fetchAny();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
