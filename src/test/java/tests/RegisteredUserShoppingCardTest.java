package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.UserRegisterationPage;

public class RegisteredUserShoppingCardTest extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerObject;
	ProductDetailsPage productObject;
	CartPage cartObject;
	CheckOutPage checkOutObject;
	LoginPage loginObject;
	String product="macB";
	String Email="fayrz@gmail.com";

	@Test(priority = 1)
	public void successfulRegisterUser() throws InterruptedException {
		homeObject =new HomePage(driver);
		homeObject.registrationUserLink();
		registerObject= new UserRegisterationPage(driver);
		registerObject.registerationUSER("hany", "khalil", Email, "123456");
		assertTrue(registerObject.registerMessage.getText().contains("Your registration completed"));
		System.out.println(registerObject.registerMessage.getText());
	}

	@Test(priority = 2)
	public void findProductByAutoComplete() throws InterruptedException {
		homeObject =new HomePage(driver);
		homeObject.seachProductWithAuto(product);
		productObject= new ProductDetailsPage(driver);
		Assert.assertTrue(productObject.productInBreadBrumb.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));
		productObject.addCartBotton();
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");

	}

	@Test(priority = 3)
	public void userCanCheckOutProduct() {
		cartObject= new CartPage(driver);
		cartObject.fromCartToCheckOut();
	}

	@Test(priority = 4)
	public void userContinueCheckOut() throws InterruptedException {
		checkOutObject = new CheckOutPage(driver);
		checkOutObject.checkOutForm("hany", "khalil",Email, "Egypt", "suez", "hankhjhkkd", "123333", "01233334555");
		//checkOutObject.selectItem();
		//Thread.sleep(4000);
		//Assert.assertTrue(checkOutObject.confirmMessage.getText().contains("Your order has been successfully processed!"));

	}

	@Test(priority = 5)
	public void logOut() throws InterruptedException { 
		Thread.sleep(4000);
		loginObject= new LoginPage(driver);
		loginObject.logoutClick();
	}
}
