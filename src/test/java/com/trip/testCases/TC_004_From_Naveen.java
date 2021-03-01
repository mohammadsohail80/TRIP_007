package com.trip.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.trip.Utilities.Xls_Reader;

public class TC_004_From_Naveen {

	public static void main(String[] args) throws InterruptedException {
	
	
		
Xls_Reader reader = new Xls_Reader("C:/Users/owner/Desktop/Selenium/office_projectSetup/1DET_TRIP/src/test/java/com/trip/testData/testdata.xlsx");


int rowcount = reader.getRowCount("sheet1");



	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://demo.guru99.com/V1/index.php");



	
	
for(int rownum=2;rownum<=rowcount;rownum++ )
{
	
	
	
	String userid = reader.getCellData("sheet1", "userid", rownum);
	System.out.println(userid);
	
	String password = reader.getCellData("sheet1", "password", rownum);
	System.out.println(password);
	
	driver.findElement(By.name("uid")).clear();
driver.findElement(By.name("uid")).sendKeys(userid);


driver.findElement(By.name("password")).clear();
driver.findElement(By.name("password")).sendKeys(password);

driver.findElement(By.name("btnLogin")).click();







}


	}}

/*





driver.findElement(By.name("btnLogin")).click();

*/



	

//}
