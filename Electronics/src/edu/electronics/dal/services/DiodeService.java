package edu.electronics.dal.services;

import java.util.List;

import org.hibernate.Session;

import edu.electronics.dal.DataAccess;
import edu.electronics.dal.orm.Crystal;
import edu.electronics.dal.orm.Diode;

public class DiodeService extends BaseService {

	public static void saveDiode(Diode diode) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.save(diode);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	public static List<Diode> getAllDiodes() {
		Session session = DataAccess.openSession();
		return session.createCriteria(Diode.class).list();
	}
}
