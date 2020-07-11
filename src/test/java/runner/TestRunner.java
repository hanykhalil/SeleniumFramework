package runner;

import io.cucumber.testng.CucumberOptions;

import tests.TestBase;

@CucumberOptions(features = {"D:\\Selenium Package\\TAF\\src\\test\\java\\features"}
,glue = {"steps"}
,plugin = {"pretty","html:target\\cucumber-html-report.html"})
public class TestRunner extends TestBase
{
  
}
