package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;

public class ChangeCurrencyTest extends TestBase{
	HomePage homeObject;
	ProductDetailsPage productObject;
	String product="macB";
	
	@Test(priority = 1)
	public void changeCurrency() {
		homeObject =new HomePage(driver);
		homeObject.selectFromDropDownList();
	}
	
	@Test(priority = 2)
	public void findProductByAutoComplete() throws InterruptedException {
		homeObject.seachProductWithAuto(product);
		productObject= new ProductDetailsPage(driver);
		Assert.assertTrue(productObject.productInBreadBrumb.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));
		Assert.assertTrue(productObject.priceTag.getText().contains("Ђ"));
		System.out.println(productObject.priceTag.getText());
	}
}
