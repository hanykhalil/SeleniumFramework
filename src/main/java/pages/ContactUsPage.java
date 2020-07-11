package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends pageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "FullName")
	WebElement nameText;
	
	@FindBy(id = "Email")
	WebElement emailText;
	
	@FindBy(id = "Enquiry")
	WebElement enquiryText;
	
	@FindBy(css = "input.button-1.contact-us-button")
	WebElement submitBTN;
	
	public@FindBy(css = "div.result")
	WebElement contactUsMessage;
	
	
	public void contactForm(String name, String email, String enquiry) {
		sendkeysText(nameText, name);
		sendkeysText(emailText, email);
		sendkeysText(enquiryText, enquiry);
		clickButton(submitBTN);
	}
	

}
