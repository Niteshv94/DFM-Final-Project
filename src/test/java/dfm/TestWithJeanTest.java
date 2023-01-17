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
public class TestWithJeanTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testWithJean() {
    driver.get("https://qa.modeler2.decisionsfirst.com/login");
    driver.manage().window().setSize(new Dimension(1144, 602));
    driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
    driver.findElement(By.cssSelector(".ng-valid")).sendKeys("nitesh@rxw.com");
    driver.findElement(By.cssSelector(".ng-untouched")).click();
    driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("defaultUserPass@123");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector(".sidebar-control-button")).click();
    driver.findElement(By.cssSelector(".logOut > .item-text")).click();
  }
}
