import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;

import edu.electronics.dal.DataAccess;
import edu.electronics.dal.orm.Resistor;

@ManagedBean
@ViewScoped
public class Test implements Serializable {

	public Test() {
	}

	public void btnPressed() {
		System.out.println("b tn pressed");

		
		Resistor a = new Resistor();
		a.setNumberOfPieces(3);
		a.setNumberOfUsedPieces(2);
		a.setValue(100);
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.save(a);

		session.getTransaction().commit();
		session.close();
		System.out.println("btn - end");
	}
}
