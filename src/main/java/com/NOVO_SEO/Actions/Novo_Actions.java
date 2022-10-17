package com.NOVO_SEO.Actions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.NOVO_SEO.Listeners.Log;
import com.NOVO_SEO.Utilities.Screenshot;

public class Novo_Actions {

	public WebDriver driver;
	public WebDriverWait wait;
	public Alert alert;
	public Select select;
	static final int TIMEOUT = 40;
	static final int POLLING = 100;
	public static String testName;
	public static String title;
	public Actions actions;

	Screenshot screenhsot;
	
	Logger Log = LogManager.getLogger(Novo_Actions.class.getName());

	// Constructor
	public Novo_Actions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	// wait for element to appear
	public void waitForElementToAppear(By elementBy, String strObjectName) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
			System.out.println(strObjectName + " is  present on UI");
			highLightElement(elementBy);
		} catch (Exception e) {
			System.out.println(strObjectName + " is Not present on UI");// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// wait for element to Click
	public void waitForElementToClick(By elementBy) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(elementBy));
			highLightElement(elementBy);
		} catch (Exception e) {
			System.out.println(elementBy + "is Not present on UI");
			e.printStackTrace();
		}
	}

	// wait for alert to appear
	public void waitForAlertToAppear() {
		alert = wait.until(ExpectedConditions.alertIsPresent());
		if (alert != null) {
			isAlertPresent();
		}
	}

	// is Element present
	public boolean isElementPresent(By elementBy) {
		try {
			if (driver.findElements(elementBy).size() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	// is Element Visible
	public boolean isElementVisible(By elementBy) {
		try {
			if (driver.findElement(elementBy).isDisplayed()) {
				System.out.println("Element is Dispalyed");
				return true;
			} else {
				System.out.println("Element is not Displayed");
				return false;
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	// Highlight Element
	public void highLightElement(By elementBy) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style','border: 5px solid red;');",
					driver.findElement(elementBy));
			// sleepTime(3);
			Screenshot.captureScreen(driver, title, testName);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", driver.findElement(elementBy), "");
		} catch (Exception e) {
			System.out.println(elementBy + "Is not HighLighting");// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Un Highlight emelent
	public void unHighLightElement(By elementBy) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", driver.findElement(elementBy), "");
		// sleepTime(1);
	}

	// check Alert present
	public boolean isAlertPresent() {
		boolean presentFlag = false;
		try {
			alert = driver.switchTo().alert();
			presentFlag = true;
			alert.accept();
		} catch (NoAlertPresentException ex) {
			ex.printStackTrace();
		}
		return presentFlag;
	}

	// Click Method
	public void Click(By elementBy) {
		try {
			WebElement element = driver.findElement(elementBy);
			Log.info("Trying to find element" + element.getText());
			waitForElementToClick(elementBy);
			highLightElement(elementBy);
			String temp = Screenshot.captureScreen(driver, title, testName);
			Log.info(temp + "Clicking on" + element.getText() + "button");
			unHighLightElement(elementBy);
			element.click();
		} catch (Exception e) {
			System.out.println(elementBy + " is not able to click.");// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// clear
	public void clear(By elementBy) {
		try {
			waitForElementToClick(elementBy);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].value = '';", driver.findElement(elementBy));
		} catch (Exception e) {
			System.out.println(elementBy + "is not able to perform clear.");// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// is selected
	public boolean isSelected(By elementBy) {
		return driver.findElement(elementBy).isSelected();
	}

	// Double click
	public void doubleClick(By elementBy) {
		try {
			waitForElementToClick(elementBy);
			actions = new Actions(driver);
			actions.doubleClick(driver.findElement(elementBy)).perform();
		} catch (Exception e) {
			System.out.println("Not able to perform double click on" + elementBy + ".");// TODO Auto-generated catch
																						// block
			e.printStackTrace();
		}
	}

	// Write text
	public void writeText(By elementBy, String text) {
		WebElement element = driver.findElement(elementBy);
		waitForElementToClick(elementBy);
		Log.info("Enterin" + text + "value to :" + element.getAttribute("name"));
		highLightElement(elementBy);
		element.clear();
		element.sendKeys(text);
		String temp = Screenshot.captureScreen(driver, title, testName);
		Log.info(temp + "Entered " + text + " value to : " + element.getAttribute("name"));
		unHighLightElement(elementBy);
	}

	// Read text
	public String readText(By elementBy) {
		WebElement element = driver.findElement(elementBy);
		waitForElementToClick(elementBy);
		highLightElement(elementBy);
		String temp = Screenshot.captureScreen(driver, title, testName);
		Log.info(temp + "Reading the text value from: " + element.getText());
		unHighLightElement(elementBy);
		return element.getText();
	}

	// Get element
	public WebElement getElement(By elementBy) {
		WebElement element = driver.findElement(elementBy);
		waitForElementToClick(elementBy);
		highLightElement(elementBy);
		String temp = Screenshot.captureScreen(driver, title, testName);
		Log.info(temp + "Getting the WebElement from : " + element.getText());
		unHighLightElement(elementBy);
		return driver.findElement(elementBy);
	}

	// Get title
	public String getPageTitle() {
		return driver.getTitle();
	}

	// SwitchToWindow method
	public String switchToWindow_GetTitle() {
		String parent = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> I1 = s1.iterator();
		String title = null;
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				title = driver.switchTo().window(child_window).getTitle();
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		return title;
	}

	// Get elements
	public List<WebElement> getElements(By elementBy) {
		// waitForElementToAppear(elementBy);
		return driver.findElements(elementBy);
	}

	// Keyboard function
	public void keysEnter(By elementBy) {
		waitForElementToClick(elementBy);
		driver.findElement(elementBy).sendKeys(Keys.ENTER);
	}

	// Search Function
	public WebElement getSearch(By elementBy, String text) {
		waitForElementToClick(elementBy);
		highLightElement(elementBy);
		driver.findElement(elementBy).sendKeys(text);
		Log.info("Enter the Data in Search textbox:" + elementBy);
		driver.findElement(elementBy).sendKeys(Keys.DOWN);
		Log.info("Selecting Item to down:" + elementBy);
		driver.findElement(elementBy).sendKeys(Keys.ENTER);
		Log.info("Select Item is Enter:" + elementBy);
		return driver.findElement(elementBy);
	}

	// Multiple selection by text
	public void multiSelectByText(By elementBy, String xPathValue) {
		// waitForElementToAppear(elementBy, "Selecting "+xPathValue+" from
		// :"+elementBy.toString());
		int size = driver.findElements(By.xpath(xPathValue)).size();
		System.out.println(size + " mapsets found");
		boolean element = isElementPresent(By.xpath(xPathValue));
		if (element == true) {
			driver.findElement(By.xpath("(" + xPathValue + ")[" + size + "]")).click();
		} else {

		}
		System.out.println("changes are made to the most recent  mapset");
	}

	// Select by visible text
	public void selectByVisibleText(By elementBy, String value) {
		WebElement element = driver.findElement(elementBy);
		Log.info("Trying to find : " + element.getAttribute("name"));
		waitForElementToClick(elementBy);
		highLightElement(elementBy);
		select = new Select(element);
		select.selectByVisibleText(value);
		String temp = Screenshot.captureScreen(driver, title, testName);
		Log.info(temp + "Selected : " + value + " from : " + element.getAttribute("name"));
		unHighLightElement(elementBy);
	}

	// Select by value
	public void selectByValue(By elementBy, String value) {
		WebElement element = driver.findElement(elementBy);
		Log.info("Trying to find : " + element.getAttribute("name"));
		waitForElementToClick(elementBy);
		highLightElement(elementBy);
		select = new Select(element);
		select.selectByValue(value);
		String temp = Screenshot.captureScreen(driver, title, testName);
		Log.info(temp + "Selected : " + value + " from : " + element.getAttribute("name"));
		unHighLightElement(elementBy);
	}

	// Get select value
	public String getSelectedValue(By elementBy) {
		// waitForElementToAppear(elementBy, "Getting Selected value from :
		// "+elementBy.toString());
		Select select = new Select(driver.findElement(elementBy));
		return select.getFirstSelectedOption().getText();
	}

	// Element to be click from the list
	public void elementTobeClickFromList(By elementBy, String value, String logMsg) {
		// highLightElement(elementBy, logMsg);
		List<WebElement> checkBoxes = getElements(elementBy);
		for (WebElement boxes : checkBoxes) {
			String textValues = boxes.getText();
			if (textValues.contains(value)) {

				boxes.click();
				break;
			} else
				throw new RuntimeException(value + " is not available in the list");
		}
	}

	// JavaScript click
	public void javaScriptClick(By elementBy, String logMsg) {
		WebElement element = driver.findElement(elementBy);
		Log.info("Trying to find element : " + element.getText());
		waitForElementToClick(elementBy);
		highLightElement(elementBy);
		String temp = Screenshot.captureScreen(driver, title, testName);
		Log.info(temp + "Clicking on :" + element.getText());
		unHighLightElement(elementBy);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
	}

	// Scroll into view
	public void scrollIntoView(By elementBy) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(elementBy));
	}

	// Scroll page
	public void scroll() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)", "");
	}

	// Scroll page
	public void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("scroll(0, -250);");
		jse.executeScript("window.scrollBy(0, -250)", "");
	}

	// Thread wait
	public void sleepTime(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Wait for page to load
	public void waitForPageToLoad() {
		sleepTime(1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String state = (String) js.executeScript("return document.readyState");
		while (!state.equals("complete")) {
			sleepTime(20);
			state = (String) js.executeScript("return document.readyState");
		}
	}

	// Convert date
	public String convertDate(String inputdate) {
		System.out.println("input date" + inputdate);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try {
			System.out.println("input date in concert date****" + inputdate);
			date = new SimpleDateFormat("MM/dd/yyyy").parse(inputdate);
			System.out.println("Date in concert date****" + date);
		} catch (Exception e) {
			e.getMessage();
		}
		return df.format(date);
	}

	// Maximize the Browser
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	// Get Screenshot
	public void takeScreenShot() {
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		// String filePath = CRConstants.REPORTS_PATH + "screenshots//"
		// +//screenshotFile;
		String filePath = "";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileHandler.copy(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// WebDriver
	public WebDriver getDriver() {
		return driver;
	}

	// Wait to Page Load method
	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {

		}
	}

}
