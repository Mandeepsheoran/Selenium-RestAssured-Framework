package org.igt.demo.runner;

import java.io.IOException;
import org.testng.annotations.AfterSuite;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	
	@CucumberOptions(features = {"src/test/resources/Feature"}, glue = { "org.igt.demo.stepDefinitions"},
monochrome = true, dryRun =false,
plugin = { "pretty",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }

)
public class APIRunner extends AbstractTestNGCucumberTests   {

@AfterSuite()
public void last() throws IOException {
	
	 //TestSetup.d.quit();
	//tags=("@login or @task or @subtask or @action or @subaction or @mapping or @posAndpcc or @stq or @report or @agentSkills or @languageSkills or @dashboard or @brand")

	 
	 
}
}
