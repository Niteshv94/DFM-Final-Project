// Generated by Selenium IDE

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
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class DeleteObjectProperties {
	private static WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

	public String waitForWindow(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> whNow = driver.getWindowHandles();
		Set<String> whThen = (Set<String>) vars.get("window_handles");
		if (whNow.size() > whThen.size()) {
			whNow.removeAll(whThen);
		}
		return whNow.iterator().next();
	}

	@Test(priority = 1)
	public void loginToApplication() throws InterruptedException, IOException, AWTException {
		login();
		searchObjectProperties();
	}

	@Test(priority = 2)
	public void deleteAndValidateObjectProperties() throws InterruptedException, IOException, AWTException {
		deleteSearchDiagram();
		Thread.sleep(5000);
		searchObjectProperties();
	}

	public void login() throws InterruptedException {

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
	}

	public static void searchObjectProperties() throws InterruptedException, IOException, AWTException {

		// Get the xpath and Tag data form Excel Sheet
		File src = new File("./Test Data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("DeleteObjectProperties");

		String searchDiagram = sheet.getRow(1).getCell(0).getStringCellValue();

		// 11 | type | id=search-ip | dummy
		driver.findElement(By.xpath(
				"//dfm-search-control[@ng-reflect-search-action='class UpdateSearchForHomeSearc']//input[@placeholder='Search']"))
				.clear();

		driver.findElement(By.xpath(
				"//dfm-search-control[@ng-reflect-search-action='class UpdateSearchForHomeSearc']//input[@placeholder='Search']"))
				.sendKeys(searchDiagram);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(200);

		// driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div/dfm-home-container/nb-card/div/div[1]/dfm-search-control/div/div[1]/div/i")).click();

	}

	public static void deleteSearchDiagram() throws InterruptedException {
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-search-container/nb-card/div/div[2]/div[2]/dfm-infinite-search-list/nb-list/nb-list-item/dfm-preview-container/div/dfm-search-list-item/div/div/button"))
				.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//i[@class='nb-close icon']")).click();

		// driver.navigate().refresh();
	}
}