package edu.electronics.dal.services;

import java.util.List;

import org.hibernate.Session;

import edu.electronics.dal.DataAccess;
import edu.electronics.dal.orm.IC;

public class ICService extends BaseService {

	public static void saveIC(IC ic) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.save(ic);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	public static List<IC> getAllICs() {
		Session session = DataAccess.openSession();
		return session.createCriteria(IC.class).list();
	}
}
