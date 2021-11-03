package cpsat;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Set1B_2 extends CommonUtility {
	WebDriver driver;
	int iterator = 0;

	@BeforeMethod
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "https://www.rediff.com/");
	}
	
	@Test
	public void testMethod1() throws Exception {
		String sheetName = "Set1B_2";
		int rowCount = getExcelRowCount(sheetName);
		for (int rowNum=0; rowNum<rowCount; rowNum++) {
			checkMenu(getExcelData(sheetName, rowNum+1, 0));
			checkSubMenu(getExcelData(sheetName, rowNum+1, 1));
			checkSubMenuLink(getExcelData(sheetName, rowNum+1, 1), getExcelData(sheetName, rowNum+1, 2));
		}
	}
	
	//Asserting Menu present on web page is same as that of excel value. If so, clicking on the same.
	public void checkMenu(String menu) throws Exception {
		List<WebElement> menuName = driver.findElements(By.xpath("//li[@class='"+menu+"']"));
		Assert.assertEquals(menuName.size()>0, true);
		clickWebElement("//li[@class='"+menu+"']");
		Thread.sleep(2000);
	}

	//Asserting SubMenu present on web page is same as that of excel value.
	public void checkSubMenu(String submenu) throws InterruptedException {
		List<WebElement> subMenuName = driver.findElements(By.xpath("//a[text()='"+submenu+"']"));
		Assert.assertEquals(subMenuName.size()>0, true);
	}

	//Asserting HREF present on web page for SubMenu is same as that of excel value. If so, clicking on SubMenu and taking screen shot.
	public void checkSubMenuLink(String submenu, String expectedLink) throws Exception {
		String actLink = getAtrribute("//a[text()='"+submenu+"']", "href");
		Assert.assertEquals(actLink, expectedLink);
		clickWebElement("//a[text()='"+submenu+"']");
		takeScreenshot("Set1B_Question2_"+(++iterator));
		driver.navigate().back();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() throws IOException {
		quitBrowser();
	}
}
