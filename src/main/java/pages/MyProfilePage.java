package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtils;
import utils.WaitUtils;;

public class MyProfilePage extends BasePage {

	public MyProfilePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editContactButton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement editProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement aboutTab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement aboutTabLastName;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id='tailBreadcrumbNode']")
	public WebElement userProfilePageNameDisplay;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	@FindBy(css = "[class=\"view highlight\"]")
	public WebElement newPostHighlight;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement fileLink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentPost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement uploadFile;

	@FindBy(css = "#chatterFile")
	public WebElement fileOpen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publishShareButton;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;

		
	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	
	

	@FindBy(css = "#displayBadge")
	public WebElement moderatorButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
	public WebElement firstPostText;

	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;

	@FindBy(xpath = "//form[@name=\"j_id0:waitingForm\"]")
	public WebElement spinnerIcon;

	@FindBy(id = "cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;

	@FindBy(id = "progressIcon")
	public WebElement fileUploadSpinner;

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;

	@FindBy(id = "publishersharebutton")
	public WebElement photosharebutton;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;

	public boolean isProfilePageLoaded(WebDriver driver) {
		boolean isProfilePage = false;
		if (postTextArea.isDisplayed()) {
			isProfilePage = true;
		}
		return isProfilePage;
	}

	public void waitAndClickOnEditIcon(WebDriver driver) {
		if (WaitUtils. waitForElementVisibility(editContactButton, driver)) {
			editContactButton.click();
		}
		;
	}

	public boolean verifyEditProfilePopUpIsVisible(WebDriver driver) {
		boolean verifyEditProfilePopUp = false;
		if (editProfilePopupwindow.isDisplayed()) {
			driver.switchTo().frame(iframeAboutTab);
			System.out.println("verifyEditProfilePopUpIsVisible : Pop up window is displayed");
			if (WaitUtils. waitForElementVisibility(aboutTab, driver) && contactTab.isDisplayed()) {
				verifyEditProfilePopUp = true;
				System.out.println("verifyEditProfilePopUpIsVisible : about and contact tab loaded");
			}
			driver.switchTo().parentFrame();
		}
		return verifyEditProfilePopUp;
	}

	public boolean verifyChangeLastNameInAboutTab(WebDriver driver, String lastNameToChange) throws InterruptedException {
		driver.switchTo().frame(iframeAboutTab);
		if (aboutTab.isDisplayed()) {
			aboutTab.click();
			aboutTabLastName.clear();
			aboutTabLastName.sendKeys(lastNameToChange);
			saveAllButton.click();
		}
		driver.switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
		wait.until(org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement(userProfilePageNameDisplay, lastNameToChange));
		String[] actualUsername = userProfilePageNameDisplay.getText().split(" ");
		System.out.println("actual username: "+actualUsername[1]+" expected username: "+lastNameToChange);
		return actualUsername[1].equals(lastNameToChange);
	}

	public boolean verifyCreatePost(WebDriver driver, String message) {
		if (WaitUtils. waitForElementVisibility(postLink, driver)) {
			postLink.click();
			// iframe index to be updated to 1 if below doesnt work
			driver.switchTo().frame(0);
			if (postTextArea.isDisplayed()) {
				postTextArea.sendKeys(message);
			}
			driver.switchTo().defaultContent();
			shareButton.click();
		}
		String xpath = "(//span/p[text()='" + message + "'])[1]";
		if (WaitUtils. waitForElementVisibility(driver.findElement(By.xpath(xpath)), driver)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifyFileUpload(WebDriver driver, String filePath) {
		boolean isFileUploaded = false;
		if(fileLink.isDisplayed()) {
			fileLink.click();
			uploadFile.click();
			fileOpen.sendKeys(filePath);
			if(WaitUtils.waitForElementClickable(publishShareButton, driver)) {
			publishShareButton.click();
			}
		} 
		if(WaitUtils. waitForElementVisibility(cancelUpload, driver)) {
			if(newPostHighlight.isDisplayed()) {
				isFileUploaded = true;
			}
		}
		return isFileUploaded;
	}
	
	public void clickOnAddPhoto(WebDriver driver) {
		CommonUtils.mouseHover(driver, moderatorButton);
		updateButton.click();
	}
	
	public boolean verifyAddPhoto(WebDriver driver, String path) throws InterruptedException {
		boolean isPhotoadded = false;
		driver.switchTo().frame(photoUploadIframe);
		if(WaitUtils.waitForElementVisibility(uploadphoto, driver)) {
			uploadphoto.sendKeys(path);
			photoSaveButton.click();
			WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			wait.until(org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf(spinnerIcon));
		}
		if(WaitUtils.waitForElementVisibility(spinnerIcon, driver)) {
			if(WaitUtils.waitForElementVisibility(photoSaveButton2, driver)) {
			photoSaveButton2.click();
			}
			WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

			wait.until(org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf(spinnerWhileCropping));

			if(WaitUtils.waitForElementInVisiblity(spinnerWhileCropping, driver)) {
				isPhotoadded = true;
			}
		} 
		driver.switchTo().defaultContent();
		return isPhotoadded;
	}

}
