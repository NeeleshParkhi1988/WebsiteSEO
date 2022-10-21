package com.NOVO_SEO.Exclude;

import org.testng.annotations.Test;

import com.NOVO_SEO.Config.DriverManagerWeb;
import com.NOVO_SEO.FunctionLibrary.Unient_HomePage;

public class Unient_HomePageTest extends DriverManagerWeb{
	
	Unient_HomePage lp;
	
	@Test(priority=0)
	public void Unient_HomePageMetaDescriptionVelidation() throws InterruptedException
	{
		lp = new Unient_HomePage(driver);
		lp.testName="homePageTitleVelidation";
		lp.title="homePageTitle";
		lp.homePageMetaDescription();
	}

}
