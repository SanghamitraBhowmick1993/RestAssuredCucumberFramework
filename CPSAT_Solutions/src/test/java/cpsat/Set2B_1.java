package cpsat;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Set2B_1 extends CommonUtility {
	@BeforeMethod
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "https://www.meripustak.com/");
	}
	
	@Test
	public void testMethod() throws Exception {
		//Printing the height and width of the logo.
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Meripustak logo']"));
		System.out.println("Height of logo is "+logo.getSize().getHeight());
		System.out.println("Width of logo is "+logo.getSize().getWidth());
		
		//Scrolling to the follow us text
		performMoveToElementAction("//*[.='Follow Us']");
		Thread.sleep(2000);
		
		//Printing the Twitter target url under follow us. 
		String twitter = getAtrribute("//*[.='Follow Us']//parent::div//i[contains(@class,'twitter')]//parent::a", 
				"href");
		System.out.println("Twitter target URL is "+twitter);
		enterText("(//body)[1]", Keys.HOME);
		
		//Validating empty cart and message for the same
		String itemsInCart = getText("((//a[contains(@href,'cart')])[2]//span)[2]");
		itemsInCart = itemsInCart.split(" ")[0];
		if (itemsInCart=="0") {
			clickWebElement("(//a[contains(@href,'cart')])[1]");
			String text = getText("//table[contains(@class,'cart_table')]//td");
			Assert.assertEquals(text, "No Item is Added In Cart yet.Cart is Empty!!!");
		}
		
		//Navigating back to home page
		driver.navigate().back();
		Thread.sleep(5000);
		
		//Searching and adding book to the cart
		enterText("//input[@id='txtsearch']", "Java book");
		enterText("//input[@id='txtsearch']", Keys.ENTER);
		clickWebElement("//div[@id='book_list']//li[1]//a[contains(., 'Add to cart')]");
		Thread.sleep(5000);
		
		//Validating cart emtpy or not
		clickWebElement("(//a[contains(@href,'cart')])[1]");
		Thread.sleep(2000);
		Boolean isCartEmpty;
		try {
			isCartEmpty = driver.findElement
					(By.xpath("//*[contains(.,'No Item is Added In Cart yet.Cart is Empty!!!')]")).isDisplayed();
		} catch (NoSuchElementException e) {
			isCartEmpty = false;
		} catch (Exception e) {
			isCartEmpty = false;
		}		
		Assert.assertFalse(isCartEmpty);
	
	}
	
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		quitBrowser();
	}
}
