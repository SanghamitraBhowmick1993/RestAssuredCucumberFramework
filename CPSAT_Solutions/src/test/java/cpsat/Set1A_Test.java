package cpsat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

public class Set1A_Test extends CommonUtility {

	@BeforeMethod
	public void method1(){
		init("Chrome","https://www.rediff.com/");
	}
	//click on news
	 public void Test1() throws Exception{
		 clickWebElement("//a[text()='NEWS']");
		 Thread.sleep(10000);
		 //take screenshot
		 takeScreenshot("Set1A_1_Testing");
		 //get href
		 List<WebElement> allHeadlines = driver.findElements(By.xpath("//div[@class='subnavbar news']//a"));
		 for(WebElement hrefHeadline : allHeadlines){
			 System.out.println("All subheadings" + hrefHeadline);
		 }
		 //tooltip assertion
	 }
}
