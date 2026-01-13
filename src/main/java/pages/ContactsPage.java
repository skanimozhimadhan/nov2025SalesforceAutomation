package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import constants.FileConstants;
import utils.FileUtils;
import utils.WaitUtils;

public class ContactsPage extends BasePage{

	public ContactsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@title='New']")
	public WebElement NewContact;
	
	@FindBy(id="name_lastcon2")
	public WebElement LastName;
	
	@FindBy(id="con4")
	public WebElement AccountName;
	
	@FindBy(xpath="//input[@title='Save'][1]")
	public WebElement Save;
	
	@FindBy(xpath="//input[@name='save_new'][1]")
	public WebElement SaveAndNew;
	
	@FindBy(xpath="//h2[@class='pageDescription']")
	public WebElement ContactDetail;
	
	@FindBy(id="hotlist_mode")
	public WebElement RecentlyDropDown;
	
	@FindBy(xpath="//*[@id=\"bodyCell\"]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
	public WebElement RecentContacts;
	
	@FindBy(id="fcf")
	public WebElement MyContactsView;
	
	@FindBy(xpath="//input[@name='go']")
	public WebElement Go;
	
	@FindBy(xpath="//table[@class='x-grid3-row-table']")
	public WebElement MyContactTable;
	
	@FindBy(xpath="//a[text()='Create New View']")
	public WebElement CreateNewView;
	
	@FindBy(id="devname")
	public WebElement UniqueViewName;
	
	@FindBy(xpath="//input[@id='fname']/following-sibling::div")
	public WebElement ErrorMsg;
	
	@FindBy(id="fname")
	public WebElement ViewName;
	
	@FindBy(xpath="//input[@title='Cancel'][1]")
	public WebElement Cancel;
	
public boolean verifyContactCreation(WebDriver driver) {
		
		boolean verifyContactCreation=false;
		 NewContact.click();
		 if(LastName.isDisplayed()) {
			 LastName.sendKeys("ABCD");
			 AccountName.sendKeys("Account1");
		 }
		 Save.click();
		 WaitUtils.waitForElementVisibility(ContactDetail, driver);
		 if(ContactDetail.getText().equals("ABCD"))
		 {
			 verifyContactCreation=true;
		 }
		
		return verifyContactCreation ;
		
	}

public boolean verifyContactCreationSaveAndNew(WebDriver driver) {
	
	boolean verifyContactCreation=false;
	 NewContact.click();
	 if(LastName.isDisplayed()) {
		 LastName.sendKeys("Indian");
		 AccountName.sendKeys("Account1");
	 }
	 SaveAndNew.click();
	 WaitUtils.waitForElementVisibility(ContactDetail, driver);
	 if(ContactDetail.getText().equals("New Contact"))
	 {
		 verifyContactCreation=true;
	 }
	
	return verifyContactCreation ;
	
}

public boolean verifyRecentlyCreated(WebDriver driver) {
	
	boolean verifyRecentlyCreated=false;
	WaitUtils.waitForElementVisibility(RecentlyDropDown, driver);
	
	Select RecentlyDropDownList =new Select(RecentlyDropDown);
	RecentlyDropDownList.selectByValue("2");
	if(RecentContacts.getText().equals("Indian")) {
		verifyRecentlyCreated =true;
	}
	
	
	return verifyRecentlyCreated ;
	
}

public boolean verifyMyContacts(WebDriver driver) {
	
	boolean verifyMyContacts=false;
	WaitUtils.waitForElementVisibility(MyContactsView, driver);
	Select MyContactsViewDropDown =new Select(MyContactsView);
	MyContactsViewDropDown.selectByVisibleText("My Contacts");
	Go.click();
	WaitUtils.waitForElementVisibility(MyContactTable, driver);
	if(MyContactTable.isDisplayed()) {
		verifyMyContacts=true;
	}
	return verifyMyContacts ;
	
}


public boolean verifyRecentContact(WebDriver driver) {
	
	boolean verifyRecentContact=false;
	WaitUtils.waitForElementVisibility(MyContactsView, driver);
	if(RecentContacts.isDisplayed()) {
		
		String RecentContact=RecentContacts.getText();
		RecentContacts.click();
		WaitUtils.waitForElementVisibility(ContactDetail, driver);
		if(ContactDetail.getText().equals(RecentContact)) {
			verifyRecentContact=true;
		}
	}
	
	return verifyRecentContact ;
	
}

public boolean verifyErrorMessage(WebDriver driver) {
	
	boolean verifyErrorMessage=false;
	WaitUtils.waitForElementVisibility(CreateNewView, driver);
	
	CreateNewView.click();
		WaitUtils.waitForElementVisibility(UniqueViewName, driver);
		UniqueViewName.sendKeys("EFGH");
		Save.click();
		WaitUtils.waitForElementVisibility(ErrorMsg, driver);
		
		if(ErrorMsg.getText().equals("Error: You must enter a value")) {
			verifyErrorMessage=true;
		}
		
	
	return verifyErrorMessage ;
	
}

public boolean verifyContactCancel(WebDriver driver) {
	
	boolean verifyContactCancel=false;
	WaitUtils.waitForElementVisibility(CreateNewView, driver);
	
	CreateNewView.click();
		WaitUtils.waitForElementVisibility(UniqueViewName, driver);
		ViewName.sendKeys("ABCD");
		UniqueViewName.sendKeys("EFGH");
		Cancel.click();
		if(ContactDetail.getText().equals("Home")) {
			verifyContactCancel=true;
		}
		
		return verifyContactCancel ;
	
}
}
