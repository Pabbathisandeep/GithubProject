package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import ApplicationsLayer.PrimusBankLoginPage;
import ApplicationsLayer.PrimusbankBranchPage;
import ApplicationsLayer.PrimusbankLogoutPage;

public class PrimusBankTestScript {
WebDriver driver;
@BeforeTest
public void setUp()
{
	System.setProperty("webdriver.chrome.driver", "./CommonDrivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("http://primusbank.qedgetech.com/");
	PrimusBankLoginPage login = PageFactory.initElements(driver, PrimusBankLoginPage.class);
	login.verifyLogin("Admin", "Admin");
}
@Test
public void newbranchcreation() throws Throwable
{
	PrimusbankBranchPage branch = PageFactory.initElements(driver, PrimusbankBranchPage.class);
	branch.verifynewbranch("dilsukhnagar", "LBnagar", "Uppal", "srnagar", "Pragathinagar", "505405", "INDIA", "Andhra Pradesh", "Hyderabad");
	
}
@AfterTest
public void teardown() throws Throwable
{
	PrimusbankLogoutPage logout = PageFactory.initElements(driver, PrimusbankLogoutPage.class);
	logout.verifyLogout();
	driver.close();
}



}
