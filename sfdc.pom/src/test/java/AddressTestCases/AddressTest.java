package AddressTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CRUD.Address;
import CRUD.AddressPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddressTest{
	WebDriver driver;
	private AddressPage addressPage ;

	@BeforeTest
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://a.testaddressbook.com/sign_in");
		driver.manage().window().maximize();
		driver.findElement(By.id("session_email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("session_password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		addressPage = new AddressPage(driver);

	}
	@Test
	public void createAddressTest() throws InterruptedException{
		Address address = new Address("Sanghamitra","Bhowmick","Test Address","Karnataka","600097");
		String successMessage = addressPage.addAddress(address);
		Assert.assertEquals(successMessage, "Address was successfully created.");
	}
	@Test
	public void updateAddressTest() throws InterruptedException{
		Address address = new Address("SanghamitraUpdate","BhowmickUpdate","Test AddressUpdate","Karnataka","600097");
		addressPage.addAddress(address);
		address.setLastName("Bhowmick");
		address.setCity("NY");
		String successMessage =addressPage.updateAddress(address, address.getFirstName());
		Assert.assertEquals(successMessage, "Address was successfully updated.");

	}
	@Test
	public void deleteAddressTest() throws InterruptedException{
		Address address = new Address("SanghamitraDelete","BhowmickDelete","Test AddressDelete","Karnataka","600097");
		addressPage.addAddress(address);
		String successMessage =addressPage.deleteAddress(address.getFirstName());
		Assert.assertEquals(successMessage, "Address was successfully destroyed.");

	}
	@Test
	public void getAddress() throws InterruptedException{
		Address address = new Address("SanghamitraGet","BhowmickGet","Test AddressGet","Karnataka","600097");
		addressPage.addAddress(address);
		String actualFName = addressPage.getAddress(address.getFirstName());
		Assert.assertEquals(actualFName, address.getFirstName());
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}

