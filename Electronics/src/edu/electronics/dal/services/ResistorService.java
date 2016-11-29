package edu.electronics.dal.services;

import java.util.List;

import org.hibernate.Session;

import edu.electronics.dal.DataAccess;
import edu.electronics.dal.orm.Resistor;

public class ResistorService extends BaseService {

	public static void saveResistor(Resistor resistor) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.save(resistor);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void updateResistor(Resistor resistor) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.update(resistor);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void deleteResistor(Resistor resistor) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.delete(resistor);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	public static List<Resistor> getAllResistors() {
		Session session = DataAccess.openSession();
		return session.createCriteria(Resistor.class).list();
	}
}
