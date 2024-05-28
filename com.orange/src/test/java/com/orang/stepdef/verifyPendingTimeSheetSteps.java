package com.orang.stepdef;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.orang.driverManger.driverManger;
import com.orange.constant.constants;
import com.orange.pages.Dashboard;
import com.orange.pages.Time;
import com.orange.pages.loginPage;

import io.cucumber.java.en.*;
import utils.commonutils;

public class verifyPendingTimeSheetSteps {
	
	private static final Logger LOGGER = LogManager.getLogger(verifyPendingTimeSheetSteps.class);

	@Given("The user is on the homepage")
	public void the_user_is_on_the_homepage() {
		
	
//		driverManger.getDriver().get(constants.C_APP_URL);
//        driverManger.getDriver().manage().window().maximize();
//        driverManger.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//        loginPage.USERNAME.sendKeys(constants.C_USERNAME);
//        loginPage.PASSWORD.sendKeys(constants.C_PASSWORD);
//        loginPage.LOGIN_BUTTON.click();
//        
//        String url = driverManger.getDriver().getCurrentUrl();
//        if(url.contains("dashboard")){
     	   LOGGER.info("the user is logged in successfully and in home page");

	}

	@Given("the user clicks on the time option from the menu")
	public void the_user_clicks_on_the_time_option_from_the_menu() {
		try {
	     Dashboard.getInstance().clickTimeLink();}
	   catch(Exception e)
		{
   	   LOGGER.error(e);
		//commonutils.getInstance().takeScreenShot();
		Assert.fail(e.getMessage());

		}



	}

	@Given("the user enter the name as {string}")
	public void the_user_enter_the_name_as(String employeename) throws InterruptedException {
    try {
		    Time.getInstance().setEnterEmpName(employeename);
           //Time.ENTEREMPNAME.sendKeys(employeename);
           //Thread.sleep(1000);
           
           
           List <WebElement> joboptions =  driverManger.getDriver().findElements(By.xpath("//div[@role='listbox']//span"));
           System.out.println("Job Options  " + joboptions.size());

           for (WebElement opt : joboptions)
           {
        	  if( opt.getText().equals(employeename)) {
        	   opt.click();
        	   break;}
           }
    	 	LOGGER.info("the user select " + employeename + " select box");
    	 	Thread.sleep(1000);

     	   LOGGER.info("the user enters the employeename");
    }
	
    catch(Exception e)
	{
	   LOGGER.error(e);
	  // commonutils.getInstance().takeScreenShot();
		Assert.fail(e.getMessage());
	}
    }

	@Given("clicks on the view button")
	public void clicks_on_the_view_button() throws InterruptedException {
		try {
        Thread.sleep(1000);
        Time.getInstance().clickView();
		//Time.CLICKVIEW.click();
        
  	   LOGGER.info("the user click on the view button");

	}
		catch(Exception e)
		{
   	   LOGGER.error(e);
		//commonutils.getInstance().takeScreenShot();
		Assert.fail(e.getMessage());

		}
	}
	@Then("the user should see the message as  {string}")
	public void the_user_should_see_the_message_as(String exceptedmessage) throws InterruptedException {
		try {
        Thread.sleep(1000);

         String actualmessage = Time.getInstance().getMessage();
         
         if(actualmessage.equalsIgnoreCase(exceptedmessage))
        		 {
        	   LOGGER.info("the user shoudl see the message" + exceptedmessage);

        		 }
  
		
	}
		
		catch(Exception e)
		{
   	   LOGGER.error(e);
		//commonutils.getInstance().takeScreenShot();
		Assert.fail(e.getMessage());

		}



}
}
