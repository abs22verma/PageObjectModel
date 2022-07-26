package com.demoqa.TestSteps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.demoqa.common.BasePage;
import com.demoqa.utility.Driver;

public class FormDetailsPage {

	public static void enterValueByID(String id,String value) {
		BasePage.clear(BasePage.findElementById(id));
		BasePage.enterValue(BasePage.findElementById(id),value);
	}
	
	public static void enterValueByWebelement(WebElement element,String value) {
		BasePage.clear(element);
		BasePage.enterValue(element,value);
	}
	
	
	
	public static void enterValueByXpath(String id,String value) {
		BasePage.clear(BasePage.findElementByXpath(id));
		BasePage.enterValue(BasePage.findElementByXpath(id),value);
	}
	
	public static void clickOnSubmit(String id) {
		BasePage.keyPress("Submit");
		//BasePage.click(BasePage.findElementById(id));
	}
	
	public static void selectGender(String gender) {
		switch(gender) {
		case "Male":
			BasePage.click(BasePage.findElementByXpath("value",gender));
			break;
		case "Female":
			BasePage.click(BasePage.findElementByXpath("value",gender));
			break;
		case "Other":
			BasePage.click(BasePage.findElementByXpath("value",gender));
			break;
		default:
			System.out.println("Not a valid value : "+gender);
		}
	}

	public static void selectDate(String date) {
		
		String selectedDate = BasePage.selectDateFromDatePicker(date.replace("-", " "));
		System.out.println(selectedDate);
	}

	public static void selectSubject(String string){
		BasePage.click(BasePage.findElementById("subjectsContainer"));
		try {
		Thread.sleep(1000);
		BasePage.enterValue(BasePage.findElementById("subjectsInput"), string);
		BasePage.keyPress("Tab");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void selectHobbies(String text) {
		String hobbies[] = text.split(",");
		for(String str:hobbies)
		BasePage.click(BasePage.findElementByXpathText(str));
		
	}

	public static void selectDropdownValue(String field, String value) {
		BasePage.click(BasePage.findElementById(field));
		
		try {
			Thread.sleep(1000);
			//BasePage.actionClick(BasePage.findElementByXpathText(value));
			BasePage.keyPress("Tab");
			Thread.sleep(1000);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public static void verification(String values) {
		
		String value[] = values.split(",");
		for(int i=1,j=0;i<=4;i++,j++) {
			String text = Driver.getDriver().findElement(By.xpath("//table//tr["+i+"]//td[2]")).getText();
			Assert.assertEquals(text, value[j]);
			//Assert.assertTrue(BasePage.isElementPresent(""));
		}
		
	}
	
}
