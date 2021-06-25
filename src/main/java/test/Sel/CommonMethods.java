package test.Sel;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utils.Reporter;

public class CommonMethods extends Reporter implements FrameworkInterface {

	public static RemoteWebDriver driver;
	public String sUrl, primaryWindowHandle, sHubUrl, sHubPort, appUrl;
	int i = 1;

	public void startApp(String browser) throws IOException {
		try {
			if (browser.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				driver = new ChromeDriver(options);
				options.addArguments("--start-maximized");
				options.addArguments("--start-fullscreen");

			} else if (browser.equalsIgnoreCase("firefox")) {

				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("IE")) {

				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}
			
			else if (browser.equalsIgnoreCase("Edge")) {

				System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
				driver = new EdgeDriver();

			}
			
			

			if (testCaseFileName != "GPSO") {
				appUrl = testCaseFileName + "_" + configFileReader("Loc") + "_" + configFileReader("Region");
			} else {
				appUrl = testCaseFileName + "_" + configFileReader("Region");
			}

			driver.get(configFileReader(appUrl));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			reportStep("The browser:" + browser + " launched successfully", "pass", takeSnap(getTitle()));
		} catch (WebDriverException e) {
			e.printStackTrace();
			reportStep("The browser:" + browser + " could not be launched", "fail", takeSnap(getTitle()));
		}

	}

	public String configFileReader(String value) {

		BufferedReader reader;
		Properties pro = null;

		try {

			reader = new BufferedReader(new FileReader("config//configuration.properties"));
			pro = new Properties();
			pro.load(reader);
			reader.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (pro.getProperty(value) != null)
			return pro.getProperty(value);
		else
			throw new RuntimeException("The value specified is not available in the property file");

	}

	public boolean selectContract(String contract) throws IOException {
		try {
			try {

				click(locateElement("xpath", "//*[@href='javascript:doSubmit(" + contract + ")']"));
				return true;
			} catch (Exception e) {

				type(locateElement("xpath", "//input[@name='contractNumber' and @type='text']"), contract);
				return true;
			}
		} catch (Exception e) {

			return false;
		}
	}

	public void mouseHover(WebElement ele) throws InterruptedException {

		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		Thread.sleep(1000);
	}

	public void scroll() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	public void isImageBroken() throws IOException {

		for (WebElement image : driver.findElements(By.cssSelector("img")))

		{

			image.getAttribute("alt");
			if (image.getAttribute("naturalWidth").equals("0")) {
				System.out.println(image.getAttribute("outerHTML") + " is broken.");
				reportStep(image.getAttribute("alt") + " is broken", "fail", takeSnap(getTitle()));
			}

		}

	}

	public void isLinksBroken() throws MalformedURLException, IOException {

		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		for (WebElement link : driver.findElements(By.tagName("a"))) {

			url = link.getAttribute("href");

			if ((url != null) && !url.startsWith("javascript") && !url.contains(".html") && !url.contains(".com")) {

				try {
					huc = (HttpURLConnection) (new URL(url).openConnection());
					huc.setRequestMethod("HEAD");
					huc.connect();
					respCode = huc.getResponseCode();
				} catch (Exception e) {

					reportStep("Response timed out for URL: " + link.getText(), "fail", takeSnap(getTitle()));
				}

				if (respCode >= 400) {

					reportStep("Link broken for URL: " + link.getText(), "fail", takeSnap(getTitle()));
				}

			}
		}
	}

	public void waitUntil(String path) {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
	}

	public WebElement locateElement(String locator, String locValue) {

		try {
			switch (locator) {

			case ("id"):
				return driver.findElementById(locValue);
			case ("linkText"):
				return driver.findElementByLinkText(locValue);
			case ("xpath"):
				return driver.findElementByXPath(locValue);
			case ("name"):
				return driver.findElementByName(locValue);
			case ("class"):
				return driver.findElementByClassName(locValue);
			case ("tag"):
				return driver.findElementByTagName(locValue);
			case ("css"):
				return driver.findElementByCssSelector(locValue);
			}
		} catch (NoSuchElementException e) {

			System.out.println("The element with locator " + locator + " and with value " + locValue + " not found.");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			System.out.println("WebDriverException");
			throw new RuntimeException();
		}
		return null;
	}

	public void clickBack() {

		driver.navigate().back();
	}

	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
	}

