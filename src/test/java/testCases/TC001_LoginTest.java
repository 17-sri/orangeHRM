package testCases;

import org.testng.annotations.Test;

import testComponents.BaseClass;

public class TC001_LoginTest extends BaseClass {
	@Test
	public void loginApp() {
		landingPage.loginApplication("Admin", "admin123");

	}

}
