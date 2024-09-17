package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.LandingPage;

public class BaseClass {
	public WebDriver driver;
	public LandingPage landingPage;
	Properties properties = new Properties();

	public WebDriver initializeDriver() throws IOException {
		
		FileInputStream fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\utilities\\GlobalData.properties");
		properties.load(fileInputStream);
		String browserName = properties.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			// edge browser code is here
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	 public String getUsername() {
	        return properties.getProperty("username");
	    }

	    public String getPassword() {
	        return properties.getProperty("password");
	    }
	    
	    public void login() {
	    	String username = getUsername();
	        String password = getPassword();
			landingPage.loginApplication(username, password);
	    }
	    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String filePath = System.getProperty("user.dir") + "//screenshots//" + testCaseName + timeStamp+ ".png";
			File file = new File(filePath);
			FileUtils.copyFile(source, file);
			return filePath;
		}

	@BeforeMethod(alwaysRun = true)
	//if we want to run in groups, we should mention (alwaysRun = true) for prerequisites
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}

	@AfterMethod(alwaysRun = true)
	//if we want to run in groups, we should mention (alwaysRun = true) for postrequisites
	public void tearDown() {
		driver.quit();
	}
}