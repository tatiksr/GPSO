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
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import salesForceWebPages.AppLauncherPage;
import salesForceWebPages.CasesPage;
import salesForceWebPages.HomePage;
import salesForceWebPages.LightningCommonPage;
import salesForceWebPages.PlansPage;
import test.Sel.CommonMethods;
import test.Sel.Project;



public class GPSOT_1012 extends Project {

	CommonMethods method = new CommonMethods();
	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_1012";
		testCaseDesc = "Initial Project Setup: RPS Account Fields in Onboarding Org (RIA Firm Record Type) in Salesforce";
		category = "GPSOTest";
		author = "Supriya Subramanya";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_1012_Test(Map<String, String> details) throws InterruptedException, IOException {

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
		
		
		//Navigating to Sales app
		try {
			waitPageLoading();
			driver.findElement(By.xpath("//button[@class='slds-button slds-show']")).sendKeys(Keys.ENTER);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Accounts");
			click(locateElement("xpath", "//span/p/b[text()='Accounts']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
				reportStep("Cases Page is displayed", "pass", takeSnap(getTitle()));
			

		} catch (Exception e) {
			reportStep("Failed to display the Cases Page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

				
		//  Verify the RIA Firm Account Record Type:
		//Account Information Section

		try {
			waitPageLoading();

			/*click(locateElement("xpath", "//span[text()='Accounts']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	*/				
			click(locateElement("xpath", "(//span[text()='Recently Viewed'])[1]"));				
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			click(locateElement("xpath", "(//span[text()='All Accounts'])[1]"));
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
			//click(locateElement("xpath", "//input[@name='Account-search-input']"));
			driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Professional Retr. Programs");
			driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys(Keys.ENTER);
			click(locateElement("xpath", "//a[@title='Professional Retr. Programs']"));
			locateElement("xpath", "//span[text()='US Retirement']").isDisplayed();
			locateElement("xpath", "//button[@class='slds-button slds-button_outline-brand']").isDisplayed();
			locateElement("xpath", "//button[@title='Collapse All']").isDisplayed();
			locateElement("xpath", "//button[@title='Hide Blank Fields']").isDisplayed();				
			locateElement("xpath", "//button[@title='Refresh']").isDisplayed();
			
			locateElement("xpath", "//label[text()='Account Name']").isDisplayed();
			locateElement("xpath", "//label[text()='Parent Account ID']").isDisplayed();
			locateElement("xpath", "//label[text()='Account Fax']").isDisplayed();	
			locateElement("xpath", "//label[text()='Account Phone']").isDisplayed();
			locateElement("xpath", "//label[text()='Company Email Address']").isDisplayed();
			locateElement("xpath", "//label[text()='Website']").isDisplayed();
			locateElement("xpath", "//label[text()='Account Description']").isDisplayed();
			locateElement("xpath", "//label[text()='Firm Notes for Dissemination']").isDisplayed();	
			locateElement("xpath", "//label[text()='Company ID']").isDisplayed();
			locateElement("xpath", "//label[text()='Owner ID']").isDisplayed();
			locateElement("xpath", "//label[text()='Taxpayer ID']").isDisplayed();
			locateElement("xpath", "//label[text()='Electronic File Feed']").isDisplayed();
			locateElement("xpath", "//label[text()='Record Type ID']").isDisplayed();	
			locateElement("xpath", "//label[text()='Customer Status']").isDisplayed();				
			locateElement("xpath", "//label[text()='Customer Status Effective Date']").isDisplayed();
			locateElement("xpath", "//label[text()='Company ID']").isDisplayed();	
			
			
			reportStep("Account information section fields are displayed", "pass", takeSnap(getTitle()));
		

	} catch (Exception e) {
		reportStep("Failed to display account information section fields", "fail", takeSnap(getTitle()));
		e.printStackTrace();
	}
		//Address Information Section

		try {
			
			WebElement element = driver.findElement(By.xpath("//span[text()='Address Information']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); 

			
			locateElement("xpath", "//span[text()='Address Information']").isDisplayed();
			
			locateElement("xpath", "//label[text()='Billing Country']").isDisplayed();
			locateElement("xpath", "//label[text()='Billing Street']").isDisplayed();
			locateElement("xpath", "//label[text()='Billing City']").isDisplayed();
			locateElement("xpath", "//label[text()='Billing State/Province']").isDisplayed();				
			locateElement("xpath", "//label[text()='Shipping Country']").isDisplayed();
			locateElement("xpath", "//label[text()='Shipping Street']").isDisplayed();
			locateElement("xpath", "//label[text()='Shipping City']").isDisplayed();				
			locateElement("xpath", "//label[text()='Shipping State/Province']").isDisplayed();
			

			reportStep("Address information section fields are displayed", "pass", takeSnap(getTitle()));
		

	} catch (Exception e) {
		reportStep("Failed to display address information section fields", "fail", takeSnap(getTitle()));
		e.printStackTrace();
	}
		//RIA Firm Profile Information Section

		try {
			
			WebElement element = driver.findElement(By.xpath("//span[text()='RIA Firm Profile Information']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); 

			
			locateElement("xpath", "//span[text()='RIA Firm Profile Information']").isDisplayed();
			locateElement("xpath", "//label[text()='Total Number of Employees']").isDisplayed();
			locateElement("xpath", "//label[text()='Total Number of Advisors']").isDisplayed();
			locateElement("xpath", "//label[text()='Total Number of Offices']").isDisplayed();
			locateElement("xpath", "//span[text()='Does this office have a Sales Desk?']").isDisplayed();
			locateElement("xpath", "//label[text()='Firm Discussion Points']").isDisplayed();	
			locateElement("xpath", "//label[text()='Firm Performance']").isDisplayed();
			locateElement("xpath", "//label[text()='Firm Performance Year']").isDisplayed();
			
			
			Actions act = new Actions(driver);
            act.sendKeys(Keys.PAGE_DOWN).build().perform(); 

			reportStep("RIA Firm Profile Information section fields are displayed", "pass", takeSnap(getTitle()));
		

	} catch (Exception e) {
		reportStep("Failed to display RIA Firm Profile Information section fields", "fail", takeSnap(getTitle()));
		e.printStackTrace();
	}
		
	
		
		//Selling Agreement/Firm Regulations Information Section

				try {
					
					WebElement element = driver.findElement(By.xpath("//span[text()='Selling Agreement/Firm Regulations Information']"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					Thread.sleep(500); 

					
					locateElement("xpath", "//span[text()='Selling Agreement/Firm Regulations Information']").isDisplayed();
					
					locateElement("xpath", "//label[text()='Co-Mingling']").isDisplayed();
					locateElement("xpath", "//label[text()='Compensation Restrictions']").isDisplayed();
					locateElement("xpath", "//label[text()='Meeting Approval Process']").isDisplayed();
					locateElement("xpath", "//span[text()='Pre-Approval for Product']").isDisplayed();
					locateElement("xpath", "//span[text()='Pre-Approval for Marketing']").isDisplayed();	
					
					
					
		

					reportStep("Selling Agreement/Firm Regulations Information section fields are displayed", "pass", takeSnap(getTitle()));
				

			} catch (Exception e) {
				reportStep("Failed to display Selling Agreement/Firm Regulations Information section fields", "fail", takeSnap(getTitle()));
				e.printStackTrace();
			}
				
			
				
				
		
		
		//System Information Section
		try {
			
			WebElement element = driver.findElement(By.xpath("(//span[text()='System Information'])[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); 

			waitPageLoading();		
			locateElement("xpath", "(//span[text()='System Information'])[1]").isDisplayed();
			locateElement("xpath", "//label[text()='Created By ID']").isDisplayed();				
			locateElement("xpath", "//label[text()='Satuit ID']").isDisplayed();
			locateElement("xpath", "//label[text()='PeopleSoft ID']").isDisplayed();
			locateElement("xpath", "//label[text()='Last Modified By ID']").isDisplayed();				


			reportStep("System information section fields are isplayed", "pass", takeSnap(getTitle()));
			

		} catch (Exception e) {
			reportStep("Failed to display system information section fields", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}
		
		
		
		
		//Compensation and Fees Section
				try {
					
					WebElement element = driver.findElement(By.xpath("(//span[text()='Compensation and Fees'])[1]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					Thread.sleep(500); 

					waitPageLoading();		
					locateElement("xpath", "(//span[text()='Compensation and Fees'])[1]").isDisplayed();
					locateElement("xpath", "//span[text()='Asset Based Commission Only']").isDisplayed();				
					locateElement("xpath", "//span[text()='Commission Grid Available']").isDisplayed();
					locateElement("xpath", "//span[text()='Disable Commissions & RIA Fees']").isDisplayed();
					locateElement("xpath", "//span[text()='Commission Based Only On Transfer Assets']").isDisplayed();				
					locateElement("xpath", "(//span[text()='Comp either by Commission or RIA only'])[1]").isDisplayed();
					locateElement("xpath", "//span[text()='RIA Fee']").isDisplayed();				
					locateElement("xpath", "//span[text()='RIA Fee Grid Available']").isDisplayed();
					
					reportStep("Compensation and Fees section fields are isplayed", "pass", takeSnap(getTitle()));
					

				} catch (Exception e) {
					reportStep("Failed to display Compensation and Fees section fields", "fail", takeSnap(getTitle()));
					e.printStackTrace();
				}
				
				
		//System Information Section
				try {
					
					WebElement element = driver.findElement(By.xpath("(//span[text()='Account Name'])[2]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					Thread.sleep(500); 

					
					locateElement("xpath", "//span[text()='Account Name']").isDisplayed();
					locateElement("xpath", "//span[text()='Parent Account']").isDisplayed();
					locateElement("xpath", "//span[text()='Account Owner']").isDisplayed();
					locateElement("xpath", "//span[text()='Account Record Type']").isDisplayed();
					locateElement("xpath", "//span[text()='Account Currency']").isDisplayed();
					
					WebElement element1 = driver.findElement(By.xpath("(//span[text()='System Information'])[2]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
					Thread.sleep(500); 
					
					locateElement("xpath", "(//span[text()='System Information'])[2]").isDisplayed();
					locateElement("xpath", "//span[text()='Created By']").isDisplayed();
					locateElement("xpath", "//span[text()='RPS External Id']").isDisplayed();
					locateElement("xpath", "//span[text()='Last Modified By']").isDisplayed();
					


					reportStep("System information section fields are isplayed", "pass", takeSnap(getTitle()));
					

				} catch (Exception e) {
					reportStep("Failed to display system information section fields", "fail", takeSnap(getTitle()));
					e.printStackTrace();
				}
		
		
		
		//  Logout of the application
	try {
			
			click(locateElement("xpath", "(//span[@class = 'uiImage'])[1]"));
			click(locateElement("linkText", "Log Out"));
			reportStep("Application is logged out successfully", "pass", takeSnap(getTitle()));
			
		} catch (Exception e) {
			reportStep("Failed to log out of the application and display the login page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		
		
		
	}
}
