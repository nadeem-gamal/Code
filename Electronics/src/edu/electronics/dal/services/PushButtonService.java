package edu.electronics.dal.services;

import java.util.List;

import org.hibernate.Session;

import edu.electronics.dal.DataAccess;
import edu.electronics.dal.orm.LED;
import edu.electronics.dal.orm.PushButton;

public class PushButtonService extends BaseService {

	public static void savePushButton(PushButton pushButton) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.save(pushButton);
		session.getTransaction().commit();
		session.close();
	}
	public static void updatePushButton(PushButton pushButton) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.update(pushButton);
		session.getTransaction().commit();
		session.close();
	}
	public static void deletePushButton(PushButton pushButton) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.delete(pushButton);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	public static List<PushButton> getAllPushButtons() {
		Session session = DataAccess.openSession();
		return session.createCriteria(PushButton.class).list();
	}
}
