package dfm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.apache.poi.ss.usermodel.DataFormatter;

public class MultiUser01 {
	static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

	@Test(priority = 1)
	public void loginAction() throws InterruptedException, IOException {

		// For QA Environment
		// 1 | open | https://qa.modeler2.decisionsfirst.com/login |
		driver.get("https://qa.modeler2.decisionsfirst.com/login");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// 2 | setWindowSize | 1289x602 |
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(989, 1002));

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
		// 8 | waitForElementVisible | css=.sidebar-control-button | 30000
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sidebar-control-button")));
		}
	}

	@Test(priority = 2)
	public void navigateToDiagram() throws InterruptedException {

		driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[1]/dfm-home-container/nb-card/div/div[1]/dfm-search-control/div/div[1]/input"))
				.sendKeys("Test MultiUser Diagram");
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[1]/dfm-home-container/nb-card/div/div[2]/dfm-infinite-search-list/nb-list/nb-list-item/dfm-preview-container/div/dfm-search-list-item/div/div/span/span[2]"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//i[@class='eva eva-settings-2-outline']")).click();
		Thread.sleep(4000);
	}

	@Test(priority = 3)
	public void createDiagram() throws IOException, InterruptedException {

		File file = new File("./Test Data/TestData.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet("MultiUser");

		// Cell data2 = sheet.getRow(0).getCell(1);
		DataFormatter dataFormatter = new DataFormatter();

		String value1 = dataFormatter.formatCellValue(sheet.getRow(1).getCell(0));
		int number1 = Integer.parseInt(value1);

		String value2 = dataFormatter.formatCellValue(sheet.getRow(1).getCell(1));
		int number2 = Integer.parseInt(value2);

		String value3 = dataFormatter.formatCellValue(sheet.getRow(2).getCell(0));
		int number3 = Integer.parseInt(value3);

		String value4 = dataFormatter.formatCellValue(sheet.getRow(2).getCell(1));
		int number4 = Integer.parseInt(value4);

		// Input data from excel
		String value5 = dataFormatter.formatCellValue(sheet.getRow(1).getCell(2));
		int number5 = Integer.parseInt(value5);

		String value6 = dataFormatter.formatCellValue(sheet.getRow(1).getCell(3));
		int number6 = Integer.parseInt(value6);

		String value7 = dataFormatter.formatCellValue(sheet.getRow(2).getCell(2));
		int number7 = Integer.parseInt(value7);

		String value8 = dataFormatter.formatCellValue(sheet.getRow(2).getCell(3));
		int number8 = Integer.parseInt(value8);

		String value9 = dataFormatter.formatCellValue(sheet.getRow(1).getCell(4));
		int number9 = Integer.parseInt(value9);

		String value10 = dataFormatter.formatCellValue(sheet.getRow(1).getCell(5));
		int number10 = Integer.parseInt(value10);

		String value11 = dataFormatter.formatCellValue(sheet.getRow(2).getCell(4));
		int number11 = Integer.parseInt(value11);

		String value12 = dataFormatter.formatCellValue(sheet.getRow(2).getCell(5));
		int number12 = Integer.parseInt(value12);

		String value13 = dataFormatter.formatCellValue(sheet.getRow(1).getCell(6));
		int number13 = Integer.parseInt(value13);

		String value14 = dataFormatter.formatCellValue(sheet.getRow(1).getCell(7));
		int number14 = Integer.parseInt(value14);

		String value15 = dataFormatter.formatCellValue(sheet.getRow(2).getCell(6));
		int number15 = Integer.parseInt(value15);

		String value16 = dataFormatter.formatCellValue(sheet.getRow(2).getCell(7));
		int number16 = Integer.parseInt(value16);

		String value17 = dataFormatter.formatCellValue(sheet.getRow(1).getCell(8));
		int number17 = Integer.parseInt(value17);

		String value18 = dataFormatter.formatCellValue(sheet.getRow(1).getCell(9));
		int number18 = Integer.parseInt(value18);

		String value19 = dataFormatter.formatCellValue(sheet.getRow(2).getCell(8));
		int number19 = Integer.parseInt(value19);

		String value20 = dataFormatter.formatCellValue(sheet.getRow(2).getCell(9));
		int number20 = Integer.parseInt(value20);

		String value21 = dataFormatter.formatCellValue(sheet.getRow(1).getCell(10));
		int number21 = Integer.parseInt(value21);

		String value22 = dataFormatter.formatCellValue(sheet.getRow(1).getCell(11));
		int number22 = Integer.parseInt(value22);

		String value23 = dataFormatter.formatCellValue(sheet.getRow(2).getCell(10));
		int number23 = Integer.parseInt(value23);

		String value24 = dataFormatter.formatCellValue(sheet.getRow(2).getCell(11));
		int number24 = Integer.parseInt(value24);

		Actions act = new Actions(driver);

		WebElement src = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[2]/dfm-go-js-add-object-palette/div/div/canvas"));

		WebElement target = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/div/dfm-go-js-display-diagram/div/div"));

		WebElement reuse_objects = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[3]/dfm-go-js-existing-objects-palette/div/div/canvas"));

		// Input Source data 1
		act.moveToElement(src, number1, number2);
		act.clickAndHold().moveByOffset(number1, number2);
		act.moveToElement(src, number3, number4);
		act.moveToElement(target, number4, number4);
		act.release();
		act.perform();
		Thread.sleep(8000);

		// Knowledge data
		act.moveToElement(src, number5, number6);
		act.clickAndHold().moveByOffset(number5, number6);
		act.moveToElement(src, number7, number8);
		act.moveToElement(target, number7, number8);
		act.release();
		act.perform();
		Thread.sleep(12000);

		// Decision Objects
		act.moveToElement(src, number9, number10);
		act.clickAndHold().moveByOffset(number9, number10);
		act.moveToElement(src, number11, number12);
		act.moveToElement(target, number11, number12);
		act.release();
		act.perform();
		Thread.sleep(8000);

		// Group Item Objects
		act.moveToElement(src, number13, number14);
		act.clickAndHold().moveByOffset(number13, number14);
		act.moveToElement(src, number15, number16);
		act.moveToElement(target, number15, number16);
		act.release();
		act.perform();
		Thread.sleep(8000);

		// Annotation Objects
		act.moveToElement(src, number17, number18);
		act.clickAndHold().moveByOffset(number17, number18);
		act.moveToElement(src, number19, number20);
		act.moveToElement(target, number19, number20);
		act.release();
		act.perform();
		Thread.sleep(8000);

		// Decision re-used objects
		act.moveToElement(reuse_objects, number21, number22);
		act.clickAndHold().moveByOffset(number21, number22);
		act.moveToElement(reuse_objects, number23, number24);
		act.moveToElement(target, number23, number24);
		act.release();
		act.perform();
		Thread.sleep(5000);

	}

}
