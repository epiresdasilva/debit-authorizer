package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.BalanceDAO;
import br.com.evandropires.debitauthorizer.dao.util.ConnectionUtil;
import br.com.evandropires.debitauthorizer.entity.BalanceEntity;
import br.com.evandropires.debitauthorizer.entity.ProvisionalDebitEntity;
import com.jcabi.jdbc.JdbcSession;
import com.jcabi.jdbc.SingleOutcome;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by evandro on 14/11/2018.
 */
public class BalanceDAOImpl implements BalanceDAO {

	@Override
	public BalanceEntity findBalance(Integer agency, Integer accountNumber) {
		DataSource dataSource = ConnectionUtil.getDataSource();
		try {
			return new JdbcSession(dataSource)
					.sql("SELECT agency, accountnumber, balancevalue FROM balance WHERE agency = ? and accountnumber = ?")
					.set(agency)
					.set(accountNumber)
					.select(
							(ResultSet rset, Statement statement) -> {
								BalanceEntity balance = new BalanceEntity();
								while (rset.next()) {
									balance.setAgency(rset.getInt("agency"));
									balance.setAccountNumber(rset.getInt("accountnumber"));
									balance.setValue(rset.getBigDecimal("balancevalue"));
								}
								return balance;
							});
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateBalance(Integer agency, Integer accountNumber, BigDecimal operationValue) {
		DataSource dataSource = ConnectionUtil.getDataSource();
		try {
			new JdbcSession(dataSource)
					.sql("UPDATE balance SET balancevalue = balancevalue + ? WHERE agency = ? and accountnumber = ?")
					.set(operationValue)
					.set(agency)
					.set(accountNumber)
					.update(new SingleOutcome<>(Long.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


}
