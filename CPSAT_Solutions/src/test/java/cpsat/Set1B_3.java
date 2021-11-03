package cpsat;

import java.io.IOException;
import java.util.Set;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

public class Set1B_3 extends CommonUtility {
	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "https://www.rediff.com/");
	}
	
	@Test
	public void testMethod() throws Exception {
		Set1B_3_POM obj = new Set1B_3_POM();
		
		//Switch to frame
		driver.switchTo().frame(driver.findElement(obj.getFrame()));
		
		//get BSE Index
		String bseIndex = driver.findElement(obj.getBSE()).getText();
		System.out.println("BSE Index is "+bseIndex);
		
		//get NSE Index
		String nseIndex = driver.findElement(obj.getNSE()).getText();
		System.out.println("NSE Index is "+nseIndex);
		
		//Search Kotak Mahindra Bank Ltd.
		driver.findElement(obj.getSearchField()).sendKeys("Kotak Mahindra Bank Ltd.");
		Thread.sleep(1000);
		driver.findElement(obj.getSearchField()).sendKeys(Keys.ENTER);
		
		//Validating new window has “KOTAK MAHINDRA BANK LTD.” in it
		String currentWindow1 = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			if(!win.equals(currentWindow1)) {
				driver.switchTo().window(win);
				break;
			}
		}
		String relianceTitle = driver.getTitle();
		Assert.assertTrue(relianceTitle.contains("KOTAK MAHINDRA BANK LTD."));
		
		//Title of the window has “Rediff.com:” in it
		String currentWindow2 = driver.getWindowHandle();
		for (String win : windows) {
			if(!win.equals(currentWindow2)) {
				driver.switchTo().window(win);
				break;
			}
		}
		String rediffTitle = driver.getTitle();
		Assert.assertTrue(rediffTitle.contains("Rediff.com:"));
	}
	
	@After
	public void tearDown() throws IOException {
		quitBrowser();
	}
}
