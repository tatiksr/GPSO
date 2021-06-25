package GPSOTest;

	import java.io.IOException;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.time.LocalDate;
	import java.util.Calendar;
	import java.util.Map;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

	import test.Sel.Project;

	public class GPSOT_1284 extends Project {

		@BeforeTest

		public void setData() {
			testCaseName = "GPSOT_1284";
			testCaseDesc = "Initial Project Setup: Additional fields to Project Object";
			category = "GPSOTest";
			author = "Suraj";
			testCaseFileName = "GPSO";

		}

		@Test(dataProvider = "fetchData")
		public void GPSOT_1284_Test(Map<String, String> details) throws InterruptedException, IOException {

			// Step 2 : Log into the application

			try {
				
				waitPageLoading();
				/* // FIREFOX Driver-Working 
				WebDriverWait wait = new WebDriverWait(driver, 60);  
				Alert alert = wait.until(ExpectedConditions.alertIsPresent()); 
				Thread.sleep(20000);
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();*/
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				reportStep("Login is Successful", "pass", takeSnap(getTitle()));
			} catch (Exception e) {
				reportStep("Login not Successful", "fail", takeSnap(getTitle()));
				e.printStackTrace();

			}

			
			//  Verify the Onboarding Manager Project Page
			
			try {
				waitPageLoading();
				
				
				WebElement cases= driver.findElement(By.xpath("//span[text()='Cases']"));
				JavascriptExecutor executor=(JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", cases);
				
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
					
					reportStep("New Case page is displayed ", "pass",
							takeSnap(getTitle()));
				} else {
					reportStep("New Case page is not displayed", "fail",
							takeSnap(getTitle()));
				}

			} catch (Exception e) {
				reportStep("Failed to display the new cases page", "fail",
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
				locateElement("xpath", "//span[text() = 'P+Plan Code']").isDisplayed();
				locateElement("xpath", "//span[text() = 'Participant Count']").isDisplayed();
				locateElement("xpath", "//span[text() = 'Expected MVR (after Prelim) ($)']").isDisplayed();
				locateElement("xpath", "//span[text() = 'Project Folder Location/link']").isDisplayed();
							
				
					
					reportStep("Case fields are displayed in the new case creation page", "pass",
							takeSnap(getTitle()));
				
			} catch (Exception e) {
				reportStep("Failed to display the Tasks Tab  in the Onboarding project page", "fail",
						takeSnap(getTitle()));
				e.printStackTrace();
			}
			
			
			try {
				WebElement projectOverview = driver.findElement(By.xpath("//span[text()='Project Overview']"));
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", projectOverview);
				
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
				
					reportStep("Project Overview section is displayed", "pass", takeSnap(getTitle()));
				

			} catch (Exception e) {
				reportStep("Failed to display Project Overview section", "fail", takeSnap(getTitle()));
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

