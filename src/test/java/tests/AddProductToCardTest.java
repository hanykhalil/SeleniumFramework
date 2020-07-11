package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;

public class AddProductToCardTest extends TestBase{
	HomePage homeObject;
	ProductDetailsPage productDetailObject;
	CartPage cartObject;
	String firstProduct="macB";
	String secondProduct="asus";

	@Test(priority = 1)
	public void searchProduct() throws InterruptedException {
		homeObject= new HomePage(driver);
		productDetailObject= new ProductDetailsPage(driver);
		cartObject= new CartPage(driver);
		homeObject.seachProductWithAuto(firstProduct);
		productDetailObject.addCartBotton();
		homeObject.seachProductWithAuto(secondProduct);
		productDetailObject.addCartBotton();
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");

	}

	@Test(priority = 2)
	public void userCanCompareProducts() throws InterruptedException{
		cartObject= new CartPage(driver);
		cartObject.compareProduct();
		Thread.sleep(3000);
		Assert.assertEquals(cartObject.allRows.size(), 7);
	}
	@Test(priority = 3)
	public void userCanremove(){
		cartObject= new CartPage(driver);
		//Assert.assertEquals(cartObject.allRows.size(), 7);
		cartObject.removeFirstProduct();
		cartObject.updateCart();
		cartObject.removeSecondProduct();
		cartObject.updateCart();
	}
}
