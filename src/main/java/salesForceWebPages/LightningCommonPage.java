/**
 * 
 */
package salesForceWebPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
public class LightningCommonPage {
	
	CommonMethods cmethods = new CommonMethods();

	WebDriver driver;
	
	
	public LightningCommonPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	
	
	@FindBy(xpath="//div[@class='headerButtonBody']")
	WebElement oBellIcon;
	
	@FindBy(xpath="(//span[@class='notification-text-title uiOutputText'])[1]")
	WebElement oClickNotification;
	
	

		//Checking custom notification
		public LightningCommonPage check_custom_notification() throws InterruptedException {
			oBellIcon.click();
			//oClickNotification.click();
			
			
			return this;
		}
		
		
		//Clicking on notificTION
		
		public LightningCommonPage click_custom_notification() throws InterruptedException {
			//oBellIcon.click();
			oClickNotification.click();
			
			
			return this;
		}
		
		
		
	
	
	
	
}
