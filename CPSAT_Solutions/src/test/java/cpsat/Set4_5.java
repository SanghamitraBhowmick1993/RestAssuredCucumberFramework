package cpsat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

public class Set4_5 extends CommonUtility {
	
	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "http://www.onlineconversion.com/length_common.htm");
	}
	
	@Test
	public void testMethod() throws Exception {
		//Enter value 5.
		int numberToSearch = 5;
		enterText("(//input[@type='text'])[1]", String.valueOf(numberToSearch));
		
		//Select feet from From list.
		selectValueFromDropDown("//select[@name='from']", "feet", "text");
	
		//Select inch from To list.
		selectValueFromDropDown("//select[@name='to']", "inch", "text");
		
		//Click on Convert button.
		clickWebElement("//input[@name='Go']");
		String text = getAtrribute("//input[@name='answer']", "value");
		System.out.println("Output value is "+text);
		
		//Assert expected value
		int resultValue = Integer.parseInt(text.split(" = ")[1].split(" ")[0]);
		System.out.println("Final transformed value is "+resultValue);
		Assert.assertEquals(resultValue, numberToSearch*12);
		
	}
	
	@After
	public void tearDown() throws Exception {
		quitBrowser();
	}
	
}
