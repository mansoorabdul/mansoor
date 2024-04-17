package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Specificvalue {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/s?k=iphone+15+pro+max&crid=2OWT26OCGZRYA&sprefix=ip%2Caps%2C205&ref=nb_sb_ss_ts-doa-p_1_2");
	WebElement findElement = driver.findElement(By.xpath("//div[@data-asin='B0CHWWVSLF']//span[@class='a-price-whole']"));
	System.out.println(findElement.getText());
	
}

	
		

	}
