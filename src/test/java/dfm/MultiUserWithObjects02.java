package dfm;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultiUserWithObjects02 {
	
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

		driver.get("https://qa.modeler2.decisionsfirst.com/login");
		// driver.get("https://dev.modeler2.decisionsfirst.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("test5@rxw.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
		driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		 //Thread.sleep(18000);
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sidebar-control-button")));
		}
	}
	@Test(priority = 2)
	public void navigateToObjects() throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[1]/dfm-home-container/nb-card/div/div[1]/dfm-search-control/div/div[1]/input"))
				.sendKeys("Test Multiuser Objects & Diagram");
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[1]/dfm-home-container/nb-card/div/div[2]/dfm-infinite-search-list/nb-list/nb-list-item/dfm-preview-container/div/dfm-search-list-item/div/div/span/span[2]"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//i[@class='eva eva-settings-2-outline']")).click();
		Thread.sleep(4000);

		Actions act = new Actions(driver);

		WebElement target = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/div/dfm-go-js-display-diagram/div/div"));
		
		WebElement reuse_objects = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[3]/dfm-go-js-existing-objects-palette/div/div/canvas"));

		// Input data source 1
				act.moveToElement(target, 5, 5);
				act.click().build().perform();
				Thread.sleep(2000);
				String expected_value1 = driver.findElement(By.cssSelector("div[class='ql-editor'] p")).getText();
				System.out.println("Value fetched after object placed is :- " + expected_value1);
				
				// Input data source 1
				act.moveToElement(target, -95, 5);
				act.click().build().perform();
				Thread.sleep(2000);
				String expected_value2 = driver.findElement(By.cssSelector("div[class='ql-editor'] p")).getText();
				System.out.println("Value fetched after object placed is :- " + expected_value2);
				
				// Input data source 1
				act.moveToElement(target, 255, -145);
				act.click().build().perform();
				Thread.sleep(2000);
				String expected_value3 = driver.findElement(By.cssSelector("div[class='ql-editor'] p")).getText();
				System.out.println("Value fetched after object placed is :- " + expected_value3);
				
				// Input data source 1
				act.moveToElement(target, 55, -145);
				act.click().build().perform();
				Thread.sleep(2000);
				String expected_value4 = driver.findElement(By.cssSelector("div[class='ql-editor'] p")).getText();
				System.out.println("Value fetched after object placed is :- " + expected_value4);
				
				// Input data source 1
				act.moveToElement(target, -125, -145);
				act.click().build().perform();
				Thread.sleep(2000);
				String expected_value5 = driver.findElement(By.cssSelector("div[class='ql-editor'] p")).getText();
				System.out.println("Value fetched after object placed is :- " + expected_value5);
				
	}

}
