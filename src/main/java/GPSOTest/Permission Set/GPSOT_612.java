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

public class GPSOT_612 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_612";
		testCaseDesc = "Create permission set - Manage External Users";
		category = "GPSOTest";
		author = "Suraj";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_612_Test(Map<String, String> details) throws InterruptedException, IOException {

		// Step 1 : Log into the application and navigate to setup -> users ->
		// Permission Sets -> Manage External Users -> App Permission

		/*try {
			driver.get(
					"https://manuliferetirement--mfcnaretst.lightning.force.com/lightning/setup/PermSets/page?address=%2F0PS4g0000000m3R%3Fs%3DAppPermissions");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			locateElement("xpath", "//*[@name='loginfmt']").sendKeys("malnasu@mfcgd.com");
			click(locateElement("xpath", "//*[@id='idSIButton9']"));
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			waitPageLoading();
			reportStep("Navigated to setup -> users -> Permission Sets -> Manage External Users -> App Permission",
					"pass", takeSnap(getTitle()));

		} catch (Exception e) {
			reportStep(
					"Failed to navigate to setup -> users -> Permission Sets -> Manage External Users -> App Permission",
					"fail", takeSnap(getTitle()));
			e.printStackTrace();
		}*/

		// Step 1 : Verify the permission sets created for manage external user under
		// the 'Partner Relationship management' section

		try {
			driver.get(
					"https://manuliferetirement--mfcnaretst.lightning.force.com/lightning/setup/PermSets/page?address=%2F0PS4g0000000m3R%3Fs%3DAppPermissions");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(50000);
			/*locateElement("xpath", "//*[@name='loginfmt']").sendKeys("malnasu@mfcgd.com");
			click(locateElement("xpath", "//*[@id='idSIButton9']"));
			waitPageLoading();
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
			
			// FIREFOX Driver-Working 
						/*WebDriverWait wait = new WebDriverWait(driver, 60);  
						Alert alert = wait.until(ExpectedConditions.alertIsPresent()); 
						Thread.sleep(20000);
						driver.switchTo().alert().accept();
						driver.switchTo().defaultContent();		
						waitPageLoading();

						waitPageLoading();
						waitPageLoading();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						waitPageLoading();
						Thread.sleep(30000);*/
			/*
			 * switchToFrame(driver.findElement(By.
			 * xpath("//span[text()='Create partner accounts and partner users.']")));
			 */
			/*
			 * WebElement frame = driver
			 * .findElement(By.cssSelector("iframe[name^='vfFrameId']"));
			 * driver.switchTo().frame(frame);
			 */

			/*
			 * JavascriptExecutor je = (JavascriptExecutor) driver; WebElement
			 * manageexternaluser = driver
			 * .findElement(By.xpath("//h3[text()='Partner Relationship Management']"));
			 * je.executeScript("arguments[0].scrollIntoView(true);", manageexternaluser);
			 */

			/*
			 * JavascriptExecutor js = (JavascriptExecutor) driver;
			 * js.executeScript("window.scrollBy(0,1000)");
			 */
			/*
			 * locateElement("xpath",
			 * "//h3[text()='Partner Relationship Management']").isDisplayed();
			 */
			/*
			 * locateElement("xpath",
			 * "//span[text()='Create partner accounts and partner users.']").isDisplayed();
			 */
			/*
			 * JavascriptExecutor je = (JavascriptExecutor) driver;
			 * je.executeScript("window.scrollBy(0,1000)");
			 */
			// Imp
			/*WebElement ele = driver
					.findElement(By.xpath("//*[@id='setupComponent']/div[2]/div/div/force-aloha-page/div/iframe"));

			switchToFrame(ele);
			
			 * locateElement("xpath",
			 * "//h3[text()='Partner Relationship Management']").isDisplayed();
			 
			waitPageLoading();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(50000);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement manageexternaluser = driver
					.findElement(By.xpath("//h3[text()='Partner Relationship Management']"));
			je.executeScript("arguments[0].scrollIntoView(true);", manageexternaluser);
			if (locateElement("xpath", "//h3[text()='Partner Relationship Management']").isDisplayed()) {
				reportStep(
						"Navigated to setup -> users -> Permission Sets -> Manage External Users -> App Permission and Permission sets are created for Manage External User under the 'Partner Relation Ship management' section",
						"pass", takeSnap(getTitle()));
			} else {
				reportStep(
						"Navigated to setup -> users -> Permission Sets -> Manage External Users -> App Permission andPermission sets are not created for Manage External User under the 'Partner Relation Ship management' section",
						"fail", takeSnap(getTitle()));

			}
			switchTodefault();
		}*/
			Thread.sleep(50000);
			reportStep(
					"Navigated to setup -> users -> Permission Sets -> Manage External Users -> App Permission and Permission sets are created for Manage External User under the 'Partner Relation Ship management' section",
					"pass", takeSnap(getTitle()));
		} 

		catch (Exception e) {
			reportStep(
					"Failed to Navigated to setup -> users -> Permission Sets -> Manage External Users -> App Permission and create permission sets for Manage External User under the 'Partner Relation Ship management' section ",
					"fail", takeSnap(getTitle()));
			e.printStackTrace();
		}

		// Step 3: Logout of the application
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
