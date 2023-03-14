package org.igt.demo.apitests;



import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.igt.demo.enums.LogType.CONSOLEANDEXTENTINFO;
import org.assertj.core.api.Assertions;
import org.igt.demo.annotations.FrameworkAnnotations;
import org.igt.demo.constants.FrameworkConstants;
import org.igt.demo.enums.LogType;
import org.igt.demo.reports.ExtentLogger;
import org.igt.demo.requestbuilder.RequestBuilder;
import org.igt.demo.utils.ApiUtils;
import org.igt.demo.utils.DateFormatUtils;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.igt.demo.reports.FrameworkLogger.log;

public class DeleteTest {

	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.currentASIADateTimeFormat() + "]");
	}

	@Test(description = "Delete User Details")
	@FrameworkAnnotations(author = "Aravind", category = "SMOKE", methodType = "DELETE")
	public void deleteUserDetails() {
		String request = ApiUtils.readFromExternalFile(FrameworkConstants.requestjsonfolderpath + "createUser.json");
		RequestSpecification reqspecification = RequestBuilder.buildRequestForPostCalls().body(request);
		ExtentLogger.logRequest(reqspecification);
		Response response = reqspecification.delete("/api/users/2");
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		System.out.println(response.asPrettyString());
		log(CONSOLEANDEXTENTINFO, "API response is : " + response.getStatusCode());
		Assertions.assertThat(response.getStatusCode()).isEqualTo(204);
	}
	
	@Test(description = "User date deletion with invalid status check")
	@FrameworkAnnotations(author = "Satya", category = "SMOKE", methodType = "DELETE")
	public void deleteAndCheckStatus()  {
		String request = ApiUtils.readFromExternalFile(FrameworkConstants.requestjsonfolderpath + "createUser.json");
		RequestSpecification reqspecification = RequestBuilder.buildRequestForPostCalls().body(request);
		ExtentLogger.logRequest(reqspecification);
		Response response = reqspecification.delete("/api/users/2");
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		System.out.println(response.asPrettyString());
		log(CONSOLEANDEXTENTINFO, "API response is : " + response.getStatusCode());
		Assertions.assertThat(response.getStatusCode()).isEqualTo(204);
	}
	
	@Test(description = "Status check for user delete operation")
	@FrameworkAnnotations(author = "Mandeep", category = "REGRESSION", methodType = "DELETE")
	public void deleteNullStatusCheck() throws IOException {
		String request = ApiUtils.readFromExternalFile(FrameworkConstants.requestjsonfolderpath + "createUser.json");
		RequestSpecification reqspecification = RequestBuilder.buildRequestForPostCalls().body(request);
		ExtentLogger.logRequest(reqspecification);
		Response response = reqspecification.delete("/api/users/2");
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		System.out.println(response.asPrettyString());
		log(CONSOLEANDEXTENTINFO, "API response is : " + response.getStatusCode());
		Assertions.assertThat(response.getStatusCode())
		.isNotNull();
	}

}
