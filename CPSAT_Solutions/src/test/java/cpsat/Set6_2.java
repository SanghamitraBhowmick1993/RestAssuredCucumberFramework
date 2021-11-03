package cpsat;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class Set6_2 extends CommonUtility {

	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		init("Chrome", "http://www.wikipedia.org");
	}
	
	@Test
	public void testMethod1() throws Exception {
		
		//Fetching english articles
		String text = getText("//strong[.='English']/..//small//bdi");
		System.out.println("No of English articles are: "+text.replace(" ", ""));
		
		//Clicking English search
		clickWebElement("//strong[.='English']/..");
		
		//Search for Anna University
		enterText("//input[@name='search']", "Anna University");
		enterText("//input[@name='search']", Keys.ENTER);
		
		//Printing motto
		String motto = getText("//th[@scope='row']//div[contains(.,'Motto')]/../..//td");
		System.out.println("Motto is '"+motto+"'");
		
		//Verifying word 'Knowledge' in motto
		Assert.assertTrue(motto.contains("Knowledge"));
		
	}
	
	@After
	public void tearDown() throws IOException {
		quitBrowser();
	}
}
