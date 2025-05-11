package testcases;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageClasses.QaLegendHomePage;
import PageClasses.QaLegendLoginPage;
import PageClasses.TicketPage;
import automationcore.BaseClass;
import utilities.RetryAnalyzer;

		public class QaLegendTicketTest extends BaseClass{
		WebDriver driver;
		QaLegendLoginPage loginPage;
		QaLegendHomePage homepage;
		TicketPage ticketpage;
	
		Properties prop;
		FileInputStream fis;
		@BeforeMethod
		@Parameters({"browsername"})
		public void initialisation(String browsername) throws Exception {
		driver=browserInitialisation(browsername);
		driver.get("https://qalegend.com/crm/index.php/signin");
		driver.manage().window().maximize();
		loginPage= new QaLegendLoginPage(driver);
		homepage=new QaLegendHomePage(driver);
		ticketpage= new TicketPage(driver);
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\userdetails.properties");//can handle file
		prop=new Properties();
		prop.load(fis);
		}
	
	
		@Test(retryAnalyzer = RetryAnalyzer.class,  groups = {"Regression"})
		public void addTicket() throws InterruptedException {
		loginPage.loginInToQaLegend(prop.getProperty("username"),prop.getProperty("password"));  //accessing data from the property file
		homepage.clickOnTicketsMenu();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		ticketpage.ClickOnaddticketbutton();
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(10));
		String title=prop.getProperty("title");
		ticketpage.addTicketDetails(title,prop.getProperty("Description") );
		ticketpage.addClient(prop.getProperty("client"));
		ticketpage.waitForInvisibilityOfAddTicketModal();
		ticketpage.searchitem(title);
		Assert.assertEquals(ticketpage.cellvalueFind(), true);	
		}
		
	
		@Test(retryAnalyzer = RetryAnalyzer.class,  groups= {"Smoke"})    
		public void deleteTicket() throws InterruptedException {
		loginPage.loginInToQaLegend(prop.getProperty("username"),prop.getProperty("password"));  //accessing data from the property file
		homepage.clickOnTicketsMenu();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		ticketpage.ClickOnaddticketbutton();
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(10));
		String title=prop.getProperty("title");
		ticketpage.addTicketDetails(title,prop.getProperty("Description") );
		ticketpage.addClient(prop.getProperty("client"));
		ticketpage.waitForInvisibilityOfAddTicketModal();
		ticketpage.searchitem(title);
		ticketpage.deleteTicket();
		ticketpage.searchitem(title);
		Assert.assertEquals(ticketpage.cellvalueFind(), true);
		}
		
		
		
		@Test(retryAnalyzer = RetryAnalyzer.class,  groups = {"Regression"} )
		public void editTicket() throws InterruptedException {
		loginPage.loginInToQaLegend(prop.getProperty("username"),prop.getProperty("password"));  //accessing data from the property file
		homepage.clickOnTicketsMenu();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		ticketpage.ClickOnaddticketbutton();
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(10));
		String title=prop.getProperty("title");
		ticketpage.addTicketDetails(title,prop.getProperty("Description") );
		ticketpage.addClient("123");
		ticketpage.waitForInvisibilityOfAddTicketModal();
		ticketpage.searchitem(title);
		ticketpage.editTicket(title);
		driver.navigate().back();
		ticketpage.searchitem(title);
		Assert.assertEquals(ticketpage.cellvalueFind(), true);
		}
		}
