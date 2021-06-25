/**
 * 
 */
package salesForceWebPages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import test.Sel.CommonMethods;
import test.Sel.Project;


/**
 * @author subrsup
 *
 */
public class CasesPage extends CommonMethods {
	

	//CommonMethods cmethods = new CommonMethods();

	//WebDriver driver;
	
	@SuppressWarnings("deprecation")
	Wait<WebDriver> wait ;
		
		
	
	public CasesPage() {

		//this.driver = driver;
		PageFactory.initElements(driver, this);	
	}

	/*@FindBy(xpath = "//one-app-nav-bar-item-root//a[@href='/lightning/o/Case/home']")
	private WebElement Cases_Nav_Bar;*/
	
	////one-app-nav-bar-item-root//a[@title='Cases']
	
	@FindBy(xpath = "//table[@data-aura-class = 'uiVirtualDataTable']//tr[1]/td[3]/span//div/a")
	//@FindBy(xpath = "//table[@data-aura-class = 'uiVirtualDataTable']//tr[1]//th[@tabindex = '-1']/span/a[1]")
	private WebElement caseNumber_Link_inFirstRow;
	
	@FindBy(xpath="//a[@data-tab-value='tasksTab']")
	private WebElement tasks_tab;
	
	@FindBy(xpath="//lightning-button-icon[@slot='actions'][1]")
	private WebElement expandAndColapse_Button; 
	
	public String expandAndColapse_Element = "//lightning-button-icon[@slot='actions'][1]//button[@title='Expand All']";
	////*[@data-key='expand_all']
	@FindBy(xpath="//slot/lightning-button-icon[1]/button/span")
	private WebElement expand_Collapse_Element;
	
public String expand_Collapse = "//slot/lightning-button-icon[1]/button/span";
		
	@FindBy(xpath="//lightning-button-icon[@slot='actions'][1]//span")
	private WebElement expandAndCollapse_tooltip;
	
	public String expandAndCollapse_tooltip_Element = "//lightning-button-icon[@slot='actions'][1]//span";
	
       //"//lightning-button-icon[@slot='actions'][1]//span[text()='Collapse All']")
	//button[@title='Expand All']//span[text()='Expand All']
	
	//ActionPlan table
	@FindBy(xpath="//table[@role='treegrid']//tbody")
	private WebElement actionPlan_Treegrid;
	
	public String actionPlan_Treegrid_Table = "//table[@role='treegrid']//tbody";
	public String onBoardingDriectorQue_Cell = "//td[3]//lightning-base-formatted-text";
	public String onBoardingDriectorQue_TaskStatus_Cell = "//td[1]//lightning-base-formatted-text";
	public String showActions_button = "//td[4]//span[text()='Show actions']";
	public String accept_Menu = "//td[4]//lightning-button-menu//a/span[text()='Accept']";
	
	//table[@role='treegrid']//tbody//tr[5]/td[3]//div/lightning-base-formatted-text
	//table[@role='treegrid']//tbody//tr[5]/td[3]//lightning-base-formatted-text  -- Onboarding Director Queue
	//table[@role='treegrid']//tbody//tr[5]/td[1]//lightning-base-formatted-text -- Not Started
	//table[@role='treegrid']//tbody//tr[5]//td[4]//lightning-button-menu//a/span[text()='View']  -- Veiw/Accept/Edit
	
		
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

     //click on cases on nav bar
/*	public void click_Cases_On_NavBar() {
		Cases_Nav_Bar.click();		
	}*/
	
	//click on 
     public void click_caseNumber_Link_inFirstRow() {
    	 caseNumber_Link_inFirstRow.click();
     }
     
     //click on Tasks tab
     public void click_Tasks_Tab() {
    	 waitPageLoading();
    	 tasks_tab.click();    	 
     }
     
     public WebElement expandCollapse() {
    	 
          return driver.findElement(By.xpath("//lightning-button-icon[@slot='actions'][1]"));    	 
    	 
    	 
 
     }
     
     //Sreeram
     public String mouseHover_On_Expand_And_Collapse() throws InterruptedException {
    	 
    	 String text="";
    	 //cmethods.verifyDisplayed(expandAndColapse_Button);
		// scroll();
		 if(locateElement("xpath", expandAndColapse_Element).isDisplayed())
		   {
			// click_JS(locateElement("xpath", expand_Collapse));
			 //mouseHover(locateElement("xpath", expandAndColapse_Element));
			// mouseHover(locateElement("xpath", expand_Collapse));
			  text = locateElement("xpath", expandAndCollapse_tooltip_Element).getText();
		   }
		return text;
     }

    
     /**
      * Author: Sreeram
      * Get the text when collapsed the button
      */
     public String mouseHover_To_Get_CollapseAll() {
    	 
    	 String text = "";
    	 if(locateElement("xpath", expand_Collapse).isDisplayed())
		   {
			 click_JS(locateElement("xpath", expand_Collapse));
			 //mouseHover(locateElement("xpath", expandAndColapse_Element));
			// mouseHover(locateElement("xpath", expand_Collapse));
			  text = locateElement("xpath", expandAndCollapse_tooltip_Element).getText();
		   }
    	 return text;
     }
     
     /**
      * Author: Sreeram
      * Click on Expand_collapse_button
      */
     public void clickJS_Expand_Collapse_Button() {
    	 click_JS(locateElement("xpath", expand_Collapse));
     }

/**
 * Get the table content from action plan table grid          
 * @throws IOException 
 */
     public void accept_Action_Task_Under_Que() throws IOException {
    	 
    	 try {
    		 if(locateElement("xpath", actionPlan_Treegrid_Table).isDisplayed())
    		 {
    			 WebElement table = locateElement("xpath", "actionPlan_Treegrid_Table");
    			 List<WebElement> rows = table.findElements(By.tagName("tr"));
    			 for(int row = 0; row < rows.size(); row++)
    			     {
    				     if(locateElement("xpath", actionPlan_Treegrid_Table+"//tr["+row+"]"+onBoardingDriectorQue_Cell).getText().equalsIgnoreCase("Onboarding Director Queue"))
    				     {
    				    	 if(locateElement("xpath", actionPlan_Treegrid_Table+"//tr["+row+"]"+onBoardingDriectorQue_TaskStatus_Cell).getText().equalsIgnoreCase("Not Started"))
    				    	     {
    				    		    click_JS(locateElement("xpath", actionPlan_Treegrid_Table+"//tr["+row+"]"+showActions_button));   		    
    				    		    click_JS(locateElement("xpath", actionPlan_Treegrid_Table+"//tr["+row+"]"+accept_Menu));
    				    	     }
    				    	 else
    				    	     {
    				    		     reportStep(locateElement("xpath", actionPlan_Treegrid_Table+"//tr["+row+"]"+onBoardingDriectorQue_TaskStatus_Cell).getText()+" is present instead of Not Started.", "fail", takeSnap(getTitle()));
    				    	     }
    				     }
    				     else
    				     {
    				    	 reportStep(locateElement("xpath", actionPlan_Treegrid_Table+"//tr["+row+"]"+onBoardingDriectorQue_Cell).getText()+" is present instead of Onboarding Director Queue.", "fail", takeSnap(getTitle()));
    				     }
    			     }
    			 
    		 }
    		 else
    		 {
    			 reportStep("Unable to find action plan table. Pelase check with locator: "+ actionPlan_Treegrid_Table, "fail", takeSnap(getTitle()));
    		 }
    	 }
    	 catch(Exception e) {
    		 reportStep("Unable to find action plan table", "fail", takeSnap(getTitle()));
    		 e.printStackTrace();
    	 }
     }
     
    


}
