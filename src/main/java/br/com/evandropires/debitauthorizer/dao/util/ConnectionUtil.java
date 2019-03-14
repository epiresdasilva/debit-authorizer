package br.com.evandropires.debitauthorizer.dao.util;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by evandro on 21/11/2018.
 */
public class ConnectionUtil {

	public static Connection newConnection() throws SQLException {
		String userName = "aesmqtuh";
		String password = "r7EVmDvBmLi-P9NXSMyXtQYYTW7Z_xfg";
		String url = "jdbc:postgresql://aesmqtuh:r7EVmDvBmLi-P9NXSMyXtQYYTW7Z_xfg@isilo.db.elephantsql.com:5432/aesmqtuh";

		return DriverManager.getConnection(url, userName, password);
	}

	public static DataSource getDataSource() {
		String userName = "aesmqtuh";
		String password = "r7EVmDvBmLi-P9NXSMyXtQYYTW7Z_xfg";
		String url = "jdbc:postgresql://isilo.db.elephantsql.com:5432/aesmqtuh";

		PGSimpleDataSource dataSource = new PGSimpleDataSource();
		dataSource.setURL(url);
		dataSource.setUser(userName);
		dataSource.setPassword(password);
		return dataSource;
	}
}
