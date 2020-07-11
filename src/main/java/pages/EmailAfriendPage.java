package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailAfriendPage extends pageBase {

	public EmailAfriendPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "FriendEmail")
	WebElement friendEmailText;
	
	@FindBy(id = "PersonalMessage")
	WebElement personalMessageText;
	
	@FindBy(css = "input.button-1.send-email-a-friend-button")
	WebElement submitBTN;
	
	public void sendProductToFriendForm(String emailfriend, String message) {
		sendkeysText(friendEmailText, emailfriend);
		sendkeysText(personalMessageText, message);
		clickButton(submitBTN);
	}
}
