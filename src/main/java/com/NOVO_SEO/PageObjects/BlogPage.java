package com.NOVO_SEO.PageObjects;

import org.openqa.selenium.By;

public interface BlogPage {
	By blog = By.xpath("(//a[contains(text(),'Blog')])[1]");
	
	By unientUnveiling = By.xpath("(//div[@class='row justify-content-center g-3']/div)[1]");
	
	By trustAndPerformance = By.xpath("(//div[@class='row justify-content-center g-3']/div)[2]");
	
	By employerOfRecord = By.xpath("(//div[@class='row justify-content-center g-3']/div)[3]");
	
	By sevenReasonWhy = By.xpath("(//div[@class='row justify-content-center g-3']/div)[4]");
}
