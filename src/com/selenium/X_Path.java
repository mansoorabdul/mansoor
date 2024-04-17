package com.selenium;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class X_Path {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\Eclipse\\Selenium_Project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("ipads");
		driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
		WebElement text = driver.findElement(By.xpath("//div[@class='_4rR01T']"));
		System.out.println("ipads Name"+text.getText());
		List<WebElement> AllText= driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		for (WebElement webElement : AllText) {
			System.out.println(webElement.getText());
		}
		}
}
