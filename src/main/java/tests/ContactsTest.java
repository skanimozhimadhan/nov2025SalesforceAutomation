package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import constants.FileConstants;
import pages.ContactsPage;
import pages.HomePage;
import utils.FileUtils;
import utils.ListenersUtil;
import utils.ReportUtils;

@Listeners(ListenersUtil.class)
public class ContactsTest extends BaseTest {

	       @Test
			public void create_Contact_TC025()  {
				WebDriver driver =  BaseTest.getBrowser();
				ExtentTest test = ReportUtils.getTest();
				String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
				driver.get(loginUrl);
				//driver.get(BaseTest.loginURLOauth);

				test.info("Login url launched in browser");
				
				HomePage hp= new HomePage(driver);
				ContactsPage cp= hp.clickContacts(driver);
				Assert.assertTrue(cp.verifyContactCreation(driver));
				
			}
			
	       @Test
			public void create_Contact_TC032()  {
				WebDriver driver =  BaseTest.getBrowser();
				ExtentTest test = ReportUtils.getTest();
				String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
				driver.get(loginUrl);
				//driver.get(BaseTest.loginURLOauth);

				test.info("Login url launched in browser");
				
				HomePage hp= new HomePage(driver);
				ContactsPage cp= hp.clickContacts(driver);
				Assert.assertTrue(cp.verifyContactCreationSaveAndNew(driver));
				
			}
	        
	       @Test(dependsOnMethods = { "create_Contact_TC032()" })
			public void create_Contact_TC027()  {
				WebDriver driver =  BaseTest.getBrowser();
				ExtentTest test = ReportUtils.getTest();
				String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
				driver.get(loginUrl);
				//driver.get(BaseTest.loginURLOauth);

				test.info("Login url launched in browser");
				
				HomePage hp= new HomePage(driver);
				ContactsPage cp= hp.clickContacts(driver);
				Assert.assertTrue(cp.verifyRecentlyCreated(driver));
				
			}
	        @Test
	        public void create_Contact_TC028()  {
				WebDriver driver =  BaseTest.getBrowser();
				ExtentTest test = ReportUtils.getTest();
				String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
				driver.get(loginUrl);
				//driver.get(BaseTest.loginURLOauth);

				test.info("Login url launched in browser");
				
				HomePage hp= new HomePage(driver);
				ContactsPage cp= hp.clickContacts(driver);
				Assert.assertTrue(cp.verifyMyContacts(driver));
				
			}
	        @Test
	        public void create_Contact_TC029()  {
				WebDriver driver =  BaseTest.getBrowser();
				ExtentTest test = ReportUtils.getTest();
				String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
				driver.get(loginUrl);
				//driver.get(BaseTest.loginURLOauth);

				test.info("Login url launched in browser");
				
				HomePage hp= new HomePage(driver);
				ContactsPage cp= hp.clickContacts(driver);
				Assert.assertTrue(cp.verifyRecentContact(driver));
				
			}
	        
	       @Test
	        public void create_Contact_TC030()  {
				WebDriver driver =  BaseTest.getBrowser();
				ExtentTest test = ReportUtils.getTest();
				String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
				driver.get(loginUrl);
				//driver.get(BaseTest.loginURLOauth);

				test.info("Login url launched in browser");
				
				HomePage hp= new HomePage(driver);
				ContactsPage cp= hp.clickContacts(driver);
				Assert.assertTrue(cp.verifyErrorMessage(driver));
				
			}
	        
	        @Test
	        public void create_Contact_TC031()  {
				WebDriver driver =  BaseTest.getBrowser();
				ExtentTest test = ReportUtils.getTest();
				String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
				driver.get(loginUrl);
				//driver.get(BaseTest.loginURLOauth);

				test.info("Login url launched in browser");
				
				HomePage hp= new HomePage(driver);
				ContactsPage cp= hp.clickContacts(driver);
				Assert.assertTrue(cp.verifyContactCancel(driver));
				
			}
	        
			
}
