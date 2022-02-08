package ApplicationsLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class OrangeHHRMLoginpage {
	WebDriver driver;
	public OrangeHHRMLoginpage(WebDriver driver)
	{
		this.driver = driver;
	}
	//define repository
	@FindBy(name = "txtUsername")
	WebElement Username;
	@FindBy(name ="txtPassword")
	WebElement Password;
	@FindBy(name = "Submit")
	WebElement loginbtn;
	public void verifyLogin(String Username, String Password)
	{
		Actions ac = new Actions(driver);
		this.Username.sendKeys(Username);
		this.Password.sendKeys(Password);
		ac.moveToElement(loginbtn).click().perform();
	}
	

}
