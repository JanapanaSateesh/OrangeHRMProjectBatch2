package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LoginTestValidData {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentSparkReporter spark;
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		extent=new ExtentReports();
		
		spark= new ExtentSparkReporter("./Reports/testcasessummaryreport.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Summary Report");	
		extent.attachReporter(spark);
		test=extent.createTest("Login with valid credentials");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		test.info("URL is launched");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		test.info("Username Admin is entered");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		test.info("password ******* is entered");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		test.info("clicked on submit button");
		
		extent.flush();
	}

}
