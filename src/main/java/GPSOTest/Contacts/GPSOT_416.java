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
	import test.Sel.Project;

	public class GPSOT_416 extends Project {

		@BeforeTest

		public void setData() {
			testCaseName = "GPSOT_416";
			testCaseDesc = "Initial Contact Setup: Create Contacts Record Types and Page Layouts in Salesforce";
			category = "GPSOTest";
			author = "subraaa";
			testCaseFileName = "GPSO";

		}

		@Test(dataProvider = "fetchData")
		public void GPSOT_416_Test(Map<String, String> details) throws InterruptedException, IOException {

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
				/*WebElement element2= driver.findElement(By.xpath("//lightning-formatted-url/a[text()='Key dates and PIM assignment']"));
				JavascriptExecutor executor=(JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element2);
			*/	//click(locateElement("xpath", "//button[@class='slds-button slds-show']"));	
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
				driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Contacts");
				click(locateElement("xpath", "//span/p/b[text()='Contacts']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
					reportStep("Accounts Page is displayed", "pass", takeSnap(getTitle()));
				

			} catch (Exception e) {
				reportStep("Failed to display the Accounts Page", "fail", takeSnap(getTitle()));
				e.printStackTrace();
			}
			
			
			//Step 2: click on contacts tab and open a required contact
					try {
						
						waitPageLoading();
						click(locateElement("xpath", "(//span[text()='Recently Viewed'])[1]"));				
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						click(locateElement("xpath", "(//span[text()='All Contacts'])[1]"));
						Thread.sleep(2000);
						//click(locateElement("xpath", "//input[@name='Account-search-input']"));
						driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys("Claire Werner");
						driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys(Keys.ENTER);
						click(locateElement("xpath", "//a[@title='Claire Werner']"));					
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						click(locateElement("xpath", "//button[text()='Hide US Section']"));
							
						//locateElement("xpath", "//button[text()='Hide US Section']").isDisplayed();	
						
							
					} catch (Exception e) {
						reportStep("Unable to navigate to Contacts page", "fail", takeSnap(getTitle()));
						e.printStackTrace();

					}				
					
			
			
					
					//Step 3: Validate all the fields on System Information section in Contacts details page
					//System Information Section
					try {
												
						locateElement("xpath", "//span[text()='Name']").isDisplayed();
						locateElement("xpath", "//span[text()='Account Name']").isDisplayed();
						locateElement("xpath", "//span[text()='Contact Currency']").isDisplayed();
						locateElement("xpath", "//span[text()='Contact Owner']").isDisplayed();
						locateElement("xpath", "//span[text()='Contact Record Type']").isDisplayed();
						
						locateElement("xpath", "//span[text()='System Information']").isDisplayed();
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
	

