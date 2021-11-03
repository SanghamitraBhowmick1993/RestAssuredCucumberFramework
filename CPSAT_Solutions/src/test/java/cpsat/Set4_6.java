package cpsat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Set4_6 extends CommonUtility {		
	
	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "https://en.wikipedia.org/wiki/Main_Page");
	}
	
	@Test
	public void testMethod() throws Exception {
		enterText("//input[@type='search']", "Memento (film)");
		enterText("//input[@type='search']", Keys.ENTER);
		Thread.sleep(5000);
		
		String directedBy = getText("//*[.='Directed by']//..//td//a");
		Assert.assertEquals(directedBy, "Christopher Nolan");
		
		String runningTime = getText("//*[.='Running time']/..//td");
		runningTime = runningTime.split("minutes")[0].trim();
		Assert.assertEquals(runningTime, "113");
		
		
		String boxOffice = getText("//*[.='Box office']/..//td");
		Assert.assertTrue(boxOffice.contains("$40 million"));
		
		performMoveToElementAction("//span[@id='Cast']");
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='div-col']//li"));
		for (WebElement ele : list) {
			System.out.println("Casting "+ele.getText());
		}
		
	}
	
	@After
	public void tearDown() throws Exception {
		quitBrowser();
	}		
			
			

}
