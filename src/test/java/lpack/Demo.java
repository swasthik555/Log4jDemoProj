package lpack;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	@SuppressWarnings("deprecation")
	@Test
	public void test() throws InterruptedException {

		Logger log = LogManager.getLogger(Demo.class.getName());
		log.debug("Demo Test Execution has Started");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		log.debug("Chrome Browser got launched");
		driver.manage().window().maximize();
		log.debug("Window maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com/");
		log.debug("Navigted to Omayo application");
		driver.findElement(By.linkText("onlytestingblog")).click();
		log.debug("Clicked on onlytestingblog and navigated to onlytestingblog page");
		driver.navigate().back();
		log.debug("Navigated backward to omayo application");
		driver.navigate().forward();
		log.debug("Navigated forward to onlytestingblog application");

		if (driver.getTitle().equals("Only Testing: TextBox")) {

			log.info("Success: The correct page title gor displayed");

		} else {
			
			log.error("Failed: Wrong title got displayed");
		
		}
		driver.quit();
		log.debug("Browser got closed and the Test got ended");

	}

}
