package edu.electronics.dal.services;

import java.util.List;

import org.hibernate.Session;

import edu.electronics.dal.DataAccess;
import edu.electronics.dal.orm.Diode;
import edu.electronics.dal.orm.DipSwitch;

public class DipSwitchService extends BaseService {

	public static void saveDipSwitch(DipSwitch dipSwitch) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.save(dipSwitch);
		session.getTransaction().commit();
		session.close();
	}
	public static void updateDipSwitch(DipSwitch dipSwitch) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.update(dipSwitch);
		session.getTransaction().commit();
		session.close();
	}
	public static void deleteDipSwitch(DipSwitch dipSwitch) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.delete(dipSwitch);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	public static List<DipSwitch> getAllDipSwitches() {
		Session session = DataAccess.openSession();
		return session.createCriteria(DipSwitch.class).list();
	}
}
