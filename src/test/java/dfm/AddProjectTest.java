// Generated by Selenium IDE

//Script to create Project

package dfm;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class AddProjectTest {
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

	@Test
	public void addProject() throws InterruptedException, IOException {
		// Test name: Add Project
		// Step # | name | target | value

		// QA Environment
		// 1 | open | https://qa.modeler2.decisionsfirst.com/login |
		 driver.get("https://qa.modeler2.decisionsfirst.com/login");

		// For Openshift Environment
		//driver.get("https://modeler2-dfm-dms.apps.oc-prod.decisionsfirst.com/login");

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
		Thread.sleep(3000);
		// 10 | click | xpath=//span[contains(.,'Tag Explorer')] |
		driver.findElement(By.xpath("//span[contains(.,\'Tag Explorer\')]")).click();
		Thread.sleep(3000);
		// 11 | click | css=.eva-plus-circle-outline:nth-child(2) |
		driver.findElement(By.cssSelector(".eva-plus-circle-outline:nth-child(2)")).click();
		Thread.sleep(3000);
		// 12 | click | css=.wj-listbox-item:nth-child(1) > div |
		driver.findElement(By.cssSelector(".wj-listbox-item:nth-child(1) > div")).click();
		Thread.sleep(3000);
		// 13 | click | css=.rich-text-editor-focus p |
		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id='name']/quill-editor/div[2]/div/p"))
				.click();
		// Thread.sleep(5000);

		// Get the xpath and Project data form Excel Sheet
		File src = new File("./Test Data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("AddProjectTest");

		String projectName = sheet.getRow(1).getCell(0).getStringCellValue();
		String description = sheet.getRow(1).getCell(1).getStringCellValue();
		String branching = sheet.getRow(1).getCell(2).getStringCellValue();

		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id=\'name\']/quill-editor/div[2]/div"))
				.sendKeys(projectName);

		// 15 | click | css=.ql-blank > p |
		driver.findElement(By.cssSelector(".ql-blank > p")).click();

		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id=\'description\']/quill-editor/div[2]/div"))
				.sendKeys(description);

		// 17 | click | xpath=//nb-radio[@id='item-enableSimpleBranching']/label/span[2]
		// |
		driver.findElement(By.xpath(branching)).click();
		// 18 | click | xpath=//button[contains(.,'Add Project')] |
		driver.findElement(By.xpath("//button[contains(.,\'Add Project\')]")).click();
		// 19 | click | css=.sidebar-control-button |
		//driver.findElement(By.cssSelector(".sidebar-control-button")).click();
		// 20 | click | css=.logOut > .item-text |
		Thread.sleep(2000);
		//driver.findElement(By.cssSelector(".logOut > .item-text")).click();
		System.out.println("<<<<<Project added successfully>>>>>");
		workbook.close();
	}
}
