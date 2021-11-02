package com.sfdc.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sfdc.pages.BaseClass;
import com.sfdc.pages.LoginPage;

public class LoginTestSFDC extends BaseClass {
	
	@Test(priority=1)
	public void loginApplicationTest() {
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		String actualTitle = loginPage.logintosfdc(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		Assert.assertEquals(actualTitle, "Home | Salesforce");
		}

	
	/*@Test(priority=2)
	public void openCreateAccountPageTest() throws InterruptedException{
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginApplicationTest();
		String actualTitle =loginPage.OpenCreateAccountPage();
		Assert.assertEquals(actualTitle, "New Account");
	}*/
	/*@Test(priority=3)
	public void createAccountTest() throws InterruptedException{
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		openCreateAccountPageTest();
		String actualTitle =loginPage.createAccount("TestingPOMAccount", "1231231234", "1008776422", "6000000");
		Assert.assertEquals(actualTitle, "TestingPOMAccount");

	}*/

}

