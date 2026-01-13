package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitUtils;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id='oneHeader']/div[2]/span/div[2]/ul/li[7]/span/div/button")
	public WebElement profileButton;
	
	@FindBy(id = "userNavLabel")
	public WebElement userMenu;
	
	@FindBy(xpath = "//a[@title='Logout']")
	public WebElement logOutButton;
	
	@FindBy(xpath="//a[text()='Switch to Salesforce Classic']")
	public WebElement switchToClassic;
	
	
	@FindBy(xpath="//li[@id='Opportunity_Tab']/a[text()='Opportunities']")
	public WebElement Opportunity_Tab;
	
	@FindBy(xpath="//li[@id='Account_Tab']/a[text()='Accounts']")
	public WebElement Accounts;
	
	@FindBy(xpath="//li[@id='Lead_Tab']/a[text()='Leads']")
	public WebElement Leads;
	
	@FindBy(xpath="//li[@id='Contact_Tab']/a[text()='Contacts']")
	public WebElement Contacts;
	
	public void clickProfile(WebDriver driver) {
		if (WaitUtils.waitForElementClickable(profileButton, driver)) {
			profileButton.click();
		}
	}
	
	public void click(WebDriver driver) {
		if (WaitUtils.waitForElementClickable(profileButton, driver)) {
			profileButton.click();
		}
	}
	
   public void switchToClassic(WebDriver driver) {
		
		clickProfile(driver);
		if (WaitUtils.waitForElementClickable(switchToClassic, driver)) {
			switchToClassic.click();
		}
		
	}
	
	public LoginPage clickLogOutButton(WebDriver driver) {
		if (!( logOutButton.isDisplayed())) {
			userMenu.click();

		    logOutButton.click();
		
	}else {
		 logOutButton.click();
			
	}
		return new LoginPage(driver);
	}
	
	public AccountPage clickAccounts(WebDriver driver) {
		if (WaitUtils.waitForElementClickable(Accounts, driver)) {
			Accounts.click();
		}
		
		return new AccountPage(driver);
	}
	
	public CreateOptyPage clickOpportunities(WebDriver driver) {
		if (WaitUtils.waitForElementClickable(Opportunity_Tab, driver)) {
			Opportunity_Tab.click();
		}
		
		return new CreateOptyPage(driver);
	}
	
	public LeadsPage clickLeads(WebDriver driver) {
		if (WaitUtils.waitForElementClickable(Leads, driver)) {
			Leads.click();
		}
		
		return new LeadsPage(driver);
	}
	
	public ContactsPage clickContacts(WebDriver driver) {
		if (WaitUtils.waitForElementClickable(Contacts, driver)) {
			 Contacts.click();
		}
		
		return new ContactsPage(driver);
	}
}
