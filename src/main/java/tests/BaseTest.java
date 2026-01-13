package tests;

import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import com.salesforce.oauth.SalesforceAuth;
import utils.ReportUtils;

public class BaseTest {
	
	public static String loginURLOauth = "";
	
	private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
	public static Logger logger = LogManager.getLogger(BaseTest.class);
	
	public void generateOAuthURLToLogin() {
		 BaseTest.loginURLOauth = BaseTest.getSfdcDirectLoginUrl();
		 logger.log(Level.INFO, "Login oauth url generated "+loginURLOauth);;
	}
	
	@BeforeMethod
	public void init(Method method) {
		BaseTest.setDriver("chrome", false);
	}
	
	@AfterMethod
	public void quitBrowserInstance() {
		BaseTest.getBrowser().quit();
	}
	
	
	public static void setDriver(String browserName, boolean headless) {
		WebDriver driver = BaseTest.getDriver(browserName, headless);
		if(driver == null) {
			throw new RuntimeException("Webdriver initialization failed");
		}
		threadLocal.set(driver);
	}
	
	public static WebDriver getBrowser() {
		return threadLocal.get();
	}
	

	public static WebDriver getDriver(String browserName, boolean isHeadless) {
		WebDriver driver = null;
		switch (browserName.toLowerCase()) {
		case "chrome":
			if(isHeadless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
				logger.log(Level.INFO, "Chrome driver object is created with headless mode");
			} else {
				driver = new ChromeDriver();
				logger.log(Level.INFO, "Chrome driver object is created  ");
			}
			break;

		case "safari":
			driver = new SafariDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Allowed browsers are chrome, safari, firefox. Any other syntax fails to return driver");
			break;
		}
		if(driver!=null) {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

		return driver;

	}
	
	public static String getSfdcDirectLoginUrl() {
		final String CONSUMER_KEY = "3MVG9rZjd7MXFdLj4SPjUucdAc7W8cgh_6TKjAbC7QlIiJFKr.nmUWPFUqVLafE36yxNWV1ccWGuKULHDoDph";
	    final String CONSUMER_SECRET = "03A8CFA9E9941610B67BE93A5E0DDC4A9C6B550E1CA924A882CCAAF5C1BB3DB3";    
		SalesforceAuth auth = new SalesforceAuth(CONSUMER_KEY, CONSUMER_SECRET, false);
		String url = auth.start();
		System.out.println(url);
		return url;

	}

}
