package com.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("Realme 12",Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='realme 12 Pro 5G (Navigator Beige, 256 GB)']")).click();
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> in=new ArrayList<>(windowHandles);
		driver.switchTo().window(in.get(1));
		org.openqa.selenium.interactions.Actions s= new org.openqa.selenium.interactions.Actions(driver);
		WebElement b = driver.findElement(By.xpath("//div[@class='_2usHgU']"));
		s.moveToElement(b).perform();
		WebElement findElement = driver.findElement(By.xpath("//iframe[@class='_1JqCrR']"));
		driver.switchTo().frame(findElement);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
		driver.switchTo().defaultContent();
		
		
		
		
		
		
		
		
		

	}

}
