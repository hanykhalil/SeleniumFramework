package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends pageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Change password")
	WebElement changepasswordLink;

	@FindBy(id = "OldPassword")
	WebElement oldPassword;

	@FindBy(id = "NewPassword")
	WebElement newPassword;

	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmNewPassword;

	@FindBy(css = "input.button-1.change-password-button")
	WebElement changePassClickBTN;

	public @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div")
	WebElement signReturn;

	@FindBy(linkText = "Log in")
	WebElement reLogin;

	public void changePassordClicklink() {
		clickButton(changepasswordLink);
	}

	public void changePassordClickButton() {
		clickButton(changePassClickBTN);
	}

	public void changePasswordSend(String password, String newPass) {
		sendkeysText(oldPassword, password );
		sendkeysText(newPassword, newPass);
		sendkeysText(confirmNewPassword, newPass);
		clickButton(changePassClickBTN);
	}
	
}
