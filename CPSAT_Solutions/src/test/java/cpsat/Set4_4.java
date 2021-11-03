package cpsat;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

public class Set4_4 extends CommonUtility {
	
	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "https://www.shoppersstop.com/");
	}
	
	@Test
	public void testMethod() throws Exception {
		//From excel read the given keywords and search them
		int rowCount = getExcelRowCount("Set4_4");
		for (int count=0; count<rowCount; count++) {
			String data = getExcelData("Set4_4", count+1, 0);
			enterText("//input[@id='js-site-search-input']", data);
			enterText("//input[@id='js-site-search-input']", Keys.ENTER);
			Thread.sleep(5000);
			
			//In the results page for each item, sort the items in descending order.
			clickWebElement("//li[@sortcode='price-desc']");
			Thread.sleep(5000);
			
			//Check whether the prices are in descending order.
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i=1; i<=5; i++) {
				String text = getText
				("((//ul[@class='product-listing product-grid ']//li[contains(@itemtype,'Product')])//div[@class='price_div'])["+i+"]");
				int price = Integer.parseInt(text.replace(" ", "").replace("MRP", "").replace("Rs", "").trim());
				list.add(price);	
			}
			
			boolean flag = false;
			for (int j=1; j<list.size(); j++) {
				if(list.get(j-1)>=list.get(j)) {
					flag = true;
					continue;
				} else {
					System.out.println("Items "+data+" not listed in descending order");
					break;
				}
			}
			if(flag) {
				System.out.println("Items "+data+" listed in descending order");
			}
		}
	}
	
	@After
	public void tearDown() throws Exception {
		quitBrowser();
	}

}
