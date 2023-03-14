package org.igt.demo.uitests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.igt.demo.drivers.Driver;
/**
 * Set of methods to initialize & close the report and drivers.
 * Apr 3, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
public class BaseTest {
	
	protected BaseTest() {		
	}
	
	/**
	 * Method to setup the driver initialization with specific browser requirement before executing any method.
	 * Apr 3, 2022
	 * @author Mandeep Sheoran
	 * @version 1.0
	 * @since 1.0
	 */
	@BeforeClass
	protected void setUp() {  
		Driver.initdriver("chrome","99");
		
	}
	
	/**
	 * Method to tear down the driver initialization after executing all the methods.
	 * Apr 3, 2022
	 * @author Mandeep Sheoran
	 * @version 1.0
	 * @since 1.0
	 */
	@AfterClass
	protected void tearDown() {
		Driver.quitdriver();
	}

}
