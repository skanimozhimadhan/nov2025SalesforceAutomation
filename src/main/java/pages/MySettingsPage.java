package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FileConstants;
import utils.FileUtils;
import utils.WaitUtils;

public class MySettingsPage extends BasePage{

	public MySettingsPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//*[@id=\'PersonalInfo_font\']")
	public WebElement personallink;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id='RelatedUserLoginHistoryList_body']")
	public WebElement logindisplay;
	
	@FindBy(xpath = "//*[@id='RelatedUserLoginHistoryList_body']/div/a")
	public WebElement loginhistorydownload;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	
	@FindBy(xpath = "//*[@id='DisplayAndLayout_font']")
	public WebElement DisplayLayoutlink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	@FindBy(xpath = "//select[@id='p4']")
	public WebElement customApp;

	@FindBy(xpath = "//*[@id='duel_select_0']")
	public WebElement Availabletab;
	
	@FindBy(id="duel_select_1")
	public WebElement SelectedTabs;

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;
	
	@FindBy(xpath="//img[@title='Remove']")
	public WebElement Remove;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(xpath = "//*[@id='tabBar']/li")
	public List<WebElement> tabList;
	
	@FindBy(id="tsidLabel")
	public WebElement AppSwitcher;
	
	@FindBy(linkText="Salesforce Chatter")
	public WebElement SalesforceChatter;
	
	@FindBy(linkText="Sales")
	public WebElement Sales;
	
	@FindBy(xpath="//div[@id='EmailSetup']/a")
	public WebElement email;
	
	@FindBy(id="EmailSettings_font")
	public WebElement emailSettings;
	
	@FindBy(id="sender_name")
	public WebElement emailName;
	
	@FindBy(id="sender_email")	
	public WebElement emailaddress;
	
	@FindBy(id="auto_bcc1")
	public WebElement BCCYes;
	
	@FindBy(xpath="//input[@name='save']")
	public WebElement EmailSave;
	
	@FindBy(xpath="//div[@class='messageText']")
	public WebElement EmailMsg;
	// Calendar and Remainders
		@FindBy(id = "CalendarAndReminders_font")
		public WebElement CalendarAndReminders;

		@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
		public WebElement ActivityRemainder;

		@FindBy(id = "testbtn")
		public WebElement OpenaTestRemainder;

		@FindBy(xpath = "//*[@id='summary']")
		public WebElement SampleEventPopup;
		
		@FindBy(id="userNavButton")
		public WebElement userdropdown;
		@FindBy(xpath="//a[@title='My Settings']")
		public WebElement mySettings;
	
	public boolean isMySettingsPageLoaded(WebDriver driver) {
		boolean isMySettingsPage = false;
		if (personallink.isDisplayed()) {
			isMySettingsPage = true;
		}
		return isMySettingsPage;
	}
  
	public boolean isLoginHistoryLoaded(WebDriver driver) {
		boolean isLoginHistoryPage = false;
		personallink.click();
		if (loginHistorylink.isDisplayed()) {
			loginHistorylink.click();
		}
				
			if(logindisplay.isDisplayed()) {
			isLoginHistoryPage = true;
		}
		return isLoginHistoryPage;
	}

	public boolean isLoginHistoryDownloaded(WebDriver driver) {
		boolean isLoginHistoryPageDownload = false;
		if(loginhistorydownload.isDisplayed()) {
			loginhistorydownload.click();
			isLoginHistoryPageDownload=true;
		}
		return isLoginHistoryPageDownload;
	
}
	
	public boolean verifyReportsTab(WebDriver driver) {
	    boolean isReportsTab= false;
	    
	    try {
	    DisplayLayoutlink.click();
	    if(WaitUtils.waitForElementVisibility(CustomizedTab, driver)) {
	    CustomizedTab.click();
	    }
	    
		  Select customAppDropdown=new Select(customApp); 
		  customAppDropdown.selectByVisibleText("Salesforce Chatter");
		  Select AvailableTabDropdown=new Select(Availabletab); 
		  AvailableTabDropdown.selectByVisibleText("Reports");
		  Add.click();
		  if(WaitUtils.waitForElementClickable(save, driver)){
		  save.click();
		  }
		  
		  try{AppSwitcher.click();
		  }catch(StaleElementReferenceException e) {
	            // Retry locating and clicking the element
	            WebElement element = driver.findElement(By.id("tsidLabel"));
	            element.click();
		  }
		  
		  try {
		  SalesforceChatter.click();
		  }catch(StaleElementReferenceException e) {
	            // Retry locating and clicking the element
	            WebElement element = driver.findElement(By.linkText("Salesforce Chatter"));
	            element.click();
		  }
	
			for(WebElement element: tabList) {
			if(element.getText().trim().equals("Reports")) {
				isReportsTab=true;
			}
				}
	}
			finally {
				
			try{AppSwitcher.click();
			  }catch(StaleElementReferenceException e) {
		            // Retry locating and clicking the element
		            WebElement element = driver.findElement(By.id("tsidLabel"));
		            element.click();
			  }
			 try {
				  Sales.click();
				  }catch(StaleElementReferenceException e) {
			            // Retry locating and clicking the element
			            WebElement element = driver.findElement(By.linkText("Sales"));
			            element.click();
				  }
			 
			 userdropdown.click();
			 mySettings.click();
			 DisplayLayoutlink.click();
			    if(WaitUtils.waitForElementVisibility(CustomizedTab, driver)) {
			    CustomizedTab.click();
			    }
			    
				  Select customAppDropdown=new Select(customApp); 
				  customAppDropdown.selectByVisibleText("Salesforce Chatter");
			  Select SelectedTabsDropdown=new Select(SelectedTabs);
			  SelectedTabsDropdown.selectByVisibleText("Reports");
			  Remove.click();
			  if(WaitUtils.waitForElementClickable(save, driver)){
				  save.click();
				  }
			  
			  
			}
			
	    return isReportsTab;
	    
	    
	    
	}
	
	public boolean verifyEmailTab(WebDriver driver) {
	    boolean isEmailTab= false;
	    
	    if(WaitUtils.waitForElementVisibility(email, driver)) {
	    email.click();
	    }
	    if(WaitUtils.waitForElementVisibility(emailSettings, driver)) {
	    	emailSettings.click();
	    }
	    
	    if(emailName.isDisplayed()) {
	    	isEmailTab= true;
	    }
		  
		  
	    return isEmailTab;
	    
	}
	
	public boolean verifySave(WebDriver driver) {
		
		boolean isEmailSaved=false;
		EmailSave.click();
		String actualmessage=EmailMsg.getText();
		String expectedEmailMsg=FileUtils.readPropertiesFile(FileConstants.MYSETTINGS_TEST_DATA_FILE_PATH, "emailmsg");
		if(actualmessage.equals(expectedEmailMsg)) {
			isEmailSaved=true;
		}
		return isEmailSaved;	
		
		
	}

	public boolean verifyActivityandReminder(WebDriver driver) {
		boolean isActivityandReminder=false;
		
		CalendarAndReminders.click();
		if(WaitUtils.waitForElementVisibility(ActivityRemainder, driver)) {
			ActivityRemainder.click();
	    }
		if(WaitUtils.waitForElementVisibility(OpenaTestRemainder, driver)) {
			OpenaTestRemainder.click();
	    }
		
		
		 Set<String> oldTabs = driver.getWindowHandles();
		 if(WaitUtils.waitForElementVisibility(OpenaTestRemainder, driver)) {
				OpenaTestRemainder.click();
		    }
		 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		 wait.until(d-> d.getWindowHandles().size() > oldTabs.size());
		 Set<String> newTabs = driver.getWindowHandles(); 
		 newTabs.removeAll(oldTabs);
		 String newTabHandle = newTabs.iterator().next();
		 driver.switchTo().window(newTabHandle);
	 if(SampleEventPopup.isDisplayed()) {
		 isActivityandReminder=true;
	 }
	    driver.close();
	  
		return isActivityandReminder;
		
	}
	
}
