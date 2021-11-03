package cpsat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class CommonUtility {
	
	WebDriver driver;
	
	public WebDriver init(String browser, String url) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("incognito");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public void clickWebElement(String xpath) throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		Thread.sleep(500);
	}
	
	public void takeScreenshot(String fileName) throws IOException {
		TakesScreenshot sc = ((TakesScreenshot) driver);
		File scrFile = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshot\\"+fileName+".jpg"));
	}
	
	public void enterText(String xpath, String textToEnter) throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		element.sendKeys(textToEnter);
		Thread.sleep(500);
	}
	
	public void enterText(String xpath, Keys keys) throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		element.sendKeys(keys);
		Thread.sleep(500);
	}
	
	public String getText(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return element.getText().trim();
	}
	
	public String getAtrribute(String xpath, String attribute) {
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		return element.getAttribute(attribute).trim();
	}
	
	public void quitBrowser() throws IOException {
		driver.quit();
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
	}
	
	public String getExcelData(String sheetName, int rowIndex, int colIndex) throws IOException {		
		File location = new File(System.getProperty("user.dir")+"\\excel.xlsx");
		FileInputStream fis = new FileInputStream(location);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		String cellData = sheet.getRow(rowIndex).getCell(colIndex).toString();
		wb.close();
		return cellData;
	}
	
	public int getExcelRowCount(String sheetName) throws IOException {		
		File location = new File(System.getProperty("user.dir")+"\\excel.xlsx");
		FileInputStream fis = new FileInputStream(location);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	public void setExcelData(String sheetName, int rowIndex, int colIndex, String cellData) throws IOException {
		File location = new File(System.getProperty("user.dir")+"\\excel.xlsx");
		FileInputStream fis = new FileInputStream(location);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		if(sheet.getRow(rowIndex)==null) {
			sheet.createRow(rowIndex).createCell(colIndex).setCellValue(cellData);
		} else {
			sheet.getRow(rowIndex).createCell(colIndex).setCellValue(cellData);
		}
		 FileOutputStream fos = new FileOutputStream(location);
		 wb.write(fos);
		 wb.close();
	}
	
	public void performMoveToElementAction(String xpath) throws Exception {
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(xpath));
		action.moveToElement(ele).build().perform();
		Thread.sleep(500);
	}
	
	public void selectValueFromDropDown(String xpath, String value, String typeToSearch) throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath(xpath));
		Select select = new Select(ele);
		if (typeToSearch == "value") {
			select.selectByValue(value);
		} else if (typeToSearch == "text") {
			select.selectByVisibleText(value);
		}
		Thread.sleep(2000);
	}
	
	public void clearTextBox(String xpath) throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		element.clear();
		Thread.sleep(500);
	}
}
