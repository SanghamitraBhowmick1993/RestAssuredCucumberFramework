package cpsat;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Set7_1 extends CommonUtility {
	
	
	
	
	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		init("Chrome", "http://www.shoppersstop.com");
	}
	
	@Test
	public void testMethod1() throws Exception {
		
		clickWebElement("//a[@title='BRANDS']");
		
		performMoveToElementAction("(//img[@title='Haute Curry'])[1]");
		
		clickWebElement("(//img[@title='Haute Curry'])[2]/../..//span");
		
		Thread.sleep(2000);
		
		takeScreenshot("Set7A_1");
		
		String actualPageTitle = driver.getTitle();
		
		System.out.println("Page title is "+actualPageTitle);
		
		String expectedTitle = "Haute Curry Bags | Haute Curry Ladies Footwear | Shoppers Stop | Shoppers Stop";
		
		Assert.assertEquals(expectedTitle, actualPageTitle);
		

	}
	
	@After
	public void tearDown() throws IOException {
		quitBrowser();
	}

}
