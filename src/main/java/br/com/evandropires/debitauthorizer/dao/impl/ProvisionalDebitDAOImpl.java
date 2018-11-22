package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.ProvisionalDebitDAO;
import br.com.evandropires.debitauthorizer.dao.util.ConnectionUtil;
import br.com.evandropires.debitauthorizer.jooq.tables.Provisionaldebit;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by evandro on 14/11/2018.
 */
public class ProvisionalDebitDAOImpl implements ProvisionalDebitDAO {

	@Override
	public Long addProvisionalDebit(Integer agency, Integer account, BigDecimal debitValue) {
		try (Connection conn = ConnectionUtil.newConnection()) {
			DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
			return create.insertInto(Provisionaldebit.PROVISIONALDEBIT)
					.set(Provisionaldebit.PROVISIONALDEBIT.ACCOUNTNUMBER, account)
					.set(Provisionaldebit.PROVISIONALDEBIT.AGENCY, agency)
					.set(Provisionaldebit.PROVISIONALDEBIT.DEBITVALUE, debitValue)
					.set(Provisionaldebit.PROVISIONALDEBIT.DEBITDATE, new java.sql.Date(new Date().getTime()))
					.set(Provisionaldebit.PROVISIONALDEBIT.STATUS, "PENDING")
					.returning(Provisionaldebit.PROVISIONALDEBIT.ID)
					.fetchOne()
					.getValue(Provisionaldebit.PROVISIONALDEBIT.ID, Long.class);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void registerProvisionalDebit(Long id) {
		try (Connection conn = ConnectionUtil.newConnection()) {
			DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
			create.update(Provisionaldebit.PROVISIONALDEBIT)
					.set(Provisionaldebit.PROVISIONALDEBIT.STATUS, "REGISTERED")
					.where(Provisionaldebit.PROVISIONALDEBIT.ID.eq(id.intValue()))
					.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
