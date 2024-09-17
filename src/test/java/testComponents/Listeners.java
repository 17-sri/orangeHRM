
package testComponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseClass implements ITestListener {
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();    //thread safe
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);      //assigning unique thread id for being thread safe
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "  Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    extentTest.get().log(Status.FAIL, "Test failed");
	    extentTest.get().fail(result.getThrowable());
	    try {
	        driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	        String filePath = getScreenshot(result.getMethod().getMethodName(), driver);
	        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onFinish(ITestContext result) {
		extent.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}
}
