package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import testComponents.BaseClass;

public class TC001_LoginTest extends BaseClass {
	@Test
	public void loginApp() {
		HomePage homePage = landingPage.loginApplication("Admin", "admin123");
		//landingPage.goTo();
		//landingPage.loginApplication();
	}

}
