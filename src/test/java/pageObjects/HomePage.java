package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractComponents {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(className = "oxd-userdropdown-tab")
	WebElement clkUser;
	@FindBy(className = "oxd-userdropdown-link")
	WebElement clkLogout;
	
	public void logout() {
		clkUser.click();
		clkLogout.click();
	}
	
	

}
