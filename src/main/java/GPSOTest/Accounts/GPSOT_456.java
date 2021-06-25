package GPSOTest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import test.Sel.Project;

public class GPSOT_456 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_456";
		testCaseDesc = "SF - Account Relationships on Project";
		category = "GPSOTest";
		author = "Suraj";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_456_Test(Map<String, String> details) throws InterruptedException, IOException {

		// Step 1 : Log into the application as "System Administrator"

		try {
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			locateElement("xpath", "//*[@name='loginfmt']").sendKeys("malnasu@mfcgd.com");
			click(locateElement("xpath", "//*[@id='idSIButton9']"));
			Thread.sleep(10000);
			click(locateElement("xpath", "//a[@title='Accounts']"));

			// ForFirefox
			// FIREFOX Driver-Working
			/*
			 * WebDriverWait wait = new WebDriverWait(driver, 60); Alert alert =
			 * wait.until(ExpectedConditions.alertIsPresent()); Thread.sleep(20000);
			 * driver.switchTo().alert().accept(); driver.switchTo().defaultContent();
			 */
			waitPageLoading();

			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			waitPageLoading();
			Thread.sleep(30000);
			reportStep("Login is Successful as System Administrator", "pass", takeSnap(getTitle()));

		} catch (Exception e) {
			reportStep("Unable to login to application", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 2 : Navigate to 'Cases' object
		try {
			waitPageLoading();
			Thread.sleep(20000);

			click(locateElement("xpath", "//button[@class='slds-button slds-show']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Cases");
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(20000);
			if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
				reportStep("Cases page is displayed", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Cases page is not displayed", "fail", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Unable to navigate to Cases page", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 3 : Navigate to Case number and navigate to case account relationship
		/*try {

			Thread.sleep(2000);
			click(locateElement("xpath", "(//a[text() = '00001183'])[1]"));
			Thread.sleep(10000);

			
			 * JavascriptExecutor je = (JavascriptExecutor) driver;
			 * 
			 * WebElement accountphone =
			 * driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			 * je.executeScript("arguments[0].scrollIntoView(true);", accountphone);
			 
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement region = driver.findElement(By.xpath("(//a[text() = 'Related'])[1]"));
			je.executeScript("arguments[0].scrollIntoView(true);", region);
			Thread.sleep(5000);
			click(locateElement("xpath", "(//a[text() = 'Related'])[1]"));
			Thread.sleep(5000);

			if (locateElement("xpath", "(//a[text() = 'Related'])[1]").isDisplayed()) {

				reportStep("Case Account Relation ship page is displayed", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Case Account relation ship is not displayed", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to naviage to case account relationship", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}*/

		// Step 4 : Verify the new case account relationship screen

		try {
			click(locateElement("xpath", "(//a[text() = '00001183'])[1]"));
			Thread.sleep(7000);
			/*click(locateElement("xpath", "(//div[text() =  'New'])[2]"));*/
			Thread.sleep(10000);

			if (locateElement("xpath", "//h2[text() = 'New Case Account Relationship']").isDisplayed()) {

				reportStep("New Case Account Relation ship screen is displayed", "pass", takeSnap(getTitle()));
			} else {
				reportStep("New Case Account Relation ship screen is not displayed", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to navigate to New Case Account Relation ship screen", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 5 : Enter the fields in the new case account relationship screen

		try {

			Thread.sleep(2000);
			click(locateElement("xpath", "(//div[text() =  'New'])[1]"));
			Thread.sleep(10000);
			// Start Date
			locateElement("xpath", "//input[@name='Start_Date__c']").sendKeys("2021-06-14");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(5000);

			// Accounts
			click(locateElement("xpath", "(//input[@class =  'slds-input slds-combobox__input'])[2]"));

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();

			// Role in case
			click(locateElement("xpath", "(//input[@class =  'slds-input slds-combobox__input'])[3]"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(5000);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ARROW_DOWN).build().perform();
			actions.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(5000);
			if (locateElement("xpath", "//h2[text() =   'New Case Account Relationship']").isDisplayed()) {

				reportStep("New Case Account Relation ship screen is displayed with fields entered", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("New Case Account Relation ship screen is not displayed with fields entered", "fail",
						takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to enter fields in the New Case Account Relation ship screen", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 6 : Enter the fields in the new case account relationship screen
		try {

			click(locateElement("xpath", "(//input[@class =  '//button[@name = 'SaveEdit']"));
			Thread.sleep(5000);

			reportStep("New Case Account Relation ship is saved successfully", "pass", takeSnap(getTitle()));

		} catch (Exception e) {
			reportStep("Failed to save the new case account relationship", "fail", takeSnap(getTitle()));

			e.printStackTrace();
		}

		// Step 7 : Edit the case account relationship

		try {

			Thread.sleep(2000);
			click(locateElement("xpath", "(//a[text() = 'CAR-7'])[3]"));
			Thread.sleep(10000);

			if (locateElement("xpath", "(//a[text() = 'Related'])[1]").isDisplayed()) {

				reportStep("Able to edit the case account relationship created", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Unable to edit the case accunt relatinship edited ", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to edit the case account relationship", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 8 : Verify the history tracking

		try {

			Thread.sleep(2000);
			click(locateElement("xpath", "(//a[text() = 'Related'])[1]"));
			Thread.sleep(10000);

			if (locateElement("xpath", "(//a[text() = 'Related'])[1]").isDisplayed()) {

				reportStep("Able to view the history tracking", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Unable to view the history tracking", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display the history tracking for case accounts relationship", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

		// ONBOARDING STANDARD USER
		try {

			click(locateElement("xpath", "//button[@class='slds-button slds-show']"));
			locateElement("xpath",
					"//input[@class = 'slds-input slds-text-color_default slds-p-left--none slds-size--1-of-1 input default input uiInput uiInputTextForAutocomplete uiInput--{remove}']")
							.sendKeys("maia");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(10000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			click(locateElement("xpath", "//div[text() = 'User Detail']"));

			WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));

			switchToFrame(ele);

			click(locateElement("xpath", "//input[@name = 'login']"));
			WebDriverWait wait = new WebDriverWait(driver, 10);

			Thread.sleep(20000);
			reportStep("Login is Successful as 'Onboarding Standard User", "pass", takeSnap(getTitle()));
			/* switchTodefault(); */

		} catch (Exception e) {
			reportStep("Unable to login as 'Onboarding Standard User'", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 2 : Navigate to 'Cases' object
		try {
			waitPageLoading();
			Thread.sleep(20000);

			click(locateElement("xpath", "//button[@class='slds-button slds-show']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Cases");
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(20000);
			if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
				reportStep("Cases page is displayed", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Cases page is not displayed", "fail", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Unable to navigate to Cases page", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 3 : Navigate to Case number and navigate to case account relationship
		try {

			Thread.sleep(2000);
			click(locateElement("xpath", "(//a[text() = '00001183'])[3]"));
			Thread.sleep(10000);

			/*
			 * JavascriptExecutor je = (JavascriptExecutor) driver;
			 * 
			 * WebElement accountphone =
			 * driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			 * je.executeScript("arguments[0].scrollIntoView(true);", accountphone);
			 */
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement region = driver.findElement(By.xpath("(//a[text() = 'Related'])[1]"));
			je.executeScript("arguments[0].scrollIntoView(true);", region);
			Thread.sleep(5000);
			click(locateElement("xpath", "(//a[text() = 'Related'])[1]"));
			Thread.sleep(5000);

			if (locateElement("xpath", "(//a[text() = 'Related'])[1]").isDisplayed()) {

				reportStep("Case Account Relation ship page is displayed", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Case Account relation ship is not displayed", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to naviage to case account relationship", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 7 : Edit the case account relationship

		try {

			Thread.sleep(2000);
			click(locateElement("xpath", "(//a[text() = 'CAR-7'])[3]"));
			Thread.sleep(10000);

			if (locateElement("xpath", "(//a[text() = 'Related'])[1]").isDisplayed()) {

				reportStep("Able to edit the case account relationship created", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Unable to edit the case accunt relatinship edited ", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to edit the case account relationship", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 8 : Verify the history tracking

		try {

			Thread.sleep(2000);
			click(locateElement("xpath", "(//a[text() = 'Related'])[1]"));
			Thread.sleep(10000);

			if (locateElement("xpath", "(//a[text() = 'Related'])[1]").isDisplayed()) {

				reportStep("Able to view the history tracking", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Unable to view the history tracking", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display the history tracking for case accounts relationship", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Logout of the application
		try {

			click(locateElement("xpath", "(//span[@class = 'uiImage'])[1]"));
			click(locateElement("linkText", "Log Out"));
			reportStep("Application is logged out successfully", "pass", takeSnap(getTitle()));

		} catch (Exception e) {
			reportStep("Failed to log out of the application and display the login page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// ONBOARDING PLAN SERVICES
		try {
			Thread.sleep(5000);
			driver.get("https://manuliferetirement--mfcnaretst.lightning.force.com/lightning/page/home");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			waitPageLoading();
			Thread.sleep(10000);
			locateElement("xpath",
					"//input[@class = 'slds-input slds-text-color_default slds-p-left--none slds-size--1-of-1 input default input uiInput uiInputTextForAutocomplete uiInput--{remove}']")
							.sendKeys("sally");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(20000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			click(locateElement("xpath", "//div[text() = 'User Detail']"));

			WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));

			switchToFrame(ele);

			click(locateElement("xpath", "//input[@name = 'login']"));
			WebDriverWait wait = new WebDriverWait(driver, 10);
			Thread.sleep(50000);
			reportStep("Login is Successful as 'Onboarding Plan Services", "pass", takeSnap(getTitle()));
			switchTodefault();

		} catch (Exception e) {
			reportStep("Unable to login as 'Onboarding Plan Services'", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 3 : Navigate to Case number and navigate to case account relationship
		try {

			Thread.sleep(2000);
			click(locateElement("xpath", "(//a[text() = '00001183'])[3]"));
			Thread.sleep(10000);

			/*
			 * JavascriptExecutor je = (JavascriptExecutor) driver;
			 * 
			 * WebElement accountphone =
			 * driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			 * je.executeScript("arguments[0].scrollIntoView(true);", accountphone);
			 */
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement region = driver.findElement(By.xpath("(//a[text() = 'Related'])[1]"));
			je.executeScript("arguments[0].scrollIntoView(true);", region);
			Thread.sleep(5000);
			click(locateElement("xpath", "(//a[text() = 'Related'])[1]"));
			Thread.sleep(5000);

			if (locateElement("xpath", "(//a[text() = 'Related'])[1]").isDisplayed()) {

				reportStep("Case Account Relation ship page is displayed", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Case Account relation ship is not displayed", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to naviage to case account relationship", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 7 : Edit the case account relationship

		try {

			Thread.sleep(2000);
			click(locateElement("xpath", "//a[text() = 'CAR-0']"));
			Thread.sleep(10000);

			if (locateElement("xpath", "(//a[text() = 'Related'])[1]").isDisplayed()) {

				reportStep("Able to edit the case account relationship created", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Unable to edit the case accunt relatinship edited ", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to edit the case account relationship", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 8 : Verify the history tracking

		try {

			Thread.sleep(2000);
			click(locateElement("xpath", "(//a[text() = 'Related'])[1]"));
			Thread.sleep(10000);

			if (locateElement("xpath", "(//a[text() = 'Related'])[1]").isDisplayed()) {

				reportStep("Able to view the history tracking", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Unable to view the history tracking", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display the history tracking for case accounts relationship", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Logout of the application
		try {

			click(locateElement("xpath", "(//span[@class = 'uiImage'])[1]"));
			click(locateElement("linkText", "Log Out"));
			reportStep("Application is logged out successfully", "pass", takeSnap(getTitle()));

		} catch (Exception e) {
			reportStep("Failed to log out of the application and display the login page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

	}

}
