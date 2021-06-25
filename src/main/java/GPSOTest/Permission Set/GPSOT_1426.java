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

public class GPSOT_1426 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_1426";
		testCaseDesc = "Create permission set - US Onboarding Project Support";
		category = "GPSOTest";
		author = "Suraj";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_1426_Test(Map<String, String> details) throws InterruptedException, IOException {

		// Step 1 : Log into the application as "System Administrator"

		try {
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			locateElement("xpath", "//*[@name='loginfmt']").sendKeys("malnasu@mfcgd.com");
			click(locateElement("xpath", "//*[@id='idSIButton9']"));
			Thread.sleep(20000);
			// ForFirefox // FIREFOX Driver-Working

			
			 WebDriverWait wait = new WebDriverWait(driver, 60); Alert alert =
			  wait.until(ExpectedConditions.alertIsPresent()); Thread.sleep(20000);
			  driver.switchTo().alert().accept(); driver.switchTo().defaultContent();
			 

			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			waitPageLoading();
			Thread.sleep(5000);
			reportStep("Login is Successful", "pass", takeSnap(getTitle()));

		} catch (Exception e) {
			reportStep("Unable to login to application", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 2 : Navigate to setup home page

		try {
			/*
			 * Thread.sleep(2000); click(locateElement("xpath", "//*[@id='75:231;a']"));
			 */
			/*
			 * Thread.sleep(2000); WebElement setupicon =
			 * driver.findElement(By.xpath("//*[@id='75:231;a']")); JavascriptExecutor
			 * executor = (JavascriptExecutor)driver;
			 * executor.executeScript("arguments[0].click();", setupicon);
			 * click(locateElement("xpath", "//*[@id='66:231;a']//a/div"));
			 */
			Thread.sleep(10000);
			driver.get("https://manuliferetirement--mfcnaretst.lightning.force.com/lightning/setup/SetupOneHome/home");
			Thread.sleep(10000);
			reportStep("setup home page is displayed", "pass", takeSnap(getTitle()));

		} catch (Exception e) {
			reportStep("Unable to display the setup home page", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 3 : Navigate to permission sets page

		try {
			Thread.sleep(2000);
			click(locateElement("xpath", "(//a[text() = 'Users'])[1]"));
			Thread.sleep(2000);
			click(locateElement("xpath", "//a[text() = 'Permission Sets']"));
			Thread.sleep(5000);
			reportStep("Permission sets page is displayed", "pass", takeSnap(getTitle()));

		} catch (Exception e) {
			reportStep("Unable to display the Permission sets page", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 4 : Navigate to US Onboarding Project Support Permission set page

		try {
			Thread.sleep(7000);
			WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));
			switchToFrame(ele);
			click(locateElement("xpath", "//span[text() = 'U']"));
			Thread.sleep(2000);
			click(locateElement("xpath", "//span[text() = 'US Onboarding Project Support']"));

			Thread.sleep(5000);
			reportStep("US Onboarding Project Support Permission sets page is displayed", "pass", takeSnap(getTitle()));
			/* switchTodefault(); */
		} catch (Exception e) {
			reportStep("Unable to display the US Onboarding Project Support Permission sets page", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 5 : Navigate toUS Onboarding Project Support object settings Permission
		// set
		// page

		try {
			Thread.sleep(2000);
			/*
			 * WebElement ele = driver.findElement(By.xpath(
			 * "//*[@id='setupComponent']//force-aloha-page/div/iframe"));
			 * switchToFrame(ele);
			 */
			driver.get(
					"https://manuliferetirement--mfcnaretst.lightning.force.com/lightning/setup/PermSets/page?address=%2F0PS4g0000000oKI%3Fs%3DEntityPermissions");
			/* click(locateElement("xpath", "//a[text() = 'Object Settings']")); */
			Thread.sleep(10000);
			reportStep("US Onboarding Project Support object settings Permission set page is displayed", "pass",
					takeSnap(getTitle()));
			/* switchTodefault(); */
		} catch (Exception e) {
			reportStep("Unable to display the US Onboarding Project Support object settings Permission set page",
					"fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 6 : Navigate to RPS Accounts object and field level permission sets page
		// page

		try {
			Thread.sleep(20000);
			WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));
			switchToFrame(ele);
			click(locateElement("xpath", "//a[text() = 'RPS Accounts']"));
			Thread.sleep(20000);
			reportStep("RPS Accounts object and field level permission sets page is displayed", "pass",
					takeSnap(getTitle()));
			/* switchTodefault(); */

		} catch (Exception e) {
			reportStep("Unable to display the RPS Accounts object and field level permission sets page", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 7 : Verify the RPS Accounts FLS fields for US Project Management for
		// read and edit access

		// page

		try {
			Thread.sleep(2000);
			WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));
			switchToFrame(ele);
			locateElement("xpath", "//td[text() = '$ Amount']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Billing Latitude']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Company ID']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Deconversion Package']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Document Type Provider']").isDisplayed();

			locateElement("xpath", "//td[text() = 'External ID']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Firm Performance']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Fund Partner Total Assets']").isDisplayed();

			locateElement("xpath", "//td[text() = 'JH Calculated Vesting']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Longitude (MapAnything)']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Middle Name']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Other Network']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Participant Initiated Online Loans']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Proprietary Fund Products']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Review Withdrawals']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Seller Status Effective Date']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Shipping Latitude']").isDisplayed();

			locateElement("xpath", "//td[text() = 'TPA Admin System']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Website']").isDisplayed();
			Thread.sleep(5000);
			reportStep("RPS Accounts FLS fields are validated for edit and read access", "pass", takeSnap(getTitle()));

			switchTodefault();
			driver.navigate().back();

		} catch (Exception e) {
			reportStep("Failed to validate the RPS Accounts FLS fields are validated for edit and read access", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 8 : Navigate to RPS Contact object and field level permission sets page
		// page

		try {
			Thread.sleep(20000);
			WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));
			switchToFrame(ele);
			click(locateElement("xpath", "//a[text() = 'RPS Contacts']"));
			Thread.sleep(20000);
			reportStep("RPS Contacts object and field level permission sets page is displayed", "pass",
					takeSnap(getTitle()));
			switchTodefault();

		} catch (Exception e) {
			reportStep("Unable to display the RPS Contacts object and field level permission sets page", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 9 : Verify the RPS Contacts FLS fields for US Project Management for
		// read and edit access

		// page

		try {
			Thread.sleep(2000);
			WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));
			switchToFrame(ele);
			locateElement("xpath", "//td[text() = '403B?']").isDisplayed();

			locateElement("xpath", "//td[text() = 'AUA for Advisor']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Contact Preference']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Do Not Contact']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Do Not Mail']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Fax Opt Out']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Fiduciary Role']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Influence Rating']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Last Name']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Mailing Latitude']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Marketing Preferences Verified On']").isDisplayed();

			locateElement("xpath", "//td[text() = 'MM RVP - FA Tier']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Number of Retirement Plan Clients']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Other Country Code']").isDisplayed();

			locateElement("xpath", "//td[text() = 'PeopleSoft ID']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Region/Branch Number']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Sells Taft Hartley?']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Specialties']").isDisplayed();

			locateElement("xpath", "//td[text() = 'Website']").isDisplayed();
			Thread.sleep(5000);
			reportStep("RPS Contacts FLS fields are validated for edit and read access", "pass", takeSnap(getTitle()));

			switchTodefault();
		} catch (Exception e) {
			reportStep("Unable to display the RPS Contacts object and field level permission sets page", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Verify the permission set is assigned to 'US Project Management' for
		// 'Onboarding standard user' profile
		try {
			driver.get("https://manuliferetirement--mfcnaretst.lightning.force.com/lightning/page/home");
			Thread.sleep(5000);
			/* click(locateElement("xpath", "//button[@class='slds-button slds-show']")); */
			locateElement("xpath",
					"//input[@class = 'slds-input slds-text-color_default slds-p-left--none slds-size--1-of-1 input default input uiInput uiInputTextForAutocomplete uiInput--{remove}']")
							.sendKeys("maia");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			click(locateElement("xpath", "//div[text() = 'User Detail']"));
			if (locateElement("xpath", "//div[text() = 'User Detail']").isDisplayed()) {
				reportStep("Navigated to 'onboarding standard user' profile", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Unable to navigate to Navigated to 'onboarding standard user profile", "fail",
						takeSnap(getTitle()));
			}

			WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));

			switchToFrame(ele);

			/* click(locateElement("xpath", "//input[@name = 'Edit']")); */
			if (locateElement("xpath", "//a[text() = 'US Project Management']").isDisplayed()) {

				reportStep(
						"permission set is assigned to 'US Project Management' for 'onboarding stndard user' profile",
						"pass", takeSnap(getTitle()));
			} else {
				reportStep(
						"permission set is not assigned to 'US Project Management' for 'onboarding stndard user' profile",
						"fail", takeSnap(getTitle()));
			}
			switchTodefault();

		} catch (Exception e) {
			reportStep("Unable to display permmision set to 'US Project Management' for 'Onboarding Standard User'",
					"fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Verify the permission set is assigned to 'US Project Management' for
		// 'onboarding plan services user' profile
		try {
			driver.get("https://manuliferetirement--mfcnaretst.lightning.force.com/lightning/page/home");
			Thread.sleep(5000);
			/* click(locateElement("xpath", "//button[@class='slds-button slds-show']")); */
			locateElement("xpath",
					"//input[@class = 'slds-input slds-text-color_default slds-p-left--none slds-size--1-of-1 input default input uiInput uiInputTextForAutocomplete uiInput--{remove}']")
							.sendKeys("sally");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			click(locateElement("xpath", "//div[text() = 'User Detail']"));
			if (locateElement("xpath", "//div[text() = 'User Detail']").isDisplayed()) {
				reportStep("Navigated to 'onboarding plan services' profile", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Unable to navigate to Navigated to 'onboarding plan services profile", "fail",
						takeSnap(getTitle()));
			}
			WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));

			switchToFrame(ele);

			/* click(locateElement("xpath", "//input[@name = 'Edit']")); */
			if (locateElement("xpath", "//a[text() = 'US Onboarding Project Support']").isDisplayed()) {

				reportStep(
						"permission set is assigned to 'US Onboarding Project Support' for 'onboarding plan services user' profile",
						"pass", takeSnap(getTitle()));
			} else {
				reportStep(
						"permission set is not assigned to 'US Onboarding Project Support' for 'onboarding plan services user' profile",
						"fail", takeSnap(getTitle()));
			}
			switchTodefault();

		} catch (Exception e) {
			reportStep(
					"Unable to display permmision set to 'US Onboarding Project Support' for 'onboarding plan services user'",
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
