package salesForceWebPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.Sel.CommonMethods;

public class AccountsPage {
	
	CommonMethods methods = new CommonMethods();

	WebDriver driver;
	
	public AccountsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(xpath="//div[@title='New']")
	WebElement oNew;

	//Clicking on New
	public AccountsPage click_on_new() throws InterruptedException {
		oNew.click();


		return this;
	}
	
	
	@FindBy(xpath="//span[text()='Plan Sponsor']")
	WebElement oRecordType;
	
	@FindBy(xpath="(//span[@class='slds-radio--faux'])[10]")
	WebElement oRadiobutton;
	
	@FindBy(xpath="//button[@class='slds-button slds-button--neutral slds-button slds-button_brand uiButton']//span[text()='Next']")
	WebElement oNext;
	
	
	
	
	//Selecting account record type and click on next
		public AccountsPage select_record_type() throws InterruptedException {
						
			oRadiobutton.click();
			//oNext.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", oNext);

			return this;
		}
	
		
		
		
				
				
			@FindBy(xpath="(//div[@class='autocompleteWrapper slds-grow']//input)[1]")
			WebElement oAccountName;
			
			@FindBy(xpath="//button[@title='Save']")
			WebElement oSave;
			
			
			//Filling mandatory fields in new accounts page
			public AccountsPage enter_account_information(String accountname) throws InterruptedException {
							
				oAccountName.click();
				Thread.sleep(4000);
				oAccountName.sendKeys("Ivy Finance");
				oSave.click();
				Thread.sleep(4000);
				
				
				return this;
			}
			
				
		
		
	
	
	
	
	
	
	

}
