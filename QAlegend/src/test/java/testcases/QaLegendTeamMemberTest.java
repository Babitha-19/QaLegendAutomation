package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageClasses.QaLegendHomePage;
import PageClasses.QaLegendItemsPage;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendNotesPage;
import PageClasses.QaLegendTeamMemberPage;
import automationcore.BaseClass;
import constants.Constant;
import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.RetryAnalyzer;

public class QaLegendTeamMemberTest extends BaseClass {
		WebDriver driver;
		QaLegendLoginPage loginPage;
		QaLegendHomePage homepage;
		QaLegendTeamMemberPage teammemberpage;
		QaLegendNotesPage notespage;
		QaLegendItemsPage itemspage;
		
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
		teammemberpage=new QaLegendTeamMemberPage(driver);
		itemspage=new QaLegendItemsPage(driver);
		notespage= new QaLegendNotesPage(driver);
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\userdetails.properties");//can handle file
		prop=new Properties();
		prop.load(fis);
		
		}
	
	  	@Test(retryAnalyzer = RetryAnalyzer.class, priority=1, groups = {"Regression"})
		public void addTeamMember() throws InterruptedException {
		loginPage.loginInToQaLegend(prop.getProperty("username"),prop.getProperty("password"));  //accessing data from the property file
		homepage.clickOnteamMemberMenu();
		teammemberpage.clickOnAddTeamemberButton();
		String firstname=FakerUtility.getFirstFakeName();
		String lastname=FakerUtility.getLastFakeName();
		String emailid="teammember"+ FakerUtility.randomNumberGenerator()+"@gmail.com";
		teammemberpage.addTeamMember(firstname, lastname, prop.getProperty("teammemberrole"), emailid ,prop.getProperty("teammemberpassword"));////accessing data from the property file
		teammemberpage.waitForInvisibilityOfaddnotemodal();
		teammemberpage.searchMember(emailid);
		AssertJUnit.assertEquals(teammemberpage.cellvalueFind(), true); //for comparing the searched and added values//verification, this TC completed
		}
   
	
	  	@Test(retryAnalyzer = RetryAnalyzer.class, priority=2, groups = {"Regression"})
	  	public void deleteTeamMember() throws IOException, InterruptedException {
		loginPage.loginInToQaLegend(prop.getProperty("username"),prop.getProperty("password"));  //accessing data from the property file
		homepage.clickOnteamMemberMenu();
		teammemberpage.clickOnAddTeamemberButton();
		String firstname=ExcelUtility.readStringData(1, 0, "Teammembers", Constant.EXCELFILEPATH)+FakerUtility.randomNumberGenerator();//value frm excel
		String lastname=ExcelUtility.readStringData(1, 1, "Teammembers", Constant.EXCELFILEPATH)+FakerUtility.randomNumberGenerator();
		String emailid=ExcelUtility.readStringData(1, 2, "Teammembers", Constant.EXCELFILEPATH)+FakerUtility.randomNumberGenerator()+ FakerUtility.randomNumberGenerator()+"@gmail.com";
		teammemberpage.addTeamMember(firstname, lastname, prop.getProperty("teammemberrole"), emailid ,prop.getProperty("teammemberpassword"));////accessing data from the property file
		teammemberpage.waitForInvisibilityOfaddnotemodal();
		teammemberpage.searchMember(emailid);
		teammemberpage.clickOnDelete();
		teammemberpage.deleteConfirmationPopup();	
		teammemberpage.searchMember(emailid);	
		driver.navigate().refresh();
		}
	
	
	  	@Test(retryAnalyzer = RetryAnalyzer.class,priority=3, groups = {"Regression"})
		public void addNewNote() throws InterruptedException {
		loginPage.loginInToQaLegend(prop.getProperty("username"),prop.getProperty("password"));  //accessing data from the property file
		homepage.clickOnNotesMenu();
		notespage.clickOnAddNoteIcon();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		String Title="Title"+FakerUtility.randomNumberGenerator()+"Test";
		String Description="Des"+FakerUtility.randomNumberGenerator()+"Test";
		notespage.addNewNote(Title, Description);
		notespage.waitForInvisibilityOfaddnotemodal();
		notespage.searchNote(Title);
		Assert.assertEquals(notespage.cellvalueFind(), true);  
		}
	
	
	  	@Test(retryAnalyzer = RetryAnalyzer.class,priority=4, groups= {"Smoke"} )
	  	public void addItems() throws InterruptedException {
	  	loginPage.loginInToQaLegend(prop.getProperty("username"),prop.getProperty("password"));  //accessing data from the property file
		homepage.clickOnItemsMenu();
		itemspage.clickOnAddItem();  	
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		String titlefield="item"+FakerUtility.randomNumberGenerator()+"test";
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(10));
		String ratefield="rate"+FakerUtility.randomNumberGenerator();
		itemspage.addNewItem(titlefield,ratefield);
		itemspage.waitForInvisibilityOfAddItemModal();
		itemspage.searchitem(titlefield);
		Assert.assertEquals(itemspage.cellvalueFind(), true);		
		}	  	
		}
	

