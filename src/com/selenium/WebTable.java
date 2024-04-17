package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println("---All Data---");
		List<WebElement> findElements = driver.findElements(By.xpath("(//table)[1]/tbody/tr/td"));
		for (WebElement AllData : findElements) {
			System.out.println(AllData.getText());
		}
		System.out.println("---RowData---");
		List<WebElement> elements = driver.findElements(By.xpath("(//table)[1]/tbody/tr[2]/td"));
		for (WebElement row : elements) {
			System.out.println(row.getText());
		}
		System.out.println("---ColumnData---");
		List<WebElement> findElements2 = driver.findElements(By.xpath("(//table)[1]/tbody/tr/td[3]"));
		for (WebElement column : findElements2) {
			System.out.println(column.getText());
			
		}
		System.out.println("---ParticularData---");
		WebElement particular = driver.findElement(By.xpath("(//table)[1]/tbody/tr[5]/td[4]"));
		System.out.println(particular.getText());
		System.out.println("---Header---");
		WebElement header = driver.findElement(By.xpath("(//thead)"));
		System.out.println(header.getText());

	}

}
