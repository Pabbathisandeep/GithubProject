package CommonFunctions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import Constant.PBConstant;

public class FunctionsLibrary extends PBConstant
{

	//Method for login
	public static boolean verifyLogin(String username, String password) throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("Objusername"))).sendKeys(username);
		driver.findElement(By.xpath(config.getProperty("Objpasswrd"))).sendKeys(password);
		driver.findElement(By.xpath(config.getProperty("ObjLoginbtn"))).click();
		Thread.sleep(3000);
		String expected = "adminflow";
		String actual = driver.getCurrentUrl();
		if(actual.toLowerCase().contains(expected.toLowerCase()))
		{
			Reporter.log("log in success::"+expected+"    "+actual);
			return true;

		}
		else
		{
			Reporter.log("log in fail::"+expected+"   "+actual);
			return false;

		}
	}
	//method click branches
	public static void clickBranches() throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("Objbranches"))).click();
		Thread.sleep(2000);
	}
	//method to create new branch
	public static boolean verifyNewBranchCreation(String bname, String address1,String address2, String address3,String area, String zipcode, String country,String state, String city) throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("Objnewbranch"))).click();
		driver.findElement(By.xpath(config.getProperty("Objbranchname"))).sendKeys(bname);
		driver.findElement(By.xpath(config.getProperty("Objaddress1"))).sendKeys(address1);
		driver.findElement(By.xpath(config.getProperty("Objaddress2"))).sendKeys(address1);
		driver.findElement(By.xpath(config.getProperty("Objaddress3"))).sendKeys(address1);
		driver.findElement(By.xpath(config.getProperty("Objarea"))).sendKeys(area);
		driver.findElement(By.xpath(config.getProperty("Objzipcode"))).sendKeys(zipcode);
		new Select(driver.findElement(By.xpath(config.getProperty("Objcountry")))).selectByVisibleText(country);
		Thread.sleep(3000);
		new Select(driver.findElement(By.xpath(config.getProperty("Objstate")))).selectByVisibleText(state);
		Thread.sleep(3000);
		new Select(driver.findElement(By.xpath(config.getProperty("Objcity")))).selectByVisibleText(city);
		Thread.sleep(3000);
		driver.findElement(By.xpath(config.getProperty("Objsubmitbtn"))).click();
		String expectedalert = driver.switchTo().alert().getText();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String actualAlert = "new Branch with";
		if(expectedalert.toLowerCase().contains(actualAlert.toLowerCase()))
		{
			Reporter.log("Branch creation success::"+expectedalert+"   "+actualAlert, true);
			return true;
		}
		else
		{
			Reporter.log("Branch creation fail::"+expectedalert+"   "+actualAlert,true);
			return false;
		}
	}
	//method for branch updation 
	public static boolean verifyBranchUpdates(String branch,String address1,String zipcode) throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("Objeditbtn"))).click();
		Thread.sleep(3000);
		WebElement branchname = driver.findElement(By.xpath(config.getProperty("Objbranchnameedit")));
		branchname.clear();
		branchname.sendKeys(branch);
		Thread.sleep(3000);
		WebElement Add = driver.findElement(By.xpath(config.getProperty("Objaddress1edit")));
		Add.clear();
		Add.sendKeys(address1);
		Thread.sleep(3000);
		WebElement Objzipcode = driver.findElement(By.xpath(config.getProperty("Objzipcodeeidt")));
		Objzipcode.clear();
		Objzipcode.sendKeys(zipcode);
		Thread.sleep(3000);
		driver.findElement(By.xpath(config.getProperty("Objupdatebtn"))).click();
		String expectedupdatealert = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String actualupdatealert = "Branch updated";
		if(expectedupdatealert.toLowerCase().contains(actualupdatealert.toLowerCase()))
		{
			Reporter.log("Branch updation success"+expectedupdatealert+"    "+actualupdatealert,true);
			return true;
		}
		else
		{
			Reporter.log("Branch updation not success"+expectedupdatealert+"  "+actualupdatealert,true);
			return false;
		}
	}
	//method for logout 
	public static boolean verifyLogOut() throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("Objlogoutbtn"))).click();
		Thread.sleep(3000);
		if(driver.findElement(By.xpath(config.getProperty("ObjLoginbtn"))).isDisplayed())
		{
			Reporter.log("logout success",true);
			return true;
		}
		else
		{
			Reporter.log("logout failed",true);
			return false;

		}
	}
	public static void clickRoles() throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("Objroles"))).click();
		Thread.sleep(2000);
	}
	
	public static boolean verifyRoleCreation(String rolename, String roledes, String roletype) throws Throwable
	{
		driver.findElement(By.xpath(config.getProperty("Objnewrole"))).click();
		driver.findElement(By.xpath(config.getProperty("Objrolename"))).sendKeys(rolename);
		driver.findElement(By.xpath(config.getProperty("Objroledes"))).sendKeys(roledes);
		Thread.sleep(3000);
		new Select(driver.findElement(By.xpath(config.getProperty("Objroletype")))).selectByVisibleText(roletype);
		Thread.sleep(3000);
		driver.findElement(By.xpath(config.getProperty("Objrolesubmitbtn"))).click();
		Thread.sleep(3000);
		String expectedalert = driver.switchTo().alert().getText();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String actualAlert = "New Role with id ";
		if(expectedalert.toLowerCase().contains(actualAlert.toLowerCase()))
		{
			Reporter.log("Role creation success::"+expectedalert+"   "+actualAlert, true);
			return true;
		}
		else
		{
			Reporter.log("Role creation fail::"+expectedalert+"   "+actualAlert,true);
			return false;
		}
		
	}
	public static String generateDates()
	{
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("YYYY_MM_dd hh_mm_ss");
		return df.format(date);
	}












}
