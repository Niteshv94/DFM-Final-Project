// Generated by Selenium IDE

//Test Script to login the DFM application with Admin Credentials

package dfm;

import java.io.File;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.base.BaseClass;
import com.dfm.utility.Helper;

public class LoginAdmin_01 extends BaseClass {
	WebDriver driver = null;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	ExtentSparkReporter sparkReporter;
	public static ExtentReports reports;
	ExtentTest extentTest;

	Reporter report = new Reporter();

	@BeforeTest(alwaysRun = true)
	@Parameters("browserName")
	public void setupBrowser(String browserName) throws Exception {

		System.out.println("Test Cases executed in the Browser is : " + browserName);
		System.out.println("Thread is : " + Thread.currentThread().getId());
		// Check if parameter passed from TestNG is 'firefox'
		if (browserName.equalsIgnoreCase("Chrome")) {
			// create firefox instance
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();

		}
		// Check if parameter passed as 'chrome'
		else if (browserName.equalsIgnoreCase("firefox")) {
			// set path to chromedriver.exe
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			// set path to Edge.exe
			System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			// If no browser is passed throw exception
			throw new Exception("Incorrect Browser");
		}
	}

	@BeforeSuite(alwaysRun = true)
	public void setUp() {

		// start reporters
		// sparkReporter = new
		// ExtentSparkReporter("./Reports/login_DD-MM-YYYY_HH-MM-SS.html");
		sparkReporter = new ExtentSparkReporter(new File(
				System.getProperty("user.dir") + "./Reports/Login/DFM_Login_" + Helper.getCurrentDateTime() + ".html"));
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);

	}

//	@BeforeClass (alwaysRun = true)
//	public void setUpTest() {
//		// System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
//		// driver = new ChromeDriver();
//
////    System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
////	driver=new EdgeDriver();
//		
//		
//		extentTest = reports.createTest(getClass().getSimpleName());
//	}

	@Test(priority = 1, alwaysRun = true)
	public void LoginToAdminAccount() {

		// reports.createTest("Login");
		Reporter.log("Test Case for Login");
		extentTest = reports.createTest("Login", "Login to DFM Application");
		// log with snapshot
//		extentTest.pass("Details",
//				MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/screenshot.png").build());
		// test with snapshot
		extentTest.addScreenCaptureFromPath("screenshot.png");

		// log(Status, details)
		extentTest.log(Status.INFO, "Starting Test Case");
		// 1 | open | /login |
		driver.get("https://qa.admin.decisionsfirst.com/login");
		// driver.get("https://admin-dfm-dms.apps.oc-prod.decisionsfirst.com/login");
		extentTest.pass("Navigates to DFM URL");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		// 2 | setWindowSize | 698x602 |
		// driver.manage().window().setSize(new Dimension(698, 602));
		// 3 | click | css=.form-group:nth-child(2) > .form-control |
		driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
		// 4 | type | xpath=//input[@type='text'] | dmsadmin@dmsadmin.com
		driver.findElement(By.xpath("//input[@type=\'text\']")).sendKeys("dmsadmin@dmsadmin.com");
		extentTest.pass("Entered Admin Email Id");
		// 5 | click | css=.ng-untouched |
		driver.findElement(By.cssSelector(".ng-untouched")).click();
		// 6 | type | xpath=//input[@type='password'] | dms@123
		driver.findElement(By.xpath("//input[@type=\'password\']")).sendKeys("dms@123");
		extentTest.pass("Entered Admin Password");
		// 7 | click | css=.btn |
		driver.findElement(By.cssSelector(".btn")).click();
		extentTest.pass("Pressed Login button");
		// 8 | mouseOver | css=.btn |
		{
			WebElement element = driver.findElement(By.cssSelector(".btn"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		// 9 | mouseOut | css=.btn |
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}

		// Verify Title
		String title = driver.getTitle();
		System.out.println("<<<The title of the Application is >>> " + title);
		// 10 | click | xpath=//i |
	}

	@Test(priority = 2, alwaysRun = true)
	public void logOut() {
		Reporter.log("Test Case for Logout");
		driver.findElement(By.xpath("//i[@class='sidebar-control-button nb-menu sidebar-toggle icon-gray-color']"))
				.click();
		// 11 | click | xpath=//span[contains(.,'Log Out')] |
		driver.findElement(By.xpath("//span[contains(.,\'Log Out\')]")).click();
		extentTest.pass("Clicked Logout button");

		extentTest.log(Status.INFO, "Test Completed");
	}

	@AfterSuite(alwaysRun = true)
	public void tearDownReport() {

		// calling flush writes everything to the log file
		reports.flush();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
