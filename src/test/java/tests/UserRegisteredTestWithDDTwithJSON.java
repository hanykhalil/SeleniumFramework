package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import data.JsonReaderData;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisteredTestWithDDTwithJSON extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	
	@Test(priority = 1,alwaysRun = true)
	public void successfulRegisterUser() throws InterruptedException, IOException, ParseException {
			JsonReaderData json= new JsonReaderData();
			json.jsonReader();
			homeObject =new HomePage(driver);
			homeObject.registrationUserLink();
			registerObject= new UserRegisterationPage(driver);
			Thread.sleep(3000);
			registerObject.registerationUSER(json.fname, json.lname, json.useremail, json.userpass);
			assertTrue(registerObject.registerMessage.getText().contains("Your registration completed"));
			System.out.println(registerObject.registerMessage.getText());
			loginObject= new LoginPage(driver);
			Thread.sleep(3000);
			loginObject.logoutClick();
			Thread.sleep(3000);
			loginObject.loginClick();
			Thread.sleep(3000);
			loginObject.loginForm(json.useremail, json.userpass);
			Thread.sleep(3000);
			loginObject.logoutClick();

		}
		

		
	

	@Test(dependsOnMethods = {"successfulRegisterUser"}, enabled = false)
	public void logOutForm() {
		loginObject= new LoginPage(driver);
		loginObject.logoutClick();
	}

	@Test(dependsOnMethods = {"logOutForm"}, enabled = false)
	public void successfullyLoginUser() {
		homeObject.loginUserLink();
		loginObject= new LoginPage(driver);
		loginObject.loginForm("khalilo@yahoo.com", "123456");
		//loginObject.loginClick();
		assertTrue(loginObject.logouBTN.isDisplayed());
		System.out.println(loginObject.logouBTN.getText());
	}
	 
	
	@Test(dependsOnMethods = {"successfullyLoginUser"}, enabled = false)
	public void clickMyAccount() {
		registerObject.myAccountClick();
	}
	


}
