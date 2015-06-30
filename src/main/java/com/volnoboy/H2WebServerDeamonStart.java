package com.volnoboy;

import org.hibernate.jdbc.Work;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Reuven on 6/29/15.
 */
public class H2WebServerDeamonStart extends Thread {

	public H2WebServerDeamonStart() {
		setDaemon(true);
		start();
	}

	public void run() {
		while (true) {
			HibernateUtils.getSessionFactory().openSession().doWork(
					new Work() {
						public void execute(Connection connection) throws SQLException {
							org.h2.tools.Server.startWebServer(connection);
						}
					}
			);
		}
	}


}
