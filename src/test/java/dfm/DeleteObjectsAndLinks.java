
package dfm;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DeleteObjectsAndLinks {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
//		System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
//		driver=new EdgeDriver();
		driver.get("https://qa.modeler2.decisionsfirst.com/login");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("nitesh@rxw.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
		driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		 Thread.sleep(18000);

		driver.findElement(By.xpath(
				"//nb-list-item[2]//dfm-preview-container[1]//div[1]//dfm-search-list-item[1]//div[1]//div[1]//span[1]//span[1]"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//i[@class='eva eva-settings-2-outline']")).click();
		Thread.sleep(4000);

		Actions act = new Actions(driver);

		WebElement src = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[2]/dfm-go-js-add-object-palette/div/div/canvas"));

		WebElement LINKS = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[1]"));

		WebElement target = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/div/dfm-go-js-display-diagram/div/div"));

		WebElement reuse_objects = driver.findElement(By.xpath(
				"/html/body/dfm-root/dfm-main-container/nb-layout/div/div/div/div/div/nb-layout-column/dfm-tabs-container/div/div/div[2]/dfm-view-diagram-container/div/dfm-diagram-sidebar/div/div[1]/dfm-diagram-tabs-container/div/div[2]/dfm-palettes-diagram-container/div/div[3]/dfm-go-js-existing-objects-palette/div/div/canvas"));

		// Input Source data 1
		act.moveToElement(src, -30, 5);
		act.clickAndHold().moveByOffset(-30, 5);
		act.moveToElement(src, 1, 1);
		act.moveToElement(target, 1, 1);
		act.release();
		act.perform();
		Thread.sleep(3000);

		// Input Source data 2
		act.moveToElement(src, -30, 5);
		act.clickAndHold().moveByOffset(-30, 5);
		act.moveToElement(src, -100, 1);
		act.moveToElement(target, -100, 1);
		act.release();
		act.perform();
		Thread.sleep(3000);

		// Decision Source data 1
		act.moveToElement(src, -56, 5);
		act.clickAndHold().moveByOffset(-56, 5);
		act.moveToElement(src, 250, -150);
		act.moveToElement(target, 250, -150);
		act.release();
		act.perform();
		Thread.sleep(3000);

		// Decision Source data 2
		act.moveToElement(src, -56, 5);
		act.clickAndHold().moveByOffset(-56, 5);
		act.moveToElement(src, 50, -150);
		act.moveToElement(target, 50, -150);
		act.release();
		act.perform();
		Thread.sleep(3000);

		// Decision Source data 3
		act.moveToElement(src, -56, 5);
		act.clickAndHold().moveByOffset(-56, 5);
		act.moveToElement(src, -130, -150);
		act.moveToElement(target, -130, -150);
		act.release();
		act.perform();
		Thread.sleep(3000);

		// click Information Links
		act.moveToElement(LINKS, -43, 20);
		act.click().build().perform();
		Thread.sleep(2000);

		// Link with the Objects
		// creating the connection with links between Input Source 1 & Decision Source 2
		act.moveToElement(target, 15, 5);
		act.clickAndHold().moveByOffset(15, 5);
		act.moveByOffset(50, -150);
		act.release();
		act.perform();
		Thread.sleep(2000);

		// creating the connection with links between Input Source 2 & Decision Source 3
		act.moveToElement(target, 10, 5);
		act.clickAndHold().moveByOffset(10, 5);
		act.moveByOffset(250, -150);
		act.release();
		act.perform();
		Thread.sleep(2000);

		// creating the connection with links between Input Source 2 & Decision Source 1
		// ok
		act.moveToElement(target, 10, 5);
		act.clickAndHold().moveByOffset(10, 5);
		act.moveByOffset(-200, -150);
		act.release();
		act.perform();
		Thread.sleep(2000);

		// Delete Particular Objects
		/*
		 * act.moveToElement(target, 253, -150); act.click(); act.keyDown(Keys.DELETE);
		 * act.keyUp(Keys.DELETE).build().perform(); Thread.sleep(3000);
		 * 
		 * act.moveToElement(target, 10, 5); act.click(); act.keyDown(Keys.DELETE);
		 * act.keyUp(Keys.DELETE).build().perform(); Thread.sleep(3000);
		 * 
		 * act.moveToElement(target, -200, -150); act.click(); act.keyDown(Keys.DELETE);
		 * act.keyUp(Keys.DELETE).build().perform(); Thread.sleep(3000);
		 */

		// find the SoftwareTestingMaterial logo using linkText Locator
//		WebElement element = driver.findElement(By.xpath("//div[@class='links-palette']"));
//		//Used points class to get x and y coordinates of element.
//		Point point = element.getLocation();
//		int xcord = point.getX();
//		System.out.println("Position of the webelement from left side is "+xcord +" pixels");
//		int ycord = point.getY();
//		System.out.println("Position of the webelement from top side is "+ycord +" pixels");
//		
//		act.moveToElement(element, xcord, ycord).click().build().perform();

//		act.moveToElement(target, 100, -100);
//		act.contextClick().build().perform();
//		Thread.sleep(4000);
//		
//		act.moveToElement(target, 250, -150);
//		act.contextClick().build().perform();

		// Remove the diagram permanently
		act.moveToElement(target);
		act.click().build().perform();
		act.keyDown(Keys.CONTROL).sendKeys("a");
		act.keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(3000);

		act.moveToElement(target, 100, -100);
		act.contextClick().build().perform();
		Thread.sleep(8000);

		driver.findElement(By.xpath("//span[contains(text(),'Remove Permanently')]")).click();

		System.out.println("<<<Diagram removed permanently>>>");

	}

}
