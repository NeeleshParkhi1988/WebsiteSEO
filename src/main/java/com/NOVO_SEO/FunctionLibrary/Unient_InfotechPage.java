package com.NOVO_SEO.FunctionLibrary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.NOVO_SEO.Actions.Novo_Actions;
import com.NOVO_SEO.PageObjects.HomePage;
import com.NOVO_SEO.PageObjects.InfotechPage;
import com.NOVO_SEO.Utilities.PropertyReader;

public class Unient_InfotechPage extends Novo_Actions implements HomePage, InfotechPage {

	PropertyReader prop = new PropertyReader();
	Logger Log = LogManager.getLogger(Unient_InfotechPage.class.getName());

	public Unient_InfotechPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void infotechPageTitle() {
		Log.info("We are at Unient infotech page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(infotech);
		String expectedPageTitle = "Unient | Custom Software & Technology Solutions";
		String actualpageTitle = getPageTitle();
		System.out.println(actualpageTitle);
		Assert.assertEquals(actualpageTitle, expectedPageTitle);
	}

	public void infotechPageMetaDescription() {
		Log.info("We are at Unient infotech page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(infotech);
		String expectedMetaDescription = "We design & deliver tech-enabled solutions that give startups, small to medium businesses & global enterprises a competitive edge in — no matter the industry";
		WebElement element = driver.findElement(By.xpath("//meta[@name='description']"));
		String metaDescription = element.getAttribute("content");
		Assert.assertEquals(metaDescription, expectedMetaDescription);
	}

}
