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

import test.Sel.Project;

public class GPSOT_30 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_30";
		testCaseDesc = "Plan Support Manager Project Page";
		category = "GPSOTest";
		author = "Suraj";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_30_Test(Map<String, String> details) throws InterruptedException, IOException {

		// Step 2 : Log into the application

		try {

			/*
			 * type(locateElement("id", "username"),
			 * "suraj_malnad@jhancock.com.mfcnaretdv");
			 */
			type(locateElement("id", "username"), "suraj_malnad@jhancock.com.mfcnaretst");
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

		try {

			// CLICK 'SETUP' ICON
			/*
			 * click(locateElement("xpath",
			 * "(//div[@class ='headerTrigger  tooltip-trigger uiTooltip'])[2]"));
			 */
			/* click(locateElement("id", "75:237;a")); */
			WebElement element = driver
					.findElement(By.xpath("(//div[@class ='headerTrigger  tooltip-trigger uiTooltip'])[2]"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			/*
			 * waitPageLoading(); driver.manage().timeouts().implicitlyWait(5,
			 * TimeUnit.SECONDS);
			 */

			// CLICK 'SETUP' OPTION
			/*
			 * WebElement elementsetup =
			 * driver.findElement(By.xpath("//a[text()= 'Setup']")); JavascriptExecutor
			 * executorsetup = (JavascriptExecutor)driver;
			 * executor.executeScript("arguments[0].click();", elementsetup);
			 */
			/*
			 * click(locateElement("xpath",
			 * "/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[7]/one-app-nav-bar-item-dropdown/div/one-app-nav-bar-menu-button"
			 * ));
			 */
			/* click(locateElement("linkText", "Setup")); */
			/*
			 * Actions action = new Actions(driver);
			 * action.sendKeys(Keys.ARROW_DOWN).build().perform();
			 * action.sendKeys(Keys.ENTER).build().perform();
			 */
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			/* switchToWindow(1); */
			/*
			 * driver.switchTo().window(
			 * "https://manuliferetirement--mfcnaretst.lightning.force.com/lightning/setup/SetupOneHome/home"
			 * );
			 */
			/*
			 * ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			 * driver.switchTo().window(tab.get(1));
			 */
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			// CLICK 'USERS'
			click(locateElement("linkText", "Users"));

			// CLICK 'PROFILES'
			click(locateElement("id", "Profiles"));

			// CLICK 'PLAN SUPPORT MANAGER'
			click(locateElement("id", "Plan Support Manager"));

			// CLICK 'VIEW USERS'
			click(locateElement("name", "users"));

			// CLICK 'LOGIN'
			click(locateElement("xpath", "//a[text() = 'Login']"));
			if (locateElement("xpath", "//span[text() = 'Home']").isDisplayed()) {
				reportStep("Login Successful as Plan Support Manager", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Login not Successful as Plan Support Manager", "pass", takeSnap(getTitle()));
			}

			click(locateElement("xpath", "//span[text() = 'Home']"));

		} catch (Exception e) {
			reportStep("Login not Successful as Plan Spport Manager", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		// Step 2 : Verify the Key alert display bar in the Plan Support Manager Project Page

		try {
			if (locateElement("xpath", "//span[text() = 'App Launcher']").isDisplayed()) {
				reportStep("Key alert display bar is displayed in the Onboarding home page", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Key alert display bar is not displayed in the Onboarding home page", "pass",
						takeSnap(getTitle()));
			}
			// CLICK 'APP LAUNCHER'
			click(locateElement("xpath", "//span[text() = 'App Launcher']"));
			// ENTER'WEALTH MANAGEMENT' IN THE SEARCH
			type(locateElement("(//input[@class = 'slds-input'])[2]"), "Wealth Management");

			// CLICK 'WEALTH MANAGEMENT'
			click(locateElement("xpath", "(//*[text() = 'Wealth Management'])[4]"));

		} catch (Exception e) {
			reportStep("Failed to display the Key alert display bar in the Onboarding home page", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 3 : Verify the Task - list view in the Plan Support Manager Project Page

		try {
			if (locateElement("linkText", "All Tasks").isDisplayed()
					&& locateElement("xpath", "//span[text() = 'Assigned To']").isDisplayed()) {
				reportStep("Task - list view is displayed in the Onboarding home page", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Task - list view is not displayed in the Onboarding home page", "pass",
						takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Task - list view in the Onboarding home page", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 4 : Verify the Plan Support Manager Project Page

		try {
			click(locateElement("linkText", "00001007"));

			if (locateElement("xpath", "//div[text() = 'Project']").isDisplayed()) {
				reportStep("Onboarding Manager Project Page is displayed home page", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Onboarding Manager Project Page is not displayed", "fail", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Onboarding Manager Project Page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 5 : Verify the Project - list view in the Plan Support Manager Project Page

		try {
			if (locateElement("xpath", "//span[text() = 'Projects']").isDisplayed()
					&& locateElement("xpath", "//span[text() = 'Project Name']").isDisplayed()) {
				reportStep("Project - list view is displayed in the Onboarding home page", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Project - list view is not displayed in the Onboarding home page", "pass",
						takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Project - list view in the Onboarding home page", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 6 : Verify the Activity in the Plan Support Manager Project Page

		try {
			if (locateElement("xpath", "//span[text() = 'Activity']").isDisplayed()) {
				reportStep("Activity is displayed in the Onboarding home page", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Activity is not displayed in the Onboarding home page", "pass", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Activity in the Onboarding home page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 7 : Verify the Chatter in the Plan Support Manager Project Page

		try {
			if (locateElement("xpath", "//span[text() = 'Chatter']").isDisplayed()) {
				reportStep("Chatter is displayed in the Onboarding home page", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Chatter is not displayed in the Onboarding home page", "pass", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Chatter in the Onboarding home page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 8 : Logout of the application

		try {
			click(locateElement("xpath", "(//span[@class = 'uiImage'])[1]"));
			click(locateElement("linkText", "Log Out"));

			if (locateElement("id", "Login").isDisplayed()) {

				reportStep("Application is logged out successfully", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Application is not logged out successfully", "pass", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to log out of the application and display the login page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

	}
}
