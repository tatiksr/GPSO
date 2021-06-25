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
	public class GPSOT_1590 extends Project {

			@BeforeTest

			public void setData() {
				testCaseName = "GPSOT_1590";
				testCaseDesc = "SF - Create Public Groups for Account Object";
				category = "GPSOTest";
				author = "Suraj";
				testCaseFileName = "GPSO";

			}

			@Test(dataProvider = "fetchData")
			public void GPSOT_1590_Test(Map<String, String> details) throws InterruptedException, IOException {

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
					type(locateElement("xpath", "//input[@title='Search...']"), "Sally Smith");
					//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					Thread.sleep(5000);
					click(locateElement("xpath", "//div[@class='slds-truncate uiOutputRichText']"));
					waitPageLoading();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
					click(locateElement("xpath", "//div[text()='User Detail']"));
					
					reportStep("Login is Successful", "pass", takeSnap(getTitle()));
				} catch (Exception e) {
					reportStep("Login not Successful", "fail", takeSnap(getTitle()));
					e.printStackTrace();

				}
					
					try {
						waitPageLoading();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						Thread.sleep(3000);	
						/*click(locateElement("xpath", "//div[text()='User Detail']"));
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						Thread.sleep(5000);*/		
						/*driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='User: Sally Smith ~ Salesforce - Unlimited Edition']")));
						Thread.sleep(5000);	*/
						click(locateElement("xpath", "//a[text()='Public Groups']"));
						Thread.sleep(3000);	
						reportStep("Public Groups Page is displayed", "pass", takeSnap(getTitle()));
						

					} catch (Exception e) {
						reportStep("Failed to display Public Groups Page", "fail", takeSnap(getTitle()));
						e.printStackTrace();
					}
					try {
						waitPageLoading();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						
						driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Public Groups ~ Salesforce - Unlimited Edition']")));
						
						click(locateElement("xpath", "//a[text()='US Account Read']"));
						Thread.sleep(2000);
						driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Group: US Account Read ~ Salesforce - Unlimited Edition']")));
						locateElement("xpath", "//td[text()='Label']//following-sibling::td[text()='US Account Read']").isDisplayed();//label name
						
						locateElement("xpath", "//td[text()='Group Name']//following-sibling::td[text()='US_Account_Read']").isDisplayed();//Group Name
						locateElement("xpath", "//td[text()='Grant Access Using Hierarchies']//following-sibling::td//img[@title='Checked']").isEnabled();//Grant access using hierarchies
						
						
						locateElement("xpath", "//a[text()='AVP of Administration']").isDisplayed();
						locateElement("xpath", "//a[text()='AVP of ERISA']").isDisplayed();
						Thread.sleep(3000);	
						driver.switchTo().defaultContent();
						reportStep("Account Read Page displayed", "pass", takeSnap(getTitle()));
						

					} catch (Exception e) {
						reportStep("Failed to display Account Read Page", "fail", takeSnap(getTitle()));
						e.printStackTrace();
					}
					try {
						click(locateElement("xpath", "//a[text()='Public Groups']"));
						Thread.sleep(3000);
						
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						
						driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Public Groups ~ Salesforce - Unlimited Edition']")));
						
						click(locateElement("xpath", "//a[text()='US Account Read/Write']"));
						Thread.sleep(2000);
						driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Group: US Account Read/Write ~ Salesforce - Unlimited Edition']")));
						locateElement("xpath", "//td[text()='Label']//following-sibling::td[text()='US Account Read/Write']").isDisplayed();//label name
						
						locateElement("xpath", "//td[text()='Group Name']//following-sibling::td[text()='US_Account_Read_Write']").isDisplayed();//Group Name
						locateElement("xpath", "//td[text()='Grant Access Using Hierarchies']//following-sibling::td//img[@title='Checked']").isEnabled();//Grant access using hierarchies
						
						
						locateElement("xpath", "//a[text()='AVP Client Services']").isDisplayed();
						
						Thread.sleep(3000);	
						driver.switchTo().defaultContent();
						reportStep("Account Read/Write Page displayed", "pass", takeSnap(getTitle()));
						

					} catch (Exception e) {
						reportStep("Failed to display Account Read/Write Page", "fail", takeSnap(getTitle()));
						e.printStackTrace();
					}
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
					
	
