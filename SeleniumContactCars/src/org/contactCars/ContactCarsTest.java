package org.contactCars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactCarsTest {

	public static void test(Integer brandValue) {
		System.setProperty("webdriver.chrome.driver", "D:\\downloads\\temp\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.contactcars.com/usedcars?search=uc&mk=" + brandValue);

		List<WebElement> usedCarBoxList = driver.findElements(By.xpath("//div[@class='usedCarsListView panel custom_p_2']"));
		int index = 0;
		for (WebElement usedCarBox : usedCarBoxList) {
			String url = usedCarBox.findElement(By.tagName("a")).getAttribute("href");

			String priceStr = usedCarBox.findElements(By.xpath("//span[@class='orange_txt left']")).get(index).getText();
			Double price = Double.parseDouble(priceStr.split(" ")[0].replace(",", ""));

			String yearStr = usedCarBox.findElements(By.xpath("//p[@class='tit_10 ']")).get(index).getText();
			Long year = Long.parseLong(yearStr.split(" - ")[1]);

			
			System.out.println(year);
			
			FileWriter.write(usedCarBox.getText(), url, price, year);
			index++;
		}

//		driver.quit();

	}
}
