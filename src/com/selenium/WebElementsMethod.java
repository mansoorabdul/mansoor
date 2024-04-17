package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsMethod {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\Eclipse\\Selenium_Project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.get("https://www.flipkart.com/");
		 WebElement search = driver.findElement(By.xpath("//button[@class='_2iLD__']"));
		 search.sendKeys("iphones"); 
		 search.click();
    	boolean displayed = search.isDisplayed();
    	System.out.println(displayed);
    	boolean enabled = search.isEnabled();
    	System.out.println(enabled);
    	boolean selected = search.isSelected();
    	System.out.println(selected);
    	WebElement text = driver.findElement(By.linkText("Travel"));
    	System.out.println(text.getText());

	}

}
