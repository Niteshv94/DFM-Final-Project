// Generated by Selenium IDE
package dfm;

import org.junit.Test;

import org.junit.Before;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class AddProjectTagAndDiagram {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		// driver.quit();
	}

	@Test
	public void addProject() throws InterruptedException, IOException {
		// Test name: Add Project
		// Step # | name | target | value
		// 1 | open | https://qa.modeler2.decisionsfirst.com/login |
		driver.get("https://qa.modeler2.decisionsfirst.com/login");
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
		// 9 | click | css=.sidebar-control-button |
		driver.findElement(By.cssSelector(".sidebar-control-button")).click();
		Thread.sleep(3000);
		// 10 | click | xpath=//span[contains(.,'Tag Explorer')] |
		driver.findElement(By.xpath("//span[contains(.,\'Tag Explorer\')]")).click();
		Thread.sleep(5000);
		// 11 | click | css=.eva-plus-circle-outline:nth-child(2) |
		driver.findElement(By.cssSelector(".eva-plus-circle-outline:nth-child(2)")).click();
		Thread.sleep(5000);
		// 12 | click | css=.wj-listbox-item:nth-child(1) > div |
		driver.findElement(By.cssSelector(".wj-listbox-item:nth-child(1) > div")).click();
		Thread.sleep(5000);
		// 13 | click | css=.rich-text-editor-focus p |
		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id='name']/quill-editor/div[2]/div/p"))
				.click();
		// Thread.sleep(5000);

		// Get the Projet & Tag data form Excel Sheet
		File src = new File("./Test Data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("AddProjectTagAndDiagram");

		String projectName = sheet.getRow(1).getCell(0).getStringCellValue();
		String description = sheet.getRow(1).getCell(1).getStringCellValue();
		String branching = sheet.getRow(1).getCell(2).getStringCellValue();
		String searchProject = sheet.getRow(1).getCell(3).getStringCellValue();
		String projectName1 = sheet.getRow(1).getCell(4).getStringCellValue();
		String tagName = sheet.getRow(1).getCell(5).getStringCellValue();
		String tagDescription = sheet.getRow(1).getCell(6).getStringCellValue();
		String tagXpath = sheet.getRow(1).getCell(7).getStringCellValue();
		String diagramName = sheet.getRow(1).getCell(8).getStringCellValue();
		String diagramDescription = sheet.getRow(1).getCell(9).getStringCellValue();
		String knowledgeName = sheet.getRow(1).getCell(10).getStringCellValue();
		String inputName = sheet.getRow(1).getCell(11).getStringCellValue();
		String decisionName = sheet.getRow(1).getCell(12).getStringCellValue();

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

		// Add Tag

		Thread.sleep(5000);
		// 10 | click | id=search-ip |
		driver.findElement(By.id("search-ip")).click();
		// 11 | type | id=search-ip | dummy
		driver.findElement(By.id("search-ip")).sendKeys(searchProject);

		// identify element
		WebElement l = driver.findElement(By.xpath(projectName1));
		// Actions class with moveToElement() and contextClick()
		Actions a = new Actions(driver);
		a.moveToElement(l).contextClick().build().perform();
		Thread.sleep(2000);

		// 13 | click | css=.rich-text-editor-focus p |
		driver.findElement(By.xpath("//div[contains(text(),'Add Tag')]")).click();

		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id='name']//div[@class='ql-editor ql-blank']"))
				.sendKeys(tagName);

		driver.findElement(
				By.xpath("//core-edit-multiple-lines-control[@id='description']//div[@class='ql-editor ql-blank']"))
				.sendKeys(tagDescription);

		// 17 | click | css=.btn-block |
		driver.findElement(By.xpath("//button[contains(.,'Add Tag')]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[@class='wj-node-text has-text']")).click();

		// identify element
		WebElement tag = driver.findElement(By.xpath(tagXpath));
		// Actions class with moveToElement() and contextClick()
		Actions a1 = new Actions(driver);
		a1.moveToElement(tag).contextClick().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Create DRD')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id='diagramName']//p")).sendKeys(diagramName);

		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id='diagramDescription']//p"))
				.sendKeys(diagramDescription);

		driver.findElement(By.xpath("//button[normalize-space()='Add Diagram']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//i[@class='eva eva-settings-2-outline']")).click();
		Thread.sleep(10000);

		Actions act = new Actions(driver);

		WebElement src1 = driver.findElement(By.xpath("//div[@class='add-object-palette']//canvas"));

		WebElement LINKS = driver.findElement(By.xpath("//div[@class='links-palette']"));

		WebElement target = driver.findElement(By.xpath("//div[@class='diagramDiv']//canvas"));

		XSSFSheet sheet1 = workbook.getSheet("AddProjectTagAndDiagram");
		// Cell data2 = sheet.getRow(0).getCell(1);
		DataFormatter dataFormatter = new DataFormatter();

		// Input data from excel for knowledge source
		String value1 = dataFormatter.formatCellValue(sheet1.getRow(6).getCell(0));
		int number1 = Integer.parseInt(value1);

		String value2 = dataFormatter.formatCellValue(sheet1.getRow(6).getCell(1));
		int number2 = Integer.parseInt(value2);

		String value3 = dataFormatter.formatCellValue(sheet1.getRow(7).getCell(0));
		int number3 = Integer.parseInt(value3);

		String value4 = dataFormatter.formatCellValue(sheet1.getRow(7).getCell(1));
		int number4 = Integer.parseInt(value4);

		// Input data from excel for Decision source
		String value5 = dataFormatter.formatCellValue(sheet1.getRow(6).getCell(2));
		int number5 = Integer.parseInt(value5);

		String value6 = dataFormatter.formatCellValue(sheet1.getRow(6).getCell(3));
		int number6 = Integer.parseInt(value6);

		String value7 = dataFormatter.formatCellValue(sheet1.getRow(7).getCell(2));
		int number7 = Integer.parseInt(value7);

		String value8 = dataFormatter.formatCellValue(sheet1.getRow(7).getCell(3));
		int number8 = Integer.parseInt(value8);

		// Input data from excel for Input source
		String value9 = dataFormatter.formatCellValue(sheet1.getRow(6).getCell(4));
		int number9 = Integer.parseInt(value9);

		String value10 = dataFormatter.formatCellValue(sheet1.getRow(6).getCell(5));
		int number10 = Integer.parseInt(value10);

		String value11 = dataFormatter.formatCellValue(sheet1.getRow(7).getCell(4));
		int number11 = Integer.parseInt(value11);

		String value12 = dataFormatter.formatCellValue(sheet1.getRow(7).getCell(5));
		int number12 = Integer.parseInt(value12);

		// Input data from excel for connection between objects
		String connectionValue1 = dataFormatter.formatCellValue(sheet1.getRow(10).getCell(0));
		int connectionNumber1 = Integer.parseInt(connectionValue1);

		String connectionValue2 = dataFormatter.formatCellValue(sheet1.getRow(10).getCell(1));
		int connectionNumber2 = Integer.parseInt(connectionValue2);

		String connectionValue3 = dataFormatter.formatCellValue(sheet1.getRow(11).getCell(0));
		int connectionNumber3 = Integer.parseInt(connectionValue3);

		String connectionValue4 = dataFormatter.formatCellValue(sheet1.getRow(11).getCell(1));
		int connectionNumber4 = Integer.parseInt(connectionValue4);

		String connectionValue5 = dataFormatter.formatCellValue(sheet1.getRow(12).getCell(0));
		int connectionNumber5 = Integer.parseInt(connectionValue5);

		String connectionValue6 = dataFormatter.formatCellValue(sheet1.getRow(12).getCell(1));
		int connectionNumber6 = Integer.parseInt(connectionValue6);

		String connectionValue7 = dataFormatter.formatCellValue(sheet1.getRow(13).getCell(0));
		int connectionNumber7 = Integer.parseInt(connectionValue7);

		String connectionValue8 = dataFormatter.formatCellValue(sheet1.getRow(13).getCell(1));
		int connectionNumber8 = Integer.parseInt(connectionValue8);

		String connectionValue9 = dataFormatter.formatCellValue(sheet1.getRow(14).getCell(0));
		int connectionNumber9 = Integer.parseInt(connectionValue9);

		String connectionValue10 = dataFormatter.formatCellValue(sheet1.getRow(14).getCell(1));
		int connectionNumber10 = Integer.parseInt(connectionValue10);

		String connectionValue11 = dataFormatter.formatCellValue(sheet1.getRow(15).getCell(0));
		int connectionNumber11 = Integer.parseInt(connectionValue11);

		String connectionValue12 = dataFormatter.formatCellValue(sheet1.getRow(15).getCell(1));
		int connectionNumber12 = Integer.parseInt(connectionValue12);

		// Knowledge Source data 1
