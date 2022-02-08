package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ApplicationsLayer.EmpPage;
import ApplicationsLayer.LogoutPage;
import ApplicationsLayer.OrangeHHRMLoginpage;

public class Orangehrmdriverscript {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./CommonDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://orangehrm.qedgetech.com/");
		OrangeHHRMLoginpage login = PageFactory.initElements(driver, OrangeHHRMLoginpage.class);
		login.verifyLogin("Admin", "Qedge123!@#");
	}
	@Test
	public void employeecreation() throws Throwable
	{
	EmpPage emp = PageFactory.initElements(driver, EmpPage.class);
	emp.verifyEmp("Sandeep", "Reddy");
	}
	@AfterTest
	public void teardown() throws Throwable
	{
		LogoutPage logout = PageFactory.initElements(driver, LogoutPage.class);
		logout.verifyLogout();
		driver.close();
	}
	}

