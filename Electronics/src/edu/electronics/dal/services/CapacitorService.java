package edu.electronics.dal.services;

import java.util.List;

import org.hibernate.Session;

import edu.electronics.dal.DataAccess;
import edu.electronics.dal.orm.BreadBoard;
import edu.electronics.dal.orm.Capacitor;

public class CapacitorService extends BaseService {

	public static void saveCapacitor(Capacitor capacitor) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.save(capacitor);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	public static List<Capacitor> getAllCapacitors() {
		Session session = DataAccess.openSession();
		return session.createCriteria(Capacitor.class).list();
	}
}
