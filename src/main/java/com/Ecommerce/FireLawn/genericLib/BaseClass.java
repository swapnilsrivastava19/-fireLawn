package com.Ecommerce.FireLawn.genericLib;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public  static Connection con;
	public FileUtilities fu=new FileUtilities();
	public WebDriver driver;
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports reports;
	public static ExtentTest test;
	public WebDriverUtilities webutilities=new WebDriverUtilities();
	
	
	@BeforeSuite
	public void configBS() throws SQLException {
		Reporter.log("Connect to database");
		con=fu.getDataDb();
		
		htmlreport=new ExtentHtmlReporter(AutoConstant.reportsPath);
		htmlreport.config().setDocumentTitle("FirelawnReport");
		htmlreport.config().setTheme(Theme.DARK);
		reports=new ExtentReports();
		reports.attachReporter(htmlreport);
	}
	@BeforeMethod
	public void openApp() throws IOException {
		WebDriverManager.chromedriver().setup();
		// In order to avoid sudden updates in browser we use the dependency 
		// called webdrivermanager.
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fu.getPropertydata("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApp(ITestResult res) throws IOException {
		int result=res.getStatus();
		if(result==ITestResult.FAILURE) {
			test.log(Status.FAIL, res.getName()+"Test Case is failed");
			test.log(Status.FAIL, res.getThrowable()+"Test Case is failed exception");
			}
		else if(result==ITestResult.SUCCESS) {
			test.log(Status.PASS, res.getName()+"Test Case is passed");
		}
		else if(result==ITestResult.SKIP){
			test.log(Status.SKIP, res.getName()+"Test Case is skipped");
		}
		// status==1 -> pass
		// status==2 -> fail
		// status==3 -> skip
		String name = res.getName();
		if(result==2) {
			ScreenShot s=new ScreenShot();
			s.getPhoto(driver, name);
		}
		driver.quit();
	}
	
	@AfterSuite
	public void configAs() throws SQLException {
		reports.flush();
		fu.closedb();
		Reporter.log("Database is closed");
		
	}

}
