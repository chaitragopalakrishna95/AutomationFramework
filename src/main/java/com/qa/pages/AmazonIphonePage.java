package com.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.testbase.TestBase;

public class AmazonIphonePage extends TestBase {
	
	@FindBy(xpath="//span[text()=\"Apple iPhone 7 (32GB) - Black\"]")
	WebElement iphone;
	
	public AmazonIphonePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public AmazonIphonePricePage iphonePage() throws InterruptedException
	{
		iphone.click();
		Set<String> handles=driver.getWindowHandles();
        Iterator<String> it=handles.iterator();
        String parentWindowId=it.next();
        String childWindowId=it.next();
	    driver.switchTo().window(childWindowId);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swfMailTo")));
		return new AmazonIphonePricePage();
	}

}
