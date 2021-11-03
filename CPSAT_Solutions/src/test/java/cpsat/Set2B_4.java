package cpsat;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Set2B_4 extends CommonUtility {
	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "https://www.premierleague.com/");
	}
	
	@Test
	public void testMethod() throws Exception {
		//Close the ADV page
		List<WebElement> adv = driver.findElements(By.xpath("//a[@id = 'advertClose']"));
		if(adv.size()>0) {
			clickWebElement("//a[@id = 'advertClose']");
		}
		
		//Allow cookies settings
		List<WebElement> cookies = driver.findElements(By.xpath("//div[contains(.,'cookies') and @role='btn']"));
		if(cookies.size()>0) {
			clickWebElement("//div[contains(.,'cookies') and @role='btn']");
		}
		
		//Clicking table menu option
		clickWebElement("//a[.='Tables']");
		Thread.sleep(1000);
		clickWebElement("(//td[@scope='row']//span[.='Arsenal'])[1]//parent::a");
		Thread.sleep(3000);
		
		//Official website
		String website = getText("//span[.='Official Website:']//parent::div//a");
		System.out.println("Official Website is "+website);
		
		//Page title
		String title = driver.getTitle();
		System.out.println("Page title is "+title);
		
	}
	
	@After
	public void tearDown() throws IOException {
		quitBrowser();
	}

}
