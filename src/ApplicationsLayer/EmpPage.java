package ApplicationsLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class EmpPage {
	WebDriver driver;
	public EmpPage(WebDriver driver)
	{
		this.driver = driver;
	}
	//define repository
	@FindBy(id="menu_pim_viewPimModule")
	WebElement clikcpim;
	@FindBy(name="btnAdd")
	WebElement clickAdd;
	@FindBy(xpath="//input[@id='firstName']")
	WebElement fname;
	@FindBy(xpath="//input[@id='lastName']")

	WebElement lname;
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement clicksave;
	@FindBy(xpath ="//input[@id='photofile']")
	WebElement clickChoosefile;
	public void verifyEmp(String fname, String lname) throws Throwable
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(clikcpim).click().perform();
		Thread.sleep(3000);
		ac.moveToElement(clickAdd).click().perform();
		Thread.sleep(3000);
		this.fname.sendKeys(fname);
		this.lname.sendKeys(lname);
		//ac.moveToElement(clickChoosefile).click().perform();
		//Runtime.getRuntime().exec("‪D:/FileUpload2.exe");
		Thread.sleep(3000);
		this.clicksave.click();
	}

}
