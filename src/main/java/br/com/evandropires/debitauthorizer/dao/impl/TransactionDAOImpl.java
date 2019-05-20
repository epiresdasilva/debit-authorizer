package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.TransactionDAO;
import br.com.evandropires.debitauthorizer.dao.util.ConnectionUtil;
import com.jcabi.jdbc.JdbcSession;
import com.jcabi.jdbc.SingleOutcome;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by evandro on 14/11/2018.
 */
public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public void addTransaction(Integer agency, Integer account, BigDecimal debitValue) {
		DataSource dataSource = ConnectionUtil.getDataSource();
		try {
			new JdbcSession(dataSource)
					.sql("INSERT INTO transaction (agency, accountnumber, transactionvalue, transactiondate) VALUES (?, ?, ?, ?)")
					.set(agency)
					.set(account)
					.set(debitValue.setScale(2, BigDecimal.ROUND_HALF_UP))
					.set(new Date(new java.util.Date().getTime()))
					.update(new SingleOutcome<>(Long.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
