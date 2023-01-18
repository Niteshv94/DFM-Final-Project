// Generated by Selenium IDE

package dfm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

public class KnowledgeSourceSearch {
	 static WebDriver driver;
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
		clickOnSearchLensIcon();
	}

	@Test(priority = 2)
	public void printListOfElements() throws InterruptedException, IOException, AWTException {
		Thread.sleep(4000);
		selectProjectDropdown();
		
	}
	
	@Test(priority = 3)
	public void printListOfInputElements() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		SearchKnowledgeSource();
		
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

	public static void clickOnSearchLensIcon() throws InterruptedException, IOException, AWTException {

		// Get the xpath and Tag data form Excel Sheet
		/*File src = new File("./Test Data/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("DeleteObjectProperties");

		String searchDiagram = sheet.getRow(1).getCell(0).getStringCellValue();*/

		// 11 | type | id=search-ip | dummy
		driver.findElement(By.xpath(
				"//dfm-search-control[@ng-reflect-search-action='class UpdateSearchForAutocompl']//i[@class='btn btn-info eva eva-search-outline search-icon']")).click();


	}
	
	public static void selectProjectDropdown() throws InterruptedException {
		
		Select drpCountry = new Select(driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-search-container/nb-card/div/div[1]/dfm-search-filter/div/div/div[1]/div/select")));
		drpCountry.selectByValue("290c240c-2df0-4905-8080-4541856c0dc9");
		Thread.sleep(3000);
		List<WebElement> allElements=driver.findElements(By.xpath("//div[@class='item-name full-type-item-name']"));
		//System.out.println(allElements.size());
		Iterator<WebElement> itr = allElements.iterator();
		while(itr.hasNext()) {
		    System.out.println(itr.next().getText());
		}

//		for(int r=1; r<10; r++)
//		{
//			String xpath = "/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-search-container/nb-card/div/div[2]/div[2]/dfm-infinite-search-list/nb-list/nb-list-item[" + r + "]/dfm-preview-container/div/dfm-search-list-item/div/div";
//			String a = driver.findElement(By.xpath(xpath)).getText();
//			System.out.println(a);
//			
//		}
		
		
	}

//	public static void deleteSearchDiagram() throws InterruptedException {
//		Thread.sleep(3000);
//
//		driver.findElement(By.xpath(
//				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-search-container/nb-card/div/div[2]/div[2]/dfm-infinite-search-list/nb-list/nb-list-item/dfm-preview-container/div/dfm-search-list-item/div/div/button"))
//				.click();
//
//		Thread.sleep(10000);
//
//		driver.findElement(By.xpath("//i[@class='nb-close icon']")).click();
//
//		// driver.navigate().refresh();
//	}
	
	public static void SearchKnowledgeSource() throws InterruptedException {
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-search-container/nb-card/div/div[1]/dfm-search-filter/div/div/div[2]/wj-tree-view/div/div[7]/input")).click();

		System.out.println("=====================================");
		Thread.sleep(3000);
		List<WebElement> allElements=driver.findElements(By.xpath("//div[@class='item-name full-type-item-name']"));
		//System.out.println(allElements.size());
		Iterator<WebElement> itr = allElements.iterator();
		while(itr.hasNext()) {
		    System.out.println(itr.next().getText());
		}
	}
}
