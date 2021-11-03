package cpsat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Set5_2 extends CommonUtility {
	@BeforeMethod
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "https://www.google.com/maps/");
	}
	@Test
	public void testMethod1() throws Exception {
		
		SoftAssert soft = new SoftAssert();
		
		//Search for “Wankhede Stadium” and then click on Maps 
		enterText("//div[@id='searchbox']", "Wankhede Stadium");
		enterText("//div[@id='searchbox']", Keys.ENTER);
		
		//Clicking on map
		WebElement ele = driver.findElement(By.xpath("//canvas[@class = 'widget-scene-canvas']"));
		int x = 37/2;
		int y= 145/2;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		Actions action = new Actions(driver);
		action.moveToElement(ele,x,y).click().build().perform();
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(2000);
		takeScreenshot("Set5_2_1");
		
		//Verify the Text Present “Stadium” in the left frame 
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Stadium')]"));
		soft.assertTrue(list.size()>0, "Stadium text is present in the left frame");
		
		//Verify the Title “Wankhede Stadium - Google Maps” 
		String title = driver.getTitle();
		soft.assertEquals(title, "Wankhede Stadium - Google Maps");
		
		//Rating and Reviews
		String rating = getText("(//div[@jsaction='pane.rating.moreReviews']//span)[3]");
		System.out.println("Rating is "+rating);
		
		String review = getText("//span/button[@jsaction='pane.rating.moreReviews']").split(" ")[0];
		System.out.println("Review is "+review);
		
		//Link mumbaicricket.com presence
		List<WebElement> list2 = driver.findElements(By.xpath("//*[.='mumbaicricket.com']"));
		soft.assertTrue(list2.size()>0, "mumbaicricket.com link is present");
		
		takeScreenshot("Set5_2_2");
		
		soft.assertAll();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		quitBrowser();
	}

}
