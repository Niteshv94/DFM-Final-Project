// Generated by Selenium IDE

//Script for creating a new tag

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
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class DeleteTag {
	private static WebDriver driver;
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
		// workbook.close();
	}

	@Test(priority = 1)
	public void loginToApplication() throws InterruptedException, IOException {
		login();
		searchTag();

	}

	@Test(priority = 2)
	public void deleteTag() throws InterruptedException, IOException {

		deleteSearchTag();

	}

	@Test(priority = 3)
	public void validateDeleteTag() throws InterruptedException, IOException {

		driver.navigate().refresh();
		Thread.sleep(5000);
		searchTag();

	}

	public static void login() throws InterruptedException, IOException {
		// Test name: Add Tag
		// Step # | name | target | value

		// For A Environment
		// 1 | open | https://qa.modeler2.decisionsfirst.com/login |
		driver.get("https://qa.modeler2.decisionsfirst.com/login");

		// For Openshift Environment
		// driver.get("https://modeler2-dfm-dms.apps.oc-prod.decisionsfirst.com/login");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// 2 | setWindowSize | 1183x602 |
		driver.manage().window().maximize();
		// 3 | click | css=.form-group:nth-child(2) > .form-control |
		driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
		// 4 | type | css=.ng-valid | test_claim2@gmail.com
		driver.findElement(By.xpath("//input[@type=\'text\']")).sendKeys("nitesh@rxw.com");
		// 5 | click | css=.ng-untouched |
		driver.findElement(By.cssSelector(".ng-untouched")).click();
		// 6 | type | css=.ng-untouched | defaultUserPass@123
		driver.findElement(By.xpath("//input[@type=\'password\']")).sendKeys("defaultUserPass@123");
		// 7 | click | css=.btn |
		driver.findElement(By.cssSelector(".btn")).click();
		Thread.sleep(12000);
		// 8 | waitForElementVisible | css=.sidebar-control-button | 30000
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
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

		// 9 | click | css=.sidebar-control-button |
		driver.findElement(By.cssSelector(".sidebar-control-button")).click();
		Thread.sleep(3000);
		// 10 | click | xpath=//span[contains(.,'Tag Explorer')] |
		driver.findElement(By.xpath("//span[@class='item-text'][normalize-space()='Tag Explorer']")).click();
		Thread.sleep(5000);

	}

	public static void searchTag() throws InterruptedException, IOException {

		// 10 | click | id=search-ip |
		driver.findElement(By.id("search-ip")).click();

		// Get the xpath and Tag data form Excel Sheet
		File src = new File("./Test Data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("DeleteTagTest");

		String searchProject = sheet.getRow(1).getCell(0).getStringCellValue();
		String projectName = sheet.getRow(1).getCell(1).getStringCellValue();
		String tagName = sheet.getRow(1).getCell(2).getStringCellValue();
		String tagDescription = sheet.getRow(1).getCell(3).getStringCellValue();

		// 11 | type | id=search-ip | dummy
		driver.findElement(By.id("search-ip")).sendKeys(tagName);
	}

	public static void deleteSearchTag() throws InterruptedException, IOException {
		// Get the xpath and Tag data form Excel Sheet
		File src = new File("./Test Data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook1 = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook1.getSheet("DeleteTagTest");
		String tagXpath = sheet.getRow(1).getCell(4).getStringCellValue();
		// identify project
		// WebElement l = driver.findElement(By.xpath(projectName));
		WebElement l1 = driver.findElement(By.xpath(tagXpath));

		// Actions class with moveToElement() and contextClick()
		Actions a = new Actions(driver);
		a.moveToElement(l1).contextClick().build().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[contains(text(),'Delete Tag')]")).click();

//		for(int r=2; r<100; r++)
//		{
//			String xpath = "/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[5]/dfm-folders-tags-management-container/nb-card/div/div[1]/dfm-project-tree-view/div/div[2]/wj-tree-view/div/div[" + r + "]";
//			String a1 = driver.findElement(By.xpath(xpath)).getText();
//			
//			if(a1.contains(tagName))
//			{
//				Thread.sleep(2000);
//				String xpath1 = "/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[5]/dfm-folders-tags-management-container/nb-card/div/div[1]/dfm-project-tree-view/div/div[2]/wj-tree-view/div/div[2]/div[" + r + "]";
//				driver.findElement(By.xpath(xpath1)).click();
//			}
//		}

	}

}
