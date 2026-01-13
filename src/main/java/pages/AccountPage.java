package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import constants.FileConstants;
import utils.CommonUtils;
import utils.FileUtils;
import utils.WaitUtils;

public class AccountPage extends BasePage{

	public AccountPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//input[@title='New']")
	public WebElement NewAccount;
	
	@FindBy(xpath="//input[@name='acc2']")
	public WebElement AccountName;
	
	@FindBy(xpath="//input[@title='Save' and @tabindex='36']")
	public WebElement SaveAccount;
	
	@FindBy(xpath="//h2[@class='pageDescription']")
	public WebElement AccountDetail;
	
	@FindBy(id="fcf")
	public WebElement ViewDropDown;
	
	@FindBy(xpath="//select[@name='fcf']")
	public WebElement ViewDropDown1;
	
	@FindBy(xpath="//a[text()='Edit']")
	public WebElement EditAccount;
	
	@FindBy(xpath="//a[text()='Create New View']")
	public WebElement CreateNewView;
	
	@FindBy(id="fname")
	public WebElement ViewName;
	
	@FindBy(id="fcol1")
	public WebElement FilterName;
	
	@FindBy(id="fop1")
	public WebElement OperatorName;
	
	@FindBy(id="fval1")
	public WebElement ValueField;
	
	@FindBy(id="colselector_select_0")
	public WebElement AvailableFields;
	
	@FindBy(xpath="//img[@title='Add'][1]")
	public WebElement AddButton;
	
	@FindBy(xpath="//input[@title='Save'][1]")
	public WebElement Save;
	
	@FindBy(xpath="//*[@id=\"ext-gen16\"]/div/table/thead/tr/td[10]/div")
	public WebElement LastActivity;
	
	@FindBy(xpath="//table/tbody/tr/td[4]/div/a/span")
	public List<WebElement> AccountNameRow;
	
	@FindBy(xpath="//a[text()='Accounts with last activity > 30 days']")
	public WebElement AccountWithLastActivityGreaterThan30;
	
	@FindBy(xpath="//label[text()='Date Field']")
	public WebElement DateField;
	
	@FindBy(xpath="//input[@name='startDate']")
	public WebElement DateFrom;
	
	@FindBy(xpath="//img[@id='ext-gen153']")
	public WebElement DatePickerFrom;
	
	@FindBy(xpath="//button[text()='Today']")
	public WebElement DatePickerToday;
	
	@FindBy(xpath="//button[text()='Save']")
	public WebElement reportSave;
	
	@FindBy(id="saveReportDlg_reportNameField")
	public WebElement ReportName;
	
	@FindBy(id="saveReportDlg_DeveloperName")
	public WebElement ReportUniqueName;
	
	@FindBy(xpath="//table[@id='dlgSaveAndRun']")
	public WebElement SaveAndRunReport;
	
	@FindBy(xpath="//h1[@class='noSecondHeader pageType']")
	public WebElement ReportHeader;
	
	public boolean verifyAccountCreation(WebDriver driver) {
		
		boolean isVerifyAccountCreation=false;
		 NewAccount.click();
		 if(AccountName.isDisplayed()) {
			 AccountName.sendKeys(FileUtils.readPropertiesFile(FileConstants.ACCOUNT_TEST_DATA_FILE_PATH, "accountname"));
		 }
		 SaveAccount.click();
		 WaitUtils.waitForElementVisibility(AccountDetail, driver);
		 if(AccountDetail.getText().equals(FileUtils.readPropertiesFile(FileConstants.ACCOUNT_TEST_DATA_FILE_PATH, "accountname")))
		 {
			 isVerifyAccountCreation=true;
		 }
		
		return isVerifyAccountCreation ;
		
	}
	
	public boolean verifyCreateNewView(WebDriver driver) {
		boolean isCreateNewView=false;
		 String viewName=FileConstants.VIEW_NAME;
		
		CreateNewView.click();
		 if(ViewName.isDisplayed()) {
			
			  ViewName.sendKeys(FileConstants.VIEW_NAME);
		 }
		 Save.click();
		 
		 Select view=new Select(ViewDropDown1); 
		 if(view.getFirstSelectedOption().getText().equals(viewName))
		 {
			 isCreateNewView=true;
		 }
		return  isCreateNewView;
	}
	
public boolean verifyEditViewName(WebDriver driver) {
		
		boolean isEditViewName=false;
		boolean isLastActivity=false;
		boolean isContains=true;
		Select view=new Select(ViewDropDown); 
		  view.selectByIndex(5);
		  EditAccount.click();
		  if(ViewName.isDisplayed()) {
			  ViewName.sendKeys(FileUtils.readPropertiesFile(FileConstants.ACCOUNT_TEST_DATA_FILE_PATH, "viewname"));
			 } 
		  Select filter=new Select(FilterName); 
		  filter.selectByValue("ACCOUNT.NAME");
		  Select operator=new Select( OperatorName); 
		  operator.selectByValue("c");
		  ValueField.clear();
		  ValueField.sendKeys("a");
		  Select available=new Select( AvailableFields); 
		  available.selectByValue("ACCOUNT.LAST_ACTIVITY");
		  AddButton.click();
		  Save.click();
		  WaitUtils.waitForElementVisibility(LastActivity, driver);
		  if(LastActivity.isDisplayed()) {
			  isLastActivity=true;
		  }
		  
		  for(WebElement element: AccountNameRow) {
				if(!element.getText().trim().toLowerCase().contains("a")) {
					isContains=false;
					break;
				}
		  }
		  if(isLastActivity && isContains ) {
			  isEditViewName =true;
		  }
		  
		  return isEditViewName;
}	  
	
public boolean verifyCreateAccountReport(WebDriver driver) {
	
	boolean isCreateAccountReport=false;
	
	AccountWithLastActivityGreaterThan30.click();
	WaitUtils.waitForElementVisibility(DateField, driver);
	DatePickerFrom.click();
	WaitUtils.waitForElementVisibility(DatePickerToday, driver);
	DatePickerToday.click();
	reportSave.click();
	WaitUtils.waitForElementVisibility(ReportName, driver);
	if(ReportName.isDisplayed()) {
		
		ReportName.sendKeys(FileConstants.REPORT_NAME);
		ReportUniqueName.click();
		
	 }
	WaitUtils.waitForElementClickable(SaveAndRunReport, driver);
	
		
		CommonUtils.mouseHover(driver, SaveAndRunReport);
		//CommonUtils.clickUsingJs(driver, SaveAndRunReport);
		SaveAndRunReport.click();
	
	WaitUtils.waitForElementVisibility(ReportHeader, driver);
	
	if(ReportHeader.isDisplayed()) {
		isCreateAccountReport=true;
	}
	return isCreateAccountReport;
	
}	  
		
}
