package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;

public class SerachProductWithAutoCompleteTest extends TestBase {
	
	HomePage homeObject;
	ProductDetailsPage productObject;
	String product="macB";
	@Test
	public void findProductByAutoComplete() throws InterruptedException {
		homeObject =new HomePage(driver);
		homeObject.seachProductWithAuto(product);
		productObject= new ProductDetailsPage(driver);
		Assert.assertTrue(productObject.productInBreadBrumb.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));
	}
}
