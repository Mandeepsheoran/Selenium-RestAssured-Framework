/**
 * 
 */
package org.igt.demo.uitests;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.igt.demo.annotations.FrameworkAnnotations;
import org.igt.demo.drivers.DriverManager;
import org.igt.demo.enums.LogType;
import org.igt.demo.enums.PropertiesType;
import org.igt.demo.pompages.BasePage;
import org.igt.demo.pompages.NotificationPage;
import org.igt.demo.utils.DateFormatUtils;
import org.igt.demo.utils.PropertyUtils;
import static org.igt.demo.enums.LogType.INFO;
import static org.igt.demo.reports.FrameworkLogger.log;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Apr 4, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see
 */
public class NotificationUITest extends BaseTest{

	NotificationPage notificationpage = new NotificationPage();

	 @BeforeMethod
	public static void beforeTest(ITestResult result) {
		log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["+ DateFormatUtils.currentASIADateTimeFormat() +"]");
	}

	@Test(description="Access Alert Screen", priority=1)
	@FrameworkAnnotations(author="Mandeep", category="SMOKE", methodType="Notification")
	public void loginPageAccess() throws InterruptedException {
		notificationpage.openNotificationPage();
		assertThat(notificationpage.checkNotificationPageVisibility())
		.as("Alert button should be visible on screen.")
		.isEqualTo(true);
	}

	@Test(description="Get Notification Page Title", priority=2)
	@FrameworkAnnotations(author="Mandeep", category="REGRESSION", methodType="Notification")
	public void getPageTitle() {
		String pagetitle = (notificationpage.getAppPageTitle());
		log(INFO, "Notification page title is : " + pagetitle);
		assertThat(pagetitle)
		.isNotNull()
		.as("Checking Actual content")
		.isEqualTo("Digital Twin Admin")
		.hasSize(18)
		.endsWith("n")
		.startsWith("D");
	}
}
