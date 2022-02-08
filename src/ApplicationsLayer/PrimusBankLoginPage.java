package ApplicationsLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class PrimusBankLoginPage {
	WebDriver driver;
	public PrimusBankLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	//define repository
	@FindBy(name = "txtuId")
	WebElement Username;
	@FindBy(name = "txtPword")
	WebElement Password;
	@FindBy(name = "login")
	WebElement Loginbtn;
	public void verifyLogin(String Username, String Password)
	{
		Actions ac = new Actions(driver);
		this.Username.sendKeys(Username);
		this.Password.sendKeys(Password);
		ac.moveToElement(Loginbtn).click().perform();
	}
	
}
