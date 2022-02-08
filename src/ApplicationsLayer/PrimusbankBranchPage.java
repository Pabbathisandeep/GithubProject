package ApplicationsLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PrimusbankBranchPage {
	WebDriver driver;
	public PrimusbankBranchPage(WebDriver driver)
	{
		this.driver = driver;
	}
	@FindBy(xpath = "//tbody/tr[2]/td[1]/a[1]/img[1]")
	WebElement Branches;
	@FindBy(name = "BtnNewBR")
	WebElement newbranch;
	@FindBy(name = "txtbName")
	WebElement Branchname;
	@FindBy(name = "txtAdd1")
	WebElement address1;
	@FindBy(name = "Txtadd2")
	WebElement address2;
	@FindBy(name = "txtadd3")
	WebElement address3;
	@FindBy(name = "txtArea")
	WebElement area;
	@FindBy(name = "txtZip")
	WebElement zip;
	@FindBy(name = "lst_counrtyU")
	WebElement country;
	@FindBy(name = "lst_stateI")
	WebElement state;
	@FindBy(name = "lst_cityI")
	WebElement city;
	@FindBy(name = "btn_insert")
	WebElement submitbtn;
	public void verifynewbranch(String Branchname, String address1, String address2, String address3, String area, String zip, String country, String state, String city) throws Throwable
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(Branches).click().perform();
		Thread.sleep(3000);
		ac.moveToElement(newbranch).click().perform();
		Thread.sleep(3000);
		this.Branchname.sendKeys(Branchname);
		this.address1.sendKeys(address1);
		this.address2.sendKeys(address2);
		this.address3.sendKeys(address3);
		this.area.sendKeys(area);
		this.zip.sendKeys(zip);
		new Select(this.country).selectByVisibleText(country);
		new Select(this.state).selectByVisibleText(state);
		new Select(this.city).selectByVisibleText(city);
		ac.moveToElement(submitbtn).click().perform();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
	}
	
	
	
	
}
