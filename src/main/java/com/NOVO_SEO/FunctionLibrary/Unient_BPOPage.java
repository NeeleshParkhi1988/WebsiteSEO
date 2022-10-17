package com.NOVO_SEO.FunctionLibrary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.NOVO_SEO.Actions.Novo_Actions;
import com.NOVO_SEO.PageObjects.AboutUsPage;
import com.NOVO_SEO.PageObjects.BPOPage;
import com.NOVO_SEO.PageObjects.BlogPage;
import com.NOVO_SEO.PageObjects.HomePage;
import com.NOVO_SEO.Utilities.PropertyReader;

public class Unient_BPOPage extends Novo_Actions implements HomePage, BPOPage {

	PropertyReader prop = new PropertyReader();
	Logger Log = LogManager.getLogger(Unient_BPOPage.class.getName());

	public Unient_BPOPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void BPOPageTitle() {
		Log.info("We are at Unient BPO page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(bpoLocator);
		String expectedPageTitle = "Unient | Front-Office & Back-Office BPO Support";
		String actualpageTitle = getPageTitle();
		System.out.println(actualpageTitle);
		Assert.assertEquals(actualpageTitle, expectedPageTitle);
	}

	public void BPOPageMetaDescription() {
		Log.info("We are at Unient BPO page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(bpoLocator);
		String expectedDescription = "The Unient advantage: operational excellence with a human approach. We create exceptional customer experiences, streamline processes & enhance productivity.";
		WebElement element = driver.findElement(By.xpath("//meta[@name='description']"));
		String metaDescription = element.getAttribute("content");
		Assert.assertEquals(metaDescription, expectedDescription);
	}

}
