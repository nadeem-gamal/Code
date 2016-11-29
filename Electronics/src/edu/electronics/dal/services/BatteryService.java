package edu.electronics.dal.services;

import java.util.List;

import org.hibernate.Session;

import edu.electronics.dal.DataAccess;
import edu.electronics.dal.orm.Battery;

public class BatteryService extends BaseService {

	public static void saveBattery(Battery battery) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.save(battery);
		session.getTransaction().commit();
		session.close();
	}

	public static void updateBattery(Battery battery) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.update(battery);
		session.getTransaction().commit();
		session.close();
	}

	public static void deleteBattery(Battery battery) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.delete(battery);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	public static List<Battery> getAllBatteries() {
		Session session = DataAccess.openSession();
		return session.createCriteria(Battery.class).list();
	}
}
