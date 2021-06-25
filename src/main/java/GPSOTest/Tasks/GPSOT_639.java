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
public class GPSOT_639 extends Project {

		@BeforeTest

		public void setData() {
			testCaseName = "GPSOT_639";
			testCaseDesc = "Onboarding Standard User Tasks";
			category = "GPSOTest";
			author = "Suraj";
			testCaseFileName = "GPSO";

		}

		@Test(dataProvider = "fetchData")
		public void GPSOT_639_Test(Map<String, String> details) throws InterruptedException, IOException {

			// Step 2 : Log into the application

			try {
				/*click(locateElement("xpath", "//span[text()='NASITAzureSSO']"));			*/
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
							
				waitPageLoading();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
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
				driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Tasks");
				click(locateElement("xpath", "//b[text()='Tasks']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
					reportStep("Tasks Page is displayed", "pass", takeSnap(getTitle()));
				

			} catch (Exception e) {
				reportStep("Failed to display the Taks Page", "fail", takeSnap(getTitle()));
				e.printStackTrace();
			}
			//status Field 
			
			try {
				locateElement("xpath", "(//span[text()='Status'])[2]").isDisplayed();
				click(locateElement("xpath", "//button[@title='Edit Status']"));				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				click(locateElement("xpath", "//a[text()='Not Started']"));
				locateElement("xpath", "//a[text()='Completed']").isDisplayed();
				locateElement("xpath", "//a[text()='Failed Validation']").isDisplayed();
				locateElement("xpath", "//a[text()='Waiting on someone else']").isDisplayed();
				locateElement("xpath", "//a[text()='Deferred']").isDisplayed();
				
					
					reportStep("Status field values are displayed ", "pass", takeSnap(getTitle()));
				

			} catch (Exception e) {
				reportStep("Failed to display the Status field values in Task details view Page", "fail", takeSnap(getTitle()));
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




