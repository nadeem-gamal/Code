package org.contactCars.dal.services;

import java.util.List;

import org.contactCars.dal.DataAccess;
import org.contactCars.dal.orm.Car;
import org.hibernate.Session;

public class CarService extends BaseService {

	public static void saveCar(Car car) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		try {
			if (car.getId() == null) {
				session.save(car);
			} else {
				session.update(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
	}

	public static void deleteCar(Car car) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		try {
			if (car.getId() != null) {
				session.delete(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
	}

	public static void deleteAllCars() {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		try {
			for (Car car : getAllCars()) {
				session.delete(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
	}

	public static List<Car> getAllCars() {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		List<Car> carList = session.createCriteria(Car.class).list();
		session.getTransaction().commit();
		session.close();
		return carList;
	}

}
