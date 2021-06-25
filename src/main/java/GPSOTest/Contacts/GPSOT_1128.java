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

import salesForceWebPages.AppLauncherPage;
import salesForceWebPages.CasesPage;
import salesForceWebPages.HomePage;
import salesForceWebPages.LightningCommonPage;
import salesForceWebPages.PlansPage;
import test.Sel.Project;

public class GPSOT_1128 extends Project {

	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_1128";
		testCaseDesc = "Initial Contact Setup: Create RPS Contacts Page Layout (Advisor Contacts) in Salesfor";
		category = "GPSOTest";
		author = "Supriya Subramanya";
		testCaseFileName = "GPSO";

	}

	@Test(dataProvider = "fetchData")
	public void GPSOT_1128_Test(Map<String, String> details) throws InterruptedException, IOException {

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
		
		
		
		
		//Step 2: click on contacts tab and open a required contact
				try {
					
					new HomePage(driver).click_contacts_tab();
					click(locateElement("xpath", "(//span[text()='Recently Viewed'])[1]"));				
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					click(locateElement("xpath", "(//span[text()='All Contacts'])[1]"));
					Thread.sleep(2000);
					//click(locateElement("xpath", "//input[@name='Account-search-input']"));
					driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys("Lucas Barton");
					driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys(Keys.ENTER);
					click(locateElement("xpath", "//a[@title='Lucas Barton']"));
					waitPageLoading();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
					if(driver.findElement(By.xpath("//span[text()='Lucas Barton']")).isDisplayed()) {
						reportStep("Contact page opened successfully", "pass", takeSnap(getTitle()));
					}else {
						reportStep("Unable to navigate to Contacts page", "fail", takeSnap(getTitle()));
					}
						
				} catch (Exception e) {
					reportStep("Unable to navigate to Contacts page", "fail", takeSnap(getTitle()));
					e.printStackTrace();

				}
				
				
				
				

		
		//Step 3: Validate all the fields on information section in Contacts details page
				try {
					if (locateElement("xpath", "//span[text()='US Retirement']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Full Name']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Salutation']").isDisplayed() &&
							locateElement("xpath", "//label[text()='First Name']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Middle Name']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Last Name']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Suffix']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Account ID']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Contact Role']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Title']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Nickname']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Gender']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Birthdate']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Email']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Mobile Phone']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Other Phone']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Business Fax']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Website']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Referenceable?']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Referenceable Effective Date']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Seller']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Person ID']").isDisplayed() &&
							locateElement("xpath", "//label[text()='TH RVP – FA Rating']").isDisplayed() &&
							locateElement("xpath", "//label[text()='National Account – FA Rating']").isDisplayed() &&
							locateElement("xpath", "//label[text()='National Account – FA Tier']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Blue Dot']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Owner ID']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Record Type ID']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Blue Dot Indicator']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Contact Status']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Contact Status Effective Date']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Elite Advisor?']").isDisplayed() &&
							locateElement("xpath", "//label[text()='MM RVP - FA Rating']").isDisplayed() &&
							locateElement("xpath", "//span[text()='In ISC Business Plan']").isDisplayed() &&
							locateElement("xpath", "//span[text()='In Prior Year ISC Business Plan']").isDisplayed() &&
							//locateElement("xpath", "//label[text()='Assistant's Name']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Assistant Email']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Asst. Phone']").isDisplayed() &&
							locateElement("xpath", "//label[text()='CRD Number']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Social Security Number']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Surviving Contact']").isDisplayed() 

							) {
						reportStep("All the fields are displaying in the Contact Information secdtion of Contacts details page", "pass",
								takeSnap(getTitle()));
					} else {
						reportStep("Fields are missing in Contacts details page", "fail",
								takeSnap(getTitle()));
					}

				} catch (Exception e) {
					reportStep("Failed to display field in the Contacts details page", "fail",
							takeSnap(getTitle()));
					e.printStackTrace();
				}
				
				
				
				//Step 4: Validate all the fields on Address Information section in Contacts details page
				try {
					if (locateElement("xpath", "//span[text()='Address Information']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Mailing City']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Mailing State/Province']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Mailing Street']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Mailing Country']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Mailing Zip/Postal Code']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Other City']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Other Street']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Other City']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Other State/Province']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Other Zip/Postal Code']").isDisplayed() 
							) {
						reportStep("All the fields are displaying in the Address Information section of Contacts details page", "pass",
								takeSnap(getTitle()));
					} else {
						reportStep("Fields are missing in Contacts details page", "fail",
								takeSnap(getTitle()));
					}

				} catch (Exception e) {
					reportStep("Failed to display field in the Contacts details page", "fail",
							takeSnap(getTitle()));
					e.printStackTrace();
				}	
		
				
		
				
				//Step 5: Validate all the fields on Description section in Contacts details page
				try {
					if (locateElement("xpath", "//span[text()='Description']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Contact Description']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Personal Information']").isDisplayed() 
							) {
						reportStep("All the fields are displaying in Description section of the Contacts details page", "pass",
								takeSnap(getTitle()));
					} else {
						reportStep("Fields are missing in Contacts details page", "fail",
								takeSnap(getTitle()));
					}

				} catch (Exception e) {
					reportStep("Failed to display field in the Contacts details page", "fail",
							takeSnap(getTitle()));
					e.printStackTrace();
				}	

				
				//Step 6: Validate all the fields on Active Signature Contracts section in Contacts details page
				try {
					if (locateElement("xpath", "//span[text()='Active Signature Contracts']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Number of Active Contracts']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Number of Lives in Active Contracts']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Products Held']").isDisplayed() &&
							locateElement("xpath", "//label[text()='First Contract Effective Date']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Last Contract Effective Date']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Line of Business']").isDisplayed()
							) {
						reportStep("All the fields are displaying in Active Signature Contracts section of the Contacts details page", "pass",
								takeSnap(getTitle()));
					} else {
						reportStep("Fields are missing in Contacts details page", "fail",
								takeSnap(getTitle()));
					}

				} catch (Exception e) {
					reportStep("Failed to display field in the Contacts detailspage", "fail",
							takeSnap(getTitle()));
					e.printStackTrace();
				}
		
		
				//Step 7: Validate all the fields on Assets Under Management Information section in Contacts details page
				try {
					if (locateElement("xpath", "//span[text()='Assets Under Management Information']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Signature Total AUM']").isDisplayed() &&
							locateElement("xpath", "//label[text()='TRS Total AUM']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Enterprise Total AUM']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Total AUM']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Total AUM As Of Date']").isDisplayed()
							) {
						reportStep("All the fields are displaying in Assets Under Management Information section of the Contacts details page", "pass",
								takeSnap(getTitle()));
					} else {
						reportStep("Fields are missing in Contacts details page", "fail",
								takeSnap(getTitle()));
					}

				} catch (Exception e) {
					reportStep("Failed to display field in the Contacts detailspage", "fail",
							takeSnap(getTitle()));
					e.printStackTrace();
				}
				
				
				//Step 8: Validate all the fields on Active Signature Contracts section in Contacts details page
				try {
					if (locateElement("xpath", "//span[text()='Assets Under Management Information']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Signature Total AUM']").isDisplayed() &&
							locateElement("xpath", "//label[text()='TRS Total AUM']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Enterprise Total AUM']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Total AUM']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Total AUM As Of Date']").isDisplayed()
							) {
						reportStep("All the fields are displaying in Active Signature Contracts section of the Contacts details page", "pass",
								takeSnap(getTitle()));
					} else {
						reportStep("Fields are missing in Contacts details page", "fail",
								takeSnap(getTitle()));
					}

				} catch (Exception e) {
					reportStep("Failed to display field in the Contacts details page", "fail",
							takeSnap(getTitle()));
					e.printStackTrace();
				}
		
				
				//Step 9: Validate all the fields on Marketing section in Contacts details page
				try {
					if (locateElement("xpath", "//span[text()='Marketing']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Future Prospect?']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Does not want to do Business with JH']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Advisor Risk Rating']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Product Preferences']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Sells Taft Hartley?']").isDisplayed() &&
							locateElement("xpath", "//span[text()='403B?']").isDisplayed()
							) {
						reportStep("All the fields are displaying in Marketing section of the Contacts details page", "pass",
								takeSnap(getTitle()));
					} else {
						reportStep("Fields are missing in Contacts details page", "fail",
								takeSnap(getTitle()));
					}

				} catch (Exception e) {
					reportStep("Failed to display field in the Contacts details page", "fail",
							takeSnap(getTitle()));
					e.printStackTrace();
				}
				
				//Step 10: Validate all the fields on Advisor/Consultant Profile section in Contacts details page
				//
				try {
					if (locateElement("xpath", "//span[text()='Advisor/Consultant Profile']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Advisor Profile Complete?']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Contact Preference']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Contact Frequency Preference']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Value Proposition to Plan Sponsor']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Practice and Strategy Overview']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Value-Add Services Offered']").isDisplayed()
							) {
						reportStep("All the fields are displaying in Advisor/Consultant Profile section of the Contacts details page", "pass",
								takeSnap(getTitle()));
					} else {
						reportStep("Fields are missing in Contacts details page", "fail",
								takeSnap(getTitle()));
					}

				} catch (Exception e) {
					reportStep("Failed to display field in the Contacts details page", "fail",
							takeSnap(getTitle()));
					e.printStackTrace();
				}
				
				//Step 11: Validate all the fields on Advisor Block of Business section in Contacts details page
				//
				try {
					if (locateElement("xpath", "//span[text()='Advisor Block of Business']").isDisplayed() &&
							locateElement("xpath", "//label[text()='AUA for Advisor']").isDisplayed() &&
							locateElement("xpath", "//label[text()='AUA As Of Date for Advisor']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Number of Retirement Plan Clients']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Percent for Retirement Business']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Other Business']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Number of Plans > 100M']").isDisplayed()
							) {
						reportStep("All the fields are displaying in Advisor Block of Business section of the Contacts details page", "pass",
								takeSnap(getTitle()));
					} else {
						reportStep("Fields are missing in Contacts details page", "fail",
								takeSnap(getTitle()));
					}

				} catch (Exception e) {
					reportStep("Failed to display field in the Contacts details page", "fail",
							takeSnap(getTitle()));
					e.printStackTrace();
				}
		
				
				//Step 12: Validate all the fields on Miscellaneous section in Contacts details page
				//
				try {
					if (locateElement("xpath", "//span[text()='Miscellaneous']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Certifications and Designations']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Compensation Types']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Fee for Service?']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Region/Branch Number']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Import File Name']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Team Type']").isDisplayed()
							) {
						reportStep("All the fields are displaying in Miscellaneous section of the Contacts details page", "pass",
								takeSnap(getTitle()));
					} else {
						reportStep("Fields are missing in Contacts details page", "fail",
								takeSnap(getTitle()));
					}

				} catch (Exception e) {
					reportStep("Failed to display field in the Contacts details page", "fail",
							takeSnap(getTitle()));
					e.printStackTrace();
				}
				
				//Step 3: Validate all the fields on System Information section in Contacts details page
				try {
					if (locateElement("xpath", "//span[text()='System Information']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Created By ID']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Satuit ID']").isDisplayed() &&
							locateElement("xpath", "//label[text()='PeopleSoft ID']").isDisplayed() &&
							locateElement("xpath", "//label[text()='Last Modified By ID']").isDisplayed() &&
							locateElement("xpath", "//span[text()='Override Territory Assignment?']").isDisplayed() &&
							locateElement("xpath", "//span[text()='House?']").isDisplayed()
							) {
						reportStep("All the fields are displaying in System Information section of the Contacts details page", "pass",
								takeSnap(getTitle()));
					} else {
						reportStep("Fields are missing in Contacts details page", "fail",
								takeSnap(getTitle()));
					}

				} catch (Exception e) {
					reportStep("Failed to display field in the Contacts details page", "fail",
							takeSnap(getTitle()));
					e.printStackTrace();
				}
		
		
		
		
	}
}
