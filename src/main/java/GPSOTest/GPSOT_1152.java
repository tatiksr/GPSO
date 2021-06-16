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

public class GPSOT_1152 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_1152";
		testCaseDesc = "Contact List View";
		category = "GPSOTest";
		author = "Supriya Subramanya";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GGPSOT_1152_Test(Map<String, String> details) throws InterruptedException, IOException {

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
		
		
		
		//Navigating to App Launcher
		try {
			waitPageLoading();
			driver.findElement(By.xpath("//button[@class='slds-button slds-show']")).sendKeys(Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Contacts");
			click(locateElement("xpath", "//span/p/b[text()='Contacts']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
				reportStep("Contacts Page is displayed", "pass", takeSnap(getTitle()));
			

		} catch (Exception e) {
			reportStep("Failed to display the Accounts Page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}


		
		
				//Step 3: Click on the list views and verify the column headers
				try {
					
					click(locateElement("xpath", "//button[@title='Select List View']"));				
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					locateElement("xpath", "//ul[@class='slds-dropdown__list slds-show']/li[2]");
					locateElement("xpath", "//ul[@class='slds-dropdown__list slds-show']/li[3]");
					locateElement("xpath", "//ul[@class='slds-dropdown__list slds-show']/li[4]");
					locateElement("xpath", "//ul[@class='slds-dropdown__list slds-show']/li[5]");
					
					
					
					
					
						reportStep("All 2 List Views are available", "pass", takeSnap(getTitle()));
				} catch (Exception e) {
					reportStep("List Views are missing", "fail", takeSnap(getTitle()));
					e.printStackTrace();

				}
				
				//Step 3: Click on the list views and verify the column headers
				try {
					
					click(locateElement("xpath", "//button[@title='Select List View']"));				
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					click(locateElement("xpath", "//ul[@class='slds-dropdown__list slds-show']/li[2]"));
		
					
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					locateElement("xpath", "//span[@title='Name']");
					locateElement("xpath", "//span[@title='Account Name']");
					locateElement("xpath", "//span[@title='Contact Owner Alias']");
					locateElement("xpath", "//span[@title='Contact Record Type']");
					
				
					
						reportStep("All 11 List Views are available", "pass", takeSnap(getTitle()));
				} catch (Exception e) {
					reportStep("List Views are missing", "fail", takeSnap(getTitle()));
					e.printStackTrace();

				}
		
				//Click on filter
				try {
					waitPageLoading();
					
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					click(locateElement("xpath", "//lightning-button-icon-stateful[@class='listViewManagerHeaderButton filterButton']//button[@title='Show filters']"));
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					locateElement("xpath", "//span[text()='My contacts']");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					
						reportStep("Filter condition is shown", "pass", takeSnap(getTitle()));
					

				} catch (Exception e) {
					reportStep("Failed to apply filter", "fail", takeSnap(getTitle()));
					e.printStackTrace();
				}
		
		
		
	}
}
