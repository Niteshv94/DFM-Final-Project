// Generated by Selenium IDE

//Script to create Project

package dfm;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class MultiuserWithProject02 {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

//		System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
//		driver = new EdgeDriver();
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

	@Test (priority=1)
	public void loginAction() throws InterruptedException, IOException {
		
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--incognito");
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, capabilities);
//		chromeOptions.merge(capabilities);
//		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get("https://qa.modeler2.decisionsfirst.com/login");
		// Test name: Add Project
		// Step # | name | target | value

		// QA Environment
		// 1 | open | https://qa.modeler2.decisionsfirst.com/login |
		 //driver.get("https://qa.modeler2.decisionsfirst.com/login");

		// For Openshift Environment
		//driver.get("https://modeler2-dfm-dms.apps.oc-prod.decisionsfirst.com/login");

		// 2 | setWindowSize | 1126x602 |
		//driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(989, 1002));
		// 3 | click | css=.form-group:nth-child(2) > .form-control |
		driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
		// 4 | type | xpath=//input[@type='text'] | test_claim2@gmail.com
		driver.findElement(By.xpath("//input[@type=\'text\']")).sendKeys("test5@rxw.com");
		// 5 | click | css=.ng-untouched |
		driver.findElement(By.cssSelector(".ng-untouched")).click();
		// 6 | type | xpath=//input[@type='password'] | defaultUserPass@123
		driver.findElement(By.xpath("//input[@type=\'password\']")).sendKeys("defaultUserPass@123");
		// 7 | click | css=.btn |
		driver.findElement(By.cssSelector(".btn")).click();
		//Thread.sleep(10000);

		// 8 | waitForElementVisible | css=.sidebar-control-button | 30000
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sidebar-control-button")));
		}
		Thread.sleep(3000);

//		WebElement close_option_tab = driver.findElement(By.xpath("//button[normalize-space()='CLOSE']"));
//		if (close_option_tab.isDisplayed()) {
//			close_option_tab.click();
//
//		} else {
//			System.out.println("Wijmo Evaluation Version (5.20213.824) is not available");
//
//		}

		// 9 | click | css=.sidebar-control-button |
		driver.findElement(By.cssSelector(".sidebar-control-button")).click();
		Thread.sleep(2000);
		// 10 | click | xpath=//span[contains(.,'Tag Explorer')] |
		driver.findElement(By.xpath("//span[contains(.,\'Tag Explorer\')]")).click();
		
	}
	
	@Test (priority = 2)
	public void addProject() throws IOException, InterruptedException {
		// Get the xpath and Project data form Excel Sheet
				File src = new File("./Test Data/TestData.xlsx");
				FileInputStream fis = new FileInputStream(src);
				XSSFWorkbook workbook = new XSSFWorkbook(fis);

				XSSFSheet sheet = workbook.getSheet("AddProjectTest");

				String projectName = sheet.getRow(1).getCell(0).getStringCellValue();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='search-ip']"))
						.sendKeys(projectName);
	}
	
	@Test(priority = 3)
	public void validateTag() throws InterruptedException, IOException {

		Thread.sleep(18000);
		// Get the xpath and Tag data form Excel Sheet
		File src = new File("./Test Data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("AddProjectTest");

		String projectName = sheet.getRow(1).getCell(0).getStringCellValue();
		String xpathVerifyProject = sheet.getRow(1).getCell(3).getStringCellValue();

		Thread.sleep(2000);

		// Verify the Customer is present or not
		driver.findElement(By.id("search-ip")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-folders-tags-management-container/nb-card/div/div[1]/dfm-project-tree-view/div/div[1]/div/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("search-ip")).sendKeys(projectName);
		Thread.sleep(2000);
	

		boolean element = driver.findElement(By.xpath(xpathVerifyProject)).isDisplayed();
		if (element) {

			System.out.println("The Project is Present...");
		} else {

			System.out.println("The Project is not Present...");
		}
}
}
