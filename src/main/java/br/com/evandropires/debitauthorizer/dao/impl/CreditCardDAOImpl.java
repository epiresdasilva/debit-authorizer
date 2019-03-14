package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.CreditCardDAO;
import br.com.evandropires.debitauthorizer.dao.util.ConnectionUtil;
import br.com.evandropires.debitauthorizer.entity.DebitCardEntity;
import com.jcabi.jdbc.JdbcSession;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by evandro on 14/11/2018.
 */
public class CreditCardDAOImpl implements CreditCardDAO {

	@Override
	public DebitCardEntity findCreditCard(Long cardNumber) {
		DataSource dataSource = ConnectionUtil.getDataSource();
		try {
			return new JdbcSession(dataSource)
					.sql("SELECT agency, accountnumber, cardnumber, status FROM debitcard WHERE cardnumber = ?")
					.set(cardNumber)
					.select(
							(ResultSet rset, Statement statement) -> {
								DebitCardEntity debitCard = new DebitCardEntity();
								while (rset.next()) {
									debitCard.setAgency(rset.getInt("agency"));
									debitCard.setAccountNumber(rset.getInt("accountnumber"));
									debitCard.setStatus(DebitCardEntity.DebitCardStatus.valueOf(rset.getString("status")));
									debitCard.setCardnumber(rset.getInt("cardnumber"));
								}
								return debitCard;
							});
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
