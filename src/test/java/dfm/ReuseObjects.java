package dfm;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ReuseObjects {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa.modeler2.decisionsfirst.com/login");
		// driver.get("https://dev.modeler2.decisionsfirst.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("nitesh@rxw.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("defaultUserPass@123");
		driver.findElement(By.xpath("//button[@class='btn form-control btn-info mr-2 login-btn']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		 //Thread.sleep(18000);

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
				"//div[@class='paletteDiv mb-2']//canvas"));


		// Input Source data 1
	/*	act.moveToElement(src, -30, 5);
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

		// Decision Source data 4
//		act.moveToElement(src, -56, 5);
//		act.clickAndHold().moveByOffset(-56, 5);
//		act.moveToElement(src, 50, -300);
//		act.moveToElement(target, 50, -300);
//		act.release();
//		act.perform();
//		Thread.sleep(3000);

		// Knowledge Source data 1
		act.moveToElement(src, 15, 5);
		act.clickAndHold().moveByOffset(15, 5);
		act.moveToElement(src, 300, -300);
		act.moveToElement(target, 300, -300);
		act.release();
		act.perform();
		Thread.sleep(4000); */

		// Group Item Source data 1
	    /*act.moveToElement(src, 50, 5);
		act.clickAndHold().moveByOffset(50, 5);
		act.moveToElement(src, 50, 100);
		act.moveToElement(target, 50, 100);
		act.release();
		act.perform();
		Thread.sleep(3000); 

		// Annotation Source data 1
		act.moveToElement(src, 58, 5);
		act.clickAndHold().moveByOffset(58, 5);
		act.moveToElement(src, 300, 150);
		act.moveToElement(target, 300, 150);
		act.release();
		act.perform();
		Thread.sleep(3000); */
		
		
		// click Information Links
		/*act.moveToElement(LINKS, -43, 20);
		act.click().build().perform();
		Thread.sleep(2000);*/
		

		//Link with the Objects
		// creating the connection with links between Input Source 1 & Decision Source 2
		/*act.moveToElement(target, 15, 5);
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

		// creating the connection with links between Input Source 2 & Decision Source 1 ok
		act.moveToElement(target, 10, 5);
		act.clickAndHold().moveByOffset(10, 5);
		act.moveByOffset(-200, -150);
		act.release();
		act.perform();
		Thread.sleep(2000); */
		
		// creating the connection with links between Decision Source 3 & Decision Source 4
		/*act.moveToElement(target, -100, -100);
		act.clickAndHold().moveByOffset(-100, -100);
		act.moveByOffset(50, -100);
		act.release();
		act.perform();
		Thread.sleep(2000);*/
		
		// creating the connection with links between Decision Source 2 & Decision Source 4
//		act.moveToElement(target, 105, -100);
//		act.clickAndHold().moveByOffset(105, -100);
//		act.moveByOffset(-300, -100);
//		act.release();
//		act.perform();
//		Thread.sleep(2000);

		// creating the connection with links between Decision Source 1 & Decision Source 4
		/*act.moveToElement(target, -200, -150);
		act.clickAndHold().moveByOffset(-200, -150);
		act.moveByOffset(300, -100);
		act.release();
		act.perform();
		Thread.sleep(2000); */
		
		// click Authority Links
		/*act.moveToElement(LINKS, 10, 20);
		act.click().build().perform();
		Thread.sleep(2000); 

		// creating the connection with links between knowledge source & Decision data 2 
		act.moveToElement(target, 20, -100);
		act.clickAndHold().moveByOffset(20, -100);
		act.moveByOffset(200, -150);
		act.release();
		act.perform();
		Thread.sleep(2000); 

		// click Annotation link
		act.moveToElement(LINKS, 43,20);
		act.click().build().perform();
		Thread.sleep(3000);*/
//		
		// creating the connection with links between annotation Source 1 & Decision Source 1
		  /*  act.moveToElement(target, 70,100);
			act.clickAndHold().moveByOffset(70,100);
			act.moveByOffset(250, -150);
			act.release();
			act.perform();
			Thread.sleep(2000); */
		
		
		// remove link between input and decision
		/*act.moveToElement(target, 100, -100);
		act.click().build().perform();
		Thread.sleep(3000); */
//		
//		act.moveToElement(target, 10, 5);
//		act.click().build().perform();
//		Thread.sleep(3000);
		
		
		
		
		
		// resue Source data 1
				/*act.moveToElement(reuse_objects, -30, 5);
				act.clickAndHold().moveByOffset(-30, 5);
				act.moveToElement(reuse_objects, 1, 1);
				act.moveToElement(target, 1, 1);
				act.release();
				act.perform();
				Thread.sleep(3000);
				
				// resue Source data 1
				act.moveToElement(reuse_objects, -10, 5);
				act.clickAndHold().moveByOffset(-10, 5);
				act.moveToElement(reuse_objects, 50, -100);
				act.moveToElement(target, 50, -100);
				act.release();
				act.perform();
				Thread.sleep(3000);*/
		

		// update Knowledge Source data 1
//		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]"))
//				.sendKeys("Knowledge name Updated");
//		Thread.sleep(2000);

		// click Input Source data 1
//		act.moveToElement(target, 305, -45);
//		act.click().build().perform();
//		Thread.sleep(3000);

		// update Input Source data 1
//		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]"))
//				.sendKeys("Input name Updated");
//		Thread.sleep(2000);

		// click Decision Source data 1
//		act.moveToElement(target, 155, 75);
//		act.click().build().perform();
//		Thread.sleep(3000);

		// update Decision Source data 1
//		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id='name']/quill-editor/div[2]/div[1]"))
//				.sendKeys("Decision name Updated");
//		Thread.sleep(2000);
		
//		act.moveToElement(LINKS, -14, 120);
//		act.contextClick().perform();
		
		//driver.findElement(By.xpath("//dfm-search-control[@ng-reflect-search-action='class UpdateSearchForDiagrammi']//input[@placeholder='Search']")).sendKeys("span");
		Thread.sleep(4000);
		
//		act.moveToElement(reuse_objects, 47, 50);
//		act.clickAndHold().moveByOffset(47, 50);
//		act.moveToElement(reuse_objects, 50, -100);
//		act.moveToElement(target, 50, -100);
//		act.release();
//		act.perform();
//		Thread.sleep(3000);
		
		act.moveToElement(reuse_objects, 61, 40);
		act.clickAndHold().moveByOffset(61, 40);
		act.moveToElement(reuse_objects, 50, -100);
		act.moveToElement(target, 50, -100);
		act.release();
		act.perform();
		Thread.sleep(3000);
		
		WebElement ele= driver.findElement(By.xpath("//div[@class='paletteDiv mb-2']//canvas"));
		Point point = ele.getLocation();
		int xcord = point.getX();
		int ycord = point.getY();
		System.out.println(xcord);
		System.out.println(ycord);
		

		
		//driver.findElement(By.xpath("//dfm-search-control[@ng-reflect-search-action='class UpdateSearchForDiagrammi']//input[@placeholder='Search']")).clear();
		//driver.findElement(By.xpath("//dfm-search-control[@ng-reflect-search-action='class UpdateSearchForDiagrammi']//input[@placeholder='Search']")).sendKeys("delete");
		Thread.sleep(4000);
		
		act.moveToElement(reuse_objects, -45, -2);
		act.clickAndHold().moveByOffset(-45, -2);
		act.moveToElement(reuse_objects, 50, -100);
		act.moveToElement(target, 50, -100);
		act.release();
		act.perform();
		Thread.sleep(3000);

		System.out.println("<<<Diagram created>>>");

	}

}
