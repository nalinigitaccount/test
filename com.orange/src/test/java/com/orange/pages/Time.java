package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Time {
	
	
	public  static Time timeInstance;
	private Time()
	{
		
	}
	public static Time getInstance()
	{
		if(timeInstance == null)
		{
			timeInstance = new Time();
		}
		return timeInstance;
	}
	
	
	@FindBy(xpath="//input[@placeholder='Type for hints....']")
	private WebElement ENTEREMPNAME;
	
	@FindBy(xpath= "//button[@type='submit1']")
	private WebElement CLICKVIEW;
	
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	private WebElement MESSAGE;
	
	public void setEnterEmpName(String empname)
	{
		ENTEREMPNAME.sendKeys(empname);
	}
	public void clickView()
	{
		CLICKVIEW.click();
	}
	
	public String getMessage()
	{
		return MESSAGE.getText();
	}

}
