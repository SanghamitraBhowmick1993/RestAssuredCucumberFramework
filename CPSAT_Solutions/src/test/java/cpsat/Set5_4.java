package cpsat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class Set5_4 extends CommonUtility {
	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		driver = init("Chrome", "http://www.allmovie.com/");
	}
	@Test
	public void testMethod1() throws Exception {
		
	SoftAssert soft = new SoftAssert();	
	
	//Search movie
	enterText("//input[@type='search']", "The Godfather");
	enterText("//input[@type='search']", Keys.ENTER);
	Thread.sleep(2000);
	
	//Search results
	String searchResult = getText("//div[@class='results']//h1").split(" ")[0];
	System.out.println("Search results- "+ searchResult);
	
	List<WebElement> totalSearches = driver.findElements(By.xpath("//ul[@class='search-results']//li"));
	int count=1;
	for (; count<=totalSearches.size(); count++) {
		String text = getText("(//ul[@class='search-results']//li)["+count+"]//div[@class='title']");
		if(text.contains("1972")) {
			break;
		}
	}
	
	clickWebElement("(//ul[@class='search-results']//li)["+count+"]//div[@class='title']");
	
	//Genre
	String genre = getText("//span[@class='header-movie-genres']//a");
	System.out.println("Movie genre is- "+genre);
	soft.assertEquals(genre, "Crime");
	
	//MPAA rating
	String rating = getText("//span[contains(.,'MPAA')]//span");
	System.out.println("Movie rating is- "+rating);
	soft.assertEquals(rating, "A");
	
	clickWebElement("//a[contains(.,'Cast & Crew')]");
	Thread.sleep(2000);
	
	//Verify movie’s director’s name 
	String director = getText("(//div[@class='director_container']//a)[2]");
	System.out.println("Director name is- "+director);
	soft.assertEquals(director, "Francis Ford Coppola");
	
	//Verify Al Pacino’s character’s name
	String character = getText("(//a[text()='Al Pacino'])[1]//ancestor::div[@class='cast_container']//div[@class='cast_role']");
	System.out.println("Al Pacino’s character name is- "+character);
	soft.assertEquals(character, "Michael Corleone");
	soft.assertAll();
						
	}

	@After
	public void tearDown() throws Exception {
		quitBrowser();
	}

}
