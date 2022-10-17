package com.NOVO_SEO.FunctionLibrary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.NOVO_SEO.Actions.Novo_Actions;
import com.NOVO_SEO.Listeners.Log;
import com.NOVO_SEO.PageObjects.HomePage;
import com.NOVO_SEO.Utilities.PropertyReader;


public class Unient_HomePage extends Novo_Actions implements HomePage{
	
	PropertyReader prop = new PropertyReader();
	Logger Log = LogManager.getLogger(Unient_HomePage.class.getName());

	public Unient_HomePage(WebDriver driver) {
		super(driver);
	}

	//Website cookies popup
	public WebElement webDriverCookies()
	{
		return driver.findElement(webSiteCookies);
	}
	
	public void homePageTitle() throws InterruptedException {
		 Log.info("We are at Unient Home page");
		 Log.info("Clicking on accept Unient Cookies");
		 Click(webSiteCookies);
		 String expectedPageTitle = "Unient | Your Versatile Partner for Better Offshoring";
		 String actualpageTitle = getPageTitle();
		 System.out.println(actualpageTitle);
		 Assert.assertEquals(actualpageTitle, expectedPageTitle);	 
	}
	
	public void homePageMetaDescription()
	{
		 Log.info("We are at Unient Home page");
		 Log.info("Clicking on accept Unient Cookies");
		 Click(webSiteCookies);
		 String expectedDescription = "Empower your organisation to function onshore & offshore as one enterprise with Unient's versatile range of services & regional service delivery capabilities.";
		 WebElement element = driver.findElement(By.xpath("//meta[@name='description']"));
		 String metaDescription = element.getAttribute("content");
		 Assert.assertEquals(metaDescription, expectedDescription);
	}

}
