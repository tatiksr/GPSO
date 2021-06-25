package GPSOTest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import salesForceWebPages.AppLauncherPage;
import test.Sel.Project;

public class GPSOT_799 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_799";
		testCaseDesc = "Acount Object - Broker/Dealer firm record type";
		category = "GPSOTest";
		author = "Suraj";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_799_Test(Map<String, String> details) throws InterruptedException, IOException {

		// Step 1 : Log into the application

		/*
		 * try { waitPageLoading(); waitPageLoading();
		 */
		// click(locateElement("name", "setup"));

		/*
		 * type(locateElement("id", "username"),
		 * "suraj_malnad@jhancock.com.mfcnaretdv"); type(locateElement("id",
		 * "password"), "Copado@1526"); click(locateElement("id", "Login"));
		 * waitPageLoading(); driver.manage().timeouts().implicitlyWait(30,
		 * TimeUnit.SECONDS);
		 */

		/*
		 * if (locateElement("xpath", "//input[@name = 'new']").isDisplayed()) {
		 * reportStep("User roles page is displayed successfully", "pass",
		 * takeSnap(getTitle())); } else {
		 * reportStep("User roles page is not displayed successfully", "fail",
		 * takeSnap(getTitle())); }
		 * 
		 * } catch (Exception e) { reportStep("Failed to display user roles page",
		 * "fail", takeSnap(getTitle())); e.printStackTrace();
		 * 
		 * }
		 */

		// Step 2 : Navigating to 'Projects in the app launcher
		/*
		 * waitPageLoading(); waitPageLoading(); try {
		 * 
		 * new AppLauncherPage(driver).search_app("Cases"); waitPageLoading();
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * 
		 * reportStep("Succesfully navigated to cases page", "pass",
		 * takeSnap(getTitle())); } catch (Exception e) {
		 * reportStep("Unable to open case page", "fail", takeSnap(getTitle()));
		 * e.printStackTrace();
		 * 
		 * }
		 */

		// Step 1 : Verify the display of the 'Account Phone' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
			je.executeScript("arguments[0].scrollIntoView(true);", accountphone);

			if (locateElement("xpath", "//label[text() = 'Account Phone']").isDisplayed()) {
				reportStep("Account Phone field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Account Phone field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Account Phone field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 2 : Verify the display of the 'Account Fax' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			/*JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement accountfax = driver.findElement(By.xpath("//label[text() = 'Account Fax']"));
			je.executeScript("arguments[0].scrollIntoView(true);", accountfax);*/

			if (locateElement("xpath", "//label[text() = 'Account Fax']").isDisplayed()) {
				reportStep("Account Fax field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Account Fax field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Account Fax field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 3 : Verify the display of the 'Company ID' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			/*JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement companyid = driver.findElement(By.xpath("//label[text() = 'Company ID']"));
			je.executeScript("arguments[0].scrollIntoView(true);", companyid);*/

			if (locateElement("xpath", "//label[text() = 'Company ID']").isDisplayed()) {
				reportStep("Company ID field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Company ID field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Company ID field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 4 : Verify the display of the 'Billing Country' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement billingcountry = driver.findElement(By.xpath("//label[text() = 'Billing Country']"));
			je.executeScript("arguments[0].scrollIntoView(true);", billingcountry);

			if (locateElement("xpath", "//label[text() = 'Billing Country']").isDisplayed()) {
				reportStep("Billing Country field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Billing Country field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Billing Country field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 5 : Verify the display of the 'Shipping Country' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement shippingcountry = driver.findElement(By.xpath("//label[text() = 'Shipping Country']"));
			je.executeScript("arguments[0].scrollIntoView(true);", shippingcountry);

			if (locateElement("xpath", "//label[text() = 'Shipping Country']").isDisplayed()) {
				reportStep("Shipping Country field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Shipping Country field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Shipping Country field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 6 : Verify the display of the 'Billing City' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement billingcity = driver.findElement(By.xpath("//label[text() = 'Billing City']"));
			je.executeScript("arguments[0].scrollIntoView(true);", billingcity);

			if (locateElement("xpath", "//label[text() = 'Billing City']").isDisplayed()) {
				reportStep("Billing City field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Billing City field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Billing City field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 7 : Verify the display of the 'Shipping City' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement shippingcity = driver.findElement(By.xpath("//label[text() = 'Shipping City']"));
			je.executeScript("arguments[0].scrollIntoView(true);", shippingcity);

			if (locateElement("xpath", "//label[text() = 'Shipping City']").isDisplayed()) {
				reportStep("Shipping City field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Shipping City field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Shipping City field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 8 : Verify the display of the 'Does this office have a sales desk?'
		// field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement doesthisoffice = driver
					.findElement(By.xpath("//span[text() = 'Does this office have a Sales Desk?']"));
			je.executeScript("arguments[0].scrollIntoView(true);", doesthisoffice);

			if (locateElement("xpath", "//span[text() = 'Does this office have a Sales Desk?']").isDisplayed()) {
				reportStep("Does this office have a Sales Desk? field is displayed successfully", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Does this office have a Sales Desk? field is not displayed successfully", "fail",
						takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Does this office have a Sales Desk? field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 9 : Verify the display of the 'Signature Selling Agreement Status' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement signaturesellingagreementstatus = driver
					.findElement(By.xpath("//label[text() = 'Signature Selling Agreement Status']"));
			je.executeScript("arguments[0].scrollIntoView(true);", signaturesellingagreementstatus);

			if (locateElement("xpath", "//label[text() = 'Signature Selling Agreement Status']").isDisplayed()) {
				reportStep("Signature Selling Agreement Status field is displayed successfully", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Signature Selling Agreement Status field is not displayed successfully", "fail",
						takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Signature Selling Agreement Status field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 10 : Verify the display of the 'Signature Selling Agreement Status Date'
		// field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement signaturesellingagreementstatusdate = driver
					.findElement(By.xpath("//label[text() = 'Signature Selling Agreement Status Date']"));
			je.executeScript("arguments[0].scrollIntoView(true);", signaturesellingagreementstatusdate);

			if (locateElement("xpath", "//label[text() = 'Signature Selling Agreement Status Date']").isDisplayed()) {
				reportStep("Signature Selling Agreement Status Date field is displayed successfully", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Signature Selling Agreement Status Date field is not displayed successfully", "fail",
						takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Signature Selling Agreement Status Date field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 11 : Verify the display of the 'Co-Mingling' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement Comingling = driver.findElement(By.xpath("//label[text() = 'Co-Mingling']"));
			je.executeScript("arguments[0].scrollIntoView(true);", Comingling);

			if (locateElement("xpath", "//label[text() = 'Co-Mingling']").isDisplayed()) {
				reportStep("Co-Mingling field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Co-Mingling field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Co-Mingling field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 12 : Verify the display of the 'Satuit ID' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement satuitid = driver.findElement(By.xpath("//label[text() = 'Satuit ID']"));
			je.executeScript("arguments[0].scrollIntoView(true);", satuitid);

			if (locateElement("xpath", "//label[text() = 'Satuit ID']").isDisplayed()) {
				reportStep("Satuit ID field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Satuit ID field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Satuit ID field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 13 : Verify the display of the 'Peoplesoft ID' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement peoplesoftid = driver.findElement(By.xpath("//label[text() = 'PeopleSoft ID']"));
			je.executeScript("arguments[0].scrollIntoView(true);", peoplesoftid);

			if (locateElement("xpath", "//label[text() = 'PeopleSoft ID']").isDisplayed()) {
				reportStep("PeopleSoft ID field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("PeopleSoft ID field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display PeopleSoft ID field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 14 : Verify the display of the 'Asset Based Commission Only' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement assetbasedcomissiononly = driver
					.findElement(By.xpath("//span[text() = 'Asset Based Commission Only']"));
			je.executeScript("arguments[0].scrollIntoView(true);", assetbasedcomissiononly);

			if (locateElement("xpath", "//span[text() = 'Asset Based Commission Only']").isDisplayed()) {
				reportStep("Asset Based Commission Only field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Asset Based Commission Only field is not displayed successfully", "fail",
						takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Asset Based Commission Only field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 15 : Verify the display of the 'Commission Grid Available' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement commissiongridavailable = driver
					.findElement(By.xpath("//span[text() = 'Commission Grid Available']"));
			je.executeScript("arguments[0].scrollIntoView(true);", commissiongridavailable);

			if (locateElement("xpath", "//span[text() = 'Commission Grid Available']").isDisplayed()) {
				reportStep("Commission Grid Available field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Commission Grid Available field is not displayed successfully", "fail",
						takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Commission Grid Available field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 16 : Verify the display of the 'RIA Fee' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement riafee = driver.findElement(By.xpath("//span[text() = 'RIA Fee']"));
			je.executeScript("arguments[0].scrollIntoView(true);", riafee);

			if (locateElement("xpath", "//span[text() = 'RIA Fee']").isDisplayed()) {
				reportStep("RIA Fee field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("RIA Fee field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display RIA Fee field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 17 : Verify the display of the 'RIA Fee Grid Available' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement riafeegrid = driver.findElement(By.xpath("//span[text() = 'RIA Fee Grid Available']"));
			je.executeScript("arguments[0].scrollIntoView(true);", riafeegrid);

			if (locateElement("xpath", "//span[text() = 'RIA Fee Grid Available']").isDisplayed()) {
				reportStep("RIA Fee Grid Available field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("RIA Fee Grid Available field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display RIA Fee Grid Available field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

	}
}