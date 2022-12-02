// Generated by Selenium IDE

//Test Script to login the DFM application with Admin Credentials

package dfm;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.time.Duration;

public class LoginAdmin_01 {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
//		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
//		driver = new ChromeDriver();

    System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
	driver=new EdgeDriver();

	}

	@After
	public void tearDown() {
		//driver.quit();
	}

	@Test
	public void tC02() {
		// Test name: TC _02
		// Step # | name | target | value
		// 1 | open | /login |
		driver.get("https://qa.admin.decisionsfirst.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		// 2 | setWindowSize | 698x602 |
		// driver.manage().window().setSize(new Dimension(698, 602));
		// 3 | click | css=.form-group:nth-child(2) > .form-control |
		driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
		// 4 | type | xpath=//input[@type='text'] | dmsadmin@dmsadmin.com
		driver.findElement(By.xpath("//input[@type=\'text\']")).sendKeys("dmsadmin@dmsadmin.com");
		// 5 | click | css=.ng-untouched |
		driver.findElement(By.cssSelector(".ng-untouched")).click();
		// 6 | type | xpath=//input[@type='password'] | dms@123
		driver.findElement(By.xpath("//input[@type=\'password\']")).sendKeys("dms@123");
		// 7 | click | css=.btn |
		driver.findElement(By.cssSelector(".btn")).click();
		// 8 | mouseOver | css=.btn |
		{
			WebElement element = driver.findElement(By.cssSelector(".btn"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		// 9 | mouseOut | css=.btn |
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}
		
		//Verify Title
		String title = driver.getTitle();
		System.out.println("<<<The title of the Application is >>> " +  title);
		// 10 | click | xpath=//i |
		driver.findElement(By.xpath("//i[@class='sidebar-control-button nb-menu sidebar-toggle icon-gray-color']"))
				.click();
		// 11 | click | xpath=//span[contains(.,'Log Out')] |
		driver.findElement(By.xpath("//span[contains(.,\'Log Out\')]")).click();
	}
}
