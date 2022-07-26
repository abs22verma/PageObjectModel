package com.demoqa.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//PageFactory

public class FormPage {
WebDriver driver = null;
	public FormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using="firstName")
	public WebElement firstName;
	
	// public WebElement firstName = driver.findElement(By.id("test"));
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(xpath = "//input[@id='userEmail']")
	public WebElement email;
	
	@FindBys({
		@FindBy(id="gender1"),
		@FindBy(className ="Male")
	})
	//<input id="gender1" class="Male"/>
	public WebElement gender;
	
	
	
	@FindBy(id="userNumber")
	public WebElement mobile;
	
	
	@FindAll({
		@FindBy(id="gender1"),
		@FindBy(className ="Male")
	})//driver.findElements
	public WebElement dob;
	
	public WebElement subject;
	
	public WebElement hobbies;
	
	
	public WebElement picture;
	
	
	public WebElement address;
	
	public WebElement state;
	
	public WebElement submitButton;
}
