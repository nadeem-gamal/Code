package org.contactCars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MantisTest {

	public static void test() {

		System.setProperty("webdriver.chrome.driver", "D:\\downloads\\temp\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://risksupport.ejada.com/mantisk/view_all_bug_page.php");

		WebElement usernameBox = driver.findElement(By.xpath("//input[@name='username']"));
		usernameBox.sendKeys("****");

		WebElement passwordBox = driver.findElement(By.xpath("//input[@name='password']"));
		passwordBox.sendKeys("****");

		WebElement buttonBox = driver.findElement(By.xpath("//input[@value='Login']"));
		buttonBox.click();

		Select projectsBox = new Select(driver.findElement(By.xpath("//select[@name='project_id']")));
		projectsBox.selectByValue("17");

		driver.findElement(By.xpath("//a[@id='hide_status_filter']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='hide_status[]']")));

		Select hideStatusBox = new Select(driver.findElement(By.xpath("//select[@name='hide_status[]']")));
		hideStatusBox.selectByValue("60");

		driver.findElement(By.xpath("//input[@value='Apply Filter']")).click();

		WebElement countBox = driver.findElement(By.xpath("//span[@class='floatleft']"));

		System.out.println(countBox.getText());

		driver.quit();

	}
}
