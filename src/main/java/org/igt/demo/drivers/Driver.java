package org.igt.demo.drivers;

import java.net.MalformedURLException;
import java.util.Objects;
import org.igt.demo.enums.PropertiesType;
import org.igt.demo.exceptions.BrowserInvocationException;
import org.igt.demo.factories.DriverFactory;
import org.igt.demo.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Class to start and close browser instances and get specific environment URL
 * Mar 31, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 */
public class Driver {

	private Driver() {}
	/**
	 * Method to initiate the browser driver
	 * @param browser will be picked from configuration file
	 */
	public static void initdriver(String browser, String browserversion) {
		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser,browserversion));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationException("Please check the browser capabilities. Driver initialization is having problem");
			}
			DriverManager.getDriver().get(PropertyUtils.getValue(String.valueOf(PropertiesType.URL)));		
		}	}

	/**
	 * Method to close the driver after execution completion
	 */
	public static void quitdriver() {
		WebDriverManager.chromedriver().quit();
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
