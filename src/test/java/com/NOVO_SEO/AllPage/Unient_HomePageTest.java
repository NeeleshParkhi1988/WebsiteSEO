package com.NOVO_SEO.AllPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.NOVO_SEO.Config.DriverManagerWeb;
import com.NOVO_SEO.FunctionLibrary.Unient_HomePage;

@Listeners(com.NOVO_SEO.Listeners.Log.class)
public class Unient_HomePageTest extends DriverManagerWeb{
	
	Unient_HomePage lp;
	
	@Test(priority=0)
	public void Unient_HomePageTitleVelidation() throws InterruptedException
	{
		lp = new Unient_HomePage(driver);
		lp.testName="homePageTitleVelidation";
		lp.title="homePageTitle";
		lp.homePageTitle();
	}
	
	@Test(priority=1)
	public void Unient_HomePageMetaDescriptionVelidation() throws InterruptedException
	{
		lp = new Unient_HomePage(driver);
		lp.testName="homePageTitleVelidation";
		lp.title="homePageTitle";
		lp.homePageMetaDescription();
	}
}
