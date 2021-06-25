package GPSOTest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.Sel.Project;

public class GPSOT_20 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_20";
		testCaseDesc = "Onboarding Manager Project Page";
		category = "GPSOTest";
		author = "Suraj";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_20_Test(Map<String, String> details) throws InterruptedException, IOException {

		// Step 2 : Log into the application

		try {

			type(locateElement("id", "username"), "suraj_malnad@jhancock.com.mfcnaretdv");
			type(locateElement("id", "password"), "Copado@1526");
			click(locateElement("id", "Login"));
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

		// Step 3 : Verify the Onboarding Manager Project Page

		try {
			click(locateElement("linkText", "00001006"));

			if (locateElement("xpath", "//div[text() = 'Project']").isDisplayed()) {
				reportStep("Onboarding Manager Project Page is displayed home page", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Onboarding Manager Project Page is not displayed", "fail", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Onboarding Manager Project Page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 4 : Verify the Assistant in the Onboarding Manager Project Page
		try {
			if (locateElement("xpath", "//span[text() = 'Assistant']").isDisplayed()) {
				reportStep("Assistant is displayed in the Onboarding home page", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Assistant is not displayed in the Onboarding home page", "fail",
						takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Assistant in the Onboarding home page", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 5 : Verify the Activity in the Onboarding Manager Project Page
		try {
			if (locateElement("xpath", "//span[text() = 'Activity']").isDisplayed()) {
				reportStep("Activity is displayed in the Onboarding home page", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Activity is not displayed in the Onboarding home page", "fail", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Activity in the Onboarding home page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 6 : Verify the Chatter in the Onboarding Manager Project Page
		try {
			if (locateElement("xpath", "//span[text() = 'Chatter']").isDisplayed()) {
				reportStep("Chatter is displayed in the Onboarding home page", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Chatter is not displayed in the Onboarding home page", "fail", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Chatter in the Onboarding home page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 7 : Logout of the application

		try {
			click(locateElement("xpath", "(//span[@class = 'uiImage'])[1]"));
			click(locateElement("linkText", "Log Out"));

			if (locateElement("id", "Login").isDisplayed()) {

				reportStep("Application is logged out successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Application is not logged out successfully", "fail", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to log out of the application and display the login page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

	}
}
