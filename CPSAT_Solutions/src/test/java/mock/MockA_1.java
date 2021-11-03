package mock;

import org.junit.Before;

public class MockA_1 extends CommonUtility{
	
	@Before
	public void setUp() {
		initializeDriver("chrome", "https://exammay2020.agiletestingalliance.org/");
	}
	

}
