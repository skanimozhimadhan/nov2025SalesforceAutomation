package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.WaitUtils;

public class LeadsPage extends BasePage{

	public LeadsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[@class='pageDescription']")
	public WebElement LeadsDetail;
	
	@FindBy(id="fcf")
	public WebElement LeadsDropDown;
	
	@FindBy(xpath="//input[@name='go']")
	public WebElement Go;
	
	@FindBy(xpath="//form[@id='00BgK00000L5s0U_actionForm']")
	public WebElement TodayLeadForm;
	
	@FindBy(xpath="//input[@title='New']")
	public WebElement NewLead;
	
	@FindBy(id="name_lastlea2")
	public WebElement Lastname;
	
	@FindBy(id="lea3")
	public WebElement CompanyName;
	
	@FindBy(xpath="//input[@title='Save'][1]")
	public WebElement Save;
	
	@FindBy(xpath="//h2[@class='pageDescription']")
	public WebElement LeadDetail;
	
	 public boolean isLeadsPageDisplayed() {
    	boolean isLeadsPageDisplayed=false;
    	if(LeadsDetail.isDisplayed()) {
    		isLeadsPageDisplayed=true;
    	}
    	
    	return isLeadsPageDisplayed;
    }
	 public ArrayList<String> getLeadsOption(){
		 Select LeadsDropDownoptions=new Select(LeadsDropDown); 
		  List<WebElement> options = LeadsDropDownoptions.getOptions();
			ArrayList<String> menuOptions=new ArrayList<String>();
			for(WebElement element:options) {
				menuOptions.add(element.getText());
				}
			return menuOptions;
		}
	 
	 public boolean isTodaysLeadsPageDisplayed(WebDriver driver) {
	    	boolean isTodaysLeadsPageDisplayed=false;
	    	 Select LeadsDropDownoptions=new Select(LeadsDropDown); 
	    	 LeadsDropDownoptions.selectByVisibleText("Today's Leads");
	    	 Go.click();
	    	 WaitUtils.waitForElementVisibility(TodayLeadForm, driver);
	    	 if(TodayLeadForm.isDisplayed()) {
	    		 isTodaysLeadsPageDisplayed=true;
	    	 }
	    	 
	    	return isTodaysLeadsPageDisplayed;
	    }
	 
	 public boolean isLeadsCreated(WebDriver driver) {
	    	boolean isLeadsCreated=false;
	    	NewLead.click();
	    	
	    	 WaitUtils.waitForElementVisibility(Lastname, driver);
	    	 Lastname.sendKeys("ABCD");
	    	 CompanyName.sendKeys("ABCD");
	    	 Save.click();
	    	 WaitUtils.waitForElementVisibility(LeadDetail, driver);
	    	 if(LeadDetail.isDisplayed()) {
	    		 isLeadsCreated=true;
	    	 }
	    	 
	    	return isLeadsCreated;
	    }
}
