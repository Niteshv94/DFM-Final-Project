// Generated by Selenium IDE

//Test Script to create the Customer, after creation of customer user will be added for that account

package dfm;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import com.base.BaseClass;
import com.dfm.utility.Helper;

import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class DeleteCustomer extends BaseClass {
	public static WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	FileInputStream fis;
	
	/*ExtentSparkReporter sparkReporter;
	ExtentReports reports;
	ExtentTest extentTest;
	Reporter report = new Reporter();*/

	
	@BeforeSuite
	public void setUpReport() {

		// start reporters
		/*sparkReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"./Reports/Delete/DFM_DeleteCustomer_"+Helper.getCurrentDateTime()+".html"));
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);*/

	}

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

//		System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
//		driver=new EdgeDriver();
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterSuite
	public void tearDownReoport() {

		// calling flush writes everything to the log file
		//reports.flush();
	}

	@Test(priority =0)
	public void logInToApplication() throws InterruptedException, IOException, Exception {

		//Reporter.log("Test Case for Login");
		//extentTest = reports.createTest("Delete Customer", "Login to Application");
	
		// test with snapshot
		//extentTest.addScreenCaptureFromPath("screenshot.png");

		// log(Status, details)
		//extentTest.log(Status.INFO, "Starting Test Case");
		// For QA environment
		driver.get("https://qa.admin.decisionsfirst.com/login");
		//extentTest.pass("Navigates to DFM URL");

		// For Openshift
		// driver.get("https://admin-dfm-dms.apps.oc-prod.decisionsfirst.com");

		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
		driver.findElement(By.xpath("//input[@type=\'text\']")).sendKeys("dmsadmin@dmsadmin.com");
		driver.findElement(By.cssSelector(".ng-untouched")).click();
		driver.findElement(By.xpath("//input[@type=\'password\']")).sendKeys("dms@123");
		driver.findElement(By.cssSelector(".btn")).click();
		Thread.sleep(8000);
		//extentTest.pass("Login Successfull");

	}
	@Test (priority =1)
	public void deleteCustomer() throws IOException, InterruptedException
	{
		Reporter.log("Test Case to Delete Customer");
		// Get the Customer data form Excel Sheet
		File src = new File("./Test Data/TestData.xlsx");
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		//Pass the same data present in AddCustomer sheet"
		XSSFSheet sheet = workbook.getSheet("DeleteCustomer");

		

		DataFormatter dataFormatter = new DataFormatter();

		// Input data from excel for number of Users
		String customerName = sheet.getRow(1).getCell(0).getStringCellValue();
		String verifyCustomer = sheet.getRow(1).getCell(1).getStringCellValue();

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(customerName);
		Thread.sleep(4000);
		// driver.findElement(By.cssSelector("span > .item-name")).click();
		driver.findElement(By.xpath("//i[@class='eva eva-trash-2-outline remove-item icon-gray-color']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='btn btn-info eva eva-search-outline search-icon']")).click();
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(customerName);
		//extentTest.pass("Customer deleted successfully");
		

		//Verify the Customer is present or not
		List<WebElement> verify_customer_inList = driver.findElements(By.xpath(verifyCustomer));
		if (verify_customer_inList.size() > 0) {
			System.out.println("The Customer is not deleted... Please try again later");

		} else {
			System.out.println("Congratulations, The Customer is deleted from the Account...");

		}
		//extentTest.log(Status.INFO, "Test Completed");

		workbook.close();

	}

}
