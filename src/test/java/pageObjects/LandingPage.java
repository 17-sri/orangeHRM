package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends AbstractComponents {

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "username")
	WebElement userName;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//button[text()=' Login ']")
	WebElement btnSubmit;

	public HomePage loginApplication(String uname, String pwd) {
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		userName.submit();
		HomePage homePage = new HomePage(driver);
		return homePage;
	}

	public void goTo() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public void logout() {

	}
}