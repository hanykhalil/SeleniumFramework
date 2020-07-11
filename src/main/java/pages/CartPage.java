package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends  pageBase {

	public CartPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(name = "removefromcart")
	WebElement removeProduct1;
	
	@FindBy(name = "removefromcart")
	WebElement removeProduct2;
	
	@FindBy(css = "input.button-2.update-cart-button")
	WebElement updateShopingCart;
	
	@FindBy(css = "div.no-data")
	WebElement updatMessage;
	
	@FindBy(css = "table.cart")
	WebElement productTable;
	
	public@FindBy(tagName = "tr")
	List<WebElement> allRows;
	
	public@FindBy(tagName = "td")
	List<WebElement> allColumns;
	
	public@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	WebElement asusProduct;
	
	public@FindBy(css = "input.button-2.continue-shopping-button")
	WebElement continueShoppingBTN;
	
	public@FindBy(id = "termsofservice")
	WebElement agreeButton;
	
	public@FindBy(css = "button.button-1.checkout-button")
	WebElement checkOutBTN;
	
	
	public void removeFirstProduct() {
		clickButton(removeProduct1);
	}
	public void removeSecondProduct() {
		clickButton(removeProduct2);
	}
	public void updateCart() {
		clickButton(updateShopingCart);
	}
	
	public void compareProduct() {
		for(WebElement row : allRows) {
			System.out.println(row.getText()+"\t");
			for(WebElement column : allColumns) {
				System.out.println(column.getText()+"\t");	
			}
		}
	}
	
	public void fromCartToCheckOut() {
		clickButton(agreeButton);
		clickButton(checkOutBTN);
	}
}
