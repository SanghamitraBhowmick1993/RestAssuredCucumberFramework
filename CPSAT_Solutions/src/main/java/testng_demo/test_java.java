package testng_demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test_java extends Common {
	

	public static void main(String[] args) throws IOException {
		POM obj = new POM(Common.getName());
		obj.display();
		System.out.println("main class name "+Common.getName());

		
//	String s1 = "rgb(188, 62, 49)";
//	String s2 = s1.replace("rgb(", "");
//	String s3 = s2.replace(")", "");
//	System.out.println(s3);
		
		
//		System.out.println(System.getProperty("user.dir"));
//		
//		File location = new File(System.getProperty("user.dir")+"\\excel.xlsx");
//		FileInputStream fis = new FileInputStream(location);
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sheet = wb.getSheet("credentials");
//		int firstRowCount = sheet.getFirstRowNum();
//		System.out.println("First Row count: "+firstRowCount);
//		int lastRowCount = sheet.getLastRowNum();
//		System.out.println("Last Row count: "+lastRowCount);
//		int firstColumn = sheet.getRow(0).getFirstCellNum();
//		int lastColumn = sheet.getRow(0).getLastCellNum();
//		System.out.println("First Col count: "+firstColumn);
//		System.out.println("Last Col count: "+lastColumn);
//		for(int i=0; i<lastRowCount; i++) {
//			Row row = sheet.getRow(i+1);
//			int cellCout = row.getLastCellNum();
//			for (int j=0; j<cellCout; j++) {
//				Cell cell = row.getCell(j);
//				System.out.println("Row-"+(i+1)+"Cell-"+j+"Value-"+cell.toString());
//			}
//		}
		
		
//		Iterator<Row> rowIterator = sheet.iterator();
//		while(rowIterator.hasNext()) {
//			Row row = rowIterator.next();
//			Iterator<Cell> colIterator = row.iterator();
//			while(colIterator.hasNext()) {
//				Cell cell = colIterator.next();
//				System.out.println(cell.getStringCellValue());
//				
//			}
//			
//		}

	}

}
