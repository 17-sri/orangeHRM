
package testComponents;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	public static ExtentReports getReportObject() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Report-"+timeStamp+".html";
		String path = System.getProperty("user.dir") + "//reports//"+reportName;
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.DARK);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("TestEngineer", "SRIKANTH V");
		extent.setSystemInfo("Application", "demo_E-com");
		return extent;
	}
}
