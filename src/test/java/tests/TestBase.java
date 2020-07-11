package tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{
	 public static WebDriver driver;
	 
	 public static String downloadsPath=System.getProperty("user.dir")+"\\Downloads\\";
		public static FirefoxOptions firfoxOption() {
		FirefoxOptions option=new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadsPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		return option;
		}
		////////////////////////////////////////////////////////////////////////////
		public static ChromeOptions chromeoption() {
			ChromeOptions options= new ChromeOptions();
			HashMap<String, Object> chromePrefs=  new HashMap<String, Object>();
			chromePrefs.put("profile.default.contect_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadsPath);
			options.setExperimentalOption("prefs", chromePrefs);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			return options;
		}
	 @Parameters({"browser"})
	@BeforeSuite
	public void startDriver(@Optional("chrome") String browserName) 
	 {
		 if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=  new ChromeDriver(chromeoption());
		 }
		 else if (browserName.equalsIgnoreCase("firefox")) {
			 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
				driver=  new FirefoxDriver(firfoxOption());
		}
		driver.navigate().to("https://demo.nopcommerce.com");
		driver.manage().window().maximize();
	}
	
	
	@AfterSuite
	public void cleanUp() {
		driver.quit();
	}
	
	@AfterMethod
	public void screenShotOnFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			System.out.println("failed");
			System.out.println("ScreenShot is taking for this failed testcase");
			Helper.capturedScreenShots(driver, result.getName());
		}
	}

}
