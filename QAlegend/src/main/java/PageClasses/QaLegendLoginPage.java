package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QaLegendLoginPage {
	WebDriver driver;
	@FindBy(id="email")
	WebElement usernamefield;
	@FindBy(id="password")
	WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement signinbutton;
	
	public QaLegendLoginPage(WebDriver driver ) {
		this.driver=driver;
		PageFactory.initElements(driver, this);    //it initi`alizes all the @FindBy-annotated WebElements inside your Page Object class.

		
		
	}
	
	
	public void loginInToQaLegend(String username, String password) {
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		signinbutton.click();
		return; //chaining of pages
		
		
		
		
	}
	

}
