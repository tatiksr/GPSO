package GPSOTest;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import salesForceWebPages.CasesPage;
import salesForceWebPages.HomePage;
import test.Sel.Project;

public class GPSOT_1685 extends Project {
	
	/**
	 *   Author: Sreeram Tatikonda
	 */
	
	//WebDriver driver;
	HomePage homePage;
	CasesPage casesPage;
	
	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_1685";
		testCaseDesc = "Verify whether the System Admin user is able to invoke an Accept action on a Task which has been assigned to a Queue when viewing a Task from Task details page (record view)";
		category = "GPSOTest";
		author = "Sreeram Tatikonda";
		testCaseFileName = "GPSO";
		
		//homePage = new HomePage();
		//casesPage = new CasesPage();

	}
	
	public GPSOT_1685() {
		homePage = new HomePage();
		casesPage = new CasesPage();
	}
	
	@Test(dataProvider = "fetchData")
	public void GPSOT_1685_Test(Map<String, String> details) throws InterruptedException, IOException {
		
		// Step 1 : Log into the application		 

        try {
            waitPageLoading();
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            locateElement("xpath", "//*[@name='loginfmt']").sendKeys("tatiksr@mfcgd.com");
            click(locateElement("xpath", "//*[@id='idSIButton9']"));
           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            waitPageLoading();
            if (locateElement("xpath", "//span[text() = 'Home']").isDisplayed()) {
                reportStep("Login is Successful", "pass", takeSnap(getTitle()));
            } else {
                reportStep("Login not Successful", "fail", takeSnap(getTitle()));
            }
        } catch (Exception e) {
            reportStep("Unable to login to application", "fail", takeSnap(getTitle()));
            e.printStackTrace();
        }
        
        //Step 2: click on Cases from nav bar
         select_Cases_From_AppLauncher("Cases");
        
        //step 3: slect first caseNumber from FirstRow()
        //casesPage.click_caseNumber_Link_inFirstRow();
        click(locateElement("xpath", "//table//tr[1]/td[3]/span//div/a"));
        
        //step 4: Click on Tasks
        //casesPage.click_Tasks_Tab();
        click(locateElement("xpath", "//a[@data-tab-value='tasksTab']"));
        
        //step 5: click on Expand_Collapse_Button
        casesPage.clickJS_Expand_Collapse_Button();
        
        //Step 6: Accept action task which assigned to Onboarding Director Que
        casesPage.accept_Action_Task_Under_Que();
 	}

}
