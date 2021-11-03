package cpsat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Set2B_2 extends CommonUtility {
	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "https://www.cii.in/OnlineRegistration.aspx");
	}
	
	@Test
	public void testMethod() throws Exception {
		//Select value from dropdown
		selectValueFromDropDown("//select[@name='drpAttendee']", "3", "value");
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='Gridview1']//tr//select"));
		Assert.assertEquals(list.size(), 3);
		
		//Printing multiple options
		List<WebElement> options = driver.findElements(By.xpath("(//table[@id='Gridview1']//tr//select)[1]//option"));
		int counter = 1;
		for (WebElement opt : options) {
			System.out.println("Option "+counter+" is "+opt.getText());
			counter++;
		}
		
		//Inserting multiple fields in title dropdown
		ArrayList<String> array = new ArrayList<String>();
		array.add("Admiral");
		array.add("CA");
		array.add("CS");
		for(int count=1; count<=3; count++) {
			selectValueFromDropDown("(//table[@id='Gridview1']//tr//select)["+count+"]", array.get(count-1), "value");
		}
		
	}
	
	@After
	public void tearDown() throws IOException {
		quitBrowser();
	}


}
