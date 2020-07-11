package steps;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase{
	HomePage homeObjecct;
    UserRegisterationPage registerObject;
    LoginPage loginObject;

		@Given("^the user in the home page$")
		public void the_user_in_the_home_page() throws InterruptedException {
			HomePage homeObjecct= new HomePage(driver);
		    homeObjecct.registrationUserLink();
		}
		
		@When("^I click on the registeration link$")
		public void I_click_on_the_registeration_link() {
		    Assert.assertTrue(driver.getCurrentUrl().contains("register"));
		}
		
	/*
	 * @And("^I entered the user data to register$") public void
	 * I_entered_the_user_data_to_register() throws InterruptedException {
	 * UserRegisterationPage registerObject= new UserRegisterationPage(driver);
	 * registerObject.registerationUSER("maged", "aly", "mardedy@yahoo.com",
	 * "12345678"); Thread.sleep(4000);
	 * 
	 * }
	 */
		@And("I entered {string},{string},{string},{string}")
		public void i_entered(String firstname, String lastname, String email, String password) throws InterruptedException {
			UserRegisterationPage registerObject= new UserRegisterationPage(driver);
			registerObject.registerationUSER(firstname, lastname, email, password);
		   
		}
		
		@Then("^the registeration page displayed successfully$")
		public void the_registeration_page_displayed_successfully() throws InterruptedException {
			//assertTrue(registerObject.registerMessage.getText().contains("Your registration completed"));
			Thread.sleep(4000);
			UserRegisterationPage registerObject= new UserRegisterationPage(driver);
			registerObject.registerLogOut.click();
		}
		

		
}
