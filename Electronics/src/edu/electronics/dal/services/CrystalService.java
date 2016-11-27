package edu.electronics.dal.services;

import java.util.List;

import org.hibernate.Session;

import edu.electronics.dal.DataAccess;
import edu.electronics.dal.orm.BreadBoard;
import edu.electronics.dal.orm.Capacitor;
import edu.electronics.dal.orm.Crystal;

public class CrystalService extends BaseService {

	public static void saveCrystal(Crystal crystal) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.save(crystal);
		session.getTransaction().commit();
		session.close();
	}
	public static void updateCrystal(Crystal crystal) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.update(crystal);
		session.getTransaction().commit();
		session.close();
	}
	public static void deleteCrystal(Crystal crystal) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.delete(crystal);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	public static List<Crystal> getAllCrystals() {
		Session session = DataAccess.openSession();
		return session.createCriteria(Crystal.class).list();
	}
}
