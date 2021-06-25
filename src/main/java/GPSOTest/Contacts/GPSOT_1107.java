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

public class GPSOT_1107 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_841";
		testCaseDesc = "Initial Contact Setup - Page Layout";
		category = "GPSOTest";
		author = "Suraj";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_1107_Test(Map<String, String> details) throws InterruptedException, IOException {

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

		// Step 1 : Verify the display of the 'Owner ID' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement ownerid = driver.findElement(By.xpath("//label[text() = 'Owner ID']"));
			je.executeScript("arguments[0].scrollIntoView(true);", ownerid);

			if (locateElement("xpath", "//label[text() = 'Owner ID']").isDisplayed()) {
				reportStep("Owner ID field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Owner ID field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Owner ID field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 2 : Verify the display of the 'Record Type ID' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			/*
			 * JavascriptExecutor je = (JavascriptExecutor) driver; WebElement accountfax =
			 * driver.findElement(By.xpath("//label[text() = 'Account Fax']"));
			 * je.executeScript("arguments[0].scrollIntoView(true);", accountfax);
			 */

			if (locateElement("xpath", "//label[text() = 'Record Type ID']").isDisplayed()) {
				reportStep("Record Type ID field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Record Type ID field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Record Type ID field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 3 : Verify the display of the 'Department' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement department = driver.findElement(By.xpath("//label[text() = 'Department']"));
			je.executeScript("arguments[0].scrollIntoView(true);", department);
			 

			if (locateElement("xpath", "//label[text() = 'Department']").isDisplayed()) {
				reportStep("Department field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Department field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Department field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 4 : Verify the display of the 'Birthdate' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			/*JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement billingcountry = driver.findElement(By.xpath("//label[text() = 'Billing Country']"));
			je.executeScript("arguments[0].scrollIntoView(true);", billingcountry);
*/
			if (locateElement("xpath", "//label[text() = 'Birthdate']").isDisplayed()) {
				reportStep("Birthdate field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Birthdate field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Birthdate field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 5 : Verify the display of the 'Mailing Country' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement mailingcountry = driver.findElement(By.xpath("//label[text() = 'Mailing Country']"));
			je.executeScript("arguments[0].scrollIntoView(true);", mailingcountry);

			if (locateElement("xpath", "//label[text() = 'Mailing Country']").isDisplayed()) {
				reportStep("Mailing Country field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Mailing Country field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Mailing Country field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 6 : Verify the display of the 'Do Not Contact' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement donotcontact = driver.findElement(By.xpath("//span[text() = 'Do Not Contact']"));
			je.executeScript("arguments[0].scrollIntoView(true);", donotcontact);

			if (locateElement("xpath", "//span[text() = 'Do Not Contact']").isDisplayed()) {
				reportStep("Do Not Contact field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Do Not Contact field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Do Not Contact field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 7 : Verify the display of the 'Email Opt Out' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement emailoptout = driver.findElement(By.xpath("//span[text() = 'Email Opt Out']"));
			je.executeScript("arguments[0].scrollIntoView(true);", emailoptout);

			if (locateElement("xpath", "//span[text() = 'Email Opt Out']").isDisplayed()) {
				reportStep("Email Opt Out field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Email Opt Out field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Email Opt Out field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 8 : Verify the display of the 'Do Not Mail' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement donotmail = driver.findElement(By.xpath("//span[text() = 'Do Not Mail']"));
			je.executeScript("arguments[0].scrollIntoView(true);", donotmail);

			if (locateElement("xpath", "//span[text() = 'Do Not Mail']").isDisplayed()) {
				reportStep("Do Not Mail field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Do Not Mail field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Do Not Mail field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 9 : Verify the display of the 'Participant Engagement Program' field
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement participantengagementprogram = driver.findElement(By.xpath("//span[text() = 'Participant Engagement Program']"));
			je.executeScript("arguments[0].scrollIntoView(true);", participantengagementprogram);

			if (locateElement("xpath", "//span[text() = 'Participant Engagement Program']").isDisplayed()) {
				reportStep("Participant Engagement Program field is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Participant Engagement Program field is not displayed successfully", "fail", takeSnap(getTitle()));
			}
		} catch (Exception e) {
			reportStep("Failed to display Participant Engagement Program field", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

	}
}