package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.AccountDAO;
import br.com.evandropires.debitauthorizer.dao.util.ConnectionUtil;
import br.com.evandropires.debitauthorizer.jooq.tables.records.AccountRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static br.com.evandropires.debitauthorizer.jooq.tables.Account.ACCOUNT;

/**
 * Created by evandro on 14/11/2018.
 */
public class AccountDAOImpl implements AccountDAO {

	@Override
	public AccountRecord findAccount(Integer agency, Integer accountNumber) {
		try (Connection conn = ConnectionUtil.newConnection()) {
			DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
			return (AccountRecord) create.select().from(ACCOUNT).where(ACCOUNT.AGENCY.eq(agency)).and(ACCOUNT.ACCOUNTNUMBER.eq(accountNumber)).fetchAny();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
