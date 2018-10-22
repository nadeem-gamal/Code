import java.util.List;

import org.contactCars.dal.DataAccess;
import org.contactCars.dal.orm.Brand;
import org.contactCars.dal.services.BrandService;

public class Program {

	public static void main(String[] args) {
		System.out.println("Start");

		DataAccess.init();
		List<Brand> brandList = BrandService.getAllActiveBrands();
		for (Brand brand : brandList) {
			ContactCarsTest.test(brand.getValue());
		}

		DataAccess.close();
		System.out.println("End");
	}
}
