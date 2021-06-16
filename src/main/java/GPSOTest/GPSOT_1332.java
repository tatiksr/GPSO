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

public class GPSOT_1332 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_1332";
		testCaseDesc = "Add Account information header to account page layout";
		category = "GPSOTest";
		author = "Suraj";
		testCaseFileName = "GPSO";
	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_1332_Test(Map<String, String> details) throws InterruptedException, IOException {

		// Step 1 : Log into the application as "System Administrator"

		try {
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			locateElement("xpath", "//*[@name='loginfmt']").sendKeys("malnasu@mfcgd.com");
			click(locateElement("xpath", "//*[@id='idSIButton9']"));
			Thread.sleep(50000);
			// ForFirefox
			// FIREFOX Driver-Working

			WebDriverWait wait = new WebDriverWait(driver, 60);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(20000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();

			waitPageLoading();

			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			waitPageLoading();
			Thread.sleep(10000);
			reportStep("Login is Successful as System Administrator", "pass", takeSnap(getTitle()));

		} catch (Exception e) {
			reportStep("Unable to login to application", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 2 : Navigate to App Launcher -> 'Accounts' object
		try {
			Thread.sleep(5000);
			click(locateElement("xpath", "//button[@class='slds-button slds-show']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Accounts");
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(2000);
			reportStep("Navigated to Account page successfully", "pass", takeSnap(getTitle()));

		} catch (Exception e) {
			reportStep("Unable to Navigate to account page", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Verify the record types for accounts page layout
		// Bank/Trust Firm
		try {

			click(locateElement("xpath", "//span[text() = 'Accounts']"));
			Thread.sleep(2000);
			click(locateElement("xpath", "(//a[text() = 'Standard Insurance Company'])[1]"));
			Thread.sleep(2000);

			/*
			 * JavascriptExecutor je = (JavascriptExecutor) driver;
			 * 
			 * WebElement accountphone =
			 * driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			 * je.executeScript("arguments[0].scrollIntoView(true);", accountphone);
			 */

			if (locateElement("xpath", "//label[text() = 'Account Phone']").isDisplayed()) {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Bank/Trust Firm'",
						"pass", takeSnap(getTitle()));
			} else {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Bank/Trust Firm",
						"fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep(
					"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Bank/Trust Firm",
					"fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Branch Firm
		try {
			driver.navigate().back();
			/*
			 * click(locateElement("xpath", "(//span[text() = 'Accounts'])[1]"));
			 * Thread.sleep(20000);
			 */
			Thread.sleep(2000);
			click(locateElement("xpath", "(//a[text() = 'ADVANCED FINANCIAL GROUP, INC'])[1]"));
			Thread.sleep(2000);

			/*
			 * JavascriptExecutor je = (JavascriptExecutor) driver;
			 * 
			 * WebElement accountphone =
			 * driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			 * je.executeScript("arguments[0].scrollIntoView(true);", accountphone);
			 */

			if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {

				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Branch Firm'",
						"pass", takeSnap(getTitle()));
			} else {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Branch Firm",
						"fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep(
					"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Branch Firm",
					"fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// National Account
		try {
			driver.navigate().back();
			/*
			 * click(locateElement("xpath", "(//span[text() = 'Accounts'])[1]"));
			 * Thread.sleep(20000);
			 */
			Thread.sleep(20000);
			click(locateElement("xpath", "(//a[text() = 'Wells Fargo National Accounts'])[1]"));
			Thread.sleep(20000);

			/*
			 * JavascriptExecutor je = (JavascriptExecutor) driver;
			 * 
			 * WebElement accountphone =
			 * driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			 * je.executeScript("arguments[0].scrollIntoView(true);", accountphone);
			 */

			if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'National Account'",
						"pass", takeSnap(getTitle()));
			} else {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'National Account",
						"fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep(
					"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'National Account",
					"fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Broker/Dealer Firm
		try {
			driver.navigate().back();
			click(locateElement("xpath", "(//span[text() = 'Accounts'])[1]"));
			Thread.sleep(20000);
			click(locateElement("xpath", "(//a[text() = 'United Planners Financial Services'])[1]"));
			Thread.sleep(20000);

			JavascriptExecutor je = (JavascriptExecutor) driver;

			WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			je.executeScript("arguments[0].scrollIntoView(true);", accountphone);

			if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Broker/Dealer Firm'",
						"pass", takeSnap(getTitle()));
			} else {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Broker/Dealer Firm",
						"fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep(
					"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Broker/Dealer Firm",
					"fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// TPA Branch Firm
		try {
			driver.navigate().back();
			click(locateElement("xpath", "(//span[text() = 'Accounts'])[1]"));
			Thread.sleep(20000);
			click(locateElement("xpath", "(//a[text() = 'FuturePlan by Ascensus'])[1]"));
			Thread.sleep(20000);

			JavascriptExecutor je = (JavascriptExecutor) driver;

			WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			je.executeScript("arguments[0].scrollIntoView(true);", accountphone);

			if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'TPA Branch Firm'",
						"pass", takeSnap(getTitle()));
			} else {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'TPA Branch Firm",
						"fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep(
					"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'TPA Branch Firm",
					"fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Fund Partner
		try {
			driver.navigate().back();
			click(locateElement("xpath", "(//span[text() = 'Accounts'])[1]"));
			Thread.sleep(20000);
			click(locateElement("xpath", "(//a[text() = 'AB - Alliance Bernstein'])[1]"));
			Thread.sleep(20000);

			JavascriptExecutor je = (JavascriptExecutor) driver;

			WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			je.executeScript("arguments[0].scrollIntoView(true);", accountphone);

			if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Fund Partner'",
						"pass", takeSnap(getTitle()));
			} else {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Fund Partner",
						"fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep(
					"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Fund Partner",
					"fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Plan Sponsor
		try {
			driver.navigate().back();
			click(locateElement("xpath", "(//span[text() = 'Accounts'])[1]"));
			Thread.sleep(20000);
			click(locateElement("xpath", "(//a[text() = 'Glanz Properties, Inc. 401(k) Retirement Plan'])[1]"));
			Thread.sleep(20000);

			JavascriptExecutor je = (JavascriptExecutor) driver;

			WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			je.executeScript("arguments[0].scrollIntoView(true);", accountphone);

			if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Plan Sponsor'",
						"pass", takeSnap(getTitle()));
			} else {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Plan Sponsor",
						"fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep(
					"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Plan Sponsor",
					"fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// TPA Firm
		try {
			driver.navigate().back();
			click(locateElement("xpath", "(//span[text() = 'Accounts'])[1]"));
			Thread.sleep(20000);
			click(locateElement("xpath", "(//a[text() = 'Compensation Services, Inc.'])[1]"));
			Thread.sleep(20000);

			JavascriptExecutor je = (JavascriptExecutor) driver;

			WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			je.executeScript("arguments[0].scrollIntoView(true);", accountphone);

			if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'TPA Firm.'",
						"pass", takeSnap(getTitle()));
			} else {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'TPA Firm",
						"fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep(
					"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'TPA Firm",
					"fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Business
		try {
			driver.navigate().back();
			click(locateElement("xpath", "(//span[text() = 'Accounts'])[1]"));
			Thread.sleep(20000);
			click(locateElement("xpath", "(//a[text() = 'National Heritage Academies, Inc'])[1]"));
			Thread.sleep(20000);

			JavascriptExecutor je = (JavascriptExecutor) driver;

			WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			je.executeScript("arguments[0].scrollIntoView(true);", accountphone);

			if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Business'",
						"pass", takeSnap(getTitle()));
			} else {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Business",
						"fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep(
					"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Bank/Trust Firm",
					"fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Generic Business firm
		try {
			driver.navigate().back();
			click(locateElement("xpath", "(//span[text() = 'Accounts'])[1]"));
			Thread.sleep(20000);
			click(locateElement("xpath", "(//a[text() = 'Nationwide'])[1]"));
			Thread.sleep(20000);

			JavascriptExecutor je = (JavascriptExecutor) driver;

			WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			je.executeScript("arguments[0].scrollIntoView(true);", accountphone);

			if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Generic Business firm'",
						"pass", takeSnap(getTitle()));
			} else {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Generic Business firm",
						"fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep(
					"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Generic Business firm",
					"fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Independent Producer Firm
		try {
			driver.navigate().back();
			click(locateElement("xpath", "(//span[text() = 'Accounts'])[1]"));
			Thread.sleep(20000);
			click(locateElement("xpath", "(//a[text() = 'American Compensation Service'])[1]"));
			Thread.sleep(20000);

			JavascriptExecutor je = (JavascriptExecutor) driver;

			WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			je.executeScript("arguments[0].scrollIntoView(true);", accountphone);

			if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Independent Producer Firm'",
						"pass", takeSnap(getTitle()));
			} else {
				reportStep(
						"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Independent Producer Firm",
						"fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep(
					"Account information section fields are displayed and Account Information Header is made visible on all page layouts for Account record type 'Independent Producer Firm",
					"fail", takeSnap(getTitle()));
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
