package GPSOTest;

import java.io.IOException;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import salesForceWebPages.AppLauncherPage;
import salesForceWebPages.CasesPage;
import salesForceWebPages.HomePage;
import salesForceWebPages.LightningCommonPage;
import salesForceWebPages.PlansPage;
import test.Sel.CommonMethods;
import test.Sel.Project;



public class GPSOT_1330 extends Project {

	CommonMethods method = new CommonMethods();
	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_1330";
		testCaseDesc = "Account Compact Layout";
		category = "GPSOTest";
		author = "Supriya Subramanya";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_1330_Test(Map<String, String> details) throws InterruptedException, IOException {


		// Step 1 : Log into the application

		try {

			//driver.findElement(By.xpath("(//span[text()='NASITAzureSSO'])[1]")).click();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if (locateElement("xpath", "//span[text()=' Sandbox: MFCNARETST']").isDisplayed()) {
				reportStep("Login Successful", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Login not Successful", "pass", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Login not Successful", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}
		
		//Navigating Accounts
		try {
			waitPageLoading();
			
			click(locateElement("xpath", "//button[@title='Show Navigation Menu']//span[text()='Show Navigation Menu']"));
			click(locateElement("xpath", "//div[@class='slds-media slds-listbox__option slds-listbox__option_entity slds-p-around_none']//a[@title='Accounts']"));
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
				reportStep("Accounts Page is displayed", "pass", takeSnap(getTitle()));
			

		} catch (Exception e) {
			reportStep("Failed to display the Accounts Page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

				
		//open any of the existing account

		try {
			waitPageLoading();

						
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			click(locateElement("xpath", "//button[@title='Select List View']"));
			locateElement("xpath", "//input[@class='slds-input default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input']").sendKeys("All Plan Sponsor Accounts");
			click(locateElement("linkText", "All Plan Sponsor Accounts"));
			driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Best Formulations Inc.");
			driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys(Keys.ENTER);
			click(locateElement("xpath", "//a[@title='Best Formulations Inc.']"));
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			locateElement("xpath", "//p[text()='Account Owner']");
			
			
			reportStep("Account compact panel displayed", "pass", takeSnap(getTitle()));
		

	} catch (Exception e) {
		reportStep("Failed to display account Account Compact panel", "fail", takeSnap(getTitle()));
		e.printStackTrace();
	}
		
		
		
		
	}
}
