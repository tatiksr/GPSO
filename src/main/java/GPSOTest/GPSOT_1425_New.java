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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import io.appium.java_client.functions.ExpectedCondition;
import test.Sel.Project;
public class GPSOT_1425_New extends Project {

		@BeforeTest

		public void setData() {
			testCaseName = "GPSOT_1425_New";
			testCaseDesc = "Onboarding Standard User Page";
			category = "GPSOTest";
			author = "Suraj";
			testCaseFileName = "GPSO";

		}

		@Test(dataProvider = "fetchData")
		public void GPSOT_1425_New_Test(Map<String, String> details) throws InterruptedException, IOException {

			// Step 2 : Log into the application

			try {
				/*click(locateElement("xpath", "//span[text()='NASITAzureSSO']"));			*/
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				//FIREFOX Driver-Working 
				WebDriverWait wait = new WebDriverWait(driver, 60);  
				Alert alert = wait.until(ExpectedConditions.alertIsPresent()); 
				Thread.sleep(20000);
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();					
				waitPageLoading();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(15000);
				type(locateElement("xpath", "//input[@title='Search...']"), "Maia Smith");
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(5000);
				click(locateElement("xpath", "//div[@class='slds-truncate uiOutputRichText']"));
				waitPageLoading();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				click(locateElement("xpath", "//div[text()='User Detail']"));
				reportStep("Login is Successful", "pass", takeSnap(getTitle()));
			} catch (Exception e) {
				reportStep("Login not Successful", "fail", takeSnap(getTitle()));
				e.printStackTrace();

			}
				
				try {
					waitPageLoading();
					/*driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					click(locateElement("xpath", "//div[text()='User Detail']"));*/
					/*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
					Thread.sleep(5000);		
					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='User: Maia Smith ~ Salesforce - Unlimited Edition']")));
					Thread.sleep(5000);	
					click(locateElement("xpath", "//a[text()='Onboarding Standard User']"));
					Thread.sleep(5000);	
					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Profile: Onboarding Standard User ~ Salesforce - Unlimited Edition']")));
				/*	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
		            ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));*/
		
					Thread.sleep(30000);
					 Actions action=new Actions(driver); 
			          action.click(locateElement("xpath", "//h3[text()='Standard Object Permissions']"));
					/*JavascriptExecutor js = (JavascriptExecutor)driver;
			         js.executeScript("window.scrollBy(0,500)");            //Scroll Down(+ve)
			          Thread.sleep(3000);*/
					/* try {
						 Actions action=new Actions(driver);
						 action.moveToElement(locateElement("xpath", "//h3[text()='Standard Object Permissions']"), 5, 5).perform();
				        } catch (Exception e) {

				            //Alternate to activate an 'i' help hover 
				            WebElement parent = locateElement("xpath", "//h3[text()='Standard Object Permissions']").findElement(By.xpath("//h3[text()='Standard Object Permissions']"));
				            click(parent);
				            
				        }
					JavascriptExecutor js = (JavascriptExecutor)driver;
			         js.executeScript("window.scrollBy(0,500)");            //Scroll Down(+ve)
			          Thread.sleep(3000);
			          Actions action=new Actions(driver); 
			          action.click(locateElement("xpath", "//h3[text()='Standard Object Permissions']"));*/
			         /* moveToElement(locateElement("xpath", "//h3[text()='Standard Object Permissions']"));*/
			          /*action.build().perform();*/
					/*waitUntil("//h3[text()='Standard Object Permissions']");*/
					/*WebElement OBUPerm= driver.findElement(By.xpath("//h3[text()='Standard Object Permissions']"));
					JavascriptExecutor executor1=(JavascriptExecutor)driver;
					executor1.executeScript("arguments[0].click();", OBUPerm);*/
					
					reportStep("Onboarding  Standard User Page displayed", "pass", takeSnap(getTitle()));
					

				} catch (Exception e) {
					reportStep("Failed to display Onboarding  Standard User Page", "fail", takeSnap(getTitle()));
					e.printStackTrace();
				}
				/*try {
					waitPageLoading();
					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Profile: Onboarding Standard User ~ Salesforce - Unlimited Edition']")));
					Thread.sleep(5000);	
					WebElement OBUPerm= driver.findElement(By.xpath("//h3[text()='Standard Object Permissions']"));
					JavascriptExecutor executor1=(JavascriptExecutor)driver;
					executor1.executeScript("arguments[0].click();", OBUPerm);
					//locateElement("xpath", "//h3[text()='Standard Object Permissions']").click();
					locateElement("xpath", "//th[text()='Accounts']//parent::tr//child::table/tbody[1]/tr[1]/td/img[@id='crudRead___Account']").isSelected();
					locateElement("xpath", "//img[@id='crudRead___Contact']").isSelected();
					
					reportStep("Onboarding Stanadrd User Stamdard Object permissions are displayed", "pass", takeSnap(getTitle()));
					

				} catch (Exception e) {
					reportStep("Failed to display Onboarding Stanadrd User Stamdard Object permissions", "fail", takeSnap(getTitle()));
					e.printStackTrace();
				}*/

						
				}
				
}
