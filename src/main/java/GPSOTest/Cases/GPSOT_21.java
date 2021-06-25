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

public class GPSOT_21 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_21";
		testCaseDesc = "Onboarding Manager Project Page";
		category = "GPSOTest";
		author = "Suraj";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_21_Test(Map<String, String> details) throws InterruptedException, IOException {

		// Step 2 : Log into the application

		try {
			click(locateElement("xpath", "//span[text()='NASITAzureSSO']"));			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			type(locateElement("xpath", "//input[@title='Search...']"), "Maia Smith");
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
/*			driver.findElement(By.xpath("//a[@title='Home']")).sendKeys(Keys.ENTER);*/
			click(locateElement("xpath", "//a[@title='GPS Hospitality LLC']"));
			WebElement element= driver.findElement(By.xpath("//a[@title='Home']"));
			JavascriptExecutor executor=(JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			driver.findElement(By.linkText("00001006")).sendKeys(Keys.ENTER);
			if (locateElement("xpath", "//div[text() = 'Case']").isDisplayed()) {
				reportStep("Onboarding Manager Project Page is displayed home page", "pass", takeSnap(getTitle()));
			} else {
				reportStep("Onboarding Manager Project Page is not displayed", "fail", takeSnap(getTitle()));
			}

		} catch (Exception e) {
			reportStep("Failed to display the Onboarding Manager Project Page", "fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		//  Verify the Task Tab in the Onboarding Manager Project Page
		try {
		
			if (locateElement("xpath", "//a[text() = 'Tasks']").isDisplayed()) {
				
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
		//Clicking on Tasks Tab and validating filter by 
		try {
			WebElement element1= driver.findElement(By.xpath("//a[text() = 'Tasks']"));
			JavascriptExecutor executor=(JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element1);
			//click(locateElement("xpath", "//a[text() = 'Tasks']"));
			if (locateElement("xpath", "//label[text() = 'Filter By']").isDisplayed()) {
				
				reportStep("Filter By is displayed in the Onboarding Project page", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Filter By is not displayed in the Onboarding Project page", "fail",
						takeSnap(getTitle()));
			}
			
			
		}
		catch (Exception e) {
			reportStep("Not Successful", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}
		//Validating drop down values:
		try {
			
		click(locateElement("xpath", "//input[@name = 'progress']"));
		locateElement("xpath", "//span[text()='All Tasks']").isDisplayed();
		locateElement("xpath", "//span[text()='My Tasks']").isDisplayed();
		
		
				//if ((locateElement("xpath", "//span[text()='All Tasks']]")).isDisplayed() && (locateElement("xpath", "//span[text()='My Tasks']")).isDisplayed()) {
			
			reportStep("Filter By drop down values are displayed in the Onboarding Project page- Tasks tab", "pass",
					takeSnap(getTitle()));
		/*} else {
			reportStep("Filter is not displayed in the Onboarding Project page", "fail",
					takeSnap(getTitle()));
		}*/
		
		
	}
	catch (Exception e) {
		reportStep("Not Successful", "fail", takeSnap(getTitle()));
		e.printStackTrace();

	}
//Validating collapsible tasks
		try {
			
			click(locateElement("xpath", "(//button[@class='slds-button slds-button_icon slds-m-right_x-small']/lightning-primitive-icon)[1]"));
			
					if ((locateElement("xpath", "//lightning-formatted-url/a[text()='Key dates and PIM assignment']")).isDisplayed()) {
				
				reportStep("Tasks are diplayed as Collapsible in the Onboarding Project page- Task tab", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Tasks are not diplayed as Collapsible in the Onboarding Project page- Task tab ", "fail",
						takeSnap(getTitle()));
			}
			
			
		}
		catch (Exception e) {
			reportStep("Not Successful", "fail", takeSnap(getTitle()));
			e.printStackTrace();

		}
		
		//validating edit/view task details:
try {
			WebElement element2= driver.findElement(By.xpath("//lightning-formatted-url/a[text()='Key dates and PIM assignment']"));
			JavascriptExecutor executor=(JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element2);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					if ((locateElement("xpath", "//button[@class='slds-button slds-button_stateful slds-button_neutral slds-not-selected runtime_sales_activitiesTaskStatusButton']/span[1]").isDisplayed())&&(locateElement("xpath", "//div[text()='Edit']")).isDisplayed()) {					
				reportStep("Mark Complete and Edit Tasks is displayed in the Task details page", "pass",
						takeSnap(getTitle()));
			} else {
				reportStep("Mark Complete and Edit Tasks is displayed in the Task details page", "fail",
						takeSnap(getTitle()));
			}
			
			
		}
		catch (Exception e) {
			reportStep("Mark Complete and Edit Tasks is not displayed in the Task details page ", "fail", takeSnap(getTitle()));
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
