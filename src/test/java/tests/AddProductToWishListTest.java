package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase {
	HomePage homeObject;
	WishListPage wishListObject;
	String product="macB";
	
	@Test
	public void searchProduct() {
		homeObject = new HomePage(driver);
		try {
			homeObject.seachProductWithAuto(product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void userCanAddToWishList() {
		homeObject = new HomePage(driver);
		homeObject.addProductWishList();
	}
	
	@Test
	public void userCanRemoveFromWishList() throws InterruptedException {
		wishListObject = new WishListPage(driver);
		wishListObject.removeFromWishList();
		Thread.sleep(3000);
		Assert.assertTrue(wishListObject.wishList.getText().contains("Wishlist"));
	}
}
