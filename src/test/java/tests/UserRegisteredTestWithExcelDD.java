package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisteredTestWithExcelDD extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	@DataProvider(name = "testData")
	public static Object[][]userData() throws IOException{
		ExcelReader reader= new ExcelReader();
		return reader.getExcelData();
	}
	
	@Test(priority = 1,alwaysRun = true, dataProvider = "testData")
	public void successfulRegisterUser(String fname, String lname, String useremail, String userpass) throws InterruptedException {
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
