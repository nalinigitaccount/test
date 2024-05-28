package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
	
	private static loginPage loginInstance;
	private loginPage()
	{
		
	}
	public static loginPage getInstance()
	{
		if( loginInstance == null)
		{
			loginInstance = new loginPage();
		}
		return loginInstance;
			
	}
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement USERNAME;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement PASSWORD;
	
	@FindBy(xpath="//button[@type='submit']")
	private static WebElement LOGIN_BUTTON;
	
	public void enterusername(String username)
	{
		USERNAME.sendKeys(username);
	}
	public void enterpassword(String pass)
	{
		PASSWORD.sendKeys(pass);
	}
	public void clickLoginButton()
	{
		LOGIN_BUTTON.click();
	}

	
	

}
