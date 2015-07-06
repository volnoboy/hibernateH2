package com.volnoboy;

import com.volnoboy.entity.Employee;
import org.h2.tools.Server;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by Reuven on 6/29/15.
 */
public class HibernateUtils {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;

	static {
		try {
			String arguments[] = {"-tcpAllowOthers", "-tcpPort", "9092"};
			Server server = Server.createTcpServer(arguments).start();

			Configuration configuration = new Configuration();
			configuration.configure();

			//This line adds entity to Hibernate
			configuration.addAnnotatedClass(Employee.class);

			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
					configuration.getProperties()).build();

			factory = configuration.buildSessionFactory(serviceRegistry);

			new H2WebServerDeamonStart();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