//		act.moveToElement(src, 58, 5);
//		act.clickAndHold().moveByOffset(58, 5);
//		act.moveToElement(src, 250, 70);
//		act.moveToElement(target, 250, 70);
//		act.release();
//		act.perform();
//		Thread.sleep(4000);

		// Knowledge Source data 2

		// Decision data 1
//		act.moveToElement(src, -56, 5);
//		act.clickAndHold().moveByOffset(-56, 5);
//		act.moveToElement(src, 100, -50);
//		act.moveToElement(target, 100, -50);
//		act.release();
//		act.perform();
//		Thread.sleep(3000);

		// click Authority Links
//		act.moveToElement(LINKS, 10, 20);
//		act.click().build().perform();
//		Thread.sleep(2000);

		// creating the connection with links between Knowledge Source
//		act.moveToElement(target, 155, 75);
//		act.clickAndHold().moveByOffset(155, 75);
//		act.moveByOffset(105, -45);
//		act.release();
//		act.perform();
//		Thread.sleep(2000);

		// Knowledge Source data 1
		act.moveToElement(src1, number1, number2);
		act.clickAndHold().moveByOffset(number1, number2);
		act.moveToElement(src1, number3, number4);
		act.moveToElement(target, number3, number4);
		act.release();
		act.perform();
		Thread.sleep(4000);

		// Decision Source data 1
		act.moveToElement(src1, number5, number6);
		act.clickAndHold().moveByOffset(number5, number6);
		act.moveToElement(src1, number7, number8);
		act.moveToElement(target, number7, number8);
		act.release();
		act.perform();
		Thread.sleep(3000);

		// Input Source data 1
		act.moveToElement(src1, number9, number10);
		act.clickAndHold().moveByOffset(number9, number10);
		act.moveToElement(src1, number11, number12);
		act.moveToElement(target, number11, number12);
		act.release();
		act.perform();
		Thread.sleep(3000);

		// click Authority Links
		act.moveToElement(LINKS, 10, 20);
		act.click().build().perform();
		Thread.sleep(2000);

		// creating the connection with links between Decision data 1 & Knowledge Source
		act.moveToElement(target, connectionNumber1, connectionNumber2);
		act.clickAndHold().moveByOffset(connectionNumber1, connectionNumber2);
		act.moveByOffset(connectionNumber3, connectionNumber4);
		act.release();
		act.perform();
		Thread.sleep(2000);

		// creating the connection with links between Input Source & Knowledge Source
		// data 1
		act.moveToElement(target, connectionNumber5, connectionNumber6);
		act.clickAndHold().moveByOffset(connectionNumber5, connectionNumber6);
		act.moveByOffset(connectionNumber7, connectionNumber8);
		act.release();
		act.perform();
		Thread.sleep(2000);

		// click Information Links
		act.moveToElement(LINKS, -43, 20);
		act.click().build().perform();
		Thread.sleep(2000);

		// creating the connection with links between Input Source & Decision data 1
		act.moveToElement(target, connectionNumber9, connectionNumber10);
		act.clickAndHold().moveByOffset(connectionNumber9, connectionNumber10);
		act.moveByOffset(connectionNumber11, connectionNumber12);
		act.release();
		act.perform();
		Thread.sleep(2000);

		// click Knowledge Source data 1
		act.moveToElement(target, 255, 75);
		act.click().build().perform();
		Thread.sleep(3000);

		// update Knowledge Source data 1
		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).sendKeys(knowledgeName);
		Thread.sleep(2000);

		// click Input Source data 1
		act.moveToElement(target, 305, -45);
		act.click().build().perform();
		Thread.sleep(3000);

		// update Input Source data 1
		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).sendKeys(inputName);
		Thread.sleep(2000);

		// click Decision Source data 1
		act.moveToElement(target, 155, 75);
		act.click().build().perform();
		Thread.sleep(3000);

		// update Decision Source data 1
		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).sendKeys(decisionName);
		Thread.sleep(2000);

		act.moveToElement(LINKS, -14, 120);
		act.contextClick().perform();

		System.out.println("<<<Diagram created>>>");
		workbook.close();

	}
}
