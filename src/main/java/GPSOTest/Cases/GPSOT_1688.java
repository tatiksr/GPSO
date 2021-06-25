package GPSOTest;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import salesForceWebPages.CasesPage;
import salesForceWebPages.HomePage;
import test.Sel.Project;

public class GPSOT_1688 extends Project{
	
	/**
	 *   Author: Sreeram Tatikonda
	 */
	
	//WebDriver driver;
	HomePage homePage;
	CasesPage casesPage;
	
	@BeforeTest

	public void setData() {
		testCaseName = "GPSOT_1688";
		testCaseDesc = "Verify whether System Admin is able to Expand and Collapse the Action Plans under Tasks tab.";
		category = "GPSOTest";
		author = "Sreeram Tatikonda";
		testCaseFileName = "GPSO";
		
		//homePage = new HomePage();
		//casesPage = new CasesPage();

	}
	
	public GPSOT_1688() {
		homePage = new HomePage();
		casesPage = new CasesPage();
	}
	
	@Test(dataProvider = "fetchData")
	public void GPSOT_1688_Test(Map<String, String> details) throws InterruptedException, IOException {
	
		// Step 1 : Log into the application		 

        try {
            waitPageLoading();
           // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            locateElement("xpath", "//*[@name='loginfmt']").sendKeys("tatiksr@mfcgd.com");
            click(locateElement("xpath", "//*[@id='idSIButton9']"));
           // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
        // casesPage.click_Cases_On_NavBar();
       // homePage.click_Cases_On_NavBar();
          //click(locateElement("xpath", "//span[text() = 'Cases']"));
        //click(locateElement("xpath", "//one-app-nav-bar-item-root//a[@href='/lightning/o/Case/home']"));
        

        select_Cases_From_AppLauncher("Cases");




        
        //step 3: slect first caseNumber from FirstRow()
        //casesPage.click_caseNumber_Link_inFirstRow();
        click(locateElement("xpath", "//table//tr[1]/td[3]/span//div/a"));
        
        //step 4: Click on Tasks
        //casesPage.click_Tasks_Tab();
        click(locateElement("xpath", "//a[@data-tab-value='tasksTab']"));
        
        
        //Step 5: Verify tootltip of Expand and Collapse
        String expandText = casesPage.mouseHover_On_Expand_And_Collapse();
        Assert.assertEquals(expandText, "Expand All");
        
        //Step 6: Verify tooltip of Collapse
        String collapseText = casesPage.mouseHover_To_Get_CollapseAll();
        Assert.assertEquals(collapseText, "Collapse All");
        
		
	}
	
	

}
