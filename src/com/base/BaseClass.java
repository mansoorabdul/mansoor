package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	//1.Browser Launch
	public static WebDriver browserlaunch(String browsername) {
		if(browsername.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browsername.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		return driver;
		
	}
	
	//2.Get URL
	public static WebDriver launchUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	//3.Terminate Browser
	public static void quit() {
		driver.quit();
	}
	
	//4.Close Current Tab
	public static void close() {
		driver.close();
	}
	
	//5.SendKeys
	public static void passinput(WebElement element,String input) {
		try {
			element.sendKeys(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//6.click
	public static void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//7.Navigate to
	public static void navigateto(String url) {
		driver.navigate().to(url);
	}
	
	//8.Navigate back
	public static void navigateback(String url) {
		driver.navigate().back();
	}
	
	//9.Navigate forward
	public static void navigateforward(String url) {
		driver.navigate().forward();
	}
	
	//10.Refresh
	public static void refresh() {
		driver.navigate().refresh();
	}
	
	//11.PageSource
	public static void pagesource() {
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}
	
	//12.Get Current Url
	public static void getcurrenturl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("currentUrl---"+currentUrl);
	}
	
	//13.Get Title
	public static void gettitle() {
		String title = driver.getTitle();
		System.out.println("title-----"+title);
	}
	
	//14.Get Text
	public static void gettext(WebElement element) {
		try {
			System.out.println(element.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//15.isDisplayed
	public static void isdisplayed(WebElement element) {
		try {
			boolean displayed = element.isDisplayed();
			System.out.println(displayed);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//16.isSelected
	public static void isselected(WebElement element) {
		try {
			boolean selected = element.isSelected();
			System.out.println(selected);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//17.isEnabled
	public static void isenabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			System.out.println(enabled);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//18.Screenshot
	public static void screenshot(String location) {
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File des=new File(location);
			FileUtils.copyFile(src, des);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//19.Java Script Executor
	public static JavascriptExecutor javascriptobject() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return js;
	}
	
	//20.Scroll Home Page up and down
	public static void scrollby(int x,int y) {
		try {
			javascriptobject().executeScript("window.scroll("+x+","+y+")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//21.Scroll into View
	public static void scrollintoview(WebElement element) {
		try {
			javascriptobject().executeScript("arguments[0].scrollIntoView();",element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//22.Java Script click
	public static void javascriptclick(WebElement element) {
		try {
			javascriptobject().executeScript("arguments[0].click();",element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//23.Java Script send value
	public static void javascriptsendvalue(WebElement element,String value) {
		try {
			javascriptobject().executeScript("arguments[0].value='"+value+"';",element);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//24.Implicit Wait
	public static void implicitwait(int num,TimeUnit TimeUnit) {
		try {
			driver.manage().timeouts().implicitlyWait(num, TimeUnit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//25.Explicit Wait
	public static void explicitwait(int num,By element) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, num);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//26.Select class object
	public static Select selectclassobject(WebElement element) {
		Select s=new Select(element);
		return s;
	}
	
	//27.Select by index
	public static void selectbyindex(WebElement element,int index) {
		try {
			selectclassobject(element).selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//28.Select by visible text
	public static void selectbyvisibletext(WebElement element,String text) {
		try {
			selectclassobject(element).selectByVisibleText(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//29.Select by value
	public static void selectbyvalue(WebElement element,String value) {
		try {
			selectclassobject(element).selectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//30.Deselected by index
	public static void deselectedbyindex(WebElement element,int index) {
		try {
			selectclassobject(element).deselectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//31.Deselected by value
	public static void deselectedbyvalue(WebElement element,String value) {
		try {
			selectclassobject(element).deselectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//32.Deselected by visible Text
	public static void deselectedbyvisibletext(WebElement element,String text) {
		try {
			selectclassobject(element).deselectByVisibleText(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//33.Is Multiple
	public static void ismultiple(WebElement element) {
		try {
			boolean multiple = selectclassobject(element).isMultiple();
			System.out.println(multiple);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//34.Deselect all
	public static void deselectall(WebElement element) {
		try {
			selectclassobject(element).deselectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//35.Get First Selected Option
	public static void getfirstselectedoption(WebElement element) {
		try {
			System.out.println("1st SELECTED VALUE---"+selectclassobject(element).getFirstSelectedOption().getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//36.Get all Selected Options
	public static void getallselectedoptions(WebElement element) {
		try {
			List<WebElement> allSelectedOptions = selectclassobject(element).getAllSelectedOptions();
			for(WebElement webElement:allSelectedOptions) {
				System.out.println("SELECTED VALUES---"+webElement.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//37.Get Options
	public static void getoptions(WebElement element) {
		try {
			List<WebElement> options = selectclassobject(element).getOptions();
			for(WebElement webElement:options) {
				System.out.println("OPTIONS---"+webElement.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//38.Get Text Alert
	public static void alertgettext() {
		try {
			System.out.println(driver.switchTo().alert().getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//39.Alert Accept
	public static void alertaccept() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//40.Alert Dismiss
	public static void alertdismiss() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//41.Alert Send keys
	public static void alertsendkeys(String value) {
		try {
			driver.switchTo().alert().sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//42.Frame By id
	public static void framebyid(String value) {
		try {
			driver.switchTo().frame(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//43.Frame By Web Element
	public static void framebywebelement(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//44.Frame By Index
	public static void framebyindex(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//45.Parent Frame
	public static void parentframe() {
		try {
			driver.switchTo().parentFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//46.Default Content Frame
	public static void defaultcontentframe() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//47.Action Class Object Creation
	public static Actions actionsobject() {
		Actions s=new Actions(driver);
		return s;
	}
	
	//48.Action Click
	public static void actionclick(WebElement element) {
		try {
			actionsobject().click(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//49.Action Double Click
	public static void actiondoubleclick(WebElement element) {
		try {
			actionsobject().doubleClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//50.Action Drag and Drop
	public static void actiondraganddrop(WebElement src,WebElement des) {
		try {
			actionsobject().dragAndDrop(src, des).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//51.Action Move to Element
	public static void actionmovetoelement(WebElement element) {
		try {
			actionsobject().moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//52.Action Context Click
	public static void actioncontextclick(WebElement element) {
		try {
			actionsobject().contextClick(element).build().perform();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//53.Robot Class Object
	public static Robot robotclassobject() throws AWTException {
		Robot r=new Robot();
		return r;
		
	}
	
	//54.Robot Class Key Press Release
	public static void robotkeypress(int value) {
		try {
			robotclassobject().keyPress(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//55.Window Handles
	public static void windowhandles(int index) {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String>in=new ArrayList<>(windowHandles);
			driver.switchTo().window(in.get(index));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
