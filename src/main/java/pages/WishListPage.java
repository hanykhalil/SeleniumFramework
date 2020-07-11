package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends pageBase {

	public WishListPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(name = "removefromcart")
	WebElement removeFromCartRadioButtom;
	
	@FindBy(css = "input.button-2.update-wishlist-button")
	WebElement updateWishList;
	
	@FindBy(tagName = "h1")
	public WebElement wishList;
	
	public void removeFromWishList() {
		clickButton(removeFromCartRadioButtom);
		clickButton(updateWishList);
	}
}
