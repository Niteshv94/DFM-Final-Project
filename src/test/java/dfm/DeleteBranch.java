// Generated by Selenium IDE
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class DeleteBranch {
	private static WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

		vars = new HashMap<String, Object>();
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

	@Test(priority = 1)
	public static void loginAction() throws InterruptedException, IOException {
		// Test name: Add Project
		// Step # | name | target | value

		// For QA Environment
		// 1 | open | https://qa.modeler2.decisionsfirst.com/login |
		driver.get("https://qa.modeler2.decisionsfirst.com/login");

		// For Openshift Environment
		// driver.get("https://modeler2-dfm-dms.apps.oc-prod.decisionsfirst.com/login");

		// 2 | setWindowSize | 1126x602 |
		driver.manage().window().maximize();
		// 3 | click | css=.form-group:nth-child(2) > .form-control |
		driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
		// 4 | type | xpath=//input[@type='text'] | test_claim2@gmail.com
		driver.findElement(By.xpath("//input[@type=\'text\']")).sendKeys("nitesh@rxw.com");
		// 5 | click | css=.ng-untouched |
		driver.findElement(By.cssSelector(".ng-untouched")).click();
		// 6 | type | xpath=//input[@type='password'] | defaultUserPass@123
		driver.findElement(By.xpath("//input[@type=\'password\']")).sendKeys("defaultUserPass@123");
		// 7 | click | css=.btn |
		driver.findElement(By.cssSelector(".btn")).click();
		Thread.sleep(15000);

		// 8 | waitForElementVisible | css=.sidebar-control-button | 30000
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sidebar-control-button")));
		}
	}

	@Test(priority = 2)
	public static void deleteBranch() throws InterruptedException, IOException, AWTException {

		File src = new File("./Test Data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Branch");

		String searchProject = sheet.getRow(1).getCell(0).getStringCellValue();
		String tagName = sheet.getRow(1).getCell(4).getStringCellValue();

		driver.findElement(By.cssSelector(".sidebar-control-button")).click();
		driver.findElement(By.cssSelector(".item:nth-child(8) > .item-text")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("search-ip")).click();
		driver.findElement(By.id("search-ip")).sendKeys(searchProject);
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div[1]/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/div/dfm-branch-explorer-container/nb-card/div/div[1]/dfm-branch-explorer-tree-view/div/div[4]/wj-tree-view/div/div[2]/div[1]"))
				.click();
		Thread.sleep(3000);

		WebElement l = driver.findElement(By.xpath(tagName));
		// Actions class with moveToElement() and contextClick()
		Actions actions = new Actions(driver);
		actions.moveToElement(l).contextClick().build().perform();
		actions.moveToElement(l).contextClick().build().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[contains(text(),'Delete Branch')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//wj-popup[@class='wj-control wj-content wj-popup delete-confirmation-popup wj-state-focus wj-state-focused']//button[@class='btn btn-info popup-btn p-1'][normalize-space()='Delete']"))
				.click();
		Thread.sleep(5000);
	}

	@Test(priority = 3)
	public static void validateBranch() throws InterruptedException, IOException, AWTException {

		File src = new File("./Test Data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Branch");

		String branchName = sheet.getRow(1).getCell(2).getStringCellValue();
		
		driver.findElement(By.id("search-ip")).clear();
		driver.findElement(By.id("search-ip")).sendKeys(branchName);

//	   Thread.sleep(3000);
//	   driver.findElement(By.xpath(branchXpath)).click();
		Thread.sleep(2000);
		String branchvalidated = driver.findElement(By.xpath("//span[normalize-space()='No Results Found']")).getText();
		System.out.println("Message after validation of branch : " + branchvalidated);

		workbook.close();

	}
}
