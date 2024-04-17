package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MiniProject {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//login
		String user = driver.findElement(By.xpath("(//p[@class='oxd-text oxd-text--p'])[1]")).getText();
		driver.findElement(By.name("username")).sendKeys(user.substring(11));
		//pass
		String pass = driver.findElement(By.xpath("(//p[@class='oxd-text oxd-text--p'])[2]")).getText();
		driver.findElement(By.name("password")).sendKeys(pass.substring(11));
		//login submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//admin click
		driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")).click();
		Actions s= new Actions(driver);
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		//user role
		driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")).click();
		//create robot and enter user role
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		s.sendKeys(Keys.ENTER).perform();
		//username
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("Mansoor");
		//password
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Mansoor@123");
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Mansoor@123");
		//user status
		driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")).click();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		s.sendKeys(Keys.ENTER).perform();
		//Employee name
		String name = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).getText();
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys(name);
//		r.keyPress(KeyEvent.VK_SPACE);
//		r.keyRelease(KeyEvent.VK_SPACE);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		s.sendKeys(Keys.ENTER).perform();
		//save
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
		//xpath for search
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		//xpath for username
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("Mansoor");
		//xpath for search
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		//xpath for delete
		driver.findElement(By.xpath("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[1]")).click();
		Thread.sleep(2000);
		//xpath for conform delete
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
		Thread.sleep(2000);
		//xpath for logout 
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		driver.findElement(By.xpath("//a[@class='oxd-userdropdown-link']")).click();
		driver.close();
	}
}
