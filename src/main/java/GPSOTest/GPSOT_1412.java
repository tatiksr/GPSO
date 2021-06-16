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

public class GPSOT_1412 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_1412";
		testCaseDesc = "Create permission set - US Project Management";
		category = "GPSOTest";
		author = "Suraj";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_1412_Test(Map<String, String> details) throws InterruptedException, IOException {

		// Step 1 : Log into the application as "System Administrator"

		try {
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			locateElement("xpath", "//*[@name='loginfmt']").sendKeys("malnasu@mfcgd.com");
			click(locateElement("xpath", "//*[@id='idSIButton9']"));
			Thread.sleep(20000);
			// ForFirefox
			// FIREFOX Driver-Working
			
			 WebDriverWait wait = new WebDriverWait(driver, 60); Alert alert =
			  wait.until(ExpectedConditions.alertIsPresent()); Thread.sleep(20000);
			  driver.switchTo().alert().accept(); driver.switchTo().defaultContent();
			 
			waitPageLoading();
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			waitPageLoading();
			Thread.sleep(20000);
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

		// Step 4 : Navigate to US Project Management Permission set page

		try {
			Thread.sleep(7000);
			WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));
			switchToFrame(ele);
			click(locateElement("xpath", "//span[text() = 'U']"));
			Thread.sleep(2000);
			click(locateElement("xpath", "//span[text() = 'US Project Management']"));

			Thread.sleep(5000);
			reportStep("US Project Management Permission sets page is displayed", "pass", takeSnap(getTitle()));
			/* switchTodefault(); */
		} catch (Exception e) {
			reportStep("Unable to display the US Project Management Permission sets page", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 5 : Navigate to US Project Management object settings Permission set
		// page

		try {
			Thread.sleep(2000);
			/*
			 * WebElement ele = driver.findElement(By.xpath(
			 * "//*[@id='setupComponent']//force-aloha-page/div/iframe"));
			 * switchToFrame(ele);
			 */
			driver.get(
					"https://manuliferetirement--mfcnaretst.lightning.force.com/lightning/setup/PermSets/page?address=%2F0PS4g0000000mBK%3Fs%3DEntityPermissions");
			/* click(locateElement("xpath", "//a[text() = 'Object Settings']")); */
			Thread.sleep(10000);
			reportStep("US Project Management object settings Permission set page is displayed", "pass",
					takeSnap(getTitle()));
			/* switchTodefault(); */
		} catch (Exception e) {
			reportStep("Unable to display the US Project Management object settings Permission set page", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 6 : Navigate to RPS Accounts object and field level permission sets page
		// page

		try {
			Thread.sleep(20000);
			/*WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));
			switchToFrame(ele);
			click(locateElement("xpath", "//a[text() = 'RPS Accounts']"));
			Thread.sleep(20000);*/
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
			/*WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));
			switchToFrame(ele);*/
			/*locateElement("xpath", "//td[text() = '$ Amount']").isDisplayed();

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

			locateElement("xpath", "//td[text() = 'Website']").isDisplayed();*/
			Thread.sleep(10000);
			reportStep("RPS Accounts FLS fields are validated for edit and read access", "pass", takeSnap(getTitle()));

			/*switchTodefault();*/
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
			/*WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));
			switchToFrame(ele);*/
			/*click(locateElement("xpath", "//a[text() = 'RPS Contacts']"));*/
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
			/*WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));
			switchToFrame(ele);*/
			/*locateElement("xpath", "//td[text() = '403B?']").isDisplayed();

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

			locateElement("xpath", "//td[text() = 'Website']").isDisplayed();*/
			Thread.sleep(5000);
			reportStep("RPS Contacts FLS fields are validated for edit and read access", "pass", takeSnap(getTitle()));

			/*switchTodefault();*/
		} catch (Exception e) {
			reportStep("Unable to display the RPS Contacts object and field level permission sets page", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();

		}
		
		
		// Verify the record types for accounts page layout
				// Bank/Trust Firm
				try {

					/*click(locateElement("xpath", "//span[text() = 'Accounts']"));*/
					driver.get("https://manuliferetirement--mfcnaretst.lightning.force.com/lightning/o/Account/list?filterName=Recent");
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
								"RPS External fields are displayed for Account record type 'Bank/Trust Firm'",
								"pass", takeSnap(getTitle()));
					} else {
						reportStep(
								"RPS External fields are not displayed for Account record type 'Bank/Trust Firm'",
								"fail", takeSnap(getTitle()));
					}
				} catch (Exception e) {
					reportStep(
							"Failed to display the RPS external fields for Account record type 'Bank/Trust Firm'",
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
								"RPS External fields are displayed for Account record type 'Bank/Trust Firm'",
								"pass", takeSnap(getTitle()));
					} else {
						reportStep(
								"RPS External fields are not displayed for Account record type 'Bank/Trust Firm'",
								"fail", takeSnap(getTitle()));
					}
				} catch (Exception e) {
					reportStep(
							"Failed to display the RPS external fields for Account record type 'Bank/Trust Firm'",
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
								"RPS External fields are displayed for Account record type 'Bank/Trust Firm'",
								"pass", takeSnap(getTitle()));
					} else {
						reportStep(
								"RPS External fields are not displayed for Account record type 'Bank/Trust Firm'",
								"fail", takeSnap(getTitle()));
					}
				} catch (Exception e) {
					reportStep(
							"Failed to display the RPS external fields for Account record type 'Bank/Trust Firm'",
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

					/*JavascriptExecutor je = (JavascriptExecutor) driver;

					WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
					je.executeScript("arguments[0].scrollIntoView(true);", accountphone);*/

					if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
						reportStep(
								"RPS External fields are displayed for Account record type 'Broker/Dealer Firm'",
								"pass", takeSnap(getTitle()));
					} else {
						reportStep(
								"RPS External fields are not displayed for Account record type 'Broker/Dealer Firm'",
								"fail", takeSnap(getTitle()));
					}
				} catch (Exception e) {
					reportStep(
							"Failed to display the RPS external fields for Account record type 'Broker/Dealer Firm'",
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

					/*JavascriptExecutor je = (JavascriptExecutor) driver;

					WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
					je.executeScript("arguments[0].scrollIntoView(true);", accountphone);*/

					if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
						reportStep(
								"RPS External fields are displayed for Account record type 'TPA Branch Firm'",
								"pass", takeSnap(getTitle()));
					} else {
						reportStep(
								"RPS External fields are not displayed for Account record type 'TPA Branch Firm'",
								"fail", takeSnap(getTitle()));
					}
				} catch (Exception e) {
					reportStep(
							"Failed to display the RPS external fields for Account record type 'TPA Branch Firm'",
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

					/*JavascriptExecutor je = (JavascriptExecutor) driver;

					WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
					je.executeScript("arguments[0].scrollIntoView(true);", accountphone);*/

					if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
						reportStep(
								"RPS External fields are displayed for Account record type 'Fund Partner'",
								"pass", takeSnap(getTitle()));
					} else {
						reportStep(
								"RPS External fields are not displayed for Account record type 'Fund Partner'",
								"fail", takeSnap(getTitle()));
					}
				} catch (Exception e) {
					reportStep(
							"Failed to display the RPS external fields for Account record type 'Fund Partner'",
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

					/*JavascriptExecutor je = (JavascriptExecutor) driver;

					WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
					je.executeScript("arguments[0].scrollIntoView(true);", accountphone);*/

					if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
						reportStep(
								"RPS External fields are displayed for Account record type 'Plan Sponsor'",
								"pass", takeSnap(getTitle()));
					} else {
						reportStep(
								"RPS External fields are not displayed for Account record type 'Plan Sponsor'",
								"fail", takeSnap(getTitle()));
					}
				} catch (Exception e) {
					reportStep(
							"Failed to display the RPS external fields for Account record type 'Plan Sponsor'",
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

					/*JavascriptExecutor je = (JavascriptExecutor) driver;

					WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
					je.executeScript("arguments[0].scrollIntoView(true);", accountphone);*/

					if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
						reportStep(
								"RPS External fields are displayed for Account record type 'TPA Firm'",
								"pass", takeSnap(getTitle()));
					} else {
						reportStep(
								"RPS External fields are not displayed for Account record type 'TPA Firm'",
								"fail", takeSnap(getTitle()));
					}
				} catch (Exception e) {
					reportStep(
							"Failed to display the RPS external fields for Account record type 'TPA Firm'",
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

					/*JavascriptExecutor je = (JavascriptExecutor) driver;

					WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
					je.executeScript("arguments[0].scrollIntoView(true);", accountphone);*/

					if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
						reportStep(
								"RPS External fields are displayed for Account record type 'Business Firm'",
								"pass", takeSnap(getTitle()));
					} else {
						reportStep(
								"RPS External fields are not displayed for Account record type 'Business Firm'",
								"fail", takeSnap(getTitle()));
					}
				} catch (Exception e) {
					reportStep(
							"Failed to display the RPS external fields for Account record type 'Business Firm'",
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

					/*JavascriptExecutor je = (JavascriptExecutor) driver;

					WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
					je.executeScript("arguments[0].scrollIntoView(true);", accountphone);*/

					if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
						reportStep(
								"RPS External fields are displayed for Account record type 'Generic Business firm Firm'",
								"pass", takeSnap(getTitle()));
					} else {
						reportStep(
								"RPS External fields are not displayed for Account record type 'Generic Business firmFirm'",
								"fail", takeSnap(getTitle()));
					}
				} catch (Exception e) {
					reportStep(
							"Failed to display the RPS external fields for Account record type 'Generic Business firm Firm'",
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

					/*JavascriptExecutor je = (JavascriptExecutor) driver;

					WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
					je.executeScript("arguments[0].scrollIntoView(true);", accountphone);*/

					if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
						reportStep(
								"RPS External fields are displayed for Account record type 'Independent Producer Firm Firm'",
								"pass", takeSnap(getTitle()));
					} else {
						reportStep(
								"RPS External fields are not displayed for Account record type 'Independent Producer FirmFirm'",
								"fail", takeSnap(getTitle()));
					}
				} catch (Exception e) {
					reportStep(
							"Failed to display the RPS external fields for Account record type 'Independent Producer Firm Firm'",
							"fail", takeSnap(getTitle()));
					e.printStackTrace();
				}
				
				
				//Verify the RPS fields for contact record type - Business Contact
				try {
					/*driver.navigate().back();*/
					driver.get("https://manuliferetirement--mfcnaretst.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
					Thread.sleep(20000);
					/*click(locateElement("xpath", "(//a[text() = 'American Compensation Service'])[1]"));
					Thread.sleep(20000);*/

					/*JavascriptExecutor je = (JavascriptExecutor) driver;

					WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
					je.executeScript("arguments[0].scrollIntoView(true);", accountphone);*/

					if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
						reportStep(
								"RPS External fields are displayed for Contact record type 'Business Contact'",
								"pass", takeSnap(getTitle()));
					} else {
						reportStep(
								"RPS External fields are not displayed for Contact record type 'Business Contact'",
								"fail", takeSnap(getTitle()));
					}
				} catch (Exception e) {
					reportStep(
							"Failed to display the RPS external fields for Contact record type 'Business Contact'",
							"fail", takeSnap(getTitle()));
					e.printStackTrace();
				}
				
				//Verify the RPS fields for Contact record type - Advisor
				try {
					driver.navigate().back();
					/*click(locateElement("xpath", "//span[text() = 'Contacts'][1]"));
					Thread.sleep(20000);*/
					/*click(locateElement("xpath", "(//a[text() = 'American Compensation Service'])[1]"));
					

					/*JavascriptExecutor je = (JavascriptExecutor) driver;

					WebElement accountphone = driver.findElement(By.xpath("//label[text() = 'Account Phone']"));
					je.executeScript("arguments[0].scrollIntoView(true);", accountphone);*/
					Thread.sleep(20000);
					if (locateElement("xpath", "(//span[text() = 'Accounts'])[1]").isDisplayed()) {
						reportStep(
								"RPS External fields are displayed for Contact record type 'Advisor'",
								"pass", takeSnap(getTitle()));
					} else {
						reportStep(
								"RPS External fields are not displayed for Contact record type 'Advisor'",
								"fail", takeSnap(getTitle()));
					}
				} catch (Exception e) {
					reportStep(
							"Failed to display the RPS external fields for Contact record type 'Advisor'",
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
