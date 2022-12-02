// Generated by Selenium IDE

//Test Script to add the user from Admin account
package dfm;

import org.junit.Test;
import org.junit.Before;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class AddUserModelerUI01Test {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

		// System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
		// driver=new EdgeDriver();
	}

	@After
	public void tearDown() {
		// driver.quit();
	}

	@Test
	public void addUserModelerUI01() throws InterruptedException, IOException {

		// int n1 = Integer.parseInt(ProjectAdministrator);
		// Test name: AddUserModelerUI_01
		// Step # | name | target | value

		// For QA Environment
		// 1 | open | https://qa.modeler2.decisionsfirst.com/login |
		// driver.get("https://qa.modeler2.decisionsfirst.com/login");

		// For Openshift Environment
		driver.get("https://modeler2-dfm-dms.apps.oc-prod.decisionsfirst.com/login");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// 2 | setWindowSize | 1289x602 |
		driver.manage().window().maximize();
		
		// 3 | click | css=.form-group:nth-child(2) > .form-control |
		driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
		// 4 | type | xpath=//input[@type='text'] | nitesh@rxw.com
		driver.findElement(By.xpath("//input[@type=\'text\']")).sendKeys("Admin@dummy.com");
		// 5 | click | css=.ng-untouched |
		driver.findElement(By.cssSelector(".ng-untouched")).click();
		// 6 | type | xpath=//input[@type='password'] | defaultUserPass@123
		driver.findElement(By.xpath("//input[@type=\'password\']")).sendKeys("defaultUserPass@123");
		// 7 | click | css=.btn |
		driver.findElement(By.cssSelector(".btn")).click();
		// 8 | waitForElementVisible | css=.sidebar-control-button | 30000
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sidebar-control-button")));
		}
		
		WebElement close_option_tab	= driver.findElement(By.xpath("//button[normalize-space()='CLOSE']"));
		if (close_option_tab.isDisplayed()) {
			close_option_tab.click();
			
		} else {
			System.out.println("Wijmo Evaluation Version (5.20213.824) is not available");

		}
		
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

		// 16 | click | css=.rich-text-editor-focus p |
		driver.findElement(By.cssSelector(".rich-text-editor-focus p")).click();
		// 17 | editContent | css=.rich-text-editor-focus > .ql-editor | <p>Standard</p>

		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id='lastName']//p")).sendKeys(lastName);

		// 18 | click | css=.ql-blank > p |
		driver.findElement(By.cssSelector(".ql-blank > p")).click();

		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id='email']//p")).sendKeys(email);

		// 20 | click | css=.form-control:nth-child(2) |
		WebElement userType = driver.findElement(By.cssSelector(".form-control:nth-child(2)"));
		userType.sendKeys(type);
		userType.click();
		// 21 | click | css=.btn-block |
		driver.findElement(By.cssSelector(".btn-block")).click();
		System.out.println("<<<<<<<User created successfully>>>>>>>");

		workbook.close();
	}

}
