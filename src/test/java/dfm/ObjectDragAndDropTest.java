package dfm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;

import java.util.*;
import java.io.IOException;
import java.time.Duration;
public class ObjectDragAndDropTest {
  private WebDriver driver;
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
    //driver.quit();
  }
  @Test (priority = 1)
	public void loginAction() throws InterruptedException, IOException {
		// Test name: Add Project
		// Step # | name | target | value

		// QA Environment
		// 1 | open | https://qa.modeler2.decisionsfirst.com/login |
		 driver.get("https://qa.modeler2.decisionsfirst.com/login");

		// For Openshift Environment
		//driver.get("https://modeler2-dfm-dms.apps.oc-prod.decisionsfirst.com/login");

		// 2 | setWindowSize | 1126x602 |
		driver.manage().window().maximize();
		// driver.manage().window().setSize(new Dimension(989, 1002));
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
		//Thread.sleep(8000);

		// 8 | waitForElementVisible | css=.sidebar-control-button | 30000
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sidebar-control-button")));
		}
	}
  @Test (priority = 2)
	public void loginAction1() throws InterruptedException, IOException {
  
    
    {
      WebElement element = driver.findElement(By.cssSelector(".btn"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    Thread.sleep(3000);
    driver.findElement(By.cssSelector(".sidebar-control-button")).click();
    driver.findElement(By.cssSelector(".item:nth-child(7) > .item-text")).click();
    Thread.sleep(5000);
    driver.findElement(By.id("search-ip")).click();
    driver.findElement(By.id("search-ip")).sendKeys("Test Validation");
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div[1]/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-folders-tags-management-container/nb-card/div/div[1]/dfm-project-tree-view/div/div[2]/wj-tree-view/div/div[1]")).click();
    driver.findElement(By.cssSelector(".wj-state-selected")).click();
    driver.findElement(By.cssSelector(".wj-state-selected > .wj-node-text")).click();
    {
     driver.findElement(By.xpath("//span[contains(text(),'Test Tag (1)')]")).click();
     Thread.sleep(4000);
   //  driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div[1]/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-folders-tags-management-container/nb-card/div/div[1]/dfm-project-tree-view/div/div[2]/wj-tree-view/div/div[2]/div[3]"));
     
     driver.findElement(By.xpath("//div[normalize-space()='Decision-Nitesh (33)']")).click();
     Thread.sleep(2000);
     String number = driver.findElement(By.xpath("/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-folders-tags-management-container/nb-card/div/div[2]/dfm-related-object-grid-view/div/div[3]/span")).getText();
     System.out.println(number);
     WebElement source = 	driver.findElement(By.xpath("//div[normalize-space()='Knowledge Source-Nitesh (8)']"));
     WebElement target =  driver.findElement(By.id("search-ip"));
    	Actions act = new Actions(driver);
    	//builder.dragAndDrop(source, target).release().perform();
    	//act.moveToElement(source).clickAndHold(source).moveToElement(target).release(target).perform();
    	
//		act.clickAndHold(source);
//		act.moveToElement(target);
//		act.release(target);
//		act.perform();
    	
    	//act.moveToElement(source).clickAndHold(source).moveToElement(target).release(target).build().perform();
    	//act.dragAndDrop(source, target).release().perform();
		
      //act.dragAndDrop(source, target).build().perform();
    	
//    int x = target.getLocation().x;
//    int y = source.getLocation().y;    
//    System.out.println(x);
//    System.out.println(y);   
//    act.moveToElement(source)
//    .pause(Duration.ofSeconds(1))
//    .clickAndHold(source)
//    .pause(Duration.ofSeconds(1))
//    .moveByOffset(x, y)
//    .moveToElement(target)
//    .moveByOffset(x,y)
//    .pause(Duration.ofSeconds(1))
//    .release().build().perform();
    
    	Point point = source.getLocation();
    	int xcord = point.getX();
    	int ycord = point.getY();
    	
    	//System.out.println(xcord);
    	//System.out.println(ycord);
    	
    	Point point1 = target.getLocation();
    	int xcordtarget = point1.getX();
    	int ycordtarget = point1.getY();
    	//System.out.println(xcordtarget);
    	//System.out.println(ycordtarget);
    
    
//    act.moveToElement(source);
//    act.clickAndHold();
//    act.moveToElement(target, -100,200);
//	act.release();
//	act.perform();
    	
    	//act.clickAndHold(source).moveToElement(target).release(target).perform();
    	
//    	Actions builder = new Actions(driver);
//        builder.keyDown(Keys.CONTROL)
//            .click(source)
//            .dragAndDrop(source, target)
//            .keyUp(Keys.CONTROL);
//            Action selected = builder.build();
//            selected.perform();
    	
    	// Configure the action
    	Actions builder = new Actions(driver);
    	builder.keyDown(Keys.CONTROL)
    	   .click(source)
    	   .click(target)
    	   .keyUp(Keys.CONTROL);

    	// Then get the action:
    	Action selectMultiple = builder.build();

    	// And execute it:
    	selectMultiple.perform(); 
    	
    	
//    	act.moveToElement(source)
//         .pause(Duration.ofSeconds(1))
//         .clickAndHold(source)
//         .pause(Duration.ofSeconds(1))
//         .moveByOffset(50, 0)
//         .moveToElement(target)
//         .moveByOffset(50, 0)
//         .pause(Duration.ofSeconds(1))
//         .release().perform();
    	
    	
    }
    //driver.findElement(By.cssSelector(".wj-state-selected > .wj-node-text")).click();
  }
}
