package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		features = "src/test/resources",
		glue="com.orang.stepdef",
		dryRun = false,
	    monochrome = true)

public class testRunner {
	
}
