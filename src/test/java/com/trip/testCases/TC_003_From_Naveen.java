package com.trip.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.trip.Utilities.Xls_Reader;
import com.trip.pageObject.Loginpage;

public class TC_003_From_Naveen {

	public static void main(String[] args) {
		
		
		
Xls_Reader reader = new Xls_Reader("C:/Users/owner/Desktop/Selenium/office_projectSetup/1DET_TRIP/src/test/java/com/trip/testData/testdata.xlsx");

String userid = reader.getCellData("sheet1", "userid", 2);
System.out.println(userid);

String password = reader.getCellData("sheet1", "password", 2);
System.out.println(password);


System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("http://demo.guru99.com/V1/index.php");


driver.findElement(By.name("uid")).sendKeys(userid);
driver.findElement(By.name("password")).sendKeys(password);
driver.findElement(By.name("btnLogin")).click();



driver.quit();
	}

}
