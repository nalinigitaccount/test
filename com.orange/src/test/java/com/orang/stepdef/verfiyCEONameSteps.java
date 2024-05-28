package com.orang.stepdef;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.orang.driverManger.driverManger;
import com.orange.constant.constants;
import com.orange.pages.Dashboard;
import com.orange.pages.Directory;
import com.orange.pages.loginPage;

import io.cucumber.java.en.*;
import utils.commonutils;

public class verfiyCEONameSteps {
	
	
	private static final Logger LOGGER = LogManager.getLogger(verfiyCEONameSteps.class);

	@Given("The user is logged in and is on Home Page")
	public void the_user_is_logged_in_and_is_on_home_page() {
		   try{
           driverManger.getDriver().get(constants.C_APP_URL);
           driverManger.getDriver().manage().window().maximize();
           driverManger.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
           loginPage.getInstance().enterusername(constants.C_USERNAME);
           loginPage.getInstance().enterpassword(constants.C_PASSWORD);
           loginPage.getInstance().clickLoginButton();
           
           String url = driverManger.getDriver().getCurrentUrl();
           if(url.contains("dashboard")){
        	   LOGGER.info("the user is logged in successfully and in home page");
        	   ExtentCucumberAdapter.addTestStepLog("Log added using add test step log");
           }
		   }
           catch(Exception e)
           {
        	   LOGGER.error(e);
   			//commonutils.getInstance().takeScreenShot();

           }
	}

	@When("User clicks on the Directory options from the menu bar")
	public void user_clicks_on_the_directory_options_from_the_menu_bar() {
		try {

		Dashboard.getInstance().clickDirectoryLink();}
		catch(Exception e)
        {
     	   LOGGER.error(e);
    	   ExtentCucumberAdapter.addTestStepLog("Log added using add test step log");
 
			//commonutils.getInstance().takeScreenShot();

        }
 	   //LOGGER.info("the user clicks on the Directory link");

	}


	@When("the user selects the job title as {string} from the drop down")
	public void the_user_selects_the_job_title_as_from_the_drop_down(String jobtitle) throws InterruptedException {
		try {
		Directory.getInstance().clickJobSelect();;
	 	LOGGER.info("the user clicks job title select box");
		
       List <WebElement> joboptions =  driverManger.getDriver().findElements(By.xpath("//div[@role='listbox']//span"));
       System.out.println("Job Options  " + joboptions.size());

       for (WebElement opt : joboptions)
       {
    	  if( opt.getText().equals(jobtitle)) {
    	   opt.click();
    	   break;}
       }
	 	//LOGGER.info("the user select " + jobtitle + " select box");
	 	Thread.sleep(1000);
		}
	 	catch(Exception e)
        {
     	   LOGGER.error(e);
			//commonutils.getInstance().takeScreenShot();

        }
		

	}

	@When("click on the search button")
	public void click_on_the_search_button() {
		try {
		Directory.getInstance().clickSubmit();
		}
		catch(Exception e)
        {
     	   LOGGER.error(e);
			//commonutils.getInstance().takeScreenShot();

        }
	 	//LOGGER.info("the user clicks on submit button");
	}

	@Then("user should see the CEO name as {string}")
	public void user_should_see_the_ceo_name_as(String Exceptedname) {
		try {

		String actualname = Directory.getInstance().getActualName();
		if(actualname.equalsIgnoreCase(Exceptedname)) {
		 	LOGGER.info("the user should see the CEO name as " + Exceptedname);

		}
		}
		catch(Exception e)
        {
     	   LOGGER.error(e);
			//commonutils.getInstance().takeScreenShot();

        }
	}




}
