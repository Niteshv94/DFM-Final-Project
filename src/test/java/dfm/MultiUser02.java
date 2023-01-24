package dfm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.apache.poi.ss.usermodel.DataFormatter;

public class MultiUser02 {
	static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

//		 System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
//				 driver=new EdgeDriver();
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
		//driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1689, 702));

		// 3 | click | css=.form-group:nth-child(2) > .form-control |
		driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
		// 4 | type | xpath=//input[@type='text'] | nitesh@rxw.com
		driver.findElement(By.xpath("//input[@type=\'text\']")).sendKeys("test5@rxw.com");
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

		Thread.sleep(10000);
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
	public void validateDiagram() throws InterruptedException, IOException {
		
		File file = new File("./Test Data/TestData.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet("MultiUser");

		// Cell data2 = sheet.getRow(0).getCell(1);
		DataFormatter dataFormatter = new DataFormatter();

		String value1 = dataFormatter.formatCellValue(sheet.getRow(7).getCell(0));
		int number1 = Integer.parseInt(value1);

		String value2 = dataFormatter.formatCellValue(sheet.getRow(7).getCell(1));
		int number2 = Integer.parseInt(value2);

		String value3 = dataFormatter.formatCellValue(sheet.getRow(7).getCell(2));
		int number3 = Integer.parseInt(value3);

		String value4 = dataFormatter.formatCellValue(sheet.getRow(7).getCell(3));
		int number4 = Integer.parseInt(value4);

		// Input data from excel
		String value5 = dataFormatter.formatCellValue(sheet.getRow(7).getCell(4));
		int number5 = Integer.parseInt(value5);

		String value6 = dataFormatter.formatCellValue(sheet.getRow(7).getCell(5));
		int number6 = Integer.parseInt(value6);

		String value7 = dataFormatter.formatCellValue(sheet.getRow(7).getCell(6));
		int number7 = Integer.parseInt(value7);

		String value8 = dataFormatter.formatCellValue(sheet.getRow(7).getCell(7));
		int number8 = Integer.parseInt(value8);

		String value9 = dataFormatter.formatCellValue(sheet.getRow(7).getCell(8));
		int number9 = Integer.parseInt(value9);

		String value10 = dataFormatter.formatCellValue(sheet.getRow(7).getCell(9));
		int number10 = Integer.parseInt(value10);

		String value11 = dataFormatter.formatCellValue(sheet.getRow(7).getCell(10));
		int number11 = Integer.parseInt(value11);

		String value12 = dataFormatter.formatCellValue(sheet.getRow(7).getCell(11));
		int number12 = Integer.parseInt(value12);
		
		Actions act = new Actions(driver);

		WebElement src = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[2]/dfm-go-js-add-object-palette/div/div/canvas"));

		WebElement target = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/div/dfm-go-js-display-diagram/div/div"));
		// Validate the new Object first Update the name then validate
		// driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).clear();
		Thread.sleep(4000);
		// driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).sendKeys(inputName1);
		// Thread.sleep(1000);
		// Click Outside
//		act.moveToElement(target, -1, -1);
//		act.click().build().perform();
//		Thread.sleep(5000);
		// Input data source 1
		act.moveToElement(target, number1, number2);
		act.click().build().perform();
		Thread.sleep(2000);
		String expected_value1 = driver.findElement(By.cssSelector("div[class='ql-editor'] p")).getText();
		System.out.println("Value fetched after object placed is :- " + expected_value1);
		// Assert.assertEquals(inputName1, expected_value1, "The Object is not
		// matched");

		// Click Outside
		Thread.sleep(5000);
		// knowledge data source 1
		act.moveToElement(target, number3, number4);
		act.click().build().perform();
		Thread.sleep(2000);
		String expected_value2 = driver.findElement(By.cssSelector("div[class='ql-editor'] p")).getText();
		System.out.println("Value fetched after object placed is :- " + expected_value2);
		// Assert.assertEquals(inputName1, expected_value1, "The Object is not
		// matched");

		// Decision source 1
		act.moveToElement(target, number5, number6);
		act.click().build().perform();
		Thread.sleep(2000);
		String expected_value3 = driver.findElement(By.cssSelector("div[class='ql-editor'] p")).getText();
		System.out.println("Value fetched after object placed is :- " + expected_value3);

		// Group Item Objects
		act.moveToElement(target, number7, number8);
		act.click().build().perform();
		Thread.sleep(2000);
		String expected_value4 = driver.findElement(By.xpath("//*[@id=\"description\"]/quill-editor/div[2]/div[1]"))
				.getText();
		System.out.println("Value fetched after object placed is :- " + expected_value4);

		// Annotation Objects
		act.moveToElement(target, number9, number10);
		act.click().build().perform();
		Thread.sleep(2000);
		String expected_value5 = driver.findElement(By.xpath("//*[@id=\"description\"]/quill-editor/div[2]/div[1]"))
				.getText();
		System.out.println("Value fetched after object placed is :- " + expected_value5);

		// Reused Decision Objects
		act.moveToElement(target, number11, number12);
		act.click().build().perform();
		Thread.sleep(2000);
		String expected_value6 = driver.findElement(By.cssSelector("div[class='ql-editor'] p")).getText();
		System.out.println("Value fetched after object placed is :- " + expected_value6);
	}

}
