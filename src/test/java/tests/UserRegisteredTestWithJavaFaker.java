package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisteredTestWithJavaFaker extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	Faker fake= new Faker();
	String fname= fake.name().firstName();
	String lname= fake.name().lastName();
	String useremail= fake.internet().emailAddress();
	String userpass= fake.number().digits(8).toString();
	
	@Test
	public void successfulRegisterUser() throws InterruptedException {
		homeObject =new HomePage(driver);
		homeObject.registrationUserLink();
		registerObject= new UserRegisterationPage(driver);
		registerObject.registerationUSER(fname, lname, useremail, userpass);
		assertTrue(registerObject.registerMessage.getText().contains("Your registration completed"));
		System.out.println(registerObject.registerMessage.getText());
		loginObject= new LoginPage(driver);
		Thread.sleep(3000);
		loginObject.logoutClick();
		Thread.sleep(3000);
		loginObject.loginClick();
		Thread.sleep(3000);
		loginObject.loginForm(useremail, userpass);
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
