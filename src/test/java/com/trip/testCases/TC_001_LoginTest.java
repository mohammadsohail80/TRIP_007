package com.trip.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.trip.pageObject.Loginpage;

import junit.framework.Assert;

public class TC_001_LoginTest extends Baseclass{
	
	
	
	@Test
	public void loginTest() throws IOException
	{
		
		Logger.info("url open");
		Loginpage lp = new Loginpage(driver);
		
		
		
		lp.setUserName(uname);
		Logger.info("user name provided");
		lp.setPassword(pword);
		lp.clickSubmit();
		Logger.info("submit button clicked");
	if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		captureScreen(driver, "loginTest");
		Assert.assertTrue(false);
	}
		
	}
	
	
	
	
	

}
