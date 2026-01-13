package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import constants.FileConstants;
import pages.AccountPage;
import pages.HomePage;
import pages.UserMenu;
import utils.FileUtils;
import utils.ListenersUtil;
import utils.ReportUtils;

@Listeners(ListenersUtil.class)
public class AccountTest extends BaseTest {
	
	    @Test
		public void create_Account_TC010()  {
			WebDriver driver =  BaseTest.getBrowser();
			ExtentTest test = ReportUtils.getTest();
			String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
			driver.get(loginUrl);
			//driver.get(BaseTest.loginURLOauth);

			test.info("Login url launched in browser");
			
			HomePage hp= new HomePage(driver);
			AccountPage ap= hp.clickAccounts(driver);
			Assert.assertTrue(ap.verifyAccountCreation(driver));
			
		}
		
		 @Test
			public void create_Account_TC011()  {
				WebDriver driver =  BaseTest.getBrowser();
				ExtentTest test = ReportUtils.getTest();
				String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
				driver.get(loginUrl);
				//driver.get(BaseTest.loginURLOauth);

				test.info("Login url launched in browser");
				
				HomePage hp= new HomePage(driver);
				AccountPage ap= hp.clickAccounts(driver);
				Assert.assertTrue(ap.verifyCreateNewView(driver));
				
			}
		    
	    @Test
		public void create_Account_TC012()  {
			WebDriver driver =  BaseTest.getBrowser();
			ExtentTest test = ReportUtils.getTest();
			String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
			driver.get(loginUrl);
			//driver.get(BaseTest.loginURLOauth);

			test.info("Login url launched in browser");
			
			HomePage hp= new HomePage(driver);
			AccountPage ap= hp.clickAccounts(driver);
			Assert.assertTrue(ap.verifyEditViewName(driver));
			
		}
	    
	    @Test
	  		public void create_Account_TC014()  {
	  			WebDriver driver =  BaseTest.getBrowser();
	  			ExtentTest test = ReportUtils.getTest();
	  			String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
	  			driver.get(loginUrl);
	  			//driver.get(BaseTest.loginURLOauth);

	  			test.info("Login url launched in browser");
	  			
	  			HomePage hp= new HomePage(driver);
	  			AccountPage ap= hp.clickAccounts(driver);
	  			Assert.assertTrue(ap.verifyCreateAccountReport(driver));
	  			
	  		}
	    
}
