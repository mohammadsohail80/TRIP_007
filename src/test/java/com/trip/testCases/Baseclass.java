package com.trip.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.trip.Utilities.ReadConfig;



public class Baseclass {
	
	ReadConfig readconfig = new ReadConfig();
	public String baseurl=readconfig.getApplicationURL();
	public String uname=readconfig.getUsername();
	public String pword= readconfig.getPassword();
	public static WebDriver driver;
	public static Logger Logger;
	
	
	
	@Parameters("browser")
	
	@BeforeClass
	public void setUp(String br)
	{
		
	//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");	
		
        Logger = Logger.getLogger("test");
        PropertyConfigurator.configure("log4j.properties");
        
        if(br.equals("chrome"))
        {
        System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver = new ChromeDriver();
        }
        else if(br.equals("ie"))
        {
        	System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
    		driver = new InternetExplorerDriver();
        }
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get(baseurl);
        
       // driver.manage().window().maximize();
        
	}
	
	
@AfterClass
public void tearDown()
{
	driver.quit();
}



public void captureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}

public boolean isAlertpresent()
{
	try
	{
	driver.switchTo().alert();
	return true;
	}
	catch(NoAlertPresentException e)
	{
		return false;
	}
}


}
