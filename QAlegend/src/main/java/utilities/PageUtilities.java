package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//all methods should be static
public class PageUtilities {
public static void clickOnAnElement(WebElement element) {
	element.click();
	
	
}
public static void enterText(WebElement element, String value) {
	element.sendKeys(value);
	
}
public static void selectByvalue(WebElement element, String value) {
	
	Select dropdown= new Select(element);
			dropdown.selectByValue(value);
			
	
}
public static void selectByVisibleText(WebElement element, String value) {
	Select dropdown= new Select(element);
	dropdown.selectByVisibleText(value);
	
}
public static void selectByIndex(WebElement element, Integer index) {
	Select dropdown= new Select(element);
	dropdown.selectByIndex(index);

	
	
}
public static void dragAnddorp(WebDriver driver, WebElement sourceElement, WebElement destinationElement) {
	Actions action= new Actions(driver);
	action.dragAndDrop(sourceElement, destinationElement).build().perform();
}
public static void clickusingJavaScript(WebDriver driver, WebElement element) {  // click using javascript exectutor
	JavascriptExecutor executor= (JavascriptExecutor) driver;  //interface
	executor.executeScript("arguments[0].click();", element);
	
	
}
public static void scrolltillElementVisible(WebDriver driver, WebElement element) {  //scroll using javascropt executor
	JavascriptExecutor executor= (JavascriptExecutor) driver;  //interface
	executor.executeScript("arguments[0].scrollIntoView();", element);  //code to scroll
	
	
}

public static void mouseOver(WebDriver driver, WebElement element) {    //utility method for the mouseover action
    Actions actions = new Actions(driver);
    actions.moveToElement(element).perform();
}

public static void doubleClick(WebDriver driver, WebElement element) {   //utility method for the double click action
    Actions actions = new Actions(driver);
    actions.doubleClick(element).perform();
}


public static void rightClick(WebDriver driver, WebElement element) {   //utility method for the rightclick action
    Actions actions = new Actions(driver);
    actions.contextClick(element).perform();
}

public static void refreshPage(WebDriver driver) {    //utility method for the refresh action
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("history.go(0)");
}


public static void navigateToUrl(WebDriver driver, String url) {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("window.location = '" + url + "';");
}


// To accept an alert box


public static void acceptAlert(WebDriver driver) {

	  driver.switchTo().alert().accept();

}

public static void dismissAlert(WebDriver driver) {

	  driver.switchTo().alert().dismiss();

}

public static void enterValuetoAlert(WebDriver driver,String Value) {

	  driver.switchTo().alert().sendKeys(Value);

}

public static String getTextFromAlert(WebDriver driver) {

	 return( driver.switchTo().alert().getText());

}
}
