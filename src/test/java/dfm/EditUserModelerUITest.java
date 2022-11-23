// Generated by Selenium IDE
package dfm;

import org.junit.Test;
import org.junit.Before;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class EditUserModelerUITest {
	private static WebDriver driver;
	private Map<String, Object> vars;
	static JavascriptExecutor js;

	// @Before
	public static void main(String[] args) throws InterruptedException, IOException {
		setUp();
		editUserModelerUI();
	}

	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	// @After
	public void tearDown() {
		// driver.quit();
	}

	// @Test
	public static void editUserModelerUI() throws InterruptedException, IOException {

		// Test name: EditUserModelerUI
		// Step # | name | target | value
		// 1 | open | https://qa.modeler2.decisionsfirst.com/login |
		driver.get("https://qa.modeler2.decisionsfirst.com/login");
		// 2 | setWindowSize | 1435x602 |
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
		Thread.sleep(8000);

		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sidebar-control-button")));
		}
		// 8 | click | css=.sidebar-control-button |
		driver.findElement(By.cssSelector(".sidebar-control-button")).click();
		// 9 | click | css=.item:nth-child(10) > .item-text |
		driver.findElement(By.cssSelector(".item:nth-child(10) > .item-text")).click();
		// 10 | runScript | window.scrollTo(0,0) |
		// js.executeScript("window.scrollTo(0,0)");

		File src = new File("./Test Data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("EditUserModelerUITest");

		// Get the xpath of permissions form Excel Sheet
		String editUserXpath = sheet.getRow(1).getCell(0).getStringCellValue();
		// String firstName = sheet.getRow(1).getCell(1).getStringCellValue();
		String lastName = sheet.getRow(1).getCell(2).getStringCellValue();
		// String email = sheet.getRow(1).getCell(3).getStringCellValue();
		// String type = sheet.getRow(1).getCell(4).getStringCellValue();

		Thread.sleep(4000);
		WebElement l = driver.findElement(By.xpath(editUserXpath));
		Actions a = new Actions(driver);
		a.moveToElement(l).contextClick().build().perform();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Edit User')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"lastname\"]/quill-editor/div[2]/div[1]/p")).clear();
		driver.findElement(By.xpath("//*[@id=\"lastname\"]/quill-editor/div[2]/div[1]/p")).sendKeys(lastName);

		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		Thread.sleep(2000);

		System.out.println("<<<<<User Name Updated Successfully>>>>>");
		workbook.close();
	}
}
