package com.test123;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportCls {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentSparkReporter spark;
	public static WebDriver driver;
	
	public static void main(String args[]) throws InterruptedException {
		
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("./Reports/report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Suneratech Summary Report");
		extent.attachReporter(spark);
		
		test = extent.createTest("Login test").assignAuthor("Sateesh Janapana").assignCategory("Web Testing");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		test.info("URL Launched");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		test.info("Entered the credentials");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		extent.flush();
	}
	
}
