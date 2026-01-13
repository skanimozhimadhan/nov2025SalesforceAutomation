package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import constants.FileConstants;
import pages.CreateOptyPage;
import pages.HomePage;

import utils.FileUtils;
import utils.ListenersUtil;
import utils.ReportUtils;

@Listeners(ListenersUtil.class)
public class Opportunities extends BaseTest {
	
	@Test
	public void userMenu_TC015() throws InterruptedException {
		WebDriver driver =  BaseTest.getBrowser();
		ExtentTest test = ReportUtils.getTest();
		String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
		driver.get(loginUrl);
		//driver.get(BaseTest.loginURLOauth);

		test.info("Login url launched in browser");
		HomePage hp= new HomePage(driver);
		CreateOptyPage op=hp.clickOpportunities(driver);		
		String[] expectedUserMenuOptions= FileUtils.readPropertiesFile(FileConstants.OPPORTUNITIES_TEST_DATA_FILE_PATH, "user.menu.options").split(",");
		String[] actualUserMenuOptions = op.getOpportunitiesOption().toArray(new String[0]);
		Assert.assertEquals(expectedUserMenuOptions, actualUserMenuOptions);
		
	}
	@Test
	public void userMenu_TC016() throws InterruptedException {
		WebDriver driver =  BaseTest.getBrowser();
		ExtentTest test = ReportUtils.getTest();
		String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
		driver.get(loginUrl);
		//driver.get(BaseTest.loginURLOauth);

		test.info("Login url launched in browser");
		HomePage hp= new HomePage(driver);
		CreateOptyPage op=hp.clickOpportunities(driver);		
		Assert.assertTrue(op.isOpportunitiesPageDisplayed(), "Opportunities Page is displayed");
		Assert.assertTrue(op.isOpportunitiesEditPageDisplayed(driver), "Opportunities Edit Page is displayed");
		Assert.assertTrue(op.isOpportunitiesCreated(driver), "Opportunities is created and Opportunities detail page is displayed");
		
	}
	
	@Test
	public void userMenu_TC017() throws InterruptedException {
		WebDriver driver =  BaseTest.getBrowser();
		ExtentTest test = ReportUtils.getTest();
		String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
		driver.get(loginUrl);
		//driver.get(BaseTest.loginURLOauth);

		test.info("Login url launched in browser");
		HomePage hp= new HomePage(driver);
		CreateOptyPage op=hp.clickOpportunities(driver);		
		Assert.assertTrue(op.isOpportunitiesPageDisplayed(), "Opportunities Page is displayed");
		Assert.assertTrue(op.isOpportunitiesPipeline(driver), "Opportunities Pipeline Report Details is displayed");
		
		
	}
	
	@Test
	public void userMenu_TC018() throws InterruptedException {
		WebDriver driver =  BaseTest.getBrowser();
		ExtentTest test = ReportUtils.getTest();
		String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
		driver.get(loginUrl);
		//driver.get(BaseTest.loginURLOauth);

		test.info("Login url launched in browser");
		HomePage hp= new HomePage(driver);
		CreateOptyPage op=hp.clickOpportunities(driver);		
		Assert.assertTrue(op.isOpportunitiesPageDisplayed(), "Opportunities Page is displayed");
		Assert.assertTrue(op.isOpportunitiesStuck(driver), "Opportunities Stuck Report Details is displayed");
		
		
	}

}
