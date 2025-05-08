package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class ScreenshotUtility {
	public void captureFailureScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot scrshot=(TakesScreenshot) driver; //convert driver object driver=scrshot
		File Screenshot=scrshot.getScreenshotAs(OutputType.FILE); //capture scrshot as file, virtual space
		File f1=new File(System.getProperty("user.dir")+"\\outputscreenshots"); //location
		if(!f1.exists()) {
			f1.mkdirs();//make directories, java create folder
		}
		String timestamp=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date(0)); 
		File finaldestination=new File(System.getProperty("user.dir")+"\\outputscreenshots\\"+name+"_"+timestamp+".png");
		FileHandler.copy(Screenshot, finaldestination);///virtual to finaldest
		
		
		
	}

}
