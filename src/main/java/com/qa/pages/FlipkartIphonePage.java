package com.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.testbase.TestBase;

public class FlipkartIphonePage extends TestBase {
	
	@FindBy(xpath="//div[text()=\"Apple iPhone 7 (Black, 32 GB)\"]")
	WebElement iphone;
	
	public FlipkartIphonePage()
	{
		PageFactory.initElements(driver, this);
	}

	public FlipkartIphonePrice getIphone() throws InterruptedException
	{
		iphone.click();
		Set<String> handles=driver.getWindowHandles();
        Iterator<String> it=handles.iterator();
        String parentWindowId=it.next();
        String childWindowId=it.next();
        String childWindowId1=it.next();
	    driver.switchTo().window(childWindowId1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"Apple iPhone 7 (Black, 32 GB)\"]")));
		return new FlipkartIphonePrice();
	}
}
