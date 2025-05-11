package PageClasses;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtilities;
import utilities.WaitUtility;

public class QaLegendTeamMemberPage {
WebDriver driver;
@FindBy(xpath="//a[text()=' Add member']")
WebElement addmemberbutton;
@FindBy(id="first_name")
WebElement firstnamefield;
@FindBy(id="last_name")
WebElement lastnamefield;
@FindBy(id="form-next")
WebElement nextbutton;
@FindBy(xpath="//input[@name='job_title']")
WebElement jobtitlefield;
@FindBy(id="email")
WebElement emailfield;
@FindBy(id="password")
WebElement passwordfield;
@FindBy(id="form-submit")
WebElement savebutton;
@FindBy(xpath="//div[@id='team_member-table_filter']//descendant::input")
WebElement searchbox;
@FindBy(xpath="//tr[@class='odd'or @class='even']")
WebElement teammembercellvalue;
@FindBy(xpath="//a[contains(@class,'delete')]")
WebElement deleteicon;
@FindBy(id="confirmDeleteButton")
WebElement deletebutton;
@FindBy(xpath="(//div[@class='modal-content'])[1]")
WebElement addnotemodal;


public QaLegendTeamMemberPage(WebDriver driver) {
this.driver=driver;
PageFactory.initElements(driver, this);   // to initialize all the @findby annotations
}

public void addTeamMember(String firstname, String lastname, String jobtitle, String email, String password) throws InterruptedException {
	PageUtilities.enterText(firstnamefield, firstname);
	PageUtilities.enterText(lastnamefield, lastname);
	PageUtilities.clickOnAnElement(nextbutton);
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	PageUtilities.enterText(jobtitlefield, jobtitle );
	PageUtilities.clickOnAnElement(nextbutton);
	WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(10));
	PageUtilities.enterText(emailfield, email);
	PageUtilities.enterText(passwordfield, password);
	PageUtilities.clickOnAnElement(savebutton);
	
	
	
}

public void searchMember(String email) { //used to find whether the user was added or not
	PageUtilities.enterText(searchbox, email);
	
}


public void clickOnAddTeamemberButton() {
	
	PageUtilities.clickOnAnElement(addmemberbutton);
	
}

public boolean cellvalueFind() {      //to locate the element/search result based on the row value,odd/even
	return(teammembercellvalue.isDisplayed());
	
	
}

public void clickOnDelete() {
	
	PageUtilities.clickOnAnElement(deleteicon);
	
	
	
	
}

public void deleteConfirmationPopup() {
	
	PageUtilities.clickOnAnElement(deletebutton);

	
	
	
	
}
public String confirmDelete() {
	
	return(teammembercellvalue.getText());

}

public void waitForInvisibilityOfaddnotemodal() {
	WaitUtility.waitForInvisibilityOfAnElement(driver, addnotemodal);
}


}
