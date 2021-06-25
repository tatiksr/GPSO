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
public class GPSOT_444 extends Project {

		@BeforeTest

		public void setData() {
			testCaseName = "GPSOT_444";
			testCaseDesc = "Onboarding Standard User Tasks";
			category = "GPSOTest";
			author = "Suraj";
			testCaseFileName = "GPSO";

		}

		@Test(dataProvider = "fetchData")
		public void GPSOT_444_Test(Map<String, String> details) throws InterruptedException, IOException {

			// Step 2 : Log into the application

			try {
				/*click(locateElement("xpath", "//span[text()='NASITAzureSSO']"));		*/	
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							
				waitPageLoading();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				type(locateElement("xpath", "//input[@title='Search...']"), "Ted Rallis");
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(5000);
				click(locateElement("xpath", "//div[@class='slds-truncate uiOutputRichText']"));
				click(locateElement("xpath", "//div[text()='User Detail']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame(driver.findElementByXPath("//*[@id='setupComponent']/div[2]/div/div/force-aloha-page/div/iframe"));
				Thread.sleep(3000);
				click(locateElement("xpath", "(//input[@title='Login'])[1]"));
				driver.switchTo().defaultContent();		
				
				reportStep("Login is Successful", "pass", takeSnap(getTitle()));
			} catch (Exception e) {
				reportStep("Login not Successful", "fail", takeSnap(getTitle()));
				e.printStackTrace();

			}

			//  Verify the Onboarding Manager Project Page

			try {
				waitPageLoading();
	
				if (locateElement("xpath", "(//span[text()='To Do'])[2]").isDisplayed()) {
					reportStep("Type field value is displayed ", "pass", takeSnap(getTitle()));
				} else {
					reportStep("Type field value is  not displayed", "fail", takeSnap(getTitle()));
				}

			} catch (Exception e) {
				reportStep("Failed to display the Type field in Task details view Page", "fail", takeSnap(getTitle()));
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

