package cpsat;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Set4_1PageFactory {
	
	WebDriver driver;
	
	public Set4_1PageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[.='CII Services'])[2]")
	WebElement ciiService;
	
	@FindBy(xpath = "//a[.='Sectoral Portfolio']")
	WebElement portfolio;
	
	@FindBy(xpath = "//a[.='Food & Agricultural']")
	WebElement foodAndAgriculture;
	
	@FindBy(xpath = "//a[.='Agriculture']")
	WebElement agriculture;
	
	@FindBy(xpath = "//div[@class='icons-container']")
	List<WebElement> socialMediaIcons;
	
	@FindBy(xpath = "//div[@class='icons-container']//img")
	List<WebElement> iconCounter;
	
	
	
	public void goToAriculture() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(ciiService).build().perform();
		Thread.sleep(1000);
		
		action.moveToElement(portfolio).build().perform();
		Thread.sleep(1000);
		
		action.moveToElement(foodAndAgriculture).build().perform();
		Thread.sleep(1000);
		
		action.moveToElement(agriculture).click().build().perform();
		Thread.sleep(1000);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public int noOfIcons() {
		return socialMediaIcons.size();
	}
	
	public String getToolTip(int index) throws Exception {
		Actions actions = new Actions(driver);
		actions.moveToElement(iconCounter.get(index)).build().perform();
		Thread.sleep(2000);
		return iconCounter.get(index).getAttribute("title");
	}

	public void takeScreenshot(int count) throws Exception {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File file = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\screenshot\\Set4_Q1_"+count+".jpg"));
		
	}
	
	
	

}
