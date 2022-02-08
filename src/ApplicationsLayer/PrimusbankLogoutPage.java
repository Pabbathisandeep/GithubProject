package ApplicationsLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PrimusbankLogoutPage {
	WebDriver driver;
	public PrimusbankLogoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	@FindBy(xpath = "//tbody/tr[1]/td[3]/a[1]/img[1]")
	WebElement Logoutbtn;
	public void verifyLogout()
	{
		Actions ac= new Actions(driver);
		ac.moveToElement(Logoutbtn).click().perform();
	}
	

}
