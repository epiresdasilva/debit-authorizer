package br.com.evandropires.debitauthorizer.dao.impl;

import br.com.evandropires.debitauthorizer.dao.AccountDAO;
import br.com.evandropires.debitauthorizer.dao.util.ConnectionUtil;
import br.com.evandropires.debitauthorizer.entity.AccountEntity;
import com.jcabi.jdbc.JdbcSession;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by evandro on 14/11/2018.
 */
public class AccountDAOImpl implements AccountDAO {

    @Override
    public AccountEntity findAccount(Integer agency, Integer accountNumber) {
        DataSource dataSource = ConnectionUtil.getDataSource();
        try {
            return new JdbcSession(dataSource)
                    .sql("SELECT agency, accountnumber, status, name FROM account WHERE agency = ? and accountnumber = ?")
                    .set(agency)
                    .set(accountNumber)
                    .select(
                            (ResultSet rset, Statement statement) -> {
                                AccountEntity account = new AccountEntity();
                                while (rset.next()) {
                                    account.setAgency(rset.getInt("agency"));
                                    account.setAccountNumber(rset.getInt("accountnumber"));
                                    account.setStatus(AccountEntity.AccountStatus.valueOf(rset.getString("status")));
                                    account.setName(rset.getString("name"));
                                }
                                return account;
                            });
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
