package com.trip.testCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.trip.Utilities.Xls_Reader;
import com.trip.pageObject.Loginpage;

public class TC_002_LoginDD extends Baseclass{
	
	
	@Test
	public void loginDataDriven() throws InterruptedException
	{
		
		SoftAssert assert1 = new SoftAssert();
	Xls_Reader reader = new Xls_Reader("C:/Users/owner/Desktop/Selenium/office_projectSetup/1DET_TRIP/src/test/java/com/trip/testData/testdata.xlsx");
	
	
	int rowcount = reader.getRowCount("sheet1");
	
	for(int rownum=2;rownum<=rowcount;rownum++ )
	{
		
	String userid = reader.getCellData("sheet1", "userid", rownum);
	System.out.println(userid);

	String password = reader.getCellData("sheet1", "password", rownum);
	System.out.println(password);
	
	Loginpage lp1 = new Loginpage(driver);
	
	lp1.setUserName(userid);
	Thread.sleep(1000);
	lp1.setPassword(password);
	Thread.sleep(1000);
	lp1.clickSubmit();
	Thread.sleep(1000);
	Logger.info("it running");
	
	if(isAlertpresent()==true) {
	driver.switchTo().alert().accept();
	Logger.info("i m running");
	assert1.assertTrue(false);
	
	}
	
	else
	{
		Assert.assertTrue(true);
		
	}
	
	
	
	}
	
	
	
	
}
	
	public boolean alert()
	{
		driver.switchTo().alert();
		return true;
	}
	

}
