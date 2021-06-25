/**
 * 
 */
/**
 * @author peruran
 *
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporter {
	public static ExtentReports extent;
	public ExtentTest test, app, child;
	public String testCaseName, testCaseDesc, category, author, testCaseFileName;

	public void beginResult() throws IOException {

		BufferedReader reader;
		Properties pro = null;
		// Added on 24-Nov-2020
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd h-m-s");
		Date date = new Date();

		try {

			reader = new BufferedReader(new FileReader("config//configuration.properties"));
			pro = new Properties();
			pro.load(reader);
			reader.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		// Added on 24-Nov-2020
		String dest = "./reports/" + pro.getProperty("Folder_Name") + "/" + dateFormat.format(date)
				+ "/ GPSO_Result.html";
		File file = new File(dest);
		file.getParentFile().mkdirs();
		file.createNewFile();

		// Added on 24-Nov-2020
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/" + pro.getProperty("Folder_Name") + "/"
				+ dateFormat.format(date) + "/ GPSO_Result.html");
		html.setAppendExisting(false);
		extent = new ExtentReports();
		extent.attachReporter(html);
	}

	public void startTestCase() {

		app = extent.createTest(testCaseFileName);
		test = app.createNode(testCaseName, testCaseDesc);
		test.assignCategory(category);
		test.assignAuthor(author);
	}

	public void reportStep(String desc, String status, String Screenshot) throws IOException {

		String ScreenshotUrl = Screenshot.substring(0, Screenshot.length() - 4);
		ScreenshotUrl = ScreenshotUrl + " with URL.png";
		//

		if (status.equalsIgnoreCase("Pass")) {

			// test.pass(desc,
			// MediaEntityBuilder.createScreenCaptureFromPath(Screenshot).build());
			test.info(desc, MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUrl).build());
			test.pass("", MediaEntityBuilder.createScreenCaptureFromPath(Screenshot, "Full Page").build());

		} else if (status.equalsIgnoreCase("Fail")) {

			test.info(desc, MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUrl).build());
			test.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot).build());
		} else if (status.equalsIgnoreCase("Warning")) {

			test.warning(desc, MediaEntityBuilder.createScreenCaptureFromPath(Screenshot).build());
			throw new RuntimeException();
		}

	}

	public void reportStep(String desc, String status) throws IOException {

		if (status.equalsIgnoreCase("Pass")) {

			test.pass(desc);

		} else if (status.equalsIgnoreCase("Fail")) {

			test.fail(desc);

		} else if (status.equalsIgnoreCase("Warning")) {

			test.warning(desc);
			throw new RuntimeException();
		}

	}

	public void endResult() {

		extent.flush();
	}

}