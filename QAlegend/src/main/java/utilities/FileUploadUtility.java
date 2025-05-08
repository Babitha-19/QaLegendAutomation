package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
public static void fileUploadUsingRobotClass(WebElement element, String path) throws AWTException {
	StringSelection ss = new StringSelection(path);//path set>>clickboard edit-String selc
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	Robot robot = new Robot(); //obj creation of robot class
	robot.delay(250);
	robot.keyPress(KeyEvent.VK_ENTER); //virtual key-VK
	robot.keyRelease(KeyEvent.VK_ENTER);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.delay(90);
	robot.keyRelease(KeyEvent.VK_ENTER);
	
	
	
}
}
