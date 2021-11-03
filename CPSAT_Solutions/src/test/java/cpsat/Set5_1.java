package cpsat;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Set5_1 extends CommonUtility {
	
	@BeforeMethod
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "http://www.meripustak.com/");
	}
	@Test
	public void testMethod1() throws Exception {
		
		//Fetching keyword from excel
		int rowCount = getExcelRowCount("Set5_1");
		for (int count=0; count<rowCount; count++) {
			String data = getExcelData("Set5_1", count+1, 0);
			enterText("//input[@id='txtsearch']", data);
			enterText("//input[@id='txtsearch']", Keys.ENTER);
			Thread.sleep(5000);
			for (int itr = 1; itr <= 10; itr++) {
				
				//Check the price of the books 
				String orgPrice = getText("(//div[contains(@class,'price left')])["+itr+"]");
				String finalPrice = getText("(//div[contains(@class,'price right')])["+itr+"]");
				
				int orgPriceValue = Integer.parseInt(orgPrice.replace("Rs.", "").replace("/-", "").trim());
				int finalPriceValue = Integer.parseInt(finalPrice.replace("Rs.", "").replace("/-", "").trim());
				
				//logging discounted price in the eclipse log
				if(orgPriceValue > finalPriceValue) {
					System.out.println("Item "+data+", search-"+itr+" product having discounted price of "+finalPriceValue);
				} else {
					System.out.println("Item "+data+", search-"+itr+" product having no discount. Final price is"+orgPriceValue);
				}
			}	
		}
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		quitBrowser();
	}

}
