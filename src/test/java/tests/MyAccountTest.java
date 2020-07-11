package tests;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class MyAccountTest extends TestBase{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	String firstName="ramy";
	String lastName="farid";
	String EmailName="mama@yahoo.com";
	String Passwords="123456";
	//String OldPasswords="123456";
	String NewPasswords="12345678";
	String ConfirmPasswords="12345678";
		
		@Test(priority = 1,alwaysRun = true)
		public void successfulRegisterUser() throws InterruptedException {
			homeObject =new HomePage(driver);
			homeObject.registrationUserLink();
			registerObject= new UserRegisterationPage(driver);
			registerObject.registerationUSER(firstName, lastName, EmailName, Passwords);
			assertTrue(registerObject.registerMessage.getText().contains("Your registration completed"));
			System.out.println(registerObject.registerMessage.getText());
		}

	
	@Test(dependsOnMethods = {"successfulRegisterUser"})
	public void clickMyAccount() {
		registerObject.myAccountClick();
	}
	
	@Test(dependsOnMethods = {"clickMyAccount"})
	public void clickChangePASS() {
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.changePassordClicklink();
	}
	
	@Test(dependsOnMethods = {"clickChangePASS"})
	public void changeUserPass() throws InterruptedException {
		myAccountObject =new MyAccountPage(driver);
		myAccountObject.changePasswordSend(Passwords, NewPasswords);
		myAccountObject.changePassordClickButton();
		Thread.sleep(4000);
		Assert.assertTrue(myAccountObject.signReturn.getText().contains("Password was changed"));
		System.out.println(myAccountObject.signReturn.getText().contains("Password was changed"));
	}
	
}
