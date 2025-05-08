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

public class QaLegendNotesPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(@class,'btn btn-default')]")
	WebElement addnewnote;
	@FindBy(id="title")
	WebElement title;
	@FindBy(xpath="//div[@class='notepad']//descendant::textarea")  //parent child
	WebElement description;
	@FindBy(xpath="//button[contains(@class,'btn btn-primary')]")
	WebElement savebutton;
	@FindBy(xpath="//div[@id='note-table_filter']//descendant::input")
	WebElement searchbox;
	@FindBy(xpath="//tr[@class='odd' or @class='even']")
	WebElement cellfind;
	@FindBy(xpath="(//div[@class='modal-content'])[1]")
	WebElement addnotemodal;
	
	
	
	public QaLegendNotesPage(WebDriver driver) {
		this.driver=driver;		
		PageFactory.initElements(driver, this);	
		}

	
	
	public void clickOnAddNoteIcon() {
		PageUtilities.clickOnAnElement(addnewnote);
	}
	
	public void addNewNote(String Title, String Description) {
		PageUtilities.enterText(title,Title);
		PageUtilities.enterText(description, Description);
		PageUtilities.clickOnAnElement(savebutton);
		
		
		
	}
	public void searchNote(String Title) {
		PageUtilities.enterText(searchbox, Title);

		
	}
	public boolean cellvalueFind() {      //to locate the element/search result based on the row value,odd/even
		return(cellfind.isDisplayed());
		
		
	}



	public void waitForInvisibilityOfaddnotemodal() {
		// TODO Auto-generated method stub
		WaitUtility.waitForInvisibilityOfAnElement(driver, addnotemodal);
	}

}
