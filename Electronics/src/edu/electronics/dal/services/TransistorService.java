package edu.electronics.dal.services;

import java.util.List;

import org.hibernate.Session;

import edu.electronics.dal.DataAccess;
import edu.electronics.dal.orm.SevenSegment;
import edu.electronics.dal.orm.Transistor;

public class TransistorService extends BaseService {

	public static void saveTransistor(Transistor transistor) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.save(transistor);
		session.getTransaction().commit();
		session.close();
	}

	public static void updateTransistor(Transistor transistor) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.update(transistor);
		session.getTransaction().commit();
		session.close();
	}

	public static void deleteTransistor(Transistor transistor) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.delete(transistor);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	public static List<Transistor> getAllTransistors() {
		Session session = DataAccess.openSession();
		return session.createCriteria(Transistor.class).list();
	}
}
