package automationcore;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.internal.annotations.ITest;

import utilities.ScreenshotUtility;
public class BaseClass {

	public WebDriver driver;
	public WebDriver browserInitialisation(String browsername) throws Exception {
		if(browsername.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("Firefox")) {
			driver= new FirefoxDriver();

		}
		else if(browsername.equalsIgnoreCase("Edge")){
			driver= new EdgeDriver();
		}
		else {
			throw new Exception("Invalid name exception");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait, because this is parent class
		return driver;
	}
	@AfterMethod
	public void afterMethod(ITestResult itResult) throws IOException {
		if(itResult.getStatus()==ITestResult.FAILURE) {
			ScreenshotUtility sc=new ScreenshotUtility();
			sc.captureFailureScreenshot(driver, itResult.getName()); //find failed tc
		}
		if(driver!=null) {
			driver.quit();
			
		}
		
	}
}
	

