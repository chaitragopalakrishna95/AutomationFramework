package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class AmazonIphonePricePage extends TestBase {

	@FindBy(id = "priceblock_ourprice")
	WebElement mobprice;

	public AmazonIphonePricePage() {
		PageFactory.initElements(driver, this);

	}

	public String iphonePrice() {
		return mobprice.getText();

	}

	public FlipkartPage navigate() {
		driver.navigate().to("https://www.flipkart.com/");
		return new FlipkartPage();

	}
}
