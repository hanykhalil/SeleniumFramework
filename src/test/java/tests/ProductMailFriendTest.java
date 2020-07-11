package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailAfriendPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductemailafriendPage;
import pages.UserRegisterationPage;
import pages.pageBase;

public class ProductMailFriendTest extends TestBase {
	
	HomePage homeObject;
	ProductDetailsPage productDetailObject;
	EmailAfriendPage emailfriendObject; 
	ProductemailafriendPage productfriendObject;
	UserRegisterationPage registerObject;
	//pageBase pageBaseObject;
	String product="macB";
	String emailfriend="masr@yahoo.com";
	String message="hey , this laptop is great check plz";
	@Test  
	public void emailProductToAfriend() throws InterruptedException {
		homeObject= new HomePage(driver);
		homeObject.registrationUserLink();
		registerObject= new UserRegisterationPage(driver);
		registerObject.registerationUSER("masry", "aly", "koko@yahoo.com", "123456");
		homeObject.seachProductWithAuto(product);
		productDetailObject= new ProductDetailsPage(driver);
		//homeObject.scrollDownPage();
		//pageBaseObject = new pageBase(driver);
		productDetailObject.emailAfriendProduct();
		emailfriendObject= new EmailAfriendPage(driver);
		emailfriendObject.sendProductToFriendForm(emailfriend, message);
		productfriendObject= new ProductemailafriendPage(driver);
		Assert.assertTrue(productfriendObject.productsentMessage.getText().contains("Your message has been sent"));
		
	} 
 
}
