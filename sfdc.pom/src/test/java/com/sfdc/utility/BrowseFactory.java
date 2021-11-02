package com.sfdc.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowseFactory {
	WebDriver driver;
	public static WebDriver startApplication(WebDriver driver,String browserName, String applicationURL){
		if(browserName.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else{
			System.out.println("Browser not supported");
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(applicationURL);
		driver.manage().window().maximize();
		driver.navigate().refresh();
		return driver;
	}
	public static void quitDriver(WebDriver driver){
		driver.quit();
	}
}
