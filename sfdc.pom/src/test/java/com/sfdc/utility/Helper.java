package com.sfdc.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	public static void captureScreenshot(WebDriver driver){
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(src, new File("./Screenshots/sfdcSnap" +getCurrentDateAndTime() + ".png"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static String getCurrentDateAndTime(){
		DateFormat customDate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customDate.format(currentDate);
	}

}
