package com.demoqa.common;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.demoqa.utility.Driver;
import com.demoqa.utility.Utilities;

public class BasePage {
	
	static WebDriver driver = Driver.getDriver();

	public static WebElement findElementById(String id) {
		return Driver.getDriver().findElement(By.id(id));
	}
	
	public static void enterValue(WebElement element, String value) {
		scrollToElement(element);
		element.sendKeys(value);
	}
	
	public static void clear(WebElement element) {
		if(isElementPresent(element)) {
		scrollToElement(element);
		element.clear();
		}
	}
	
	public static void click(WebElement element) {
		if(isElementPresent(element)) {
			scrollToElement(element);
			element.click();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isElementPresent(WebElement element) {
		return element.isDisplayed();
	}
	
	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static WebElement findElementByXpath(String field) {
		return Driver.getDriver().findElement(By.xpath("//*[@id='"+field+"']"));
	}
	
	public static WebElement findElementByXpathClassName(String field) {
		return Driver.getDriver().findElement(By.xpath("//*[@class='"+field+"']"));
	}
	
	public static WebElement findElementByXpathText(String field) {
		return Driver.getDriver().findElement(By.xpath("//*[text()='"+field+"']"));
	}

	public static WebElement findElementByXpath(String xpath, String gender) {
		return Driver.getDriver().findElement(By.xpath("//*[@"+xpath+"='"+gender+"']//parent::div")); //*[@value='Male']
		
	}
	
	public static String selectDateFromDatePicker(String date) {
		String Date[] = date.split(" ");
		String newDate = Date[0];
		String month = Date[1];
		String year = Date[2];
		findElementById("dateOfBirthInput").click();
		if(findElementByXpathClassName("react-datepicker").isDisplayed()) {
			
			Select selectMon = new Select(findElementByXpathClassName("react-datepicker__month-select"));
			
			selectMon.selectByVisibleText(Utilities.getMonth(month));
			
			Select selectYear = new Select(findElementByXpathClassName("react-datepicker__year-select"));
			
			selectYear.selectByValue(year);
			
			List<WebElement> weeks = new ArrayList<>();
			
			weeks = Driver.getDriver().findElements(By.xpath("//div[@class='react-datepicker__week']"));
			
			for(WebElement week:weeks) {
				try {
				List<WebElement> days = week.findElements(By.tagName("div"));
				for(WebElement day:days) {
					if(day.getText().equalsIgnoreCase(newDate)) {
						day.click();
						break;
					}
				}
				}catch(StaleElementReferenceException e) {
					System.out.println("Inside Catch");
					break;
				}
				
			}
			//System.out.println(findElementById("dateOfBirthInput").getAttribute("value"));
			
		}
		return findElementById("dateOfBirthInput").getAttribute("value");
	}
		
	public static void keyPress(String keyName) {
		Actions builder = new Actions(Driver.getDriver());
		switch(keyName) {
		case "Tab":	
		builder.sendKeys(Keys.TAB).build().perform();
		break;
		default:
			System.out.println("Invalid key");
		}
		
	}
	
	public static void actionClick(WebElement element) {
		Actions builder = new Actions(driver);
		builder.click(element).perform();
	}
}
