package tests;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import constants.FileConstants;
import pages.HomePage;
import pages.LoginPage;
import pages.MyProfilePage;
import pages.MySettingsPage;
import pages.UserMenu;
import utils.FileUtils;
import utils.GmailUtil;
import utils.ListenersUtil;
import utils.ReportUtils;

@Listeners(ListenersUtil.class)

public class UserMenuTest extends BaseTest{
	
	
	//@Test
	public void userMenu_TC05() throws InterruptedException {
		WebDriver driver =  BaseTest.getBrowser();
		ExtentTest test = ReportUtils.getTest();
		String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
		driver.get(loginUrl);
		//driver.get(BaseTest.loginURLOauth);

		test.info("Login url launched in browser");
		
		UserMenu um = new UserMenu(driver);
		String[] expectedUserMenuOptions= FileUtils.readPropertiesFile(FileConstants.MYPROFILE_TEST_DATA_FILE_PATH, "user.menu.options").split(",");
		String[] actualUserMenuOptions = um.getUserMenuOption().toArray(new String[0]);
		Assert.assertEquals(expectedUserMenuOptions, actualUserMenuOptions);
		
	}

	//@Test
	public void myProfile_TC06() throws InterruptedException {
		WebDriver driver =  BaseTest.getBrowser();
		ExtentTest test = ReportUtils.getTest();
		String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
		driver.get(loginUrl);
		test.info("Login url launched in browser");
		

		UserMenu um = new UserMenu(driver);
		String[] expectedUserMenuOptions= FileUtils.readPropertiesFile(FileConstants.MYPROFILE_TEST_DATA_FILE_PATH, "user.menu.options").split(",");
		String[] actualUserMenuOptions = um.getUserMenuOption().toArray(new String[0]);
		Assert.assertEquals(expectedUserMenuOptions, actualUserMenuOptions);
		MyProfilePage profile = um.selectMyProfile(driver);
		test.info("Myprofile page is selected");
		Assert.assertTrue(profile.isProfilePageLoaded(driver), "Profile page should be loaded");
		profile.waitAndClickOnEditIcon(driver);
		Assert.assertTrue(profile.verifyEditProfilePopUpIsVisible(driver), "Edit profile pop up should be visible");
		Assert.assertTrue(profile.verifyChangeLastNameInAboutTab(driver, "Abcd"), "Lastname should be updated");
		String postMessage = FileUtils.readPropertiesFile(FileConstants.MYPROFILE_TEST_DATA_FILE_PATH, "post.message");
		Assert.assertTrue(profile.verifyCreatePost(driver, postMessage));
		Assert.assertTrue(profile.verifyFileUpload(driver, FileConstants.TEST_DATA_FILE_TO_UPLOAD));
		Assert.assertTrue(profile.verifyAddPhoto(driver, FileConstants.PHOTO_UPLOAD_PATH));
	}


	@Test
	public void mySettings_TC007() throws InterruptedException {
		WebDriver driver =  BaseTest.getBrowser();
		ExtentTest test = ReportUtils.getTest();
		String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
		driver.get(loginUrl);
		test.info("Login url launched in browser");
		
		UserMenu um = new UserMenu(driver);
		String[] expectedUserMenuOptions= FileUtils.readPropertiesFile(FileConstants.MYPROFILE_TEST_DATA_FILE_PATH, "user.menu.options").split(",");
		String[] actualUserMenuOptions = um.getUserMenuOption().toArray(new String[0]);
		Assert.assertEquals(expectedUserMenuOptions, actualUserMenuOptions);
		MySettingsPage setting = um.selectMySettings(driver);
		Assert.assertTrue(setting.isMySettingsPageLoaded(driver),"My settings page is loaded");
		Assert.assertTrue(setting.isLoginHistoryLoaded(driver),"My login history is loaded");
		Assert.assertTrue(setting.isLoginHistoryDownloaded(driver),"My login history is downloaded");
		Assert.assertTrue(setting.verifyReportsTab(driver)," Verify if Reports Tab is added");
		MySettingsPage setting1 = um.selectMySettings(driver);
		Assert.assertTrue(setting1.verifyEmailTab(driver)," Verify if Email Tab is loaded");
		
		String actualEmailName=FileUtils.readPropertiesFile(FileConstants.MYSETTINGS_TEST_DATA_FILE_PATH, "emailname");
		String actualEmailAddress=FileUtils.readPropertiesFile(FileConstants.MYSETTINGS_TEST_DATA_FILE_PATH, "emailaddress");
		
		Assert.assertEquals(actualEmailName, setting1.emailName.getAttribute("value"));
		Assert.assertEquals(actualEmailAddress, setting1.emailaddress.getAttribute("value"));
	    Assert.assertTrue(setting1.BCCYes.isSelected(), "BCC is selected by default");
		Assert.assertTrue(setting1.verifySave(driver),"email settings is saved" );
	    MySettingsPage setting2 = um.selectMySettings(driver);
		Assert.assertTrue(setting2.isMySettingsPageLoaded(driver),"My settings page is loaded");
		Assert.assertTrue(setting2.verifyActivityandReminder(driver),"Sample Reminder is opened");
	}

	//@Test
	public void mySettings_TC008(){
		WebDriver driver =  BaseTest.getBrowser();
		ExtentTest test = ReportUtils.getTest();
		String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
		driver.get(loginUrl);
		test.info("Login url launched in browser");
		UserMenu um = new UserMenu(driver);
		String[] expectedUserMenuOptions= FileUtils.readPropertiesFile(FileConstants.MYPROFILE_TEST_DATA_FILE_PATH, "user.menu.options").split(",");
		String[] actualUserMenuOptions = um.getUserMenuOption().toArray(new String[0]);
		Assert.assertEquals(expectedUserMenuOptions, actualUserMenuOptions);
		Assert.assertTrue(um.selectDeveloperConsole(driver));
		 
	}
	
	//@Test
	public void mySettings_TC009(){
		WebDriver driver =  BaseTest.getBrowser();
		ExtentTest test = ReportUtils.getTest();
		String loginUrl =FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_FILE_PATH, "oauth.login.url") ;
		driver.get(loginUrl);
		test.info("Login url launched in browser");
		 HomePage hp =new HomePage(driver);
		 LoginPage lp=hp.clickLogOutButton(driver);
			test.info("Logout button is clicked");
		 Assert.assertTrue(lp.isLoginPageVisible());
			test.info("Login page is visible");
	}

}
