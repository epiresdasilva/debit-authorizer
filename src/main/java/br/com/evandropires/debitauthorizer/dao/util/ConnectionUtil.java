package br.com.evandropires.debitauthorizer.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by evandro on 21/11/2018.
 */
public class ConnectionUtil {

	public static Connection newConnection() throws SQLException {
		String userName = "admin";
		String password = "PKTTNIIUQECQBYNB";
		String url = "jdbc:postgresql://sl-us-south-1-portal.39.dblayer.com:62731/debitauthorizer?sslmode=require";

		return DriverManager.getConnection(url, userName, password);
	}
}
