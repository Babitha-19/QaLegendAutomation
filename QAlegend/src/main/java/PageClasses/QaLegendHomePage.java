package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class QaLegendHomePage {
	
	
WebDriver driver;
@FindBy(xpath = "//span[text()='Team members']")  //xpath of the teammember menu
WebElement teammemberoption;   

@FindBy(xpath="//span[text()='Notes']")   //xpath of notes menu
WebElement Notesmenu;

@FindBy(xpath="//span[text()='Items']")
WebElement Itemsmenu;

@FindBy(xpath="//span[text()='Clients']")
WebElement clientsMenu;

@FindBy(xpath="//span[text()='Tickets']")
WebElement ticketmenu;


public QaLegendHomePage(WebDriver driver) {   //constructor
	this.driver=driver;
	PageFactory.initElements(driver, this);  //initalize findby
}

public void clickOnteamMemberMenu() {     //clickon menu
	
	PageUtilities.clickOnAnElement(teammemberoption); //clicking using pageutility method , click on the element is mentioned
}

public void clickOnNotesMenu() {
	PageUtilities.clickOnAnElement(Notesmenu);	
}

public void clickOnItemsMenu() {
	PageUtilities.clickOnAnElement(Itemsmenu);
}

public void clickOnTicketsMenu() {
	PageUtilities.clickOnAnElement(ticketmenu);
	
}

}
