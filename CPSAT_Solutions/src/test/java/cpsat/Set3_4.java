package cpsat;


import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Set3_4 extends CommonUtility {
	
	@BeforeMethod
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "http://www.mptourism.com/");
	}
	
	@Test
	public void testMethod() throws Exception {
		
		//search for keywords retrieving from excel 
		int rowCount = getExcelRowCount("Set3_4");
		for (int count=0; count<=rowCount; count++) {
			String data = getExcelData("Set3_4", count+1, 0);
			clickWebElement("//a[.='Search']");
			enterText("//input[@id='keyword']", data);
			enterText("//input[@id='keyword']", Keys.ENTER);
			Thread.sleep(2000);
			
		}
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		quitBrowser();
	}

}
