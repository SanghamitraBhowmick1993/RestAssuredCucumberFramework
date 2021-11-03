package cpsat;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Set3_2 extends CommonUtility {
	@BeforeMethod
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "https://code.makery.ch/library/dart-drag-and-drop/");
	}
	
	@Test
	public void testMethod1() throws Exception {
		//Moving to drag-avatar
		performMoveToElementAction("//h3[@id='custom-drag-avatar']");
		
		//Switching to iframe
		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@src,'custom_avatar')]"));
		driver.switchTo().frame(frame);
		
		//Collecting dragable object list
		List<WebElement> docs = driver.findElements
				(By.xpath("//a[contains(@href,'example/custom_avatar')]//parent::div//img"));
		WebElement container = driver.findElement
				(By.xpath("//a[contains(@href,'example/custom_avatar')]//parent::div//div[@class='trash']"));
		
		//Dragging to bin
		Actions action = new Actions(driver);
		 for (int count=1; count<=docs.size(); count++) {
			 WebElement doc = driver.findElement(By.xpath
					 ("//a[contains(@href,'example/custom_avatar')]//parent::div//img"));
			 takeScreenshot("Set3_2_"+count);
			 action.dragAndDrop(doc, container).build().perform();
		 }
	}
	
	@AfterMethod
	public void tearDown() throws IOException {
		quitBrowser();
	}
}
