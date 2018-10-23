package org.contactCars.dal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DataAccess {
	private static SessionFactory sessionFactory = null;

	private DataAccess() {
	}

	public static void init() {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("org/contactCars/dal/hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();

			sessionFactory = metadata.buildSessionFactory();
			System.out.println("DB init");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		sessionFactory.close();
		System.out.println("DB close");
	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}
}
