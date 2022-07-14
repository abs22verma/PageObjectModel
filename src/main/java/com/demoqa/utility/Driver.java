package com.demoqa.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	private static WebDriver driver=null;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void initiateBrowser(String browser) {
		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver= new FirefoxDriver();
			break;
		default:
			System.out.println(browser + " : not supported");
		}
		
	}
}
