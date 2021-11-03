package testng_demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test {
	
	@BeforeMethod
	public void before() {
		System.out.println("before method");
	}
	
	@AfterMethod
	public void after() {
		System.out.println("after method");
	}
	@Test
	public void test() {
		System.out.println("test method:");
		System.out.println(System.getProperty("user.dir"));
	}
	

}
