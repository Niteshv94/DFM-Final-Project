/**
 * 
 */
package com.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * @author Nitesh
 *
 */
public class BaseClass {
	
	public WebDriver driver;
	public ExtentReports extentReports;
	
	
	@BeforeSuite
	public void setUpSuite()
	{
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("");
	}

}
