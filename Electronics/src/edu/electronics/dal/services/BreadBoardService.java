package edu.electronics.dal.services;

import java.util.List;

import org.hibernate.Session;

import edu.electronics.dal.DataAccess;
import edu.electronics.dal.orm.BreadBoard;

public class BreadBoardService extends BaseService {

	public static void saveBreadBoard(BreadBoard breadBoard) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.save(breadBoard);
		session.getTransaction().commit();
		session.close();
	}
	public static void updateBreadBoard(BreadBoard breadBoard) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.update(breadBoard);
		session.getTransaction().commit();
		session.close();
	}
	public static void deleteBreadBoard(BreadBoard breadBoard) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		session.delete(breadBoard);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	public static List<BreadBoard> getAllBreadBoards() {
		Session session = DataAccess.openSession();
		return session.createCriteria(BreadBoard.class).list();
	}
}
