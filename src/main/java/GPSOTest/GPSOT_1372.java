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
public class GPSOT_1372 extends Project {

		@BeforeTest

		public void setData() {
			testCaseName = "GPSOT_1372";
			testCaseDesc = "SF - Contact Compact Layout";
			category = "GPSOTest";
			author = "Suraj";
			testCaseFileName = "GPSO";

		}

		@Test(dataProvider = "fetchData")
		public void GPSOT_1372_Test(Map<String, String> details) throws InterruptedException, IOException {

			// Step 2 : Log into the application

			try {
				/*click(locateElement("xpath", "//span[text()='NASITAzureSSO']"));			*/
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				/*// FIREFOX Driver-Working 
				WebDriverWait wait = new WebDriverWait(driver, 60);  
				Alert alert = wait.until(ExpectedConditions.alertIsPresent()); 
				Thread.sleep(20000);
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();		*/
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
				driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Contacts");
				click(locateElement("xpath", "//span/p/b[text()='Contacts']"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
					reportStep("Contacts Page is displayed", "pass", takeSnap(getTitle()));
				

			} catch (Exception e) {
				reportStep("Failed to display the Contacts Page", "fail", takeSnap(getTitle()));
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
				/*click(locateElement("xpath", "(//span[text()='All Business Contacts'])[1]"));*/
				click(locateElement("xpath", "(//span[text()='All Advisor Contacts'])[1]"));
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
				//click(locateElement("xpath", "//input[@name='Account-search-input']"));
reportStep("Advisor Contact filter page is displayed", "pass", takeSnap(getTitle()));
				
			} catch (Exception e) {
				reportStep("Failed to display Advisor Contact filter page", "fail", takeSnap(getTitle()));
				e.printStackTrace();
			}
			try {
				driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys("Kaitlyn Maya");//Advisor
				//driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys("Sarah Halpin");
				driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				click(locateElement("xpath", "//a[text()='Kaitlyn Maya']"));//Advisor
				/*click(locateElement("xpath", "//a[text()='Sarah Halpin']"));*/	
				Thread.sleep(2000);
				reportStep("Contact details page is displayed", "pass", takeSnap(getTitle()));
				
			} catch (Exception e) {
				reportStep("Failed to display Contact details page", "fail", takeSnap(getTitle()));
				e.printStackTrace();
			}
	/*	try {
			WebElement accName= driver.findElement(By.xpath("(//a[@href='/lightning/r/0014g000006s0T3AAI/view'])[1]"));
			JavascriptExecutor executor1=(JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].isDispalyed();", accName);
			JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)");
			mouseHover(locateElement("xpath", "(//a[@href='/lightning/r/0014g000006s0T3AAI/view'])[1]"));
						//reportStep("Account Name in highlight panel", "pass", takeSnap(getTitle()));
						
					} catch (Exception e) {
						reportStep("Failed to highlight Account Name in Contacts page", "fail", takeSnap(getTitle()));
						e.printStackTrace();
					}
				
				try {
					scroll();
					mouseHover(locateElement("xpath", "(//a[@href='/lightning/r/0054g000000ax5iAAA/view'])[1]"));
						reportStep("Account name and Contact Owner in highlight panel", "pass", takeSnap(getTitle()));
						
					} catch (Exception e) {
						reportStep("Failed to highlight Contact Owner Name in Contacts page", "fail", takeSnap(getTitle()));
						e.printStackTrace();
					}*/
				try {
				locateElement("xpath", "(//p[text()='Account Name'])[1]").isDisplayed();
				locateElement("xpath", "(//p[text()='Contact Owner'])[1]").isDisplayed();
				locateElement("xpath", "(//p[text()='Contact Record Type'])[1]").isDisplayed();				
				
				reportStep("Contact information highlights panel fields are isplayed", "pass", takeSnap(getTitle()));
			

		} catch (Exception e) {
			reportStep("Failed to display Contact information highlights panel  fields", "fail", takeSnap(getTitle()));
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



