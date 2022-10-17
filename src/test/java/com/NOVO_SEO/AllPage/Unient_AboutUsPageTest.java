package com.NOVO_SEO.AllPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.NOVO_SEO.Config.DriverManagerWeb;
import com.NOVO_SEO.FunctionLibrary.Unient_AboutUsPage;
import com.NOVO_SEO.FunctionLibrary.Unient_BlogPage;
import com.NOVO_SEO.FunctionLibrary.Unient_HomePage;

@Listeners(com.NOVO_SEO.Listeners.Log.class)
public class Unient_AboutUsPageTest extends DriverManagerWeb{
	
	Unient_AboutUsPage ab;
	
	@Test(priority = 0)
	public void Unient_AboutUsPageTitleVelidation() throws InterruptedException
	{
		ab = new Unient_AboutUsPage(driver);
		ab.testName="aboutUsPageTitleVelidation";
		ab.title="AboutUsPageTitle";
		ab.aboutUsPageTitle();
	}
	
	@Test(priority = 1)
	public void Unient_AboutUsPageMetaDescriptionVelidation() throws InterruptedException
	{
		ab = new Unient_AboutUsPage(driver);
		ab.testName="aboutUsPageTitleVelidation";
		ab.title="AboutUsPageTitle";
		ab.aboutUsPageMetaDescription();
	}
}
