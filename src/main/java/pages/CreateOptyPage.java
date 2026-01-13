package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FileConstants;
import utils.FileUtils;
import utils.WaitUtils;

public class CreateOptyPage extends BasePage{

	public CreateOptyPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(id="fcf")
	public WebElement OpportunitiesDropDown;
	
	@FindBy(xpath="//td[@class='pbButton']/input[@title='New']")
	public WebElement New;
	
	@FindBy(id="opp3")
	public WebElement OpportunityName;
	
	@FindBy(xpath="//img[@title='Account Name Lookup (New Window)']")
	public WebElement AccountNameLookup;
	
	@FindBy(xpath="//table[@class='list']/tbody/tr[2]/th/a[1]")
	public WebElement AccountName;
	
	@FindBy(id="resultsFrame")
	public WebElement AccountFrame;
	
	@FindBy(id="opp9")
	public WebElement CloseDate;
	
	@FindBy(xpath="//a[@class='calToday']")
	public WebElement CloseDateToday;
	
	@FindBy(id="opp11")
	public WebElement Stage;
	
	@FindBy(id="opp12")
	public WebElement Probability;
	
	@FindBy(id="opp6")
	public WebElement LeadSource;
	
	@FindBy(xpath="//img[@title='Primary Campaign Source Lookup (New Window)']")
	public WebElement PrimaryCampaignSourceLookup;
	
	@FindBy(id="resultsFrame")
	public WebElement PrimaryCampaignSourceFrame;
	@FindBy(xpath="//*[@id='new']/div/div[2]/div/div[2]/table/tbody/tr[2]/th/a[1]")
	public WebElement PrimaryCampaignSource;
	
	@FindBy(id="opp7")
	public WebElement Amount;
	
	@FindBy(xpath="//input[@name='save'][1]")
	public WebElement Save;
	
	@FindBy(xpath="//h2[@class='pageDescription']")
	public WebElement OpportunitiesDetail;
	
	@FindBy(xpath="//a[text()='Opportunity Pipeline']")
	public WebElement OpportunityPipelineReport;
	
	@FindBy(xpath="//h1[@class='noSecondHeader pageType']")
	public WebElement OpportunityPipelineReportDetail;
	
	@FindBy(xpath="//a[text()='Stuck Opportunities']")
	public WebElement StuckOpportunities;
	
	@FindBy(xpath="//h1[@class='noSecondHeader pageType']")
	public WebElement StuckOpportunitiesDetail;
	
    public ArrayList<String> getOpportunitiesOption(){
	 Select OpportunitiesDropdownoptions=new Select(OpportunitiesDropDown); 
	  List<WebElement> options = OpportunitiesDropdownoptions.getOptions();
		ArrayList<String> menuOptions=new ArrayList<String>();
		for(WebElement element:options) {
			menuOptions.add(element.getText());
			}
		return menuOptions;
	}
	
    public boolean isOpportunitiesPageDisplayed() {
    	boolean isOpportunitiesPage=false;
    	if(New.isDisplayed()) {
    		isOpportunitiesPage=true;
    	}
    	
    	return isOpportunitiesPage;
    }
 
    public boolean isOpportunitiesEditPageDisplayed(WebDriver driver) {
    	boolean isOpportunitiesEditPage=false;
    	New.click();
    	WaitUtils.waitForElementVisibility(OpportunityName, driver);
    	if(OpportunityName.isDisplayed()) {
    		isOpportunitiesEditPage=true;
    	}
    	
    	return isOpportunitiesEditPage;
    }
 
    public boolean isOpportunitiesCreated(WebDriver driver) throws InterruptedException {
    	boolean isOpportunitiesCreated=false;
    	OpportunityName.sendKeys(FileUtils.readPropertiesFile(FileConstants.OPPORTUNITIES_TEST_DATA_FILE_PATH, "opportunity.name"));
    	 if(WaitUtils.waitForElementVisibility(AccountNameLookup, driver)) {
			 AccountNameLookup.click();
		    }
    	 
    	 Thread.sleep(1000);
    	Set<String> allWindows = driver.getWindowHandles();
		  List<String> list =  new ArrayList<>(); 
		  list.addAll(allWindows); 
		  
		  driver.switchTo().window(list.get(1));
		  driver.switchTo().frame(AccountFrame);
		  WaitUtils.waitForElementVisibility(AccountName, driver);
	    	AccountName.click();
	    //driver.close();
	   driver.switchTo().window(list.get(0));
	  
		 
	    
    	
    
    	CloseDate.click();
    	CloseDateToday.click();
    	Amount.click();
    	Select StageDropdown=new Select(Stage);
    	StageDropdown.selectByValue("Prospecting");
    	Probability.clear();
    	Probability.sendKeys(FileUtils.readPropertiesFile(FileConstants.OPPORTUNITIES_TEST_DATA_FILE_PATH, "probability"));
    	Select LeadSourceDropdown=new Select(LeadSource);
    	LeadSourceDropdown.selectByValue("Web");
    	
    	PrimaryCampaignSourceLookup.click();
    	Thread.sleep(1000);
    	 
    	Set<String> allWindows1 = driver.getWindowHandles();
		  List<String> list1 =  new ArrayList<>(); 
		  list1.addAll(allWindows1); 
		  
		  driver.switchTo().window(list1.get(1));
		  driver.switchTo().frame(PrimaryCampaignSourceFrame);
		  WaitUtils.waitForElementVisibility(PrimaryCampaignSource, driver);
		  PrimaryCampaignSource.click();
	    //driver.close();
	   driver.switchTo().window(list1.get(0));
	  
   	
    	
    	
    	Save.click();
 WaitUtils.waitForElementVisibility( OpportunitiesDetail, driver);
 
 
 if( OpportunitiesDetail.isDisplayed()) {
	 isOpportunitiesCreated=true;
 }
	 
    	return isOpportunitiesCreated;
    }
    
    public boolean isOpportunitiesPipeline(WebDriver driver) {
    	boolean isOpportunitiesPipeline=false;
    	OpportunityPipelineReport.click();
    	WaitUtils.waitForElementVisibility(OpportunityPipelineReportDetail, driver);
    	if(OpportunityPipelineReportDetail.isDisplayed()) {
    		isOpportunitiesPipeline=true;
    	}
    	
    	return isOpportunitiesPipeline;
    }
    
    public boolean isOpportunitiesStuck(WebDriver driver) {
    	boolean isOpportunitiesPipeline=false;
    	StuckOpportunities.click();
    	WaitUtils.waitForElementVisibility(StuckOpportunitiesDetail, driver);
    	if(StuckOpportunitiesDetail.isDisplayed()) {
    		isOpportunitiesPipeline=true;
    	}
    	
    	return isOpportunitiesPipeline;
    }
    
    
    
}
