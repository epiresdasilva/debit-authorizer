package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.CreditCardDAO;
import br.com.evandropires.debitauthorizer.dao.util.ConnectionUtil;
import br.com.evandropires.debitauthorizer.jooq.tables.records.DebitcardRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import static br.com.evandropires.debitauthorizer.jooq.tables.Debitcard.DEBITCARD;

/**
 * Created by evandro on 14/11/2018.
 */
public class CreditCardDAOImpl implements CreditCardDAO {

	@Override
	public DebitcardRecord findCreditCard(Long cardNumber) {
		try (Connection conn = ConnectionUtil.newConnection()) {
			DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
			return (DebitcardRecord) create.select().from(DEBITCARD).where(DEBITCARD.CARDNUMBER.eq(new BigDecimal(cardNumber))).fetchAny();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
