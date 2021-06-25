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
	public class GPSOT_945  extends Project {

			@BeforeTest

			public void setData() {
				testCaseName = "GPSOT_945";
				testCaseDesc = "Initial Project Setup: RPS Account Fields in Onboarding Org (Fund Partner Record Type) in Salesforce";
				category = "GPSOTest";
				author = "Suraj";
				testCaseFileName = "GPSO";

			}

			@Test(dataProvider = "fetchData")
			public void GPSOT_945_Test(Map<String, String> details) throws InterruptedException, IOException {

				// Step 2 : Log into the application

				try {
					/*click(locateElement("xpath", "//span[text()='NASITAzureSSO']"));			*/
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					 /*// FIREFOX Driver-Working 
					WebDriverWait wait = new WebDriverWait(driver, 60);  
					Alert alert = wait.until(ExpectedConditions.alertIsPresent()); 
					Thread.sleep(20000);
					driver.switchTo().alert().accept();
					driver.switchTo().defaultContent();*/
								
					waitPageLoading();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
					reportStep("Login is Successful", "pass", takeSnap(getTitle()));
				} catch (Exception e) {
					reportStep("Login not Successful", "fail", takeSnap(getTitle()));
					e.printStackTrace();

				}
				//Navigating to Sales app
				try {
					waitPageLoading();
					driver.findElement(By.xpath("//button[@class='slds-button slds-show']")).sendKeys(Keys.ENTER);
					/*WebElement element2= driver.findElement(By.xpath("//lightning-formatted-url/a[text()='Key dates and PIM assignment']"));
					JavascriptExecutor executor=(JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", element2);
				*/	//click(locateElement("xpath", "//button[@class='slds-button slds-show']"));	
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
					driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Accounts");
					click(locateElement("xpath", "//span/p/b[text()='Accounts']"));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
						reportStep("Accounts Page is displayed", "pass", takeSnap(getTitle()));
					

				} catch (Exception e) {
					reportStep("Failed to display the Accounts Page", "fail", takeSnap(getTitle()));
					e.printStackTrace();
				}

						
				//  Verify theNational Account Record Type:
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
					driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("AB - Alliance Bernstein");
					driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					click(locateElement("xpath", "//a[text()='AB - Alliance Bernstein']"));
					/*click(locateElement("xpath", "//button[text()='Hide US Section']"));
					click(locateElement("xpath", "//button[text()='Show US Section']"));*/	
					locateElement("xpath", "//button[text()='Hide US Section']").isDisplayed();	
					locateElement("xpath", "//span[text()='US Retirement']").isDisplayed();
					locateElement("xpath", "//button[@title='Collapse All']").isDisplayed();
					locateElement("xpath", "//button[@title='Hide Blank Fields']").isDisplayed();				
					locateElement("xpath", "//button[@title='Refresh']").isDisplayed();
					locateElement("xpath", "//label[text()='Account Name']").isDisplayed();
					locateElement("xpath", "//label[text()='Parent Account ID']").isDisplayed();
					locateElement("xpath", "//label[text()='Account Phone']").isDisplayed();
					locateElement("xpath", "//label[text()='Account Fax']").isDisplayed();				
					locateElement("xpath", "//label[text()='Company Email Address']").isDisplayed();
					locateElement("xpath", "//label[text()='Website']").isDisplayed();
					locateElement("xpath", "//label[text()='Account Description']").isDisplayed();				
					locateElement("xpath", "//label[text()='Company ID']").isDisplayed();
					locateElement("xpath", "//label[text()='Owner ID']").isDisplayed();
					locateElement("xpath", "//label[text()='Record Type ID']").isDisplayed();	
					locateElement("xpath", "//label[text()='Taxpayer ID']").isDisplayed();
					locateElement("xpath", "//label[text()='DCIO File Options']").isDisplayed();
					locateElement("xpath", "//label[text()='Customer Status']").isDisplayed();				
					locateElement("xpath", "//label[text()='Customer Status Effective Date']").isDisplayed();
					locateElement("xpath", "//label[text()='Company ID']").isDisplayed();	
					

					reportStep("Account information section fields are isplayed", "pass", takeSnap(getTitle()));
				

			} catch (Exception e) {
				reportStep("Failed to display account information section fields", "fail", takeSnap(getTitle()));
				e.printStackTrace();
			}
				//Address Information Section

				try {
					
					WebElement webElement = driver.findElement(By.xpath("//span[text()='Address Information']"));
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
					
					//locateElement("xpath", "//span[text()='Address Information']").isDisplayed();
					
					locateElement("xpath", "//label[text()='Billing Country']").isDisplayed();
					locateElement("xpath", "//label[text()='Billing Street']").isDisplayed();
					locateElement("xpath", "//label[text()='Billing City']").isDisplayed();
					locateElement("xpath", "//label[text()='Billing State/Province']").isDisplayed();				
					locateElement("xpath", "//label[text()='Shipping Country']").isDisplayed();
					locateElement("xpath", "//label[text()='Shipping Street']").isDisplayed();
					locateElement("xpath", "//label[text()='Shipping City']").isDisplayed();				
					locateElement("xpath", "//label[text()='Shipping State/Province']").isDisplayed();
					

					reportStep("Address information section fields are isplayed", "pass", takeSnap(getTitle()));
				

			} catch (Exception e) {
				reportStep("Failed to display address information section fields", "fail", takeSnap(getTitle()));
				e.printStackTrace();
			}
				//Fund Partner Firm Profile Information Section

				try {
					WebElement webElement1 = driver.findElement(By.xpath("//span[text()='Fund Partner Firm Profile Information']"));
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement1);
					locateElement("xpath", "//span[text()='Fund Partner Firm Profile Information']").isDisplayed();
					
					locateElement("xpath", "//label[text()='Fund Partner Tier']").isDisplayed();
					locateElement("xpath", "//label[text()='Number of DCIO Wholesalers']").isDisplayed();
					locateElement("xpath", "//label[text()='Number of Retail Wholesalers']").isDisplayed();
					locateElement("xpath", "//label[text()='Number of Sales Desks']").isDisplayed();				
					locateElement("xpath", "//label[text()='Firms associated to DCIO Firm']").isDisplayed();
					locateElement("xpath", "//label[text()='Fund Partner Total Assets']").isDisplayed();
					locateElement("xpath", "//span[text()='Proprietary Fund Products']").isDisplayed();	
					locateElement("xpath", "//label[text()='Profile Information Last Modified On']").isDisplayed();	
					

					reportStep("Fund Partner Firm Profile information section fields are isplayed", "pass", takeSnap(getTitle()));
				

			} catch (Exception e) {
				reportStep("Failed to display Fund Partner Firm Profile information section fields", "fail", takeSnap(getTitle()));
				e.printStackTrace();
			}
				//System Information Section
				try {
					waitPageLoading();		
					WebElement webElement2 = driver.findElement(By.xpath("(//span[text()='System Information'])[1]"));
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement2);
					locateElement("xpath", "(//span[text()='System Information'])[1]").isDisplayed();
					locateElement("xpath", "//label[text()='Created By ID']").isDisplayed();				
					locateElement("xpath", "//label[text()='Satuit ID']").isDisplayed();
					locateElement("xpath", "//label[text()='PeopleSoft ID']").isDisplayed();
					locateElement("xpath", "//label[text()='Last Modified By ID']").isDisplayed();				
					
					locateElement("xpath", "//span[text()='Account Name']").isDisplayed();
					locateElement("xpath", "//span[text()='Parent Account']").isDisplayed();
					locateElement("xpath", "//span[text()='Account Currency']").isDisplayed();
					locateElement("xpath", "//span[text()='Account Owner']").isDisplayed();
					locateElement("xpath", "//span[text()='Account Record Type']").isDisplayed();
					//click(locateElement("xpath", "(//span[text()='System Information'])[2]"));
					//click(locateElement("xpath", "//button[@title='Edit Account Name']"));
					WebElement webElement3 = driver.findElement(By.xpath("(//span[text()='System Information'])[2]"));
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement3);
					locateElement("xpath", "(//span[text()='System Information'])[2]").isDisplayed();
					locateElement("xpath", "//span[text()='Created By']").isDisplayed();
					locateElement("xpath", "//span[text()='RPS External Id']").isDisplayed();
					locateElement("xpath", "//span[text()='Last Modified By']").isDisplayed();
					/*locateElement("xpath", "//button[text()='Save']").isDisplayed();
					locateElement("xpath", "//button[text()='Cancel']").isDisplayed();*/
					//click(locateElement("xpath", "//button[text()='Cancel']"));
						


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
			



