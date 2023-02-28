/**
 * 
 */
package com.dfm.utility;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * @author Nitesh
 *
 */
public class ExtentReportsWithTestNG {
	static ExtentReports extent;
	
	public static ExtentReports extentReportGenertaor() {
		
	String path =	System.getProperty("user.dir")+"./Reports/Suite Report/Final_Report.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Creation of Customer till Diagram");
	reporter.config().setDocumentTitle("DFM Test Reports");
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester Name", "Nitesh Kumar");
	extent.flush();
	return extent;
	
		
	}
	

}
