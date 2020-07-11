package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;

public class SearchProductTest extends TestBase {
	String productName="Apple MacBook Pro 13-inch";
	HomePage homeObject;
	ProductDetailsPage productDetailObject;
	@Test
	public void searchProductmethod() {
		homeObject= new HomePage(driver);
		homeObject.searchProduct(productName);
		
		productDetailObject = new ProductDetailsPage(driver);
		productDetailObject.productDetails();
		
		Assert.assertTrue(productDetailObject.productInBreadBrumb.getText().equalsIgnoreCase(productName));
		System.out.println(productDetailObject.productInBreadBrumb.getText());
	}
}
	


