package org.igt.demo.factories;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.igt.demo.enums.PropertiesType;
import org.igt.demo.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * Class to check config values of required browser and runmode for execution.
 * Mar 31, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see PropertyUtils
 * @see WebDriverManager
 */
public final class DriverFactory {

	private DriverFactory() {}
	public static WebDriver getDriver(String browser,String browserversion) throws MalformedURLException {
		String runmode = PropertyUtils.getValue(String.valueOf(PropertiesType.RUNMODE));
		WebDriver driver= null;

		if(browser.equalsIgnoreCase("chrome")) {
			if(runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				cap.setVersion(browserversion);
				driver = new RemoteWebDriver(new URL(PropertyUtils.getValue(String.valueOf(PropertiesType.SELENIUMGRIDURL))), cap);
			} else {
				ChromeOptions options = new ChromeOptions();
				options.setAcceptInsecureCerts(true);
		//		options.addArguments("--headless");
				options.addArguments("--disable-extensions");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--ignore-certificate-errors");
				options.addArguments("--ignore-ssl-errors=yes");
				options.addArguments("--disable-web-security");
				options.addArguments("--allow-running-insecure-content");
				options.addArguments("--start-maximized");
				options.addArguments("--window-size=1920,1080"); 
				WebDriverManager wdm =	WebDriverManager.chromedriver().browserInDocker().enableVnc().enableRecording();
				wdm.capabilities(options);
				driver = wdm.create();
			}
		} else if(browser.equalsIgnoreCase("firefox")) {			
			if(runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				driver = new RemoteWebDriver(new URL(PropertyUtils.getValue(String.valueOf(PropertiesType.SELENIUMGRIDURL))), cap);
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();	
			}              
		} else if(browser.equalsIgnoreCase("ie")) {
			if(runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.IE);					
				driver = new RemoteWebDriver(new URL(PropertyUtils.getValue(String.valueOf(PropertiesType.SELENIUMGRIDURL))), cap);
			} else {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver(); 		
			}             
		}
		return driver;
	}
}