	public List<WebElement> locateElements(String locValue) {
		// List<WebElement> listOfElements = driver.findElements(By.xpath(locValue));
		// System.out.println(listOfElements.size());
		return driver.findElements(By.xpath(locValue));
	}

	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			// reportStep("The data: "+data+" entered successfully","Pass");
			// throw new RuntimeException();
		} catch (InvalidElementStateException e) {
			System.out.println("The data: " + data + " could not entered");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			System.out.println("WebDriverException" + e.getMessage());
			throw new RuntimeException();
		}
	}

	public void click(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(ele));

			text = ele.getText();
			ele.click();
			// reportStep("The element : "+text+" is clicked successfully","pass");
		} catch (InvalidElementStateException e) {
			System.out.println("The element: " + text + " could not clicked");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException" + e.getMessage());
		}

	}

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			System.out.println("The element : " + text + " is clicked successfully");
		} catch (InvalidElementStateException e) {
			System.out.println("The element: " + text + " could not clicked");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException" + e.getMessage());
		}
	}

	public void waitPageLoading() {

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("return document.readyState").toString().equals("complete");

	}

	public String getText(WebElement ele) {
		String bReturn = "";
		try {
			bReturn = ele.getText();
		} catch (WebDriverException e) {
			System.out.println("WebDriverException" + e.getMessage());
		}
		return bReturn;
	}

	public String getTitle() {
		String title = "";
		try {
			title = driver.getTitle();
		} catch (WebDriverException e) {
			System.out.println("WebDriverException" + e.getMessage());
		}
		return title;
	}

	public String getAttribute(WebElement ele, String attribute) {
		String bReturn = "";
		try {
			bReturn = ele.getAttribute(attribute);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException" + e.getMessage());
		}
		return bReturn;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			System.out.println("The dropdown is selected with text " + value);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException" + e.getMessage());
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			System.out.println("The dropdown is selected with index " + index);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException" + e.getMessage());
		}

	}

	public boolean verifyTitle(String expectedTitle) {
		boolean bReturn = false;
		try {
			if (getTitle().contains(expectedTitle)) {
				System.out.println("The expected title " + expectedTitle + " matches the actual " + getTitle());
				bReturn = true;
			} else {
				System.out.println(getTitle() + " The expected title " + expectedTitle + " doesn't matches the actual "
						+ getTitle());
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
		return bReturn;

	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if (getText(ele).equals(expectedText)) {
				System.out.println("The expected text matches the actual " + expectedText);
			} else {
				System.out.println("The expected text doesn't matches the actual " + expectedText);
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if (getText(ele).contains(expectedText)) {
				System.out.println("The expected text contains the actual " + expectedText);
			} else {
				System.out.println("The expected text doesn't contain the actual " + expectedText);
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
	}

	public String getUrl() {

		String url = driver.getCurrentUrl();
		return url;
	}

	public void keyboardPressEnter() throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if (getAttribute(ele, attribute).equals(value)) {
				System.out.println("The expected attribute :" + attribute + " value matches the actual " + value);
			} else {
				System.out.println(
						"The expected attribute :" + attribute + " value does not matches the actual " + value);
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if (getAttribute(ele, attribute).contains(value)) {
				System.out.println("The expected attribute :" + attribute + " value contains the actual " + value);
			} else {
				System.out.println(
						"The expected attribute :" + attribute + " value does not contains the actual " + value);
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
	}

	public void verifySelected(WebElement ele) {
		try {
			if (ele.isSelected()) {
				System.out.println("The element " + ele + " is selected");
			} else {
				System.out.println("The element " + ele + " is not selected");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
	}

	public void verifyDisplayed(WebElement ele) {
		try {
			if (ele.isDisplayed()) {
				System.out.println("The element " + ele + " is visible");
			} else {
				System.out.println("The element " + ele + " is not visible");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
	}

	public void switchToWindow(int index) {
		// String parent=driver.getWindowHandle();
		try {

			Set<String> allWindowHandles = driver.getWindowHandles();
			List<String> allHandles = new ArrayList<String>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));

		} catch (NoSuchWindowException e) {
			System.out.println("The driver could not move to the given window by index " + index);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
	}

	public void switchTodefault() {
		try {

			driver.switchTo().defaultContent();
		} catch (NoSuchWindowException e) {
			System.out.println("The driver could not move to the given window by index ");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			System.out.println("switch In to the Frame " + ele);
		} catch (NoSuchFrameException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
	}

	public void acceptAlert() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			System.out.println("The alert " + text + " is accepted.");
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
	}

	public void dismissAlert() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			System.out.println("The alert " + text + " is dismissed.");
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}

	}

	public String getAlertText() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
		return text;
	}

	public String elementScreenshot(WebElement ele) {

		String com = ele.getText();
		com = com.replace("?", "");
		String dest = "C:\\Users\\malnasu\\Desktop\\SmokeTest\\snaps\\" + java.time.LocalDate.now() + "\\"
				+ testCaseFileName + "\\" + testCaseName + "\\" + com + ".png";
		dest = dest.replace("?", "");

		try {

			File file = new File(dest);
			file.getParentFile().mkdirs();
			file.createNewFile();

			Screenshot screenshot = new AShot().takeScreenshot(driver, ele);
			ImageIO.write(screenshot.getImage(), "PNG", new File(dest));

		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}

		i++;
		return dest;
	}

	/*public String takeSnap(String title) {

		String com = title + i;
		com = com.replace("~", "");
		com = com.replace("?", "");
		com = com.replace("|", "");
		com = com.replace("-", "");
		com = com.replace(":", "");
		com = com.replace("_", "");
		String dest = "C:\\Users\\malnasu\\eclipse-workspace\\SalesforceRegression\\snaps\\"+configFileReader("Release_Name")+"\\"
		+ java.time.LocalDate.now() +"\\"+testCaseName+"\\"+ com + ".png";

		try {

			File file = new File(dest);
			file.getParentFile().mkdirs();
			file.createNewFile();

			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
					.takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "png", new File(dest));
			//FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(dest));

		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}

		i++;

		return dest;
	}*/

	public String takeSnap(String title) {

		String com = title + i;
		String name = configFileReader("Region") + "" + configFileReader("Loc");
		com = com.replace("?", "");
		com = com.replace("-", "");
		com = com.replace("|", "");
		String cwd = System.getProperty("user.dir");
		// System.out.println("Current working directory : " + cwd);
		// String dest = "C:\\Users\\devishe\\OneDrive - Manulife\\Team\\String
		// Test\\StringTest\\StringTest\\snaps\\" + java.time.LocalDate.now() +
		// "\\"+name+"\\"
		// + testCaseFileName + "\\" + testCaseName + "\\" + com + ".png";
		// dest = dest.replace("?", "");
		// String destURL = "C:\\Users\\devishe\\OneDrive - Manulife\\Team\\String
		// Test\\StringTest\\StringTest\\snaps\\" + java.time.LocalDate.now() +
		// "\\"+name+"\\"
		// + testCaseFileName + "\\" + testCaseName + "\\" + com + " with URL.png";
		// destURL = destURL.replace("?", "");

		String dest = cwd + "\\snaps\\" + java.time.LocalDate.now() + "\\" + name + "\\" + testCaseFileName + "\\"
				+ testCaseName + "\\" + com + ".png";
		dest = dest.replace("?", "");
		String destURL = cwd + "\\snaps\\" + java.time.LocalDate.now() + "\\" + name + "\\" + testCaseFileName + "\\"
				+ testCaseName + "\\" + com + " with URL.png";
		destURL = destURL.replace("?", "");

		try {

			File file = new File(dest);
			file.getParentFile().mkdirs();
			file.createNewFile();

			Robot robot = new Robot();
			BufferedImage screenShotUrl = robot
					.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(screenShotUrl, "png", new File(destURL));
			//
			waitPageLoading();
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
					.takeScreenshot(driver);
			//
			waitPageLoading();
			ImageIO.write(screenshot.getImage(), "png", new File(dest));

		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("The snapshot could not be taken");
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		i++;

		return dest;
	}

	public String takeSnapWithoutScroll(String title) {

		String com = title + i;
		String name = configFileReader("Region") + "" + configFileReader("Loc");
		String dest = "C:\\Users\\malnasu\\WorkSpace\\smoketest\\snaps\\" + java.time.LocalDate.now() + "\\" + name
				+ "\\" + testCaseFileName + "\\" + testCaseName + "\\" + com + ".png";
		dest = dest.replace("?", "");
		try {

			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(dest));

		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		i++;

		return dest;
	}

	public void closeBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("The browser could not be closed");
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("The opened browsers are closed");
		} catch (Exception e) {
			System.out.println("The browsers could not be closed");
		}
	}

	// Added by Sheela

	public String previousday() {

		Calendar cal = Calendar.getInstance();

		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
			cal.add(Calendar.DATE, -2);
		else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
			cal.add(Calendar.DATE, -3);
		else
			cal.add(Calendar.DATE, -1);

		DateFormat dateformat = new SimpleDateFormat("MMMM dd, YYYY");
		// System.out.println(dateformat.format(cal.getTime()));
		String prevdate = dateformat.format(cal.getTime()).toString();
		// System.out.println(prevdate);
		return prevdate;
	}

	// Added by Suraj

	public String previousdayformat() {

		Calendar cal = Calendar.getInstance();

		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
			cal.add(Calendar.DATE, -2);
		else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
			cal.add(Calendar.DATE, -3);
		else
			cal.add(Calendar.DATE, -1);

		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		// System.out.println(dateformat.format(cal.getTime()));
		String prevdate = dateformat.format(cal.getTime()).toString();
		// System.out.println(prevdate);
		return prevdate;
	}
	//Author:Sreeram
	 public void select_Cases_From_AppLauncher(String tabName) {
		    
    	 try {
             waitPageLoading();
             Thread.sleep(20000);

             click(locateElement("xpath", "//button[@class='slds-button slds-show']"));
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
             Thread.sleep(30000);
             driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(tabName);
             Thread.sleep(10000);
             Actions action = new Actions(driver);
             action.sendKeys(Keys.ARROW_DOWN).build().perform();
             action.sendKeys(Keys.ENTER).build().perform();
            



         } catch (Exception e) {
             //reportStep("Unable to Navigate Hidden Item 'ActionPlanTemplate' is displayed for System Administrator", "fail",
               //      takeSnap(getTitle()));
             e.printStackTrace();



         }

}
	 
	 //Author: Sreeram
	 public void click_JS(WebElement element) {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("return arguments[0].click();", element);
			
	 }
	 
	 /**
	  * Author: Sreeram
	 * @throws IOException 
	  */
	 public void loginAsProfile(String username) throws IOException {
		 try {
             
             Thread.sleep(5000);
              //Click the search box
             click(locateElement("xpath", "//button[@class='slds-button slds-show']")); 

             //Pass the value the search box
             locateElement("xpath",
                          "//input[@class = 'slds-input slds-text-color_default slds-p-left--none slds-size--1-of-1 input default input uiInput uiInputTextForAutocomplete uiInput--{remove}']").sendKeys(username);
             driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
             Thread.sleep(5000);
             Actions action = new Actions(driver);
             action.sendKeys(Keys.ARROW_DOWN).build().perform();
             action.sendKeys(Keys.ENTER).build().perform();
             driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

             click(locateElement("xpath", "//div[text() = 'User Detail']"));
             WebElement ele = driver.findElement(By.xpath("//*[@id='setupComponent']//force-aloha-page/div/iframe"));
             switchToFrame(ele);
             click(locateElement("xpath", "//input[@name = 'login']"));

	      }
		 catch(Exception e)
		     {
			    reportStep("Unable to login to application with new profile "+username, "fail", takeSnap(getTitle()));
		     }
      }
	 
	 /**
	  * Author: Sreeram
	  */
	 public void selectItem_From_RecentlyViewed(String item) {
		 click_JS(locateElement("xpath", "//span[text()='Recently Viewed']"));
		 locateElement("xpath", "//div[@class='panel-content scrollable']//input[@role='combobox']").sendKeys(item);
		 Actions action = new Actions(driver);
		 action.sendKeys(Keys.ARROW_DOWN).build().perform();
         action.sendKeys(Keys.ENTER).build().perform();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		 
		 }
	 
}//end of the class
