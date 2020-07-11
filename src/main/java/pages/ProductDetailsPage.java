package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends pageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement productDetailElement;
	
	@FindBy(css = "input.button-2.email-a-friend-button")
	WebElement emailAfriend;
	
	@FindBy(id = "price-value-4")
	public WebElement priceTag;
	
	public@FindBy(css = "strong.current-item")
	WebElement productInBreadBrumb;
	
	@FindBy(linkText = "Add your review")
	public WebElement addReviwLink;
	
	@FindBy(css = "input.button-1.add-to-cart-button")
	public WebElement addCartBtn;
	
	public void productDetails() {
		
		clickButton(productDetailElement);
	}
	
	public void emailAfriendProduct() {
		clickButton(emailAfriend);
	}
	
	public void openReviewPage() {
		clickButton(addReviwLink);
	}
	
	public void addCartBotton() {
		clickButton(addCartBtn);
	}
}
