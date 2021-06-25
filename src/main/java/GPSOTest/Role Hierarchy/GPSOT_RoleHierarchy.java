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

import test.Sel.Project;

public class GPSOT_RoleHierarchy extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_RoleHierarchy";
		testCaseDesc = "Onboarding Manager Home Page";
		category = "GPSOTest";
		author = "Suraj";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_RoleHierarchy_Test(Map<String, String> details) throws InterruptedException, IOException {

		// Step 1 : Log into the application

		try {
			waitPageLoading();
			waitPageLoading();
			//click(locateElement("name", "setup"));

			/*
			 * type(locateElement("id", "username"),
			 * "suraj_malnad@jhancock.com.mfcnaretdv"); type(locateElement("id",
			 * "password"), "Copado@1526"); click(locateElement("id", "Login"));
			 * waitPageLoading(); driver.manage().timeouts().implicitlyWait(30,
			 * TimeUnit.SECONDS);
			 */

			if (locateElement("xpath", "//input[@name = 'new']").isDisplayed()) {
				reportStep("User roles page is displayed successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("User roles page is not displayed successfully", "fail", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display user roles page", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 2 : Verify the Upper Level Role Hierarchy

		try {
			if (locateElement("linkText", "US Onboarding").isDisplayed()) {
				reportStep("Upper Level Role Hierarchy is displayed", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Upper Level Role Hierarchy is not displayed", "fail",
						takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Upper Level Role Hierarchy", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

		

		// Step 3 : Verify the Role Hierarchy for Plan Implementation Manager

		try {
			if (locateElement("linkText", "PIM Manager").isDisplayed()) {
				reportStep("Role Hierarchy for Plan Implementation Manager is displayed", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Role Hierarchy for Plan Implementation Manager is not displayed", "fail",
						takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Role Hierarchy for Plan Implementation Manager", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 4 : Verify the Role Hierarchy for DB & DC Administration (Support) Role
		// Hierarchy

		try {
			if (locateElement("linkText", "DB Technical Support Manager").isDisplayed()) {
				reportStep("Role Hierarchy for DB & DC Administration (Support) Role is displayed", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Role Hierarchy for DB & DC Administration (Support) Role is not displayed", "fail",
						takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Role Hierarchy for DB & DC Administration (Support) Role", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 5 : Verify the Role Hierarchy for PSC Hierarchy

		try {
			if (locateElement("linkText", "PSC Manager").isDisplayed()) {
				reportStep("Role Hierarchy for PSC Hierarchy is displayed", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Role Hierarchy for PSC Hierarchy is not displayed", "fail",
						takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Role Hierarchy for PSC Hierarchy", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 6 : Verify the Role Hierarchy for Platform Development (Investments)
		// Hierarchy

		try {
			if (locateElement("linkText", "Investment Services Analyst").isDisplayed()) {
				
				reportStep("Role Hierarchy for Platform Development (Investments) Hierarchy is displayed", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Role Hierarchy for Platform Development (Investments) Hierarchy is not displayed", "fail",
						takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Role Hierarchy for Platform Development (Investments) Hierarchy", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 7 : Verify the Role Hierarchy for Erisa Hierarchy

		try {
			if (locateElement("linkText", "ERISA DB Consultant").isDisplayed()) {
				
				reportStep("Role Hierarchy for Erisa Hierarchy is displayed", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Role Hierarchy for Erisa Hierarchy is not displayed", "fail",
						takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Role Hierarchy for Erisa Hierarchy", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 8 : Verify the Role Hierarchy for Trust and Relationship Management Role

		try {
			if (locateElement("linkText", "VP of Data Intelligence").isDisplayed()) {
				
				reportStep("Role Hierarchy for Trust and Relationship Management Role is displayed", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Role Hierarchy for Trust and Relationship Management Role is not displayed", "fail",
						takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Role Hierarchy for Trust and Relationship Management Role", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

	}
}
