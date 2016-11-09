package edu.electronics.dal;

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
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
				.configure("edu/electronics/dal/hibernate.cfg.xml").build();

		Metadata metadata = new MetadataSources(standardRegistry)
				// .addAnnotatedClass( MyEntity.class )
				// .addAnnotatedClassName( "org.hibernate.example.Customer" )
				// .addResource( "org/hibernate/example/Order.hbm.xml" )
				// .addResource( "org/hibernate/example/Product.orm.xml" )
				.getMetadataBuilder()
				.applyImplicitNamingStrategy(
						ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
				.build();

		sessionFactory = metadata.buildSessionFactory();// metadata.getSessionFactoryBuilder()
		// .applyBeanManager( getBeanManager() )
		// .build();

		// Session session = sessionFactory.openSession();

		System.out.println("DB init");

	}
	
	public static Session openSession(){
		//TODO:: 
		return null;
	}
}
