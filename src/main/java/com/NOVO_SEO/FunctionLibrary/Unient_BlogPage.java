package com.NOVO_SEO.FunctionLibrary;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.Assert;

import com.NOVO_SEO.Actions.Novo_Actions;
import com.NOVO_SEO.PageObjects.BlogPage;
import com.NOVO_SEO.PageObjects.HomePage;
import com.NOVO_SEO.Utilities.PropertyReader;


public class Unient_BlogPage extends Novo_Actions implements HomePage, BlogPage {

	PropertyReader prop = new PropertyReader();
	Logger Log = LogManager.getLogger(Unient_BlogPage.class.getName());

	public Unient_BlogPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void blogPageTitle() {
		Log.info("We are at Unient blog page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(blog);
		String expectedPageTitle = "Unient | Blog: Outsourcing Insights & Resources";
		String actualpageTitle = getPageTitle();
		System.out.println(actualpageTitle);
		Assert.assertEquals(actualpageTitle, expectedPageTitle);	
	}

	public void blogPageMetaDescription() {
		Log.info("We are at Unient blog page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		scrollIntoView(blog);
		Click(blog);
		String expectedDescription = "Explore articles, industry insights, the latest trends & other resources about outsourcing, offshoring, remote staffing, management, leadership & innovation.";
		WebElement element = driver.findElement(By.xpath("//meta[@name='description']"));
		String metaDescription = element.getAttribute("content");
		Assert.assertEquals(metaDescription, expectedDescription);
	}
	
	public void blogUnientUnveilingMetaDescription() {
		Log.info("We are at Unient blog page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(blog);
		scrollIntoView(unientUnveiling);
		Click(unientUnveiling);
		//Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                String expectedDescription = "Unient reflects our diversified service offerings and expanded geographical coverage and solidifies our mission to be your versatile partner for better offshoring.";
        		WebElement element = driver.findElement(By.xpath("//meta[@name='description']"));
        		String metaDescription = element.getAttribute("content");
        		Assert.assertEquals(metaDescription, expectedDescription);
            }
        }
	}
	
	public void blogTrustAndPerformanceMetaDescription() {
		Log.info("We are at Unient blog page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(blog);
		scrollIntoView(trustAndPerformance);
		Click(trustAndPerformance);
		//Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                String expectedDescription = "How can organisations create a culture of trust and personal excellence in their remote teams, rather than a culture of monitoring and surveillance? ";
        		WebElement element = driver.findElement(By.xpath("//meta[@name='description']"));
        		String metaDescription = element.getAttribute("content");
        		Assert.assertEquals(metaDescription, expectedDescription);
            }
        }
		
	}
	
	public void blogEmployerOfRecordMetaDescription() {
		Log.info("We are at Unient blog page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(blog);
		scrollIntoView(employerOfRecord);
		Click(employerOfRecord);
		//Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                String expectedDescription = "Setting up an office or a subsidiary offshore? Here are 2 offshore expansion models that offer different types  & levels of engagement: EoR & Managed Resources.";
        		WebElement element = driver.findElement(By.xpath("//meta[@name='description']"));
        		String metaDescription = element.getAttribute("content");
        		Assert.assertEquals(metaDescription, expectedDescription);
            }
        }
		
	}
	
	public void blogSevenReasonWhyMetaDescription() {
		Log.info("We are at Unient blog page");
		Log.info("Clicking on accept Unient Cookies");
		Click(webSiteCookies);
		Click(blog);
		scrollIntoView(sevenReasonWhy);
		Click(sevenReasonWhy);
		//Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                String expectedDescription = "Competitive advantage is highly contingent on the ability to apply IT in a way that serves the business objectives. Outsourcing is the way to achieve this.";
        		WebElement element = driver.findElement(By.xpath("//meta[@name='description']"));
        		String metaDescription = element.getAttribute("content");
        		Assert.assertEquals(metaDescription, expectedDescription);
            }
        }
		
	}

}
