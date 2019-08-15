package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.testbase.TestBase;

public class FlipkartIphonePrice extends TestBase {
	
	@FindBy(xpath="//div[@class=\"_1vC4OE _3qQ9m1\"]")
	WebElement amount;
	
	public FlipkartIphonePrice()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getPrice() throws InterruptedException
	{   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"Apple iPhone 7 (Black, 32 GB)\"]")));
		return amount.getText();
	}

}
