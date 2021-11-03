package cpsat;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Set6_1 extends CommonUtility {
	
	@BeforeMethod
	public void setUp() {
		//Initializing browser and navigating to URL
		init("Chrome", "https://www.pepperfry.com/");
	}
	
	@Test
	public void testMethod1() throws Exception {
		
		//Fetching count of items to be searched
		int rowCount = getExcelRowCount("Set6_1");
		for (int count=0; count<rowCount; count++) {
			String data = getExcelData("Set6_1", count+1, 0);
			//Searching the item
			clearTextBox("//input[@id='search']");
			enterText("//input[@id='search']", data);
			enterText("//input[@id='search']", Keys.ENTER);
			
			//Rearranging the search results in Ascending order
			clickWebElement("//li[@id='curSortType']");
			clickWebElement("//li[@data-sort='price-asc']//a");
			Thread.sleep(3000);
			
			List<WebElement> searchResults = 
					driver.findElements(By.xpath("//div[@unbxdattr]//span[contains(@class,'offr-price')]"));
			int[] arr = new int[searchResults.size()];
			
			for (int itemNo=0; itemNo<searchResults.size(); itemNo++) {
				String price = getText("(//div[@unbxdattr]//span[contains(@class,'offr-price')])["+(itemNo+1)+"]");
				arr[itemNo] = Integer.parseInt(price.split(" ")[1]);
			}
			
			//Verfying the search results in Ascending order
			boolean isAsc = false;
			for (int i=1; i<arr.length; i++) {
				if(arr[i]>=arr[i-1]) {
					isAsc = true;
					continue;
				} else {
					isAsc = false;
					System.out.println("Items are not in ascending order for the product "+data);
					Assert.assertTrue(isAsc,"Items are not in ascending order for the product "+data);
					break;
				}
			}
			if(isAsc) {
				System.out.println("Items are in ascending order for the product "+data);
				Assert.assertTrue(isAsc,"Items are not in ascending order for the product "+data);
			}
			
		}

	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		quitBrowser();
	}

}
