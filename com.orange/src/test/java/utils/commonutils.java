package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.support.PageFactory;

import com.orang.driverManger.driverManger;
import com.orang.stepdef.commonMethods;
import com.orang.stepdef.verfiyCEONameSteps;
import com.orange.constant.constants;
import com.orange.pages.Dashboard;
import com.orange.pages.Directory;
import com.orange.pages.Time;
import com.orange.pages.loginPage;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class commonutils {
	
	
	private static commonutils commonInstance = null;
	//private static final Logger LOGGER = LogManager.getLogger(commonutils.class);

	private commonutils()
	{
		
	}
	public static commonutils getInstance()
	{
		if (commonInstance == null) {
		commonInstance = new commonutils();}
		
    return commonInstance;
	}
	
	public  void loadProperties() 
	{				
		Properties properties = new Properties();
			try {
				//properties.load(getClass().getResourceAsStream("./src/test/resources/utilsres/config.properties"));
				properties.load(getClass().getResourceAsStream("/utilsres/config.properties"));
			}
			catch( Exception e)
			{
				e.printStackTrace();
			}
		 constants.C_APP_URL= properties.getProperty("APP_URL");
		 constants.C_BROWSER =properties.getProperty("BROWSER");
		 constants.C_USERNAME=properties.getProperty("USERNAME");
		 constants.C_PASSWORD =properties.getProperty("PASSWORD");
		 System.out.println(constants.C_BROWSER);
				 
	}
	
	
	public void initWebElements()
	{
		PageFactory.initElements(driverManger.getDriver(), loginPage.getInstance());
		PageFactory.initElements(driverManger.getDriver(), Directory.getInstance());
		PageFactory.initElements(driverManger.getDriver(), Dashboard.getInstance());
		PageFactory.initElements(driverManger.getDriver(), Time.getInstance());


	}
	
	/*public void takeScreenShot()
	{
		System.out.println("take screen shot");
		File screenshot = ((TakesScreenshot) driverManger.getDriver()).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(screenshot,new File(commonMethods.getScenarioName() + ".png"));

		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		} 

	}*/
//	@AfterStep
//		public void attachScreenshot(Scenario scenario)
//		{
//			if(scenario.isFailed())
//			{
//			System.out.println("scenario failed");
//			byte[] screenshotTaken = ((TakesScreenshot) driverManger.getDriver()).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshotTaken,"image/png", "errorscreen");
//			System.out.println("scenario failed");
//	
//			}
//		}
}	
//	 FileReader reader = null;
//	 Properties properties;
//	 try {
//		 reader = new FileReader("config.properties");
//		 
//	 }
//	 catch(FileNotFoundException e)
//	 {
//		 e.printStackTrace();
//	 }
//	 properties = new Properties();
//	 try {
//	 properties.load(reader);}
//	 catch(IOException e)
//	 {
//		  e.printStackTrace(); 
//	 }


