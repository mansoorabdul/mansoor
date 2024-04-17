package com.selenium;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Eclipse\\Selenium_Project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.get("https://in.bookmyshow.com/explore/home/chennai");
		WebElement view = driver.findElement(By.linkText("Superstar"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",view);//to view specific element
		Thread.sleep(3000);
		js.executeScript("window.scroll(0,0)");// scroll home page
		Thread.sleep(3000);
		js.executeScript("window.scroll(0,1000)");//scroll Down 
		Thread.sleep(3000);
		js.executeScript("window.scroll(0,-500)");//scroll up
		driver.get("https://www.google.co.in/");
		WebElement value = driver.findElement(By.name("q"));
		js.executeScript("arguments[0].value='Superstar Rajini';",value);//SendKeys
		WebElement Search = driver.findElement(By.name("btnK"));
		js.executeScript("arguments[0].click()",Search);//Click
	}
}
