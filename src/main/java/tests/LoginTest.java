package tests;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import constants.FileConstants;
import pages.HomePage;
import pages.LoginPage;
import utils.FileUtils;
import utils.GmailUtil;
import utils.ListenersUtil;
import utils.ReportUtils;
import utils.WaitUtils;


@Listeners(ListenersUtil.class)
/**
 * All the login module test cases can be found here
 * Add the new
 * @author kani
 */


public class LoginTest extends BaseTest {

    @Test
	public void loginTest_TC001() {
		WebDriver driver =  BaseTest.getBrowser();
		ExtentTest test = ReportUtils.getTest();
		//WebDriver driver =  BaseTest.getDriver(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "browser.name"), false);
		driver.get(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "login.url"));
		test.info("Login url launched in browser");
		
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "username"));
		lp.clearPassword();
		lp.clickLogin();
		test.info("Login button clicked");

		
		String actualErrorText = lp.getErrorMessage(driver);
		String expectedErrorText = "Error: Please enter your password.";
		Assert.assertEquals(actualErrorText, expectedErrorText);
		test.info("Error message is validated");
		//driver.close();
	}
	
    @Test
	public void loginTest_TC002() throws InterruptedException  {
		//String loginUrl = BaseTest.getSfdcDirectLoginUrl();
	
		WebDriver driver =  BaseTest.getBrowser();
		ExtentTest test = ReportUtils.getTest();

		//WebDriver driver =  BaseTest.getDriver(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "browser.name"), false);
		driver.get(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "login.url"));
		test.info("Login url launched in browser");
	
		LoginPage lp = new LoginPage(driver);
		
	    lp.enterUsername(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "username"));
	    lp.enterPassword(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "password")); 
	    lp.rememberMeCheckBoxCheck();
	    test.info("remember me checkbox is checked");
	    lp.clickLogin(); 
	    test.info("Login button clicked");

	    String otp = null;
		long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < 30000) {
			otp = GmailUtil.getOTP("Verify your identity in Salesforce", "noreply@salesforce.com");
			if (otp != null) {
				break;
			}
			Thread.sleep(5000); // Poll every 5 seconds
		}

		if (otp == null) {
			Assert.fail("OTP not received within 30 seconds");
		}

		test.info("Retrieved otp "+ otp, null);
		lp.enterVerificationCode(otp);

	    test.info("The otp is entered");
	  HomePage hp=  lp.clickOnVerifyButton(driver);
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userNavLabel")));

    }
	
	@Test
	public void loginTest_TC003() throws InterruptedException  {
		//String loginUrl = BaseTest.getSfdcDirectLoginUrl();
	
		WebDriver driver =  BaseTest.getBrowser();
		ExtentTest test = ReportUtils.getTest();

		//WebDriver driver =  BaseTest.getDriver(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "browser.name"), false);
		driver.get(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "login.url"));
		test.info("Login url launched in browser");
	
		LoginPage lp = new LoginPage(driver);
		
	    lp.enterUsername(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "username"));
	    lp.enterPassword(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "password")); 
	    lp.rememberMeCheckBoxCheck();
	    test.info("remember me checkbox is checked");
	    lp.clickLogin(); 
	    test.info("Login button clicked");

	    String otp = null;
		long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < 30000) {
			otp = GmailUtil.getOTP("Verify your identity in Salesforce", "noreply@salesforce.com");
			if (otp != null) {
				break;
			}
			Thread.sleep(5000); // Poll every 5 seconds
		}

		if (otp == null) {
			Assert.fail("OTP not received within 30 seconds");
		}

		test.info("Retrieved otp "+ otp, null);
	    lp.enterVerificationCode(otp);
	    test.info("The otp is entered");
	  HomePage hp=  lp.clickOnVerifyButton(driver);
	
	    
		//driver.get(loginUrl);			
	 
		
	
		LoginPage lp1=hp.clickLogOutButton(driver);
				
		String actualUsername=FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "username");
		
		if(lp1.isLoginPageVisible()) {
		Assert.assertEquals(actualUsername, lp1.username.getAttribute("value"));
		}
		test.info("The username is remembered");
		//driver.close();
	}
	
	@Test(dependsOnMethods = { "loginTest_TC003()" })
	public void loginTest_TC004()  {
		
		WebDriver driver =  BaseTest.getBrowser();
		ExtentTest test = ReportUtils.getTest();
		//WebDriver driver = BaseTest.getDriver(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "browser.name"), false);
		driver.get(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "login.url"));
		test.info("Login url launched in browser");
		
		LoginPage lp = new LoginPage(driver);
		lp.clickForgotPassword();
		test.info("Forgot password is clicked");
		
		Assert.assertEquals(lp.isForgotPasswordPageVisible(), true);
	
		lp.enterFPUsername(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "username"));
		lp.clickContinue();
		
		Assert.assertEquals(lp.isCheckEmailPageVisible(), true);
	
		lp.returnToLoginClick();
		
		Assert.assertEquals(lp.isLoginPageVisible(), true);
		

		//driver.close();
	}
	
	@Test
	public void loginTest_TC005()  {
		WebDriver driver =  BaseTest.getBrowser();
		ExtentTest test = ReportUtils.getTest();
		//WebDriver driver =  BaseTest.getDriver(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "browser.name"), false);
		driver.get(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "login.url"));
		test.info("Login url launched in browser");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("123");
		lp.enterPassword("22131 ");
		lp.clickLogin();
		String actualErrorText = lp.getErrorMessage(driver);
		String expectedErrorText = "Error: Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		Assert.assertEquals(actualErrorText, expectedErrorText);
		
		//driver.close();
		
		
		
	}
	
	
}
