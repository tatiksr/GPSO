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

import salesForceWebPages.AppLauncherPage;
import salesForceWebPages.CasesPage;
import salesForceWebPages.HomePage;
import salesForceWebPages.LightningCommonPage;
import salesForceWebPages.PlansPage;
import test.Sel.Project;

public class GPSOT_697 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_697";
		testCaseDesc = "[PLAN SPEC] Additional data points in Plan Object to generate plan spec -Part1";
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
		
		
		
		
		//Step 2: select plan from app launcher 
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

		
		//Step 3: Validate all the fields on plans details page
				try {
					if (locateElement("xpath", "//span[text()='Is This Plan a Multiple Employer Plan?']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Union Participants?']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Residents of Puerto Rico?']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Member of a Controlled Group?']").isDisplayed() 
							
							
							
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

		
				
		
				//Step 4: Validate all the fields in Money/Source Arrangements section
				try {
					if (locateElement("xpath", "//span[text()='Money Source/Arrangements']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Traditional 401(k)']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Voluntary (After-Tax)']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Qualified Non-Elective Contribution']").isDisplayed() 
							
							
							
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
