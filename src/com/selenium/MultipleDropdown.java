package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Selenium_Project\\Driver\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in/");
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement multi = driver.findElement(By.id("colors"));
        Select s=new Select(multi);
        boolean multiple = s.isMultiple();
        System.out.println(multiple);
        s.selectByIndex(0);
        Thread.sleep(2000);
        s.selectByValue("blue");
        Thread.sleep(2000);
        s.selectByVisibleText("Green");
        Thread.sleep(2000);
//        s.deselectByVisibleText("Green");
//        Thread.sleep(2000);
//        s.deselectByValue("blue");
//        Thread.sleep(2000);
//        s.deselectByIndex(0);
        List<WebElement> options = s.getOptions();
        for (WebElement all : options) {
        	System.out.println(all.getText());
		}
        List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
        for (WebElement select : allSelectedOptions) {
        	System.out.println("Selected Options: "+ select.getText());
		}
         WebElement firstSelectedOption = s.getFirstSelectedOption();
         System.out.println(firstSelectedOption.getText());
         s.deselectAll();
   
	}

}
