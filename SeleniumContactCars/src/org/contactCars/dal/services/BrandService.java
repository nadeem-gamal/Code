package org.contactCars.dal.services;

import java.util.List;

import org.contactCars.dal.DataAccess;
import org.contactCars.dal.orm.Brand;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class BrandService extends BaseService {

	public static void saveBrand(Brand brand) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		try {
			if (brand.getId() == null) {
				session.save(brand);
			} else {
				session.update(brand);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
	}

	public static void deleteBrand(Brand brand) {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		try {
			if (brand.getId() != null) {
				session.delete(brand);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
	}

	public static List<Brand> getAllActiveBrands() {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Brand.class);
		criteria.add(Restrictions.eq("enabled", 1));
		List<Brand> brandList = criteria.list();
		session.getTransaction().commit();
		session.close();
		return brandList;
	}

	public static List<Brand> getAllBrands() {
		Session session = DataAccess.openSession();
		session.beginTransaction();
		List<Brand> brandList = session.createCriteria(Brand.class).list();
		session.getTransaction().commit();
		session.close();
		return brandList;
	}

}
