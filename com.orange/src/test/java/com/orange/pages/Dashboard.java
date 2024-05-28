package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard {
	
	private  static Dashboard DashboardInst;

	 private Dashboard()
	   {
		   
	   }
	 public static Dashboard getInstance()
	   {
		   if(DashboardInst == null)
		   {
			   DashboardInst = new Dashboard();
		   }
		   return DashboardInst;
	   }
	
	@FindBy(xpath="//ul/li[9]/a")
	private WebElement DIRECTORYLINK;
	
	@FindBy(xpath="//ul/li[4]/a")
	private WebElement TIMELINK;
	
	public void clickDirectoryLink()
	{
		DIRECTORYLINK.click();
	}
	public void clickTimeLink()
	{
		TIMELINK.click();
	}
	

  

}
