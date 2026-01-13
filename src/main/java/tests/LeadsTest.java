package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import constants.FileConstants;

import pages.HomePage;
import pages.LeadsPage;
import utils.FileUtils;
import utils.ListenersUtil;
import utils.ReportUtils;

@Listeners(ListenersUtil.class)
public class LeadsTest extends BaseTest {

	
	        @Test
			public void Leads_TC020()  {
				WebDriver driver =  BaseTest.getBrowser();
				ExtentTest test = ReportUtils.getTest();
				String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
				driver.get(loginUrl);
				//driver.get(BaseTest.loginURLOauth);

				test.info("Login url launched in browser");
				
				HomePage hp= new HomePage(driver);
				LeadsPage ld= hp.clickLeads(driver);
				Assert.assertTrue(ld.isLeadsPageDisplayed());
				
			}
	        
	        @Test
			public void Leads_TC021()  {
				WebDriver driver =  BaseTest.getBrowser();
				ExtentTest test = ReportUtils.getTest();
				String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
				driver.get(loginUrl);
				//driver.get(BaseTest.loginURLOauth);

				test.info("Login url launched in browser");
				
				HomePage hp= new HomePage(driver);
				LeadsPage ld= hp.clickLeads(driver);
				String[] expectedUserMenuOptions= FileUtils.readPropertiesFile(FileConstants.LEADS_TEST_DATA_FILE_PATH, "user.menu.options").split(",");
				String[] actualUserMenuOptions = ld.getLeadsOption().toArray(new String[0]);
				Assert.assertEquals(expectedUserMenuOptions, actualUserMenuOptions);
				
				
			}
	        
	        
	        @Test
			public void Leads_TC023()  {
				WebDriver driver =  BaseTest.getBrowser();
				ExtentTest test = ReportUtils.getTest();
				String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
				driver.get(loginUrl);
				//driver.get(BaseTest.loginURLOauth);

				test.info("Login url launched in browser");
				
				HomePage hp= new HomePage(driver);
				LeadsPage ld= hp.clickLeads(driver);
				Assert.assertTrue(ld.isTodaysLeadsPageDisplayed(driver));
				
				
			}
	        
	        @Test
			public void Leads_TC024()  {
				WebDriver driver =  BaseTest.getBrowser();
				ExtentTest test = ReportUtils.getTest();
				String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
				driver.get(loginUrl);
				//driver.get(BaseTest.loginURLOauth);

				test.info("Login url launched in browser");
				
				HomePage hp= new HomePage(driver);
				LeadsPage ld= hp.clickLeads(driver);
				Assert.assertTrue(ld.isLeadsCreated(driver));
				}
	        
	        
	        
}
