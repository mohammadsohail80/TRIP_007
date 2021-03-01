package com.trip.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage{
	
WebDriver ldriver;

//User ID :	mngr308774
//Password :	upepunu



public Loginpage(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(name="uid")
WebElement userID;

@FindBy(name="password")
WebElement password;

@FindBy(name="btnLogin")
WebElement LOGIN;


@FindBy(name="btnReset")
WebElement RESET;

@FindBy(xpath="/html/body/div[3]/div/ul/li[10]/a")
@CacheLookup
WebElement lnkLogout;

public void setUserName(String uname)
{
	userID.sendKeys(uname);
}


public void setPassword(String pword)
{
	password.sendKeys(pword);
}

public void clickSubmit()
{
	LOGIN.click();
}

public void clickLogout()
{
	lnkLogout.click();
}

}
