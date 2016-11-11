package edu.electronics.dal.services;

import java.util.List;

import org.hibernate.Session;

import edu.electronics.dal.DataAccess;
import edu.electronics.dal.orm.IC;
import edu.electronics.dal.orm.LED;

public class LEDService extends BaseService {

	public static void saveLED(LED led) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.save(led);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	public static List<LED> getAllLEDs() {
		Session session = DataAccess.openSession();
		return session.createCriteria(LED.class).list();
	}
}
