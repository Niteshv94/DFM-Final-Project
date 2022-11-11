// Generated by Selenium IDE

package dfm;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AddTagTest {
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
		 //driver.quit();
	}

	@Test
	public void addTag() throws InterruptedException {
		// Test name: Add Tag
		// Step # | name | target | value
		// 1 | open | https://qa.modeler2.decisionsfirst.com/login |
		driver.get("https://qa.modeler2.decisionsfirst.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// 2 | setWindowSize | 1183x602 |
		driver.manage().window().maximize();
		// 3 | click | css=.form-group:nth-child(2) > .form-control |
		driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
		// 4 | type | css=.ng-valid | test_claim2@gmail.com
		driver.findElement(By.xpath("//input[@type=\'text\']")).sendKeys("test_claim2@gmail.com");
		// 5 | click | css=.ng-untouched |
		driver.findElement(By.cssSelector(".ng-untouched")).click();
		// 6 | type | css=.ng-untouched | defaultUserPass@123
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
		driver.findElement(By.xpath("//span[@class='item-text'][normalize-space()='Tag Explorer']")).click();
		Thread.sleep(5000);
		// 10 | click | id=search-ip |
		driver.findElement(By.id("search-ip")).click();
		// 11 | type | id=search-ip | dummy
		driver.findElement(By.id("search-ip")).sendKeys("dummy");

		// identify element
		WebElement l = driver.findElement(By.xpath("//span[normalize-space()='test dummy (main)']"));
		// Actions class with moveToElement() and contextClick()
		Actions a = new Actions(driver);
		a.moveToElement(l).contextClick().build().perform();
		Thread.sleep(2000);

		// 13 | click | css=.rich-text-editor-focus p |
		driver.findElement(By.xpath("//div[contains(text(),'Add Tag')]")).click();

		// 14 | editContent | css=.rich-text-editor-focus > .ql-editor | <p>test tag</p>
//    {
//      WebElement element = driver.findElement(By.cssSelector(".rich-text-editor-focus > .ql-editor"));
//      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>test tag</p>'}", element);
//    }

		driver.findElement(By.xpath("//core-edit-multiple-lines-control[@id='name']//div[@class='ql-editor ql-blank']"))
				.sendKeys("Test Tag");

		// 15 | click | css=.ql-blank > p |
//    driver.findElement(By.cssSelector(".ql-blank > p")).click();
		// 16 | editContent | css=.rich-text-editor-focus > .ql-editor | <p>tag</p>
//    {
//      WebElement element = driver.findElement(By.cssSelector(".rich-text-editor-focus > .ql-editor"));
//      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>tag</p>'}", element);
//    }

		driver.findElement(
				By.xpath("//core-edit-multiple-lines-control[@id='description']//div[@class='ql-editor ql-blank']"))
				.sendKeys("Oct-22");

		// 17 | click | css=.btn-block |
		driver.findElement(By.xpath("//button[contains(.,'Add Tag')]")).click();
	}
}