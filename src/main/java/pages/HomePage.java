package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

public class HomePage extends pageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse= (JavascriptExecutor) driver;
		action= new Actions(driver);
	}
	@FindBy(linkText = "Register")
	WebElement registrationLink;
	
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	
	@FindBy(id = "small-searchterms")
	WebElement productSerachBox;
	
	@FindBy(id="ui-id-1")
	List<WebElement> autoCompleteProduct;
	
	@FindBy(css = "input.button-1.search-box-button")
	WebElement searchProductBTN;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(id= "customerCurrency")
	WebElement changeCurrencyList;
	
	@FindBy(linkText = "Computers ")
	WebElement productHoverLink;
	
	@FindBy(linkText = "Notebooks ")
	WebElement productHoverSubLink;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addToWishListLink;
	
	@FindBy(css = "span.wishlist-label")
	WebElement wishListIcon;
	
	public void registrationUserLink() {
		clickButton(registrationLink);
	}
	public void loginUserLink() {
		clickButton(loginLink);
	}
	public void searchProduct(String productName) {
	  sendkeysText(productSerachBox, productName);
	  clickButton(searchProductBTN);
	}
	public void seachProductWithAuto(String product) throws InterruptedException{
		sendkeysText(productSerachBox, product);
		Thread.sleep(4000);
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		autoCompleteProduct.get(0).click();
	}
	public void scrollDownPage() {
		scrollToDown();
		clickButton(contactUsLink);
	}
	
	public void selectFromDropDownList() {
		select= new Select(changeCurrencyList);
		select.selectByIndex(1);
	}
	
	public void selectFirstProductMenu() {
		action.moveToElement(productHoverLink).moveToElement(productHoverSubLink).click().build().perform();
	}
	
	public void addProductWishList() {
		clickButton(addToWishListLink);
		clickButton(wishListIcon);
	}
	
	
}	

