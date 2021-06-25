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

public class GPSOT_732 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_732";
		testCaseDesc = "Additional fields to Project Object - Proposals, Rec Keeper, Other Plan Details";
		category = "GPSOTest";
		author = "Suraj";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_732_Test(Map<String, String> details) throws InterruptedException, IOException {

		// Step 1 : Log into the application

		/*try {
			waitPageLoading();
			waitPageLoading();*/
			//click(locateElement("name", "setup"));
			
			

			/*
			 * type(locateElement("id", "username"),
			 * "suraj_malnad@jhancock.com.mfcnaretdv"); type(locateElement("id",
			 * "password"), "Copado@1526"); click(locateElement("id", "Login"));
			 * waitPageLoading(); driver.manage().timeouts().implicitlyWait(30,
			 * TimeUnit.SECONDS);
			 */

			/*if (locateElement("xpath", "//input[@name = 'new']").isDisplayed()) {
				reportStep("User roles page is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("User roles page is not displayed successfully", "fail", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display user roles page", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}*/

		// Step 2 : Navigating to 'Projects in the app launcher
		/*waitPageLoading();
		waitPageLoading();
		try {

			new AppLauncherPage(driver).search_app("Cases");
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
				reportStep("Succesfully navigated to cases page", "pass", takeSnap(getTitle()));
		} catch (Exception e) {
			reportStep("Unable to open case page", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}*/
		

		// Step 3 : Verify the display of the 'New Project' creation page
		try {
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		click(locateElement("xpath", "//div[text() = 'New']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (locateElement("xpath", "//h2[text()='New Case: Project']").isDisplayed()) {
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			reportStep("New Project creation page is displayed successfully", "pass", takeSnap(getTitle()));
		} else {
			reportStep("New Project creation page is not displayed successfully", "fail", takeSnap(getTitle()));
		}
	}
		catch (Exception e) {
			reportStep("Failed to display Project creation page", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}
		
		// Step 4 : Verify the display of the 'Proposal Detail' section
				try {
					waitPageLoading();
					waitPageLoading();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					JavascriptExecutor je = (JavascriptExecutor) driver;
					WebElement proposaldetails = driver.findElement(By.xpath("//span[text()='Proposal Details']"));
					je.executeScript("arguments[0].scrollIntoView(true);",proposaldetails);
				
				if (locateElement("xpath", "//span[text()='Proposal Details']").isDisplayed()) {
					reportStep("Proposal Details section is displayed successfully", "pass", takeSnap(getTitle()));
				} else {
					reportStep("Proposal Details section is not displayed successfully", "fail", takeSnap(getTitle()));
				}
			}
				catch (Exception e) {
					reportStep("Failed to display Project creation page", "fail", takeSnap(getTitle()));
					e.printStackTrace();
				}
				
				// Step 5 : Verify the display of the 'Payroll' in 'Plan Information' section
				try {
					waitPageLoading();
					waitPageLoading();
					JavascriptExecutor je = (JavascriptExecutor) driver;
					WebElement payroll = driver.findElement(By.xpath("//span[text()='Payroll Vendor Contact']"));
					je.executeScript("arguments[0].scrollIntoView(true);",payroll);
				
				if (locateElement("xpath", "//span[text()='Payroll Vendor Contact']").isDisplayed()) {
					reportStep("Payroll in Plan Information Section is displayed successfully", "pass", takeSnap(getTitle()));
				} else {
					reportStep("Payroll in Plan Information Section is not displayed successfully", "fail", takeSnap(getTitle()));
				}
			}
				catch (Exception e) {
					reportStep("Failed to display Payroll in Plan Information Section", "fail", takeSnap(getTitle()));
					e.printStackTrace();
				}
				
				// Step 6 : Verify the display of the 'Prior Record Keeper' section
				try {
					waitPageLoading();
					waitPageLoading();
					JavascriptExecutor je = (JavascriptExecutor) driver;
					WebElement priorreckeeper = driver.findElement(By.xpath("//span[text()='Prior Recordkeeper']"));
					je.executeScript("arguments[0].scrollIntoView(true);",priorreckeeper);
				
				if (locateElement("xpath", "//span[text()='Prior Recordkeeper']").isDisplayed()) {
					reportStep("'Prior Record Keeper' section is displayed successfully", "pass", takeSnap(getTitle()));
				} else {
					reportStep("'Prior Record Keeper' section is not displayed successfully", "fail", takeSnap(getTitle()));
				}
			}
				catch (Exception e) {
					reportStep("Failed to display 'Prior Record Keeper' section", "fail", takeSnap(getTitle()));
					e.printStackTrace();
				}
				
				// Step 7 : Verify the display of the 'Optional Plan Services' Section
				try {
					waitPageLoading();
					waitPageLoading();
					JavascriptExecutor je = (JavascriptExecutor) driver;
					WebElement optionalplan = driver.findElement(By.xpath("//span[text()='Optional Plan Services']"));
					je.executeScript("arguments[0].scrollIntoView(true);",optionalplan);
				
				if (locateElement("xpath", "//span[text()='Optional Plan Services']").isDisplayed()) {
					reportStep("Optional Plan Services is displayed successfully", "pass", takeSnap(getTitle()));
				} else {
					reportStep("Optional Plan Services is not displayed successfully", "fail", takeSnap(getTitle()));
				}
			}
				catch (Exception e) {
					reportStep("Failed to display Optional Plan Services", "fail", takeSnap(getTitle()));
					e.printStackTrace();
				}

				
	
		
		
		

		

	}
}
