package ApplicationsLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	WebDriver driver;
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(xpath = "//a[@id='welcome']")
	WebElement clickwelcome;
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement clicklogout;
public void verifyLogout() throws Throwable
{
	Actions ac = new Actions(driver);
	ac.moveToElement(clickwelcome).click().perform();
	Thread.sleep(3000);
	ac.moveToElement(clicklogout).click().perform();
	
}
}
