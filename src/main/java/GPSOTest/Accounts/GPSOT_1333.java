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
public class GPSOT_1333 extends Project {

		@BeforeTest

		public void setData() {
			testCaseName = "GPSOT_1333";
			testCaseDesc = "SF - Account Search Layout";
			category = "GPSOTest";
			author = "Suraj";
			testCaseFileName = "GPSO";

		}

		@Test(dataProvider = "fetchData")
		public void GPSOT_1333_Test(Map<String, String> details) throws InterruptedException, IOException {

			// Step 2 : Log into the application

			try {
				/*click(locateElement("xpath", "//span[text()='NASITAzureSSO']"));			*/
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				// FIREFOX Driver-Working 
				WebDriverWait wait = new WebDriverWait(driver, 60);  
				Alert alert = wait.until(ExpectedConditions.alertIsPresent()); 
				Thread.sleep(20000);
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();				
				waitPageLoading();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				type(locateElement("xpath", "//input[@title='Search...']"), "Nationwide");
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//input[@title='Search...']")).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				
				reportStep("Login is Successful", "pass", takeSnap(getTitle()));
			} catch (Exception e) {
				reportStep("Login not Successful", "fail", takeSnap(getTitle()));
				e.printStackTrace();

			}



			//  Verify the Onboarding Manager Project Page

			try {
				
				locateElement("xpath", "//a[text()='Accounts']").isDisplayed();	
				locateElement("xpath", "(//span[text()='Account Name'])[1]").isDisplayed();		
				locateElement("xpath", "//span[text()='Account Owner Alias']").isDisplayed();
				locateElement("xpath", "//span[text()='Account Record Type']").isDisplayed();				
				
				
				
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



