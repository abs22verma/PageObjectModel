package com.demoqa.TestSteps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.demoqa.utility.Driver;

public class TestListener implements ITestListener {

	public void onTestSuccess(ITestResult result) {
	    System.out.println("Completed");
	  }
	
	public void onTestFailure(ITestResult result) {
	    TakesScreenshot screen = (TakesScreenshot) Driver.getDriver();
	    File file =  screen.getScreenshotAs(OutputType.FILE);
	    
	    String path = System.getProperty("user.dir")+"//target//Screenshot//"+result.getName()+".jpg";
	    try {
			FileUtils.copyFile(file, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	  }
}

