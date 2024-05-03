package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTestTestNgjCls extends BaseCls{
	

	

	@Test(dataProvider = "testData")
	public void LoginWithValidCredentials(String username, String pwd) throws InterruptedException {
			
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit123']")).click();		
	}
	

	public void LoginwithInvalidUsername() throws InterruptedException {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Sateesh");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit123']")).click();	
	}
	

	public void LoginwithInvalidPassword() throws InterruptedException {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc@123");
		driver.findElement(By.xpath("//button[@type='submit123']")).click();	
	}
	
  
	public void loginpageObjecttest() {
		LoginPage lp = new LoginPage(driver);
		lp.loginwithValiddata();
	}
	
	@DataProvider
	public String[][] testData() {
		String[][] data=new String[1][1];
		data[0][0]="Admin";
		data[0][1]="admin123";
		return data;
	}
	
}
