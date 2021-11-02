package com.sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.sfdc.utility.BrowseFactory;
import com.sfdc.utility.ConfigDataProvider;
import com.sfdc.utility.ExcelDataProvider;
import com.sfdc.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	
	@BeforeSuite
	public void setUpSuit(){
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
	}
	@BeforeClass
	public void setUp(){
	driver = BrowseFactory.startApplication(driver, config.getBrowser(), config.getURL());
	}
	@AfterClass
	public void tearDown(){
		BrowseFactory.quitDriver(driver);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE)
		Helper.captureScreenshot(driver);
	}
}
