package test.Sel;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import test.Sel.CommonMethods;

public class Project extends CommonMethods {

	@BeforeSuite
	public void beforeSuite() throws IOException {
		beginResult();
	}

	@BeforeClass
	public void beforeClass() {
		startTestCase();
	}

	@Parameters("browser")
	@BeforeMethod()
	public void login(String browser) throws IOException {
		startApp(browser);
	}

	@AfterMethod
	public void closeApp() {
		closeBrowser();
	}

	@AfterSuite
	public void afterSuite() {
		endResult();
	}

	@DataProvider(name = "fetchData", parallel = true)
	public Object[][] fetchData() throws IOException {

		return utils.ExcelUtility.readExcel(testCaseFileName);

	}

}
