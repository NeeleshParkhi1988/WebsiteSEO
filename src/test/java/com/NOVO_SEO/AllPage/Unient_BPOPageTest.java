package com.NOVO_SEO.AllPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.NOVO_SEO.Config.DriverManagerWeb;
import com.NOVO_SEO.FunctionLibrary.Unient_AboutUsPage;
import com.NOVO_SEO.FunctionLibrary.Unient_BPOPage;
import com.NOVO_SEO.FunctionLibrary.Unient_BlogPage;
import com.NOVO_SEO.FunctionLibrary.Unient_HomePage;

@Listeners(com.NOVO_SEO.Listeners.Log.class)
public class Unient_BPOPageTest extends DriverManagerWeb{
	
	Unient_BPOPage bp;
	
	@Test(priority = 0)
	public void Unient_BPOPageTitleVelidation() throws InterruptedException
	{
		bp = new Unient_BPOPage(driver);
		bp.testName="aboutUsPageTitleVelidation";
		bp.title="AboutUsPageTitle";
		bp.BPOPageTitle();
	}
	
	@Test(priority = 1)
	public void Unient_BPOPageMetaDescriptionVelidation() throws InterruptedException
	{
		bp = new Unient_BPOPage(driver);
		bp.testName="aboutUsPageMetaDescriptionVelidation";
		bp.title="AboutUsPageMetaDescription";
		bp.BPOPageMetaDescription();
	}	
}
