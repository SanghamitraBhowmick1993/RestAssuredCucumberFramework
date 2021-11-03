package cpsat;

import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Set2A_3 extends CommonUtility {
	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "https://www.hometown.in/");
	}
	
	@Test
	public void testMethod() throws Exception {
		//Clicking on More and selecting Gifting Ideas
		performMoveToElementAction("//div[text()='More']");
		clickWebElement("//a[@title='Gifting Ideas']");
		Thread.sleep(1000);
		
		//clicking on color dropdown and selecting WHITE
		performMoveToElementAction("(//p[.='Filter By']//parent::div//div//div)[1]");
		Thread.sleep(1000);
		clickWebElement("//label[contains(@for,'White')]");
		Thread.sleep(2000);
		
		//Check if first product displayed has White in it
		performMoveToElementAction("((//div[@class='listing']//div[@class='product'])[1]//a)[2]");
		String productName = getText("((//div[@class='listing']//div[@class='product'])[1]//a)[2]");
		Assert.assertTrue(productName.toLowerCase().contains("white"));
				
		//Checking if White is present in Applied filters
		Boolean flag = false;
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='tags']//ul//li"));
		for (int count=1; count<=elements.size(); count++) {
			String text = getText("(//div[@class='tags']//ul//li)["+count+"]//p");
			if(text.equalsIgnoreCase("white")) {
				flag = true;
				break;
			}
		}	
		Assert.assertTrue(flag);

	}
	
	@After
	public void tearDown() throws IOException {
		quitBrowser();
	}
}
