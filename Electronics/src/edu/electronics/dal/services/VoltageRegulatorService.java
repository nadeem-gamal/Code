package edu.electronics.dal.services;

import java.util.List;

import org.hibernate.Session;

import edu.electronics.dal.DataAccess;
import edu.electronics.dal.orm.Transistor;
import edu.electronics.dal.orm.VoltageRegulator;

public class VoltageRegulatorService extends BaseService {

	public static void saveVoltageRegulator(VoltageRegulator voltageRegulator) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.save(voltageRegulator);
		session.getTransaction().commit();
		session.close();
	}

	public static void updateVoltageRegulator(VoltageRegulator voltageRegulator) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.update(voltageRegulator);
		session.getTransaction().commit();
		session.close();
	}

	public static void deleteVoltageRegulator(VoltageRegulator voltageRegulator) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.delete(voltageRegulator);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	public static List<VoltageRegulator> getAllVoltageRegulators() {
		Session session = DataAccess.openSession();
		return session.createCriteria(VoltageRegulator.class).list();
	}
}
