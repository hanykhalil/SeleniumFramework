package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends pageBase{

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "gender-male")
	 WebElement genderBTN;
	 
	 @FindBy(id = "FirstName")
	 WebElement fNameTxt;
	 
	 @FindBy(id = "LastName")
	 WebElement lNameTxt;
	 
	 @FindBy(id = "Email")
	 WebElement emailTxt;
	 
	 @FindBy(id = "Password")
	 WebElement passwordTxt;
	 
	 @FindBy(id = "ConfirmPassword")
	 WebElement confirmedPass;
	 
	 @FindBy(id = "register-button")
	 WebElement registerBTN;
	 @FindBy(linkText = "Log out")
	 public WebElement registerLogOut;
	 
	 @FindBy(css = "div.result")
	 public WebElement registerMessage;
	 @FindBy(linkText = "My account")
	 WebElement myAccountLink;
	 
	 public void registerationUSER(String firstname, String lastname, String email, String password) throws InterruptedException {
		 clickButton(genderBTN);
		 Thread.sleep(5000);
		 sendkeysText(fNameTxt,firstname );
		 sendkeysText(lNameTxt, lastname);
		 sendkeysText(emailTxt, email);
		 sendkeysText(passwordTxt, password);
		 sendkeysText(confirmedPass, password);
		 clickButton(registerBTN);
	 }
	 public void myAccountClick() {
		 clickButton(myAccountLink);
	 }

}
