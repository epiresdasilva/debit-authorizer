package br.com.evandropires.debitauthorizer.util;

import org.javalite.activejdbc.Base;

/**
 * Created by evandro on 20/11/2018.
 */
public class BaseTestUtil {

	public static void open() {
		Base.open("org.h2.Driver", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=runscript from 'classpath:init.sql'", "sa", "");
	}

}
