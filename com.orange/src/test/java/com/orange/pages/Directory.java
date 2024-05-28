package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Directory {
	
	
	private static Directory DirectoryInstance;
	private Directory()
	{
		
	}
	public static Directory getInstance()
	{
		if (DirectoryInstance == null) 
		{
			DirectoryInstance = new Directory();
		}
		return DirectoryInstance;
	}
	
	
	//@FindBy(xpath="//div[contains(text(),'Select')][1]")
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--active']")
	public static WebElement JOBSELECT;
	
	
	@FindBy(xpath="//div[contains(text(),'Chief Executive Officer')]")
	public static WebElement JOBTITLE;
	
	@FindBy(xpath="//button[@type='submit']")
	public static WebElement SUBMIT;
	
	
	@FindBy(xpath="//div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-directory-card']//p")
	public static WebElement ACTUALNAME;
	
	public void clickJobSelect()
	{
		JOBSELECT.click();
	}
	public void clickJobTitle()
	{
		JOBTITLE.click();
	}
	public void clickSubmit()
	{
		SUBMIT.click();
	
	}
	public String getActualName()
	{
		 return ACTUALNAME.getText();
	}
}
