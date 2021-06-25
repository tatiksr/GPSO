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
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import test.Sel.Project;

public class GPSOT_417 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_417";
		testCaseDesc = "Onboarding Manager Project Page";
		category = "GPSOTest";
		author = "Suraj";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_417_Test(Map<String, String> details) throws InterruptedException, IOException {

		// Step 2 : Log into the application

		try {
			/*click(locateElement("xpath", "//span[text()='NASITAzureSSO']"));			*/
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			reportStep("Login is Successful", "pass", takeSnap(getTitle()));
		} catch (Exception e) {
			reportStep("Login not Successful", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}

		//  Verify the Onboarding Manager Project Page

		try {
			waitPageLoading();
			driver.findElement(By.xpath("//button[@class='slds-button slds-show']")).sendKeys(Keys.ENTER);
			/*WebElement element2= driver.findElement(By.xpath("//lightning-formatted-url/a[text()='Key dates and PIM assignment']"));
			JavascriptExecutor executor=(JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element2);
		*/	//click(locateElement("xpath", "//button[@class='slds-button slds-show']"));	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Cases");
			click(locateElement("xpath", "//span/p/b[text()='Cases']"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
				reportStep("Cases Page is displayed", "pass", takeSnap(getTitle()));
			

		} catch (Exception e) {
			reportStep("Failed to display the Cases Page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		//  Verify the Task Tab in the Onboarding Manager Project Page
		try {
			click(locateElement("xpath", "//div[text()='New']"));	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (locateElement("xpath", "//h2[text() = 'New Case: Project']").isDisplayed()) {
				
				reportStep("Tasks Tab is displayed in the Onboarding project page", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Tasks Tab is not displayed in the Onboarding project page", "fail",
						takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Tasks Tab  in the Onboarding project page", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}
		
		//Validating the fields:
		try {
				
			
			locateElement("xpath", "//h2[text() = 'New Case: Project']").isDisplayed();
			locateElement("xpath", "//span[text() = 'Case Owner']").isDisplayed();
			locateElement("xpath", "//span[text() = 'Case Record Type']").isDisplayed();
			locateElement("xpath", "//span[text() = 'Project Type']").isDisplayed();
			locateElement("xpath", "//label[text()='Status']").isDisplayed();
			locateElement("xpath", "//span[text()='Estimated Transfer ($)']").isDisplayed();
			locateElement("xpath", "//span[text() = 'Transfer Type']").isDisplayed();
			locateElement("xpath", "//span[text() = 'Plan Type']").isDisplayed();
			locateElement("xpath", "//span[text() = 'Plan Sub-Type']").isDisplayed();
			locateElement("xpath", "//span[text() = 'Name']").isDisplayed();
			
			
				
				reportStep("Case fields are displayed in the new case creation page", "pass",
						takeSnap(getTitle()));
			
		} catch (Exception e) {
			reportStep("Failed to display the Tasks Tab  in the Onboarding project page", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}
		//Creating new case
		try {
			//click(locateElement("xpath", "//div[text()='New']"));	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			locateElement("xpath", "//h2[text() = 'New Case: Project']").isDisplayed();
			click(locateElement("xpath", "(//a[@class='select'])[2]"));
			click(locateElement("xpath", "//a[@title='Email']"));
			
			type(locateElement("xpath", "(//input[@class=' input'])[3]"),"GPSOTestProj04");
			click(locateElement("xpath", "(//span[text()='Save'])[2]"));	
			
			
				
				reportStep("Caseis created successfully", "pass",
						takeSnap(getTitle()));
			
		} catch (Exception e) {
			reportStep("Failed to display the Tasks Tab  in the Onboarding project page", "fail",
					takeSnap(getTitle()));
			e.printStackTrace();
		}
		//validating in Case details section
try {
				
			
			
			locateElement("xpath", "//span[text() = 'Case Owner']").isDisplayed();
			locateElement("xpath", "//span[text() = 'Case Record Type']").isDisplayed();
			locateElement("xpath", "//span[text() = 'Project Type']").isDisplayed();
			locateElement("xpath", "//span[text()='Status']").isDisplayed();
			locateElement("xpath", "//span[text()='Estimated Transfer ($)']").isDisplayed();
			locateElement("xpath", "//span[text() = 'Transfer Type']").isDisplayed();
			locateElement("xpath", "//span[text() = 'Plan Type']").isDisplayed();
			locateElement("xpath", "//span[text() = 'Plan Sub-Type']").isDisplayed();
			locateElement("xpath", "//span[text() = 'Name']").isDisplayed();
			
			Thread.sleep(2000);
				
				reportStep("Case fields are displayed in the new case creation page", "pass",
						takeSnap(getTitle()));
			
		} catch (Exception e) {
			reportStep("Failed to display the Tasks Tab  in the Onboarding project page", "fail",
					takeSnap(getTitle()));
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

