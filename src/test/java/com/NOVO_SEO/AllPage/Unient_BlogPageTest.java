package com.NOVO_SEO.AllPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.NOVO_SEO.Config.DriverManagerWeb;
import com.NOVO_SEO.FunctionLibrary.Unient_BlogPage;
import com.NOVO_SEO.FunctionLibrary.Unient_HomePage;

@Listeners(com.NOVO_SEO.Listeners.Log.class)
public class Unient_BlogPageTest extends DriverManagerWeb {

	Unient_BlogPage bp;

	@Test(priority = 0)
	public void Unient_BlogPageTitleVelidation() throws InterruptedException {
		bp = new Unient_BlogPage(driver);
		bp.testName = "blogPageTitleVelidation";
		bp.title = "blogPageTitle";
		bp.blogPageTitle();
	}

	@Test(priority = 1)
	public void Unient_BlogPageMetaDescriptionVelidation() throws InterruptedException {
		bp = new Unient_BlogPage(driver);
		bp.testName = "blogPageMetaDescriptionVelidation";
		bp.title = "blogPageMetaDescription";
		bp.blogPageMetaDescription();
	}

	@Test(priority = 2)
	public void Unient_BlogUnientUnveilingPageMetaDescriptionVelidation() throws InterruptedException {
		bp = new Unient_BlogPage(driver);
		bp.testName = "blogUnientUnveilingPageMetaDescriptionVelidation";
		bp.title = "blogUnientUnveilingPageMetaDescription";
		bp.blogUnientUnveilingMetaDescription();
	}

	@Test(priority = 3)
	public void Unient_BlogTrustAndPerformancePageMetaDescriptionVelidation() throws InterruptedException {
		bp = new Unient_BlogPage(driver);
		bp.testName = "blogTrustAndPerformancePageMetaDescriptionVelidation";
		bp.title = "blogTrustAndPerformancePageMetaDescription";
		bp.blogTrustAndPerformanceMetaDescription();
	}

	@Test(priority = 4)
	public void Unient_BlogEmployerOfRecordMetaDescriptionVelidation() throws InterruptedException {
		bp = new Unient_BlogPage(driver);
		bp.testName = "blogEmployerOfRecordPageMetaDescriptionVelidation";
		bp.title = "blogEmployerOfRecordPageMetaDescription";
		bp.blogEmployerOfRecordMetaDescription();
	}

	@Test(priority = 5)
	public void Unient_BlogSevenReasonWhyMetaDescriptionVelidation() throws InterruptedException {
		bp = new Unient_BlogPage(driver);
		bp.testName = "blogSevenReasonWhyPageMetaDescriptionVelidation";
		bp.title = "blogSevenReasonWhyPageMetaDescription";
		bp.blogSevenReasonWhyMetaDescription();
	}

}
