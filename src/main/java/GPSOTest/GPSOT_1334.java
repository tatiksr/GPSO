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



public class GPSOT_1334 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_1334";
		testCaseDesc = "SF - Contact Search Layout";
		category = "GPSOTest";
		author = "Supriya";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_1334_Test(Map<String, String> details) throws InterruptedException, IOException {

		// Step 2 : Log into the application

		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
						
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			type(locateElement("xpath", "//input[@title='Search...']"), "David Abeles");
			driver.findElement(By.xpath("//input[@title='Search...']")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			
			reportStep("Login is Successful", "pass", takeSnap(getTitle()));
		} catch (Exception e) {
			reportStep("Login not Successful", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}



		//  Search contact list

		try {
			
			locateElement("xpath", "//a[@class='toggle slds-th__action slds-text-link--reset ']//span[text()='Name']").isDisplayed();	
			locateElement("xpath", "(//span[text()='Account Name'])[1]").isDisplayed();		
			locateElement("xpath", "//span[text()='Contact Owner Alias']").isDisplayed();
			locateElement("xpath", "//span[text()='Contact Record Type']").isDisplayed();				
			
			
			
				reportStep("Fields are displayed ", "pass", takeSnap(getTitle()));
			

		} catch (Exception e) {
			reportStep("Failed to display the Fields", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}
	
		
		//  Logout of the application
	try {
		WebElement profile= driver.findElement(By.xpath("//span[@class ='photoContainer forceSocialPhoto']"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", profile);
			//click(locateElement("xpath", "(//span[@class = 'uiImage'])[1]"));
			click(locateElement("linkText", "Log Out"));
			reportStep("Application is logged out successfully", "pass", takeSnap(getTitle()));
			
		} catch (Exception e) {
			reportStep("Failed to log out of the application and display the login page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

	}
	}




