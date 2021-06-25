/*package GPSOTest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import salesForceWebPages.AppLauncherPage;
import salesForceWebPages.CasesPage;
import salesForceWebPages.HomePage;
import salesForceWebPages.LightningCommonPage;
import salesForceWebPages.PlansPage;
import test.Sel.Project;

public class GPSOT_418 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_418";
		testCaseDesc = "Initial Project Setup: Create Plan object in Salesforce as part of the 'shell'";
		category = "GPSOTest";
		author = "Supriya Subramanya";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_368_Test(Map<String, String> details) throws InterruptedException, IOException {

		// Step 1 : Log into the application

		try {

			//driver.findElement(By.xpath("(//span[text()='NASITAzureSSO'])[1]")).click();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if (locateElement("xpath", "//span[text() = 'Home']").isDisplayed()) {
				reportStep("Login Successful", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Login not Successful", "pass", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Login not Successful", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}
		
		
		// Step 2: Navigating to Cases through app launcher

		try {

			new AppLauncherPage(driver).search_app("Cases");
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
				reportStep("Succesfully navigated to cases page", "pass", takeSnap(getTitle()));
		} catch (Exception e) {
			reportStep("Unable to open case page", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}
		
		
		//Step 3: Creating a new case
		try {

			new CasesPage(driver).click_on_new().enter_case_details();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
				reportStep("Succesfully created new case", "pass", takeSnap(getTitle()));
		} catch (Exception e) {
			reportStep("Unable to create new case", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}
		
		
		//Step 4: select plan from app launcher 
				try {
					
					new AppLauncherPage(driver).search_app1();
					waitPageLoading();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
					new PlansPage(driver).click_plan();
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					
						reportStep("Navigated to plans page successfully", "pass", takeSnap(getTitle()));
				} catch (Exception e) {
					reportStep("Unable to navigate to plans page", "fail", takeSnap(getTitle()));
					e.printStackTrace();

				}

		
		//Step 5: Validate all the fields on plans details page
				try {
					if (locateElement("xpath", "//span[text()='Actual Go Live Date']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Asset Transfer Date']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Blackout Date']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Date Of MVR Fronting']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Participant Count']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Expected Annual Deposits']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Expected Go Live Date']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Final Expected']").isDisplayed() &&
							locateElement("xpath", "//span[text()='First Payroll Expected']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Plan Year Effective Date']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Plan Year End (MM/DD)']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Handoff']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Internal Transfer Indicator']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Liquidation Date']").isDisplayed() &&
							locateElement("xpath", "//span[text()='LOU/FDL receipt']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Plan Code']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Plan Legal Name']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Plan Name']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Plan Status']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Plan Type']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Plan Sub-Type']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Prelim Expected']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Project Close Date']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Project Start Date']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Refresh Expected']").isDisplayed() &&
							locateElement("xpath", "//span[text()='SOX End Date']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Transition Kit Mailing Date']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Client ID']").isDisplayed() 
							
							
							) {
						reportStep("All the fields are displaying in the Plans details page", "pass",
								takeSnap(getTitle()));
					} else {
						reportStep("All the fields are displaying in the Plans details page", "pass",
								takeSnap(getTitle()));
					}

				} catch (Exception e) {
					reportStep("Failed to display field in the Plans detailspage", "fail",
							takeSnap(getTitle()));
					e.printStackTrace();
				}

		
				
		
	
		
		
		
		
		
	}
}
*/