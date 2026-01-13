package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitUtils;
public class LoginPage  extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(id = "error")
	public WebElement errorMessage;

	@FindBy(id = "rememberUn")
	public WebElement rememberMeCheckbox;

	@FindBy(xpath = "//*[@id='forgot_password_link']")
	public WebElement forgotPassword;
	
	
	
	@FindBy(id="un")
	public WebElement fpusername;
	
	@FindBy(id="continue")
	public WebElement continueButton;

	@FindBy(xpath="//a[text()='Return to Login']")
	public WebElement returnToLogin;
	
	
	
	@FindBy(xpath = "//input[@name='emc']")
	public WebElement verificationCodeInput;
	
	@FindBy(css = "[name='save']")
	public WebElement verifyButton;

	
	public boolean isLoginPageVisible() {
		
		return this.loginButton.isDisplayed();
	}
	
	public boolean isForgotPasswordPageVisible() {
		return this.fpusername.isDisplayed();
	}
	
	public boolean isCheckEmailPageVisible() {
		return this.returnToLogin.isDisplayed();
	}


	public void enterUsername(String userId) {
		if (username.isDisplayed()) {
			username.clear();
			username.sendKeys(userId);
		} else {
			System.out.println("Username element is not displayed");
		}
	}

	public void clearPassword() {
		password.clear();
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public String getErrorMessage(WebDriver driver)  {
		if(WaitUtils.waitForElementVisibility(errorMessage, driver)) {
			return errorMessage.getText();
		}else {
		return null;
	}
	}
	
	
	
	public void clickForgotPassword() {
		forgotPassword.click();
	}
	
	public void enterFPUsername(String userId) {
		if (fpusername.isDisplayed()) {
			fpusername.sendKeys(userId);
		} else {
			System.out.println("Username element is not displayed");
		}
	}
	
	public void clickContinue() {
		continueButton.click();
	}
	
	public void returnToLoginClick() {
		returnToLogin.click();
	}
	
	public void rememberMeCheckBoxCheck() {
		rememberMeCheckbox.click();
	}
	
	
	
	public void enterVerificationCode(String otp) {
		if (verificationCodeInput.isDisplayed()) {
			verificationCodeInput.sendKeys(otp);
		} else {
			System.out.println("Verification code screen not visible");
		}
	}

	public HomePage clickOnVerifyButton(WebDriver driver) {
		verifyButton.click();
		return new HomePage(driver);
	}
	
	



}
