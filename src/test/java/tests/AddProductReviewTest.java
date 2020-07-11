package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.UserRegisterationPage;

public class AddProductReviewTest extends TestBase {
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	ProductDetailsPage productObject;
	ProductReviewPage productReviewObject;
	String product="macB";
	
	@Test(priority = 1)
	public void successfulRegisterUser() throws InterruptedException {
		homeObject =new HomePage(driver);
		homeObject.registrationUserLink();
		registerObject= new UserRegisterationPage(driver);
		registerObject.registerationUSER("hany", "khalil", "blelea@yahoo.com", "123456");
		assertTrue(registerObject.registerMessage.getText().contains("Your registration completed"));
		System.out.println(registerObject.registerMessage.getText());
	}
	

	
	@Test(priority = 2)
	public void findProductByAutoComplete() throws InterruptedException {
		homeObject =new HomePage(driver);
		homeObject.seachProductWithAuto(product);
		productObject= new ProductDetailsPage(driver);
		Assert.assertTrue(productObject.productInBreadBrumb.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));
	}
	
	@Test(priority = 3)
	public void clickOnreview() {
		productObject = new ProductDetailsPage(driver);
		productObject.openReviewPage();
	}
	
	@Test(priority = 4)
	public void openProductReviewpage() {
		productReviewObject= new ProductReviewPage(driver);
		productReviewObject.addReview("good product", "this lap top is very good and i recommended to you");
		Assert.assertTrue(productReviewObject.addReviewMessage.getText().contains("Product review is successfully added"));
	}
}
