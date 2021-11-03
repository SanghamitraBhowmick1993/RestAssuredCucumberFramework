package cpsat;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Set1B_1 extends CommonUtility {
	
	@BeforeMethod
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "https://www.rediff.com/");
	}
	
	@Test
	public void testMethod() throws Exception {
		//Click Business menu
		clickWebElement("//a[.='BUSINESS']");
		Thread.sleep(1000);
		
		//Taking Business screenshot
		takeScreenshot("Set1B_1");
		
		//Getting href attribute value
		List<WebElement> subMenu = driver.findElements(By.xpath("//div[@class='subnavbar business']//a"));
		for (WebElement iterator : subMenu) {
			System.out.println(iterator.getAttribute("href"));
		}
		
		//Assert for News headlines
		String businessTitle = getAtrribute("//a[.='NEWS']", "title");
		Assert.assertEquals(businessTitle, "News headlines");
		
		//Mouse hover for News headlines
		performMoveToElementAction("//a[.='NEWS']");
		Thread.sleep(2000);
		takeScreenshot("Set1B_2");
		
		//Checking RGB background color
		String rgbValue = driver.findElement(By.xpath("//div[@class='subnavbar business']")).getCssValue("background-color");
		String rgb = Color.fromString(rgbValue).asRgb();
		Assert.assertEquals(rgb, "rgb(159, 107, 63)");
		
		//colour name (desert) check
		driver.navigate().to("https://www.color-blindness.com/color-name-hue/");
		Thread.sleep(2000);
		WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@src,'color-name-hue-tool')]"));
		driver.switchTo().frame(iframe);
		String rgbV = rgb.replace("rgb(", "");
		String rgbVa = rgbV.replace(")", "");
		String[] rgbVals = rgbVa.split(",");
		enterText("//input[contains(@id,'Red') and @type='text']", "-");
		Thread.sleep(2000);
		enterText("//input[contains(@id,'Red') and @type='text']", rgbVals[0].trim());
		enterText("//input[contains(@id,'Green') and @type='text']", "-");
		Thread.sleep(2000);
		enterText("//input[contains(@id,'Green') and @type='text']", rgbVals[1].trim());
		enterText("//input[contains(@id,'Blue') and @type='text']", "-");
		Thread.sleep(3000);
		enterText("//input[contains(@id,'Blue') and @type='text']", rgbVals[2].trim());
		Thread.sleep(2000);
		String colorName = getText("//div[@id='cp1_ColorNameText']");
		Assert.assertEquals(colorName, "Desert");
	}
	
	@AfterMethod
	public void tearDown() throws IOException {
		quitBrowser();
	}
}
