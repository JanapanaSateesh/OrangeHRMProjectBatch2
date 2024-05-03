package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGCls {

	@BeforeMethod
	public void setUp() {
		System.out.println("URL Launched");
	}
	
	@Test
	public void testcase01() {
		System.out.println("testcase01 is passed");
	}
	
	@Test
	public void testcase02() {
		System.out.println("testcase02 is passed");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Browser is closed");
	}
}
