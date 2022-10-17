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
import com.NOVO_SEO.PageObjects.HomePage;
import com.NOVO_SEO.Utilities.PropertyReader;

public class Unient_AboutUsPage extends Novo_Actions implements HomePage, AboutUsPage {

	PropertyReader prop = new PropertyReader();
	Logger Log = LogManager.getLogger(Unient_AboutUsPage.class.getName());

	public Unient_AboutUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void aboutUsPageTitle() {
		Log.info("We are at Unient infotech page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(aboutUsLocator);
		String expectedPageTitle = "Unient | About Us: Our Story So Far";
		String actualpageTitle = getPageTitle();
		System.out.println(actualpageTitle);
		Assert.assertEquals(actualpageTitle, expectedPageTitle);
	}

	public void aboutUsPageMetaDescription() {
		Log.info("We are at Unient infotech page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(aboutUsLocator);
		String expectedMetaDescription = "We create value and deliver results. Unient, formerly known as Entrinsic Technology, maintains service fulfilment capabilities in the Philippines, Singapore & India.";
		WebElement element = driver.findElement(By.xpath("//meta[@name='description']"));
		String metaDescription = element.getAttribute("content");
		Assert.assertEquals(metaDescription, expectedMetaDescription);
	}

}
