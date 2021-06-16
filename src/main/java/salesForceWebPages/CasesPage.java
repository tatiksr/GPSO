/**
 * 
 */
package salesForceWebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import test.Sel.CommonMethods;


/**
 * @author subrsup
 *
 */
public class CasesPage {
	

	CommonMethods cmethods = new CommonMethods();

	WebDriver driver;


	public CasesPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}


	@FindBy(xpath="//div[@title='New']")
	WebElement oNew;



	//Clicking on New
	public CasesPage click_on_new() throws InterruptedException {
		oNew.click();


		return this;
	}


	@FindBy(xpath="(//a[@class='select'])[2]")
	WebElement oCaseOrigin;

	@FindBy(xpath="//input[@title='Search Plans']")
	WebElement oSearchPlan;

	@FindBy(xpath="//div[@title='GPSO Test Plan']")
	WebElement oPlan;

	@FindBy(xpath="//button[@title='Save']")
	WebElement oSave;

	/*@FindBy(xpath="(//a[@class='select'])[2]")
		WebElement oCaseOrigin;

		@FindBy(xpath="(//a[@class='select'])[2]")
		WebElement oCaseOrigin;
	 */
	//entering case information, plan overview in new case page
	public CasesPage enter_case_details() throws InterruptedException {

		oCaseOrigin.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Web']")).click();
		oSearchPlan.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='GPSO Test Plan']")).click();

		oSave.click();
		Thread.sleep(3000);
		return this;
	}





	@FindBy(xpath="//a[text()='Details']")
	WebElement oDetails;

	//clicking on details tab on class page
	public CasesPage click_details() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", oDetails);
		oDetails.click();
		Thread.sleep(3000);

		return this;
	}		


	@FindBy(xpath="//lightning-button-icon[@class='slds-shrink-none change-owner-trigger']")
	WebElement oChangeOwner;

	@FindBy(xpath="//input[@title='Search Users']")
	WebElement oSearchUsers;

	@FindBy(xpath="//div[@title='Maia Smith']")
	WebElement oSearchResult;

	@FindBy(xpath="//button[text()='Change Owner']")
	WebElement oChangeOwnerButton;


	//changing case owner
	public CasesPage change_case_owner() throws InterruptedException {


		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", oDetails);
		js.executeScript("arguments[0].click();", oChangeOwner);
		oSearchUsers.sendKeys("Maia Smith");
		Thread.sleep(3000);
		oSearchResult.click();
		Thread.sleep(3000);
		oChangeOwnerButton.click();
		Thread.sleep(3000);
		//js.executeScript("arguments[0].click();", oChangeOwner);

		return this;
	}		


	@FindBy(xpath="//span[text()='GPSO Test Plan']")
	WebElement oPlanName;

	//clicking on plan on case detail page
	//
	public PlansPage click_plan() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", oPlanName);
		Thread.sleep(3000);
		
		//oPlanName.click();
		//driver.findElement(By.xpath("//span[text()='GPSO Test Plan'"])).click();
		

		return new PlansPage(driver);
	}		





}
