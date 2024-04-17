package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions {

	public Actions(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/selectable");
		WebElement weekend = driver.findElement(By.id("clour"));
		org.openqa.selenium.interactions.Actions s=new org.openqa.selenium.interactions.Actions(driver);
		s.click(weekend).build().perform();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement doubleclick = driver.findElement(By.xpath("//button[@ondblclick='myFunction1()']"));
		s.doubleClick(doubleclick).build().perform();
		driver.get("https://letcode.in/dropable");
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement des = driver.findElement(By.id("droppable"));
		s.dragAndDrop(src, des).build().perform();
		driver.navigate().to("https://www.flipkart.com/");
		WebElement mouse = driver.findElement(By.linkText("Appliances"));
		s.moveToElement(mouse).perform();
		Thread.sleep(3000);
		s.contextClick(mouse).build().perform();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
