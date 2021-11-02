package CRUD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {
	private WebDriver driver;
	
	private By firstName = By.id("address_first_name");
	private By lastName = By.id("address_last_name");
	private By address1 = By.id("address_street_address");
	private By city = By.id("address_city");
	private By zip = By.id("address_zip_code");
	private By newAddress =By.linkText("New Address");
	private By successMessage =By.xpath("//div[@class='alert alert-notice']");
	private By createAddress =By.xpath("//input[@type='submit']");
	private By firstNameVal =By.xpath("//span[@data-test='first_name']");
	private By addressClick =By.linkText("Addresses");


	public AddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickNewAddress() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(addressClick).click();
	}
	private String fillAddressForm(Address address) throws InterruptedException{
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(address.getFirstName());
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(address.getLastName());
		driver.findElement(address1).clear();
		driver.findElement(address1).sendKeys(address.getAddress1());
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(address.getCity());
		driver.findElement(zip).clear();
		driver.findElement(zip).sendKeys(address.getZip());
		Thread.sleep(2000);
		driver.findElement(createAddress).click();
		return driver.findElement(successMessage).getText();
	}
	public String addAddress(Address address) throws InterruptedException{
		clickNewAddress();
		driver.findElement(newAddress).click();
		return fillAddressForm(address);
		
	}
	public String updateAddress(Address address, String fname) throws InterruptedException{
		clickNewAddress();
		driver.findElement(By.xpath("//td[text()='"+fname+"']//following-sibling::td//a[text()='Edit']")).click();
		return fillAddressForm(address);

	}
	public String deleteAddress(String fname) throws InterruptedException{
		clickNewAddress();
		driver.findElement(By.xpath("//td[text()='"+fname+"']//following-sibling::td//a[text()='Destroy']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		return driver.findElement(successMessage).getText();

	}
	public String getAddress(String fname) throws InterruptedException{
		clickNewAddress();
		driver.findElement(By.xpath("//td[text()='"+fname+"']//following-sibling::td//a[text()='Show']")).click();
		return driver.findElement(firstNameVal).getText();
	}
}
