package GPSOTest;

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

import salesForceWebPages.AccountsPage;
import salesForceWebPages.AppLauncherPage;
import salesForceWebPages.CasesPage;
import salesForceWebPages.HomePage;
import salesForceWebPages.LightningCommonPage;
import salesForceWebPages.PlansPage;
import test.Sel.Project;

public class GPSOT_641 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_641";
		testCaseDesc = "Initial Project Setup: Create Account Object Record Types and Page Layouts in Salesforce";
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
		
		
		// Step 2: click on accounts tab and navigate to accounts records type page

		try {

			new HomePage(driver).click_accounts_tab().click_on_new();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
				reportStep("Navigated to Accounts records page", "pass", takeSnap(getTitle()));
		} catch (Exception e) {
			reportStep("Accounts records are unable to displayed", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}
		
		
		//Step 3: Validate all the account record types are displayed
		try {
			if (locateElement("xpath", "//span[text()='Plan Sponsor']").isDisplayed() &&
					locateElement("xpath", "//span[text()='Plan Sponsor']").isDisplayed() &&
					locateElement("xpath", "//span[text()='Bank/Trust Firm']").isDisplayed() &&
					locateElement("xpath", "//span[text()='Branch Firm']").isDisplayed() &&
					locateElement("xpath", "//span[text()='Broker/Dealer Firm']").isDisplayed() &&
					locateElement("xpath", "//span[text()='Fund Partner']").isDisplayed() &&
					locateElement("xpath", "//span[text()='Generic Business Firm']").isDisplayed() &&
					locateElement("xpath", "//span[text()='Independent Producer Firm']").isDisplayed() &&
					locateElement("xpath", "//span[text()='National Account']").isDisplayed() &&
					locateElement("xpath", "//span[text()='RIA Firm']").isDisplayed() &&
					locateElement("xpath", "//span[text()='TPA Firm']").isDisplayed() 
					
					
					) {
				reportStep("All the record types are available", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("All the record types are available", "pass",
						takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display Account record type", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}
		
		
		
		//Step 4: Select account record type
		try {

			new AccountsPage(driver).select_record_type();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
				reportStep("Succesfully created new case", "pass", takeSnap(getTitle()));
		} catch (Exception e) {
			reportStep("Unable to create new case", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}
		
		
		//Step 5: Enter account info
				try {
					
					new AccountsPage(driver).enter_account_information("Ivy Finance");
					waitPageLoading();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
						reportStep("Account created successfully", "pass", takeSnap(getTitle()));
				} catch (Exception e) {
					reportStep("Unable to create account", "fail", takeSnap(getTitle()));
					e.printStackTrace();

				}

		
		
		
		
	}
}
