package cpsat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Set4_3 extends CommonUtility {
	
	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "http://www.nytimes.com/");
	}
	
	@Test
	public void testMethod() throws Exception {
		//Available languages in which the site can be viewed.
		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@data-testid,'edition-menu')]//li//a"));
		for (WebElement ele : list) {
			System.out.println("Available language- "+ele.getAttribute("lang"));
		}
		
		//link Politics Url
		clickWebElement("(//a[.='Politics'])[2]");
		Thread.sleep(2000);
		takeScreenshot("Set4_2");
		
		//Verify page title
		String url = driver.getCurrentUrl();
		System.out.println("Page URl is "+url);
		Assert.assertTrue(url.contains("politics"));
		
		//Go to Search, enter “arts” 
		clickWebElement("//button[@data-test-id='search-button']");
		enterText("//input[@name='query']", "arts");
		enterText("//input[@name='query']", Keys.ENTER);
		
		//search result items
		String text = getText("(//p[@aria-live='polite'])[1]");
		System.out.println("Total serch result is "+text.split(" ")[1]);
		
	}
	
	@After
	public void tearDown() throws Exception {
		quitBrowser();
	}
	
	
	
	
}
