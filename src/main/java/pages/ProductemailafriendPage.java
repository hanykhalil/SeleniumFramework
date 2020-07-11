package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductemailafriendPage extends pageBase{

	public ProductemailafriendPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css ="div.result")
	public WebElement productsentMessage;
	

}
