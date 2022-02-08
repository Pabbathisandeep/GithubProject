package Constant;

import java.io.FileInputStream;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class PBConstant {
	public static WebDriver driver;
	public static Properties config;
	@BeforeSuite
	public void setup() throws Throwable  
	{
		config = new Properties();
		config.load(new FileInputStream("C:\\Users\\HP\\Automation_selenium\\Automation_Frameworks\\PropertyFile\\Opencart.Properties"));
		if(config.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Automation_selenium\\Automation_Frameworks\\CommonDrivers\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(config.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(config.getProperty("Browser").equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".\\CommonDrivers\\geckodriver.exe");
			driver= new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(config.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else
		{
			Reporter.log("Browser value is not matching", true);
		}
	}
	@AfterSuite
	public void tearDown() {
		driver.close();
	}

}











