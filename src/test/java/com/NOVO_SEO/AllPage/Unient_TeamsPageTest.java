package com.NOVO_SEO.AllPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.NOVO_SEO.Config.DriverManagerWeb;
import com.NOVO_SEO.FunctionLibrary.Unient_BlogPage;
import com.NOVO_SEO.FunctionLibrary.Unient_HomePage;
import com.NOVO_SEO.FunctionLibrary.Unient_TeamsPage;

@Listeners(com.NOVO_SEO.Listeners.Log.class)
public class Unient_TeamsPageTest extends DriverManagerWeb{
	
	Unient_TeamsPage tp;
	
	@Test(priority = 0)
	public void Unient_TeamsPageTitleVelidation() throws InterruptedException
	{
		tp = new Unient_TeamsPage(driver);
		tp.testName="teamsPageTitleVelidation";
		tp.title="teamsPageTitle";
		tp.teamsPageTitle();
	}
	
	@Test(priority = 1)
	public void Unient_TeamsPageMetaDescriptionVelidation() throws InterruptedException
	{
		tp = new Unient_TeamsPage(driver);
		tp.testName="teamsPageMetaDescriptionVelidation";
		tp.title="teamsPageMetaDescription";
		tp.teamsPageMetaDescription();
	}
}
