/**
 * 
 */
package salesForceWebPages;

import java.util.List;

import org.openqa.selenium.By;
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
public class AppLauncherPage {
	
	CommonMethods cmethods = new CommonMethods();

	WebDriver driver;
	
	
	public AppLauncherPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(xpath="//div[@class='appLauncher slds-context-bar__icon-action']")
	WebElement oApplauncher;
	
	@FindBy(xpath="//button[text()='View All']")
	WebElement oViewall;
	
	@FindBy(xpath="//lightning-input[@class='searchBar slds-form-element']")
	WebElement oSearchbox;
	
	/*@FindBy(xpath="//lightning-input[@class='searchBar slds-form-element']//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']")
	WebElement oSearchbox;
	*/
	
	
	/*//Clicking on App launcher and searching for app
		public AppLauncherPage search_app(String appname) throws InterruptedException {
			oApplauncher.click();
			oViewall.click();
			oSearchbox.sendKeys(appname);
			driver.findElement(By.xpath("//span[@class='slds-truncate label-display']//span//p//mark[text()='"+"Cases"+"']")).click();
	         
			
			return this;
		}
		*/
	
		//Clicking on App launcher and searching for app(case)
		public AppLauncherPage search_app(String appname) throws InterruptedException {
			oApplauncher.click();
			oViewall.click();
			oSearchbox.sendKeys(appname);
			driver.findElement(By.xpath("//span[@class='slds-truncate label-display']//span//p//mark[text()='"+"Cases"+"']")).click();
			//driver.findElement(By.xpath("//span[@class='slds-truncate label-display']//span//p//mark[text()='"+"Plans"+"']")).click();
	         
			
			return this;
		}
		
		//Clicking on App launcher and searching for app(plan)
				public AppLauncherPage search_app1() throws InterruptedException {
					oApplauncher.click();
					oViewall.click();
					oSearchbox.sendKeys("Plans");
					//driver.findElement(By.xpath("//span[@class='slds-truncate label-display']//span//p//mark[text()='"+"Cases"+"']")).click();
					driver.findElement(By.xpath("//span[@class='slds-truncate label-display']//span//p//mark[text()='"+"Plans"+"']")).click();
			         
					
					return this;
				}
	
	
	
	
	
	
	
}
