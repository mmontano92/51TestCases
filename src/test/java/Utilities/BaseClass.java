package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
		public static WebDriver driver;
		public static WebDriver getDriver() {
			
			if (driver== null) {
				switch ("chrome") {
				case "chrome";
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				
				case "chrome-headless";
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver (new ChromeOptions().setHeadless(true));
				
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "edge":
					if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
						throw new WebDriverException("Your OS doesn't support Edge");
					}
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				case "safari":
					if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
						throw new WebDriverException("Your OS doesn't support Safari");
					}
					WebDriverManager.safaridriver().setup();
					driver = new SafariDriver();
					break;
				}
				driver.get(propertiesFiles.getProperty("OrangeUrl"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
				
			}
		}

		
			

			
			public static void teadDown() {
				
				if (driver != null) {
				driver.quit();
				driver.close();
				
			}
			
			}
}
			

			

		

				
				
				
				
		
	
	
	
	
	


