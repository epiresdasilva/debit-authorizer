package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.ProvisionalDebitDAO;
import br.com.evandropires.debitauthorizer.dao.util.ConnectionUtil;
import br.com.evandropires.debitauthorizer.entity.ProvisionalDebitEntity;
import com.jcabi.jdbc.JdbcSession;
import com.jcabi.jdbc.SingleOutcome;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by evandro on 14/11/2018.
 */
public class ProvisionalDebitDAOImpl implements ProvisionalDebitDAO {

	@Override
	public Long addProvisionalDebit(Integer agency, Integer account, BigDecimal debitValue) {
		DataSource dataSource = ConnectionUtil.getDataSource();
		try {
			return new JdbcSession(dataSource)
                    .sql("INSERT INTO provisionaldebit (agency, accountnumber, debitvalue, debitdate, status) VALUES (?, ?, ?, ?, ?)")
                    .set(agency)
                    .set(account)
					.set(debitValue)
					.set(new Date())
					.set(ProvisionalDebitEntity.ProvisionalDebitStatus.PENDING.name())
                    .update(new SingleOutcome<>(Long.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void registerProvisionalDebit(Long id) {
		DataSource dataSource = ConnectionUtil.getDataSource();
		try {
			 new JdbcSession(dataSource)
					.sql("UPDATE provisionaldebit SET status = ? WHERE id = ?")
					.set(ProvisionalDebitEntity.ProvisionalDebitStatus.REGISTERED.name())
					.set(id)
					.update(new SingleOutcome<>(Long.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
