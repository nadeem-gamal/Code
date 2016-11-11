package edu.electronics.dal.services;

import java.util.List;

import org.hibernate.Session;

import edu.electronics.dal.DataAccess;
import edu.electronics.dal.orm.PushButton;
import edu.electronics.dal.orm.SevenSegment;

public class SevenSegmentService extends BaseService {

	public static void saveSevenSegment(SevenSegment sevenSegment) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.save(sevenSegment);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	public static List<SevenSegment> getAllSevenSegments() {
		Session session = DataAccess.openSession();
		return session.createCriteria(SevenSegment.class).list();
	}
}
