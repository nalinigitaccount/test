package com.orang.stepdef;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.commonutils;
import com.orange.constant.constants;
import com.orang.driverManger.driverManger;


public class commonMethods {
	
	
	private  static String scenarioName = null;
	private static final Logger LOGGER = LogManager.getLogger(commonMethods.class);
	//public static final Logger LOGGER = LoggerFactory.getLogger(commonMethods.class);
	
	public static String getScenarioName() {
		return scenarioName;
	}
	
	@Before
	public void beforeScenario(Scenario scenario)
	
	{	
		LOGGER.info("Execution started");
		try
		{
			scenarioName = scenario.getName();

			commonutils.getInstance().loadProperties();
			LOGGER.info("Loaded the properties file");


			if (driverManger.getDriver() == null) {
				LOGGER.info("Driver is NUll, Instantiating the browser");

				driverManger.lauchBrowser();
				LOGGER.info("Loaded the properties file");

			
				commonutils.getInstance().initWebElements();
				LOGGER.info("Instantiating the common utits");

			}
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			//commonutils.getInstance().takeScreenShot();
			
		}
	}
	
	@AfterStep
	public void attachScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
		System.out.println("scenario failed");
		byte[] screenshotTaken = ((TakesScreenshot) driverManger.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotTaken,"image/png", "errorscreen");
		System.out.println("scenario failed");

		}
	}
//	@After
//	public void afterScenario()
//	{
//		LOGGER.info("Logout Successfully");
//		driverManger.getDriver().close();}
//	



	

}
