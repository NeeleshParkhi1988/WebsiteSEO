package com.NOVO_SEO.AllPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.NOVO_SEO.Config.DriverManagerWeb;
import com.NOVO_SEO.FunctionLibrary.Unient_AboutUsPage;
import com.NOVO_SEO.FunctionLibrary.Unient_BlogPage;
import com.NOVO_SEO.FunctionLibrary.Unient_CreativesPage;
import com.NOVO_SEO.FunctionLibrary.Unient_HomePage;

@Listeners(com.NOVO_SEO.Listeners.Log.class)
public class Unient_CreativesPageTest extends DriverManagerWeb{
	
	Unient_CreativesPage cr;
	
	@Test(priority = 0)
	public void Unient_CreativesPageTitleVelidation() throws InterruptedException
	{
		cr = new Unient_CreativesPage(driver);
		cr.testName="creativesPageTitleVelidation";
		cr.title="CreativesPageTitle";
		cr.creativesPageTitle();
	}
	
	@Test(priority = 1)
	public void Unient_CreativesPageMetaDescriptionVelidation() throws InterruptedException
	{
		cr = new Unient_CreativesPage(driver);
		cr.testName="creativesPageTitleVelidation";
		cr.title="CreativesPageTitle";
		cr.creativesPageMetaDescription();
	}
}
