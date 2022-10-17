package com.NOVO_SEO.AllPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.NOVO_SEO.Config.DriverManagerWeb;


public class Unient_PageTitleWith65Characters extends DriverManagerWeb{
	
	@Test(priority=0)
	public void Unient_TestAndPerformancePageTitleVelidation() throws InterruptedException
	{
		driver.get("https://www.unient.biz/blog/trust-and-performance-results-based-management-in-remote-working/");
		String actualpageTitle= driver.getTitle();
		String expectedPageTitle = "Trust & Performance: Results-Based Management in Remote Working";
		Assert.assertEquals(actualpageTitle, expectedPageTitle);
	}

	@Test(priority=1)
	public void Unient_EoRPageTitleVelidation() throws InterruptedException
	{
		driver.get("https://www.unient.biz/blog/employer-of-record-and-managed-resources-which-model-is-right-for-your-business/");
		String actualpageTitle= driver.getTitle();
		String expectedPageTitle = "EoR & Managed Resources: Which Model is Right for Your Business?";
		Assert.assertEquals(actualpageTitle, expectedPageTitle);
	}
}
