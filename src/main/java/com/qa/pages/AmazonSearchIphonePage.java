package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.testbase.TestBase;

public class AmazonSearchIphonePage extends TestBase
{
	Actions actions;
	
    @FindBy(id="twotabsearchtextbox")
    WebElement searchTextBox;
    
    @FindBy(xpath="//input[@type=\"submit\" and @value=\"Go\"]")
    WebElement search;
    
    public AmazonSearchIphonePage()
    {
       PageFactory.initElements(driver, this);
    }
    
    
    
    public AmazonIphonePage SearchIphone(String searchString) throws InterruptedException
    {   //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-your-amazon")));
        Thread.sleep(4000);
        searchTextBox.sendKeys(searchString);
    	search.click();
    	return new AmazonIphonePage();
    }
}
