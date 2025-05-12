package PageClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constant;
import utilities.PageUtilities;
import utilities.WaitUtility;

public class QaLegendItemsPage {
	WebDriver driver;
	@FindBy(xpath="//a[text()=' Add item']")
	WebElement additem;
	@FindBy(xpath="//input[contains(@class,'form-control validate-hidden')]")
	WebElement addtitle;
	@FindBy(xpath="//input[@id='item_rate']")
	WebElement addrate;
	@FindBy(xpath="//button[contains(@class,'btn btn-primary')]")
	WebElement savebutton;
	@FindBy(xpath="//div[@id='item-table_filter']//descendant::input")
	WebElement searchitem;
	@FindBy(xpath="//tr[@class='odd' or @class='even']")
	WebElement cellfind;
	@FindBy(xpath="(//div[@class='modal-content'])[1]")
	WebElement additemmodal;
		

	public QaLegendItemsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	public QaLegendItemsPage clickOnAddItem() {
		PageUtilities.clickOnAnElement(additem);
		return this; 
		
	}
	
	public QaLegendItemsPage addNewItem(String titlefield, String ratefield) {
		PageUtilities.enterText(addtitle, ratefield);
		PageUtilities.enterText(addrate, ratefield);
		PageUtilities.clickOnAnElement(savebutton);
		return this;   //chaining
	}
	
	public void searchitem(String titlefield) {
		PageUtilities.enterText(searchitem, titlefield);		
	}
	
	public boolean cellvalueFind() {
		return(cellfind.isDisplayed());		
	}

	public void waitForInvisibilityOfAddItemModal() {
		// TODO Auto-generated method stub
		WaitUtility.waitForInvisibilityOfAnElement(driver, additemmodal);
	}
	
	

}
