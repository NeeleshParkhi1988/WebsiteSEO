package com.NOVO_SEO.FunctionLibrary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.NOVO_SEO.Actions.Novo_Actions;
import com.NOVO_SEO.PageObjects.BlogPage;
import com.NOVO_SEO.PageObjects.HomePage;
import com.NOVO_SEO.PageObjects.TeamsPage;
import com.NOVO_SEO.Utilities.PropertyReader;

public class Unient_TeamsPage extends Novo_Actions implements HomePage, TeamsPage {

	PropertyReader prop = new PropertyReader();
	Logger Log = LogManager.getLogger(Unient_TeamsPage.class.getName());

	public Unient_TeamsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void teamsPageTitle() {
		Log.info("We are at Unient Teams page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(teamsLocator);
		String expectedPageTitle = "Unient | Flexible Offshore Staffing & Engagement Models";
		String actualpageTitle = getPageTitle();
		System.out.println(actualpageTitle);
		Assert.assertEquals(actualpageTitle, expectedPageTitle);
	}

	public void teamsPageMetaDescription() {
		Log.info("We are at Unient Teams page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(teamsLocator);
		String expectedMetaDescription = "Scale faster and smarter and gain access to a premium global talent pool with our fully customisable offshore team solutions: Employer of Record and Managed Resources.";
		WebElement element = driver.findElement(By.xpath("//meta[@name='description']"));
		String metaDescription = element.getAttribute("content");
		Assert.assertEquals(metaDescription, expectedMetaDescription);
	}
}
