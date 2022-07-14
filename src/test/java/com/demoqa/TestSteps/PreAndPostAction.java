package com.demoqa.TestSteps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.demoqa.utility.Config;
import com.demoqa.utility.Driver;

public class PreAndPostAction {

	@BeforeTest
	public void openBrowser() {
		Driver.initiateBrowser(Config.getConfig().getString("browser"));
		Driver.getDriver().get(Config.getConfig().getString("baseURL"));
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().findElement(By.id("close-fixedban")).click();
	}
	
	@AfterTest
	public void tearDown() {
		Driver.getDriver().quit();
	}
	
	
}
