package org.contactCars;

import java.io.IOException;
import java.util.Date;

import org.contactCars.dal.orm.Car;
import org.contactCars.dal.services.CarService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ContactCarsRestTest {

	private static String baseUrl = "https://www.contactcars.com";
	private static String searchUrl = baseUrl + "/usedcars?search=uc&page=";

	public static void test() {
		// try {
		// URL url = new URL(baseUrl);
		//
		// InputStreamReader inputStreamReader = new
		// InputStreamReader(url.openStream());
		// BufferedReader bufferedReader = new
		// BufferedReader(inputStreamReader);
		//
		// String inputLine;
		// while ((inputLine = bufferedReader.readLine()) != null)
		// System.out.println(inputLine);
		// bufferedReader.close();

		// } catch (MalformedURLException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		
		CarService.deleteAllCars();

		int i = 0;
		try {
			System.out.println("Start: " + new Date());
			for (i = 1; i <= 682; i++) {
				Document doc = Jsoup.connect(searchUrl + i).get();
				// doc.select("div#latest_cars_new").forEach(System.out::println);
				Elements elements = doc.select("div#latest_cars_new");

				for (Element element : elements) {
					Elements items = element.select("div.item");
					for (Element item : items) {
						// System.out.println(item);
						// System.out.println("Year: " +
						// item.select("time.right").text());
						// System.out.println("Price: " +
						// item.select("span").text().split(" ")[0].replace(",",
						// ""));
						// System.out.println("URL: " + baseUrl +
						// item.select("a").attr("href"));
						// System.out.println("Brand: " +
						// item.select("p").get(0).text().split(" - ")[0]);
						// System.out.println("Model: " +
						// item.select("p").get(0).text().split(" - ")[1]);

						String[] brandModelTokens = item.select("p").get(0).text().split(" - ");
						Car car = new Car();
						car.setBrand(brandModelTokens[0]);
						car.setModel(brandModelTokens[1]);
						car.setPrice(Double.parseDouble(item.select("span").text().split(" ")[0].replace(",", "")));
						car.setUrl(baseUrl + item.select("a").attr("href"));
						car.setYear(Long.parseLong(item.select("time.right").text()));
						CarService.saveCar(car);

//						System.out.println("=========================");
					}
					// System.out.println(element);
					// System.out.println("-------------------------");
				}
//				try {
//					TimeUnit.SECONDS.sleep(5);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
			System.out.println("End: " + new Date());
		} catch (IOException e) {
			System.out.println("Exception i value = " + i);
			e.printStackTrace();
		}
	}
}
