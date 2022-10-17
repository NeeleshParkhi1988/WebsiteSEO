package com.NOVO_SEO.AllPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.NOVO_SEO.Config.DriverManagerWeb;
import com.NOVO_SEO.FunctionLibrary.Unient_HomePage;
import com.NOVO_SEO.FunctionLibrary.Unient_InfotechPage;

@Listeners(com.NOVO_SEO.Listeners.Log.class)
public class Unient_InfotechPageTest extends DriverManagerWeb{
	
	Unient_InfotechPage ip;
	
	@Test(priority = 0)
	public void Unient_InfotechPageTitleVelidation() throws InterruptedException
	{
		ip = new Unient_InfotechPage(driver);
		ip.testName="infotechPageTitleVelidation";
		ip.title="infotechPageTitle";
		ip.infotechPageTitle();
	}
	
	@Test(priority = 1)
	public void Unient_InfotechPageMetaDescriptionVelidation() throws InterruptedException
	{
		ip = new Unient_InfotechPage(driver);
		ip.testName="infotechPageMEtaDescriptionVelidation";
		ip.title="infotechPageMetaDescription";
		ip.infotechPageMetaDescription();
	}
}
