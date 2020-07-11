package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends pageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "Email")
	WebElement emailLogin;
	
	@FindBy(id ="Password")
	WebElement passwordLogin;
	
	@FindBy(css = "input.button-1.login-button")
	WebElement loginBTN;
	
	@FindBy(linkText  = "Log out")
	public WebElement logouBTN;
	
	@FindBy(linkText  = "Log in")
	public WebElement reLogin;
	//@FindBy(css = "a.ico-login")
	//public WebElement login;
	
	public void logoutClick() {
		clickButton(logouBTN);
	}
	
	public void loginForm(String useremail, String userpass) {
		sendkeysText(emailLogin, useremail);
		sendkeysText(passwordLogin, userpass);
		clickButton(loginBTN);
	}	
	
	public void loginClick() {
		clickButton(reLogin);
	}
	
	

}
