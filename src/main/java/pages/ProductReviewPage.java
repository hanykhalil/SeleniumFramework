package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends pageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id ="AddProductReview_Title")
	WebElement addProductTitle;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement  addProductReview;
	
	@FindBy(id = "addproductrating_4")
	WebElement  productRating;
	
	@FindBy(name = "add-review")
	WebElement addReviewBTN;
	
	@FindBy(css = "div.result")
	public WebElement addReviewMessage;
	
	public void addReview(String reviewtitle, String reviewmessage) {
		sendkeysText(addProductTitle, reviewtitle);
		sendkeysText(addProductReview, reviewmessage);
		clickButton(productRating);
		clickButton(addReviewBTN);
	}

}
