package cpsat;

import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Set1B_4 extends CommonUtility {
WebDriver driver;
	
	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "https://www.rediff.com/");
	}
	
	@Test
	public void testMethod() throws IOException {
		List<WebElement> elements = driver.findElements(By.xpath("(//div[contains(@id,'topdiv')])[1]//h2//a"));
		for (int count=1; count<=elements.size(); count++) {
			String text = driver.findElement(By.xpath("(//div[contains(@id,'topdiv')])[1]//h2["+count+"]//a")).getText();
			setExcelData("Set1B_4", count-1, 0, text);
		}
	}
	
	@After
	public void tearDown() throws IOException {
		quitBrowser();
	}

}
