package ApplicationsLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	//define Repository
	@FindBy(name= "txtUsername")
	WebElement Username;
	@FindBy(name= "txtPassword")
	WebElement Password;
	@FindBy(id= "btnLogin")
	WebElement loginbtn;
	//write method for login
	public void verifyLogin(String Username, String Password)
	{
		Actions ac = new Actions(driver);
		
		this.Username.sendKeys(Username);
		this.Password.sendKeys(Password);
		ac.moveToElement(loginbtn).click().perform();
	}

}
