package cpsat;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Set4_1 {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.cii.in");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
	@Test
	public void testMethod() throws Exception {
		//Instantiating PageFactory class
		Set4_1PageFactory obj = new Set4_1PageFactory(driver);
		
		//Navigating to Agriculture section
		obj.goToAriculture();
		
		//Getting the title
		String title = obj.getPageTitle();
		Assert.assertEquals(title, "Sectors");
		
		//social network icons and screenshots
		for(int count=1; count<=obj.noOfIcons(); count++) {
			System.out.println(obj.getToolTip(count));
			obj.takeScreenshot(count);
			
		}
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
