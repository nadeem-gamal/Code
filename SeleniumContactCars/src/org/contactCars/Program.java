package org.contactCars;

import org.contactCars.dal.DataAccess;

public class Program {

	public static void main(String[] args) {
		System.out.println("Start");
//		System.out.println("Start: " + new Date());

//		try {
//			TimeUnit.SECONDS.sleep(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		DataAccess.init();
//		List<Brand> brandList = BrandService.getAllActiveBrands();
//		for (Brand brand : brandList) {
//			ContactCarsTest.test(brand.getValue());
//		}

		ContactCarsRestTest.test();

		DataAccess.close();
//		System.out.println("End: " + new Date());
		System.out.println("End");
	}
}
