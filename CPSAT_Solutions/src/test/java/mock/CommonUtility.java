package mock;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {
	
	public static WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void initializeDriver(String browser, String url) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);		
			
		} else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//iedriver.exe");
			driver = new InternetExplorerDriver();	
			
		} else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
		
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	public String getExcelData(String sheetName, int rowIndex, int ColumnIndex) throws Exception {
		File location = new File(System.getProperty("user.dir")+"//excel.xlsx") ;
		FileInputStream fis = new FileInputStream(location);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		String cellValue = sheet.getRow(rowIndex).getCell(ColumnIndex).toString();	
		wb.close();
		return cellValue;
	}
	
	public int getExcelRowCount(String sheetName) throws Exception {
		File location = new File(System.getProperty("user.dir")+"//excel.xlsx") ;
		FileInputStream fis = new FileInputStream(location);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();	
		wb.close();
		return rowCount;
	}
	
	public void takesScreenshot(String fileName) throws IOException {
		TakesScreenshot sc = (TakesScreenshot)driver;
		File srcFile = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(("user.dir")+"//screenshot//"+fileName+".png"));
	}
	
	public void performMoveToElementAction(String xpath) {
		WebElement ele = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));	
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}

}
