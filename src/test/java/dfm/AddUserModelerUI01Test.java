// Generated by Selenium IDE

//Test Script to add the user from Admin account
package dfm;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.dfm.utility.Helper;

import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class AddUserModelerUI01Test {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	ExtentSparkReporter sparkReporter;
	public static ExtentReports reports;
	ExtentTest extentTest;

	Reporter report = new Reporter();

	@BeforeSuite(alwaysRun = true)
	public void setUpReport() {

		// start reporters
		// sparkReporter = new
		// ExtentSparkReporter("./Reports/login_DD-MM-YYYY_HH-MM-SS.html");
		sparkReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "./Reports/User/DFM_AddUser_"
				+ Helper.getCurrentDateTime() + ".html"));
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);

	}

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

		// System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
		// driver=new EdgeDriver();
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		 driver.quit();
	}

	@Test(priority = 1)
	public void loginAction() throws InterruptedException, IOException {

		Reporter.log("Test Case for Add User & Validate");
		extentTest = reports.createTest("Add User", "Add User & Validate");
		// log with snapshot
//		extentTest.pass("Details",
//				MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/screenshot.png").build());
		// test with snapshot
		extentTest.addScreenCaptureFromPath("screenshot.png");

		// log(Status, details)
		extentTest.log(Status.INFO, "Starting Test Case");
		// For QA Environment
		// 1 | open | https://qa.modeler2.decisionsfirst.com/login |
		driver.get("https://qa.modeler2.decisionsfirst.com/login");
		extentTest.pass("Navigates to DFM URL");

		// For Openshift Environment
		// driver.get("https://modeler2-dfm-dms.apps.oc-prod.decisionsfirst.com/login");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// 2 | setWindowSize | 1289x602 |
		driver.manage().window().maximize();

		// 3 | click | css=.form-group:nth-child(2) > .form-control |
		driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
		// 4 | type | xpath=//input[@type='text'] | nitesh@rxw.com
		driver.findElement(By.xpath("//input[@type=\'text\']")).sendKeys("nitesh@rxw.com");
		// 5 | click | css=.ng-untouched |
		driver.findElement(By.cssSelector(".ng-untouched")).click();
		// 6 | type | xpath=//input[@type='password'] | defaultUserPass@123
		driver.findElement(By.xpath("//input[@type=\'password\']")).sendKeys("defaultUserPass@123");
		// 7 | click | css=.btn |
		driver.findElement(By.cssSelector(".btn")).click();
		extentTest.pass("Login Successfull");
		// 8 | waitForElementVisible | css=.sidebar-control-button | 30000
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sidebar-control-button")));
		}

		/*
		 * WebElement close_option_tab =
		 * driver.findElement(By.xpath("//button[normalize-space()='CLOSE']")); if
		 * (close_option_tab.isDisplayed()) { close_option_tab.click();
		 * 
		 * } else {
		 * System.out.println("Wijmo Evaluation Version (5.20213.824) is not available"
		 * );
		 * 
		 * }
		 */

		// 9 | mouseOver | css=.btn |
		{
			WebElement element = driver.findElement(By.cssSelector(".btn"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		// 10 | mouseOut | css=.btn |
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}

	}

	@Test(priority = 2)
	public void addUser() throws InterruptedException, IOException {
		// 11 | click | css=.sidebar-control-button |
		driver.findElement(By.cssSelector(".sidebar-control-button")).click();
		// 12 | click | css=.item:nth-child(10) > .item-text |
		driver.findElement(By.cssSelector(".item:nth-child(10) > .item-text")).click();
		// 13 | click | css=.plus-icon > .eva |
		driver.findElement(By.cssSelector(".plus-icon > .eva")).click();
		Thread.sleep(3000);

		File src = new File("./Test Data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("AddUserModelerUI01Test");

		// Get the xpath of permissions form Excel Sheet
		String firstName = sheet.getRow(1).getCell(0).getStringCellValue();
		String lastName = sheet.getRow(1).getCell(1).getStringCellValue();
		String email = sheet.getRow(1).getCell(2).getStringCellValue();
		String type = sheet.getRow(2).getCell(3).getStringCellValue();

		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id='firstName']//p")).sendKeys(firstName);
		extentTest.pass("Entered First Name");

		// 16 | click | css=.rich-text-editor-focus p |
		driver.findElement(By.cssSelector(".rich-text-editor-focus p")).click();
		// 17 | editContent | css=.rich-text-editor-focus > .ql-editor | <p>Standard</p>

		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id='lastName']//p")).sendKeys(lastName);
		extentTest.pass("Entered Last Name");

		// 18 | click | css=.ql-blank > p |
		driver.findElement(By.cssSelector(".ql-blank > p")).click();

		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id='email']//p")).sendKeys(email);
		extentTest.pass("Entered Email");

		// 20 | click | css=.form-control:nth-child(2) |
		WebElement userType = driver.findElement(By.cssSelector(".form-control:nth-child(2)"));
		userType.sendKeys(type);
		userType.click();
		// 21 | click | css=.btn-block |
		driver.findElement(By.cssSelector(".btn-block")).click();
		System.out.println("<<<<<<<User created successfully>>>>>>>");
		extentTest.pass("User Added Successfully");

		workbook.close();
	}

	@Test(priority = 3)
	public void validateAddedUser() throws InterruptedException, IOException {

		File src = new File("./Test Data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("AddUserModelerUI01Test");
		String email = sheet.getRow(1).getCell(2).getStringCellValue();
		String password = sheet.getRow(1).getCell(4).getStringCellValue();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='sidebar-control-button nb-menu sidebar-toggle icon-gray-color']"))
				.click();

		driver.findElement(By.xpath("//span[contains(.,\'Log Out\')]")).click();
		extentTest.pass("Logout Sucessfull");

		driver.findElement(By.xpath("//input[@type=\'text\']")).sendKeys(email);
		extentTest.pass("Entered User Email");
		// 5 | click | css=.ng-untouched |
		driver.findElement(By.cssSelector(".ng-untouched")).click();
		// 6 | type | xpath=//input[@type='password'] | defaultUserPass@123
		driver.findElement(By.xpath("//input[@type=\'password\']")).sendKeys(password);
		extentTest.pass("Entered User Password");
		Thread.sleep(5000);
		// 7 | click | css=.btn |
		driver.findElement(By.cssSelector(".btn")).click();
		extentTest.pass("Ceated User Login Successfull");
		extentTest.log(Status.INFO, "Test Completed");
		

		workbook.close();

	}

	@AfterSuite(alwaysRun = true)
	public void tearDownReport() {

		// calling flush writes everything to the log file
		reports.flush();
	}

}
