package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends pageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement checkOutFirstName;
	@FindBy(id = "BillingNewAddress_LastName")
	WebElement checkOutLastName;
	@FindBy(id = "BillingNewAddress_Email")
	WebElement checkOutEmail;
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement checkOutCountry;
	@FindBy(id = "BillingNewAddress_City")
	WebElement checkOutCity;
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement checkOutAddress;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement checkOutZip;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement checkOutPhone;
	@FindBy(css = "input.button-1.new-address-next-step-button")
	WebElement checkOutContinueBTN;
	@FindBy(id = "shippingoption_1")
	WebElement shippingOption;
	@FindBy(css = "input.button-1.shipping-method-next-step-button")
	WebElement secondCheckOutContinueBTN;
	//@FindBy(css = "input.button-1 shipping-method-next-step-button")
	//WebElement thirdCheckOutContinueBTN;
	@FindBy(id = "paymentmethod_0")
	WebElement paymentMethod;
	@FindBy(css = "input.button-1.payment-method-next-step-button")
	WebElement paymentCheckOutContinueBTN;
	@FindBy(css = "input.button-1.payment-info-next-step-button")
	WebElement paymentInfoCheckOutContinueBTN;
	@FindBy(css = "input.button-1.confirm-order-next-step-button")
	WebElement confirmBTN;
	@FindBy(tagName = "strong")
	public WebElement confirmMessage;
	@FindBy(linkText = "Click here for order details.")
	public WebElement orderDetails;
	@FindBy(css = "a.button-2.pdf-invoice-button")
	WebElement pdfInvoiceBTN;
	
	public void checkOutForm(String firstname, String lastname, String email,String country, String city, String address,
			String zip, String phone) throws InterruptedException 
	{
		sendkeysText(checkOutFirstName, firstname);
		sendkeysText(checkOutLastName, lastname);
		checkOutEmail.clear();
		sendkeysText(checkOutEmail, email);
		sendkeysText(checkOutCountry, country);
		sendkeysText(checkOutCity, city);
		sendkeysText(checkOutAddress, address );
		sendkeysText(checkOutZip, zip );
		sendkeysText(checkOutPhone, phone );
		clickButton(checkOutContinueBTN);
		Thread.sleep(4000);
		clickButton(shippingOption);
		clickButton(secondCheckOutContinueBTN);
		Thread.sleep(4000);
		clickButton(paymentMethod);
		clickButton(paymentCheckOutContinueBTN);
		Thread.sleep(4000);
		clickButton(paymentInfoCheckOutContinueBTN);
		Thread.sleep(4000);
		clickButton(confirmBTN);
		Thread.sleep(4000);
		clickButton(orderDetails);
		Thread.sleep(4000);
		clickButton(pdfInvoiceBTN);
		Thread.sleep(4000);
		
	}
	
}
