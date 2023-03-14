package org.igt.demo.pompages;

import static org.igt.demo.enums.LogType.CONSOLEANDEXTENTINFO;
import static org.igt.demo.reports.FrameworkLogger.log;
import java.awt.Color;
import java.util.List;
import java.util.function.Predicate;
import org.igt.demo.drivers.DriverManager;
import org.igt.demo.enums.PropertiesType;
import org.igt.demo.enums.WaitMethods;
import org.igt.demo.factories.ExplicitWaitFactory;
import org.igt.demo.utils.PropertyUtils;
import groovyjarjarantlr4.v4.parse.ANTLRParser.element_return;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class NotificationPage extends BasePage {
	private final By alertmenu = By.xpath("(//span[contains(text(),'Alerts')])[1]");
	private final By timestampfilter = By.xpath("(//button[@aria-label='Open Filter Menu'])[2]");
	private final By timestampValmsg = By.xpath("//*[text()='To Date can't before From date']");
	private final By timestampdateselctn = By.xpath(
			"//owl-date-time-timer[@class='owl-dt-container-row ng-tns-c169-0 owl-dt-timer ng-star-inserted']//button[@aria-label='Minus a hour']//span[@class='owl-dt-control-button-content']//*[name()='svg']");
	private final By timestampapply = By.xpath("//button[normalize-space()='Apply']");
	private final By infrafilter = By.xpath("(//button[@aria-label='Open Filter Menu'])[4]");
		private final By statusfilter = By.xpath("(//button[@aria-label='Open Filter Menu'])[7]");
	private final By infavaluefirstrow = By
			.cssSelector("div[name='center'] div[role='rowgroup'] div:nth-child(1) div:nth-child(4)");
		private final By logentry = By.xpath(
			"/html[1]/body[1]/app-root[1]/app-dashboard[1]/app-notifications[1]/div[1]/div[1]/app-table[1]/div[1]/ag-grid-angular[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[5]/div[8]/app-actions-renderer[1]/div[1]/app-icon[1]/mat-icon[1]/*[name()='svg'][1]");
	private final By screenclick = By.xpath(
			"/html[1]/body[1]/app-root[1]/app-dashboard[1]/app-notifications[1]/div[1]/div[1]/app-table[1]/div[1]/ag-grid-angular[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[2]/input[1]");
	
	
	public NotificationPage openNotificationPage() throws InterruptedException {
		click(alertmenu, WaitMethods.CLICKABLE, "Alert Menu button");
		return this;
	}

	public Boolean checkNotificationPageVisibility() throws InterruptedException {
		return isElementExists(statusfilter, "Notification screen ");
	}

	public NotificationPage filterByTimestamp() {
		click(timestampfilter, WaitMethods.CLICKABLE, "TimeStamp Filter");
		return this;
	}

	public NotificationPage timeStampFilterSelection() throws InterruptedException {
		click(timestampdateselctn, WaitMethods.CLICKABLE, "Date and time selection");
		click(timestampdateselctn, WaitMethods.CLICKABLE, "Date and time selection");
		click(timestampapply, WaitMethods.CLICKABLE, "Apply date time");
		click(screenclick, WaitMethods.CLICKABLE, "Screen click to remove Timestamp dialog");
		return this;
	}

	public NotificationPage filterByInfra(final String inputtext) {
		sendkeys(infrafilter, inputtext, WaitMethods.PRESENCE, "Infrastructure Filter");
		return this;
	}

	public String getInfraName() {
		return getText(infavaluefirstrow, WaitMethods.VISIBLE, "Infra name text");
	}

	public Boolean isSeverityRecordAvailable(String severity) {
		List<WebElement> element = DriverManager.getDriver().findElements(By.xpath("//div[@class='options-list']"));
		element.forEach(s -> System.out.println(s.getText()));
		if (element.get(0).getText().contains(severity)) {
			log(CONSOLEANDEXTENTINFO, "Severity " + severity + " record exists");
			return true;
		} else {
			log(CONSOLEANDEXTENTINFO, "No record with " + severity + " severity.");
			return false;
		}
	}

	public Predicate<String> pd_isInfraValueAvailable = infra -> {
		List<WebElement> el = DriverManager.getDriver().findElements(By.xpath("//div[@aria-label='Column Menu']"));
		el.forEach(s -> System.out.println(s.getText()));
		if (el.get(0).getText().contains(infra)) {
			log(CONSOLEANDEXTENTINFO, "Infrastructure with " + infra + " value exists.");
			return true;
		} else {
			log(CONSOLEANDEXTENTINFO, "No record with " + infra + " infra.");
			return false;
		}
	};

	public NotificationPage logEntryButtonEnableCheck() {
		isElementEnabled(logentry, "Log Entry button");
		return this;
	}

	public Boolean newTabCheck() {
		return isNewTabOpened();
	}

	public String getTimeStampRangeMsg() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollBy(0,-250)", "");
		return getText(timestampValmsg, WaitMethods.PRESENCE,
				"Looking for invalid date range message on timestamp filter");
	}

	public String getAppPageTitle() {
		return getPageTitle();
	}
}