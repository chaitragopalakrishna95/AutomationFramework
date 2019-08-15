package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.testbase.TestBase;

public class FlipkartPage extends TestBase {
	
	@FindBy(xpath="//button[@class=\"_2AkmmA _29YdH8\"]")
	WebElement logincancel;
	
	@FindBy(name="q")
	WebElement searchtext;
	
	@FindBy(xpath="//button[@class=\"vh79eN\" and @type=\"submit\"]")
	WebElement search;
	
	public FlipkartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public FlipkartIphonePage searchIphone(String searchString) throws InterruptedException
	{
		logincancel.click();
		searchtext.sendKeys(searchString);
		search.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"Apple iPhone 7 (Black, 32 GB)\"]")));
		return new FlipkartIphonePage();
	}

}
