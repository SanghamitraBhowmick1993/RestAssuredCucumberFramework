package cpsat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Set3_3POM {
	
	WebDriver driver;

	public Set3_3POM(WebDriver driver) {
		this.driver = driver;
	}
	
	By contact = By.xpath("//a[contains(text(),'Contact Us')]");
	By icons = By.xpath("//div[@class='new-socila-icons']//span");
	
	public int getIconsCount() {
		return driver.findElements(icons).size();
	}
	
	public String getIconName(int i) {
		List<WebElement> iconNames = driver.findElements(icons);
		String[] parts = iconNames.get(i).getText().split("/");
		return parts[parts.length-1];
	}
	
	public void clickContactUs() throws Exception {
		driver.findElement(By.xpath("//body[1]")).sendKeys(Keys.END);
		Thread.sleep(1000);
		driver.findElement(contact).click();
	}
	
	public boolean checkPresence(String text) {
		List<WebElement> ele = driver.findElements(By.xpath("//*[text()='"+text+"']"));
		if (ele.size()>0) {
			return true;
		} else {
			return false;
		}
	}

}
