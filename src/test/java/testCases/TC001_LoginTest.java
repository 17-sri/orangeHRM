package testCases;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import testComponents.BaseClass;

public class TC001_LoginTest extends BaseClass {
	@Test
	public void loginApp() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		landingPage.loginApplication("Admin", "admin123");
	}

}
