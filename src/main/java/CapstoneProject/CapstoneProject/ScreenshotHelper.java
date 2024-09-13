package CapstoneProject.CapstoneProject;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotHelper {
	
	public static void captureScreenshot(WebDriver driver, String filename) {
		try {
			TakesScreenshot ts =(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(source, new File("./Screenshots/" + filename + ".png"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
