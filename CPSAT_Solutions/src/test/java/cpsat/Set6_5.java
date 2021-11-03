package cpsat;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Set6_5 extends CommonUtility {
	
	@Before
	public void setUp() {
		//Initializing browser and navigating to URL
		init("Chrome", "http://mu.ac.in/portal ");
	}
	
	@Test
	public void testMethod1() throws Exception {
		
		
	}
	
	@After
	public void tearDown() throws IOException {
		quitBrowser();
	}

}
