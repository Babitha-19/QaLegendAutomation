package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;
import utilities.WaitUtility;

public class TicketPage {
WebDriver driver;

@FindBy(xpath="//div[@class='title-button-group']//descendant::a")
WebElement addticket;
@FindBy(id="title")
WebElement titlefield;
@FindBy(xpath = "//div[@class='select2-container select2 validate-hidden']")
WebElement selectClientValuedropdown;
@FindBy(xpath = "//div[contains(@id,'select2-result-label') and normalize-space()='Amazon']")
WebElement selectClientValue;
@FindBy(id="description")
WebElement descriptionfield;
@FindBy(xpath="//button[contains(@class,'btn btn-primary')]")
WebElement savebutton;
@FindBy(xpath="//div[@id='ticket-table_filter']//descendant::input")
WebElement searchitem;
@FindBy(xpath="//tr[@class='odd' or @class='even']")
WebElement cellfind;
@FindBy(xpath="(//div[@class='modal-content'])[1]")
WebElement addticketmodal;
@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle  mt0 mb0']")
WebElement toggleicon;
@FindBy(xpath="//a[@class='delete']")
WebElement delete;
@FindBy(id="confirmDeleteButton")
WebElement confirmdelete;
@FindBy(xpath="//a[text()='Demo title']")
WebElement titlevalue;
@FindBy(id="description")
WebElement editedescvalue;
@FindBy(xpath="//button[@class='btn btn-primary pull-right btn-sm ']")
WebElement postcomment;
	

	
	
	public TicketPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);  
}
	
	public void ClickOnaddticketbutton() {
		PageUtilities.clickOnAnElement(addticket);
		
	}
	
	public void addTicketDetails(String title, String Description) {
		titlefield.sendKeys(title);
		descriptionfield.sendKeys(Description);
	}
	
	public void addClient(String description) throws InterruptedException {

		PageUtilities.clickOnAnElement(selectClientValuedropdown);
		PageUtilities.clickOnAnElement(selectClientValue);
		PageUtilities.clickOnAnElement(savebutton);
	}
		
	public void searchitem(String title) {
		PageUtilities.enterText(searchitem, title);		
	}
	
	public boolean cellvalueFind() {
		return(cellfind.isDisplayed());		
	}

	public void waitForInvisibilityOfAddTicketModal() {
		// TODO Auto-generated method stub
		WaitUtility.waitForInvisibilityOfAnElement(driver, addticketmodal);		
	}
	public void deleteTicket() {
		PageUtilities.clickOnAnElement(toggleicon);
		PageUtilities.clickOnAnElement(delete);
		PageUtilities.clickOnAnElement(confirmdelete);
		
		
	}
	
	public void editTicket(String editeddesription) {
		PageUtilities.clickOnAnElement(titlevalue);
		editedescvalue.sendKeys(editeddesription);
		PageUtilities.clickOnAnElement(postcomment);
		
		
		
	}
}
