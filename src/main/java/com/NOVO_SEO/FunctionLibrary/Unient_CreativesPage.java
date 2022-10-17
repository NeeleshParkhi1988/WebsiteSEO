package com.NOVO_SEO.FunctionLibrary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.NOVO_SEO.Actions.Novo_Actions;
import com.NOVO_SEO.PageObjects.AboutUsPage;
import com.NOVO_SEO.PageObjects.BlogPage;
import com.NOVO_SEO.PageObjects.CreativesPage;
import com.NOVO_SEO.PageObjects.HomePage;
import com.NOVO_SEO.Utilities.PropertyReader;

public class Unient_CreativesPage extends Novo_Actions implements HomePage, CreativesPage{
	
	PropertyReader prop = new PropertyReader();
	Logger Log = LogManager.getLogger(Unient_CreativesPage.class.getName());

	public Unient_CreativesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void creativesPageTitle() {
		Log.info("We are at Unient creatives page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(creativesLocator);
		String expectedPageTitle = "Unient | Creative & Digital Marketing Services";
		String actualpageTitle = getPageTitle();
		System.out.println(actualpageTitle);
		Assert.assertEquals(actualpageTitle, expectedPageTitle);
	}
	
	public void creativesPageMetaDescription() {
		Log.info("We are at Unient creatives page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(creativesLocator);
		String expectedDescription = "We offer a full suite of design & digital marketing & communications solutions to help businesses create meaningful connections, tell stories and drive conversions.";
		WebElement element = driver.findElement(By.xpath("//meta[@name='description']"));
		String metaDescription = element.getAttribute("content");
		Assert.assertEquals(metaDescription, expectedDescription);
	}

}
