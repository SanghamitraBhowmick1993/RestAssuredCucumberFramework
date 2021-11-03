package cpsat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Set2A_4 extends CommonUtility {
	@BeforeMethod
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "https://www.woodlandworldwide.com/");
	}
	
	@Test
	public void testMethod() throws Exception {
		
		int rowCount = getExcelRowCount("Set2A_4");
		
		//Iterative Search for the item fetched for excel
		for (int count=0; count<rowCount; count++) {
			
			String item = getExcelData("Set2A_4", count+1, 0);
			driver.findElement(By.xpath("//input[@id='searchKey']")).clear();
			enterText("//input[@id='searchKey']", item);
			enterText("//input[@id='searchKey']", Keys.ENTER);
			Thread.sleep(2000);
			
			//Filter the search results from price low to high.
			performMoveToElementAction("//div[@class='sorting']");
			clickWebElement("//a[@data-id='price-asc']");
			
			//Fetching product prices
			int[] arr = new int[8];
			for (int i=0; i<8; i++) {
				String price = 
						getText("(//div[contains(@class,'row products')]//div[contains(@class,'product')]//span[@class='price'])["+(i+1)+"]");
				price = price.substring(1, price.length()).replace(" ", "").trim();
				arr[i] = Integer.parseInt(price);
			}
			
			//Validating Asc product prices
			boolean isAscOrder = false;
			for (int j=1; j<arr.length; j++) {
				if(arr[j]>=arr[j-1]) {
					isAscOrder = true;
					continue;
				} else {
					isAscOrder = false;
					System.out.println("Prices for "+item+" are not in ascending order");
					break;
				}
			}

			if(isAscOrder) {
				System.out.println("Prices for "+item+" are in ascending order");
			}
			
			Thread.sleep(2000);		
		}
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		quitBrowser();
	}

}
