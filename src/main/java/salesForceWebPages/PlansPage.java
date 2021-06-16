package salesForceWebPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.Sel.CommonMethods;

public class PlansPage {
	
	CommonMethods methods = new CommonMethods();

	WebDriver driver;
	
	public PlansPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	
	@FindBy(xpath="//a[@title='Net Shell 401(k)']")
	WebElement oPlanName;
	
	
	//Clicking on Plan
	//
			public PlansPage click_plan() throws InterruptedException {
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", oPlanName);
				
				
				return this;
			}
			
			
			
		

}