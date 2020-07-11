package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pageBase {
	protected WebDriver driver;
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;
	
	public pageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 protected static void clickButton(WebElement button) {
		button.click(); 
	 }
	 protected static void sendkeysText(WebElement sendkey, String value) {
		 sendkey.sendKeys(value);
	 }
	 
	 public void scrollToDown() {
		 jse.executeScript("scrollBy(0,2500)");
	 }
	 
	 public void selectItem() {
		 select.selectByValue("Egypt");
	 }
	 
	
}
