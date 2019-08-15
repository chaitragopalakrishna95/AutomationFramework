package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.pages.FlipkartIphonePage;
import com.qa.pages.FlipkartIphonePrice;
import com.qa.pages.FlipkartPage;
import com.qa.pages.AmazonIphonePage;
import com.qa.pages.AmazonIphonePricePage;
import com.qa.pages.AmazonSearchIphonePage;
import com.qa.testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class IPhonePricePageTest extends TestBase {
	AmazonSearchIphonePage searchIphone;
	AmazonIphonePage iphonepage;
	AmazonIphonePricePage ipricepage;
	FlipkartPage flipkartpage;
	FlipkartIphonePage fiphone;
	FlipkartIphonePrice fiphoneprice;

	public IPhonePricePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		this.driver = initDriver();
		searchIphone = new AmazonSearchIphonePage();
		iphonepage = searchIphone.SearchIphone(prop.getProperty("searchString"));
		ipricepage = iphonepage.iphonePage();

	}

	@Test(priority = 1)
	public void testIphonePrice() throws InterruptedException {
		String priceamazon = ipricepage.iphonePrice();
		flipkartpage = ipricepage.navigate();
		fiphone = flipkartpage.searchIphone(prop.getProperty("searchString"));
		fiphoneprice = fiphone.getIphone();
		String priceflipkart = fiphoneprice.getPrice();
		System.out.println(priceamazon);
		System.out.println(priceflipkart);
		priceamazon = priceamazon.replaceAll("₹", "");
		priceflipkart = priceflipkart.replaceAll("₹", "");
		System.out.println(priceamazon);
		System.out.println(priceflipkart);
		priceamazon = priceamazon.replaceAll(",", "");
		priceflipkart = priceflipkart.replaceAll(",", "");
		System.out.println(priceamazon);
		System.out.println(priceflipkart);
		float priceamazonint = Float.parseFloat(priceamazon);
		float priceflipkartint = Float.parseFloat(priceflipkart);
		if (priceamazonint > priceflipkartint) {
			System.out.println("Flipkart has lesser price for Iphone" + priceflipkartint);
		} else {
			System.out.println("Amazon has lesser price for Iphone" + priceamazonint);
		}
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();

	}

}
