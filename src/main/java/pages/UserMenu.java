package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtils;

public class UserMenu extends BasePage{

	public UserMenu(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="userNavButton")
	public WebElement userdropdown;
	
	@FindBy(css="[id='userNav-menuItems']>a")
	public List<WebElement> usermenuOptions;
	
	@FindBy(xpath="//a[@title='My Profile']")
	public WebElement myProfile;
	
	@FindBy(xpath="//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img")
	public WebElement editProfile;
    
	@FindBy(xpath="//a[@title='My Settings']")
	public WebElement mySettings;

	@FindBy(xpath="//a[@title='Developer Console (New Window)']")
	public WebElement DeveloperConsole;
	
	public void userDropdownClick() {
		userdropdown.click();
	}
	public void  myProfileClick() {
		 myProfile.click();
	}
	
	public void  editProfileClick() {
		editProfile.click();
	}
	
	public ArrayList<String> getUserMenuOption(){
		
		if(!(myProfile.isDisplayed())) {
			userdropdown.click();
		}
		
		ArrayList<String> menuOptions=new ArrayList<String>();
		for(WebElement element: usermenuOptions) {
			menuOptions.add(element.getText());
			}
		return menuOptions;
	}
	
	public MyProfilePage selectMyProfile(WebDriver driver) {
		if(!(myProfile.isDisplayed())) {
			userdropdown.click();
			myProfile.click();
		} else {
			myProfile.click();
		}
		return new MyProfilePage(driver);

		}

	public MySettingsPage  selectMySettings(WebDriver driver) {
		if(!(myProfile.isDisplayed())) {
			userdropdown.click();
			mySettings.click();
		} else {
			mySettings.click();
		}
		return new MySettingsPage(driver);

		}

	public boolean selectDeveloperConsole(WebDriver driver) {
		
		boolean  isDeveloperConsole=false;
		if(!(DeveloperConsole.isDisplayed())) {
			userdropdown.click();
			 Set<String> oldTabs = driver.getWindowHandles();
			 if(WaitUtils.waitForElementVisibility(DeveloperConsole, driver)) {
				 DeveloperConsole.click();
			    }
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
			 wait.until(d-> d.getWindowHandles().size() > oldTabs.size());
			 Set<String> newTabs = driver.getWindowHandles(); 
			 newTabs.removeAll(oldTabs);
			 String newTabHandle = newTabs.iterator().next();
			 driver.switchTo().window(newTabHandle);
			 
				 isDeveloperConsole=true;
			 
			    
			 driver.close();
			
		} else {
			Set<String> oldTabs = driver.getWindowHandles();
			 if(WaitUtils.waitForElementVisibility(DeveloperConsole, driver)) {
				 DeveloperConsole.click();
			    }
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
			 wait.until(d-> d.getWindowHandles().size() > oldTabs.size());
			 Set<String> newTabs = driver.getWindowHandles(); 
			 newTabs.removeAll(oldTabs);
			 String newTabHandle = newTabs.iterator().next();
			 driver.switchTo().window(newTabHandle);
			 isDeveloperConsole=true;
		}
		return isDeveloperConsole;

		}
	
	
}
