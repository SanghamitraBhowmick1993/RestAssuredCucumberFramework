package cpsat;

import org.openqa.selenium.By;

public class Set1B_3_POM {
	
	public By getBSE(){
		return By.xpath("//span[@id='bseindex']");
	}
	
	public By getNSE(){
		return By.xpath("//span[@id='nseindex']");
	}
	
	public By getSearchField(){
		return By.xpath("//input[@id='query']");
	}
	
	public By getFrame(){
		return By.xpath("//iframe[@id='moneyiframe']");
	}
}
