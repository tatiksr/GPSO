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

public class GPSOT_820 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_820";
		testCaseDesc = "Acount Object - Bank/Trust firm record type";
		category = "GPSOTest";
		author = "Suraj";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_820_Test(Map<String, String> details) throws InterruptedException, IOException {

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

		// Step 9 : Verify the display of the 'Total Number of Employees' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement totalnumberofemployees = driver
					.findElement(By.xpath("//label[text() = 'Total Number of Employees']"));
			je.executeScript("arguments[0].scrollIntoView(true);", totalnumberofemployees);

			if (locateElement("xpath", "//label[text() = 'Total Number of Employees']").isDisplayed()) {
				reportStep("Total Number of Employees field is displayed successfully", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Total Number of Employees field is not displayed successfully", "fail",
						takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Total Number of Employees field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 10 : Verify the display of the 'Total Number of Advisors'
		// field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement totalnumberofadvisors = driver
					.findElement(By.xpath("//label[text() = 'Total Number of Advisors']"));
			je.executeScript("arguments[0].scrollIntoView(true);", totalnumberofadvisors);

			if (locateElement("xpath", "//label[text() = 'Total Number of Advisors']").isDisplayed()) {
				reportStep("Total Number of Advisors field is displayed successfully", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Total Number of Advisors field is not displayed successfully", "fail",
						takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Total Number of Advisors field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 11 : Verify the display of the 'Firm Performance' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement firmperformance = driver.findElement(By.xpath("//label[text() = 'Firm Performance']"));
			je.executeScript("arguments[0].scrollIntoView(true);", firmperformance);

			if (locateElement("xpath", "//label[text() = 'Firm Performance']").isDisplayed()) {
				reportStep("Firm Performance field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Firm Performance field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Firm Performance field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 12 : Verify the display of the 'Firm Performance Year' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement firmperformanceyear = driver.findElement(By.xpath("//label[text() = 'Firm Performance Year']"));
			je.executeScript("arguments[0].scrollIntoView(true);", firmperformanceyear);

			if (locateElement("xpath", "//label[text() = 'Firm Performance Year']").isDisplayed()) {
				reportStep("Firm Performance Year field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Firm Performance Year field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Firm Performance Yearfield", "fail", takeSnap(getTitle()));
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

		

	}
}