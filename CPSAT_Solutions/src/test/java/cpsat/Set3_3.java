package cpsat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Set3_3 {
	
	WebDriver driver;
		
	@BeforeMethod
	public void setUp() {
		//Initializing browser and navigating to URL	
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://www.cii.in/");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
	@Test
	public void testMethod() throws Exception {
		
		Set3_3POM obj = new Set3_3POM(driver);
		
		//Printing icons social media 
		int count = obj.getIconsCount();
		for (int i=0; i<count; i++) {
			System.out.println(obj.getIconName(i));
		}
		
		//Clicking contact us
		obj.clickContactUs();
		
		//Assert whether 1800 103 1244 present or not
		Assert.assertTrue(obj.checkPresence("1800 103 1244"));
		
	}
		
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	
}
