package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testComponents.BaseClass;

public class ErrorValidationTest extends BaseClass {
	
	@Test
	public void LoginErrorValidation() {
		landingPage.loginApplication("wrongUserName", "wrongPassword");
		Assert.assertNotEquals("Invalid credentials", landingPage.getErrorMessage());
	}

}
