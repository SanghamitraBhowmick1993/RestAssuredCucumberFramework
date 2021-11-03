package cpsat;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Set3_1 extends CommonUtility {
	
	@BeforeMethod
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "https://jqueryui.com/checkboxradio/");
	}
	
	@Test
	public void testMethod1() throws Exception {
		//Switching to frame
		WebElement frame = 	driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		//Selecting PARIS button i not selected
		WebElement radioButton = driver.findElement(By.xpath("//label[@for='radio-2']//span[1]"));
		if(radioButton.isSelected()==false) {
			clickWebElement("//label[@for='radio-2']//span[1]");
			System.out.println("Paris button selected");
		} else {
			System.out.println("Paris button already selected");
		}
		
		//Selecting all the checkboxes
		List<WebElement> list = driver.findElements(By.xpath("//label[contains(@for,'checkbox')]"));
		for (int count=1; count<=list.size(); count++) {
			clickWebElement("(//label[contains(@for,'checkbox')])["+count+"]");
		}
		
	}
	
	@AfterMethod
	public void tearDown() throws IOException {
		quitBrowser();
	}

}
