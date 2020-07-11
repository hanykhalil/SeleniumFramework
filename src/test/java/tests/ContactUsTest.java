package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	
	HomePage homeObject;
	ContactUsPage contactUsObject;
	String name="hamido";
	String email="hamido@gmail.com";
	String enquiry="hi";
	@Test
	public void contactusPageLogin(){
		homeObject= new HomePage(driver);
		homeObject.scrollDownPage();
		contactUsObject= new ContactUsPage(driver);
		contactUsObject.contactForm(name, email, enquiry);
		Assert.assertTrue(contactUsObject.contactUsMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
	}
}
