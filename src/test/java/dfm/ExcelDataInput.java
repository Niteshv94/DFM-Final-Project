package dfm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelDataInput {

	public static void main(String[] args) throws IOException, InterruptedException {

		File file = new File("D:\\ReactiveWorks\\Data.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Cell data2 = sheet.getRow(0).getCell(1);
		DataFormatter dataFormatter = new DataFormatter();

		String value1 = dataFormatter.formatCellValue(sheet.getRow(0).getCell(0));
		int number1 = Integer.parseInt(value1);

		String value2 = dataFormatter.formatCellValue(sheet.getRow(0).getCell(1));
		int number2 = Integer.parseInt(value2);

		String value3 = dataFormatter.formatCellValue(sheet.getRow(1).getCell(0));
		int number3 = Integer.parseInt(value3);

		String value4 = dataFormatter.formatCellValue(sheet.getRow(1).getCell(1));
		int number4 = Integer.parseInt(value4);

		// Input data from excel
		String value5 = dataFormatter.formatCellValue(sheet.getRow(2).getCell(0));
		int number5 = Integer.parseInt(value5);

		String value6 = dataFormatter.formatCellValue(sheet.getRow(2).getCell(1));
		int number6 = Integer.parseInt(value6);

		String value7 = dataFormatter.formatCellValue(sheet.getRow(3).getCell(0));
		int number7 = Integer.parseInt(value7);

		String value8 = dataFormatter.formatCellValue(sheet.getRow(3).getCell(1));
		int number8 = Integer.parseInt(value8);

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa.modeler2.decisionsfirst.com/login");
		// driver.get("https://dev.modeler2.decisionsfirst.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("nitesh@rxw.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
		driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
		// Thread.sleep(8000);

		driver.findElement(By.xpath(
				"//nb-list-item[1]//dfm-preview-container[1]//div[1]//dfm-search-list-item[1]//div[1]//div[1]//span[1]//span[1]"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//i[@class='eva eva-settings-2-outline']")).click();
		Thread.sleep(4000);

		Actions act = new Actions(driver);

		WebElement src = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[2]/dfm-go-js-add-object-palette/div/div/canvas"));

		WebElement target = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/div/dfm-go-js-display-diagram/div/div"));

		// Input data
		act.moveToElement(src, number1, number2);
		act.clickAndHold().moveByOffset(number1, number2);
		act.moveToElement(src, number3, number4);
		act.moveToElement(target, number3, number4);
		act.release();
		act.perform();
		Thread.sleep(3000);

		// Input Source data 1
		act.moveToElement(src, number5, number6);
		act.clickAndHold().moveByOffset(number5, number6);
		act.moveToElement(src, number7, number8);
		act.moveToElement(target, number7, number8);
		act.release();
		act.perform();
		Thread.sleep(3000);

		System.out.println("Data passed from excel");

	}

}
