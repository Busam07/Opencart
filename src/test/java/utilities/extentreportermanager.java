package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testcase.BaseClass;

public class extentreportermanager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repname;
	public void onStart(ITestContext testContext) {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		repname="Test-Report"+timeStamp+".html";
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repname);
		sparkReporter.config().setDocumentTitle("opencart automation report");
		sparkReporter.config().setReportName("opencart fun test");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "customer");
		extent.setSystemInfo("User name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		String os=testContext.getCurrentXmlTest().getParameter("os");
				extent.setSystemInfo("operating system", os);
		String browser=testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedgroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedgroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedgroups.toString());
		}
	}
	
	public void onTestSuccess(ITestResult results) {
		test=extent.createTest(results.getTestClass().getName());
		test.assignCategory(results.getMethod().getGroups());
		test.log(Status.PASS, results.getName()+"got successful");
		
		
	}
	public void onTestFailure(ITestResult results) {
		test=extent.createTest(results.getTestClass().getName());
		test.assignCategory(results.getMethod().getGroups());
		test.log(Status.FAIL,results.getName()+"got filed");
		test.log(Status.INFO, results.getThrowable().getMessage());
		try {
			String imgpath=new BaseClass().captureScreen(results.getName());
			test.addScreenCaptureFromPath(imgpath);
			
					}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
	}
	public void onFinish(ITestContext textContext) {
		extent.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\report"+repname;
		File extentReport = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
