import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


@ManagedBean
@ViewScoped
public class Test implements Serializable{

	public void btnPressed(){
		System.out.println("b tn pressed");
		
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
	    .configure( "hibernate.cfg.xml" )
	    .build();

	Metadata metadata = new MetadataSources( standardRegistry )
//	    .addAnnotatedClass( MyEntity.class )
//	    .addAnnotatedClassName( "org.hibernate.example.Customer" )
//	    .addResource( "org/hibernate/example/Order.hbm.xml" )
//	    .addResource( "org/hibernate/example/Product.orm.xml" )
	    .getMetadataBuilder()
	    .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
	    .build();
	
	

	SessionFactory sessionFactory = metadata.buildSessionFactory();//metadata.getSessionFactoryBuilder()
//	    .applyBeanManager( getBeanManager() )
//	    .build();
	
	Session session = sessionFactory.openSession();
	
	
	Article a = new Article();
	a.setId(1);
	a.setName("a1");
	session.beginTransaction();
	session.save(a);
	
	session.getTransaction().commit();
	session.close();
	}
}
