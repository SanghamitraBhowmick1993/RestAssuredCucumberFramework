package cpsat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

public class Set5_5 extends CommonUtility {
	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "http://ata123456789123456789.appspot.com/");
	}
	@Test
	public void testMethod1() throws Exception {
		
		int firstNum = 7;
		int secondNum = 4;
		//select the “Euclid(-)” option
		clickWebElement("//label[.='Euclid(-)']/..//input");
		
		//Enter input numbers
		clearTextBox("//input[@id='ID_nameField1']");
		enterText("//input[@id='ID_nameField1']", String.valueOf(firstNum));
		clearTextBox("//input[@id='ID_nameField2']");
		enterText("//input[@id='ID_nameField2']", String.valueOf(secondNum));
		
		clickWebElement("//button[@id='ID_calculator']");
		Thread.sleep(5000);
		
		//Capturing result
		String result = getAtrribute("//input[@id='ID_nameField3']", "value");
		int expectedResult = (firstNum*firstNum) - 2*firstNum*secondNum + (secondNum*secondNum);
		System.out.println("Expected value: "+expectedResult+" & Actual value: "+result+"");
		
		//Assert with expected value
		Assert.assertEquals(Integer.parseInt(result), expectedResult, 
				"Expected value: "+expectedResult+" & Actual value: "+result+"");
		
	}

	@After
	public void tearDown() throws Exception {
		quitBrowser();
	}

}
