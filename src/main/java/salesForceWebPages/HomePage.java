package salesForceWebPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.Sel.CommonMethods;

public class HomePage {
	
	CommonMethods methods = new CommonMethods();

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	
	@FindBy(xpath="//a[@title='Home']")
	WebElement oHome;
	
	
	//Clicking Home tab
			public HomePage click_home_tab() throws InterruptedException {
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", oHome);
				//oHome.click();
				
				return this;
			}
			
			
			
			@FindBy(xpath="//input[@title='Search...']")
			WebElement oSearchbox;
			
			@FindBy(xpath="//div[@class='slds-truncate uiOutputRichText']")
			WebElement oSerachresult;
			
			@FindBy(xpath="//div[text()='User Detail']")
			WebElement oUserDetails;
			
			@FindBy(xpath="//*[@id='setupComponent']/div[2]/div/div/force-aloha-page/div/iframe")
			WebElement oNewFrame;
			
			@FindBy(xpath="(//input[@title='Login'])[1]")
			WebElement oLoginButton;
			
			//searching for user in search bar and logging in 
					public HomePage login_user() throws InterruptedException {
						oSearchbox.click();
						Thread.sleep(3000);
						oSearchbox.sendKeys("Maia Smith");
						Thread.sleep(3000);
						oSerachresult.click();
						Thread.sleep(3000);
						oUserDetails.click();
						
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			            driver.switchTo().frame(oNewFrame);
			            Thread.sleep(3000);
			            oLoginButton.click();
			            //Thread.sleep(3000);
			            driver.switchTo().defaultContent();
						
						return this;
					}
					
					
					@FindBy(xpath="//a[@title='Accounts']")
					WebElement oAccounts;
					
					
					public AccountsPage click_accounts_tab() throws InterruptedException {
						
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].click();", oAccounts);
						//oHome.click();
						
						return new AccountsPage(driver);
					}
					
					

}
