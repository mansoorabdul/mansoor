package com.selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngAnnotations {
@BeforeSuite	
	private void propertySetting() {
		System.out.println("propertysetting");
	}
	@BeforeTest
	private void BrowserLaunch() {
		System.out.println("BrowserLaunch");
	}
	@BeforeClass
	private void LaunchUrl() {
		System.out.println("LaunchUrl");
	}
	@BeforeMethod
	private void Login() {
		System.out.println("LaunchUrl");
	}
	@Test
	private void men() {
		System.out.println("men");
		
	}
	@Test
	private void women() {
		System.out.println("women");
		
	}
	@Test
	private void kids() {
		System.out.println("kids");
		
	}
	@AfterMethod
	private void Logout() {
		System.out.println("Logout");
		
	}
	@AfterClass
	private void Screenshot() {
		System.out.println("Screenshot");
		
	}
	@AfterTest
	private void CloseTab() {
		System.out.println("CloseTab");
		
	}
	@AfterSuite
	private void TerminateBrowser() {
		System.out.println("Quit");
		
	}
	
}