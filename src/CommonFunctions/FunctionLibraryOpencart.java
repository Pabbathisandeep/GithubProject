package CommonFunctions;

import org.openqa.selenium.By;
import org.testng.Reporter;

import Constant.PBConstant;

public class FunctionLibraryOpencart extends PBConstant
{

	//Method to click my account
	public static void clickMyAccount() throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("ObjMyAccount"))).click();
		Thread.sleep(2000);
	}
	// method to create Account 
		public static boolean VerifyRegister(String Fname, String Lname, String Email, String telephone, String passwrd, String passconfirm) throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("ObjRegister"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(config.getProperty("ObjFirstName"))).sendKeys(Fname);
		driver.findElement(By.xpath(config.getProperty("ObjLastName"))).sendKeys(Lname);
		driver.findElement(By.xpath(config.getProperty("ObjEmail"))).sendKeys(Email);
		driver.findElement(By.xpath(config.getProperty("ObjTelephone"))).sendKeys(telephone);
		driver.findElement(By.xpath(config.getProperty("ObjPasswrd"))).sendKeys(passwrd);
		driver.findElement(By.xpath(config.getProperty("Objpasswrdconfirm"))).sendKeys(passconfirm);
		Thread.sleep(3000);
		driver.findElement(By.xpath(config.getProperty("ObjPrivacypolicy"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(config.getProperty("ObjContinue"))).click();
		Thread.sleep(3000);
		String expectedurl = "success";
		String actualurl = driver.getCurrentUrl();
		if(actualurl.contains(expectedurl))
		{
			Reporter.log("Account creation success", true);
			return true;
		}
		else
		{
			Reporter.log("Account creation fail", true);
			return false;
		}
	}
	
	//method for logout
	  public static boolean verifyLogout() throws Throwable
	  {
		  driver.findElement(By.xpath(config.getProperty("ObjMyAccount"))).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath(config.getProperty("ObjLogout"))).click();
		  String expectedlogouturl = "logout";
		  String actuallogout = driver.getCurrentUrl();
		  if(actuallogout.toLowerCase().contains(expectedlogouturl))
		  {
			  Reporter.log("Account logout success", true);
				return true;
		  }
		  else
		  {
			  Reporter.log("Account logout fail", true);
				return false;
		  }
	  }
	
}
