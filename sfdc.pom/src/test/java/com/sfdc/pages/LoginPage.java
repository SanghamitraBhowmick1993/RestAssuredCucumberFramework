package com.sfdc.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass {
	WebDriver driver;
	Actions actions = new Actions(driver); 

	
	public LoginPage(WebDriver ldriver){
		this.driver=ldriver;
	}
	//OR or Page Factory
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="Login") WebElement login;
	@FindBy(xpath="//*[@class='slds-icon-waffle']") WebElement appLauncher;
	@FindBy(xpath="//p[text()='Service']") WebElement serviceClick;
	@FindBy(xpath="//a//span[text()='Accounts']") WebElement accountsClick;
	@FindBy(xpath="//div[@title='New']") WebElement newClick;
	@FindBy(xpath="//div[@class='slds-modal__header']//h2") WebElement newAccountTitle;
	@FindBy(name="Name") WebElement AccountName;
	@FindBy(name="PhoneNumber") WebElement PhoneNumber;
	@FindBy(name="AccountNumber") WebElement AccountNumber;
	@FindBy(name="AnnualRevenue") WebElement AnnualRevenue;
	@FindBy(name="SaveEdit") WebElement Save;
	@FindBy(xpath="//span[@class='custom-truncate uiOutputText']") WebElement validateAcNm;


	
	//Actions
		public String logintosfdc(String usernm, String pwd) {
			  Action seriesofActions =actions.moveToElement(username).click().sendKeys(usernm).build();
			  seriesofActions.perform(); 
			  password.sendKeys(pwd);
			  login.click();
			  try {
				Thread.sleep(12000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  Actions action = new Actions(driver);
				Action seriesOfActions = action.moveToElement(appLauncher).click().build();
				seriesOfActions.perform();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				serviceClick.click();
				  try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  return driver.getTitle();

}
		public String OpenCreateAccountPage() throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", accountsClick);
			Thread.sleep(3000);
			  newClick.click();
			 return newAccountTitle.getText();

		}
		public void createAccount(String accountName,String phoneNum,String accNum,String annualRevenue){
			 Action accNm =actions.moveToElement(AccountName).click().sendKeys(accountName).build();
			 accNm.perform(); 
			  Action ph =actions.moveToElement(PhoneNumber).click().sendKeys(phoneNum).build();
			  ph.perform();
			  Action accNumr =actions.moveToElement(AccountName).click().sendKeys(accountName).build();
			  accNumr.perform();
			  Action annRev =actions.moveToElement(AnnualRevenue).click().sendKeys(annualRevenue).build();
			  annRev.perform();
			  Save.click();
			  validateAcNm.getText();
		}
}
