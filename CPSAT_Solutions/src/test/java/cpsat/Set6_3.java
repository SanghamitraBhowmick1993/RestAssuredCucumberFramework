package cpsat;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

public class Set6_3 extends CommonUtility {

	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		init("Chrome", "https://maps.google.com");
	}
	
	@Test
	public void testMethod1() throws Exception {
		
		//Home address search in map
		String homeAddress = "Kadambari nagar durg";
		enterText("//input[@id='searchboxinput']", homeAddress);
		enterText("//input[@id='searchboxinput']", Keys.ENTER);
		
		//Fetching the search result address in frame
		performMoveToElementAction("(//div[contains(@class,'header-title')])[3]");
		String searchResult = getText("(//div[contains(@class,'header-title')])[3]");
		System.out.println("Address shown "+searchResult);
		takeScreenshot("Set6_2");
		
		//Searching for office direction
		clickWebElement("//button[@data-value='Directions']");
		enterText("//input[contains(@aria-label,'Choose starting point')]", "Phase 2, HITEC City, Hyderabad, Telangana");
		enterText("//input[contains(@aria-label,'Starting point')]", Keys.ENTER);
		
		//Fetching distance and duration for 1st option search
		String distance = getText("(//div[contains(@id,'trip-0')]//div[contains(@class,'trip-des')]//div[contains(@class,'duration')]//span)[1]");		
		String duration = getText("//div[contains(@id,'trip-0')]//div[contains(@class,'trip-des')]//div[contains(@class,'distance')]//div");
		System.out.println("1st option distance is "+distance);
		System.out.println("1st option duration is "+duration);
		
		
		
	}
	
	@After
	public void tearDown() throws IOException {
		quitBrowser();
	}
}
