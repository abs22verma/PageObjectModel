package com.demoqa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoqa.ObjRepo.FormPage;
import com.demoqa.TestSteps.FormDetailsPage;
import com.demoqa.TestSteps.RetryAnalyzer;
import com.demoqa.TestSteps.TestListener;
import com.demoqa.common.BasePage;
import com.demoqa.utility.Driver;
import com.demoqa.utility.ExcelUtility;


@Listeners(TestListener.class)
//@Listeners(TestAnalyzer.class)
public class Testing {

	private WebDriver driver = null;
	//@BeforeTest
	public void setupDriver() {
		System.out.println("Test");
		driver = Driver.getDriver();
	}
	
	//@Test
	public void TC01() {
		try {
		if(BasePage.findElementById("closeLargeModal").isDisplayed()) {
			BasePage.findElementById("closeLargeModal").click();
		}
		}catch(NoSuchElementException e) {
			System.out.println("inside catch");
		}
		FormDetailsPage.enterValueByID("firstName","Abhi");
		FormDetailsPage.enterValueByID("lastName","Verma");
		FormDetailsPage.enterValueByXpath("userEmail", "abhi.verma@gmail.com");
		FormDetailsPage.enterValueByID("userNumber","1472583690");
		FormDetailsPage.selectGender("Male");
		FormDetailsPage.selectDate("27 Jun 1995");
		FormDetailsPage.selectSubject("Math");
		FormDetailsPage.selectHobbies("Reading,Sports");
		FormDetailsPage.enterValueByID("uploadPicture", "F:\\SSI\\Test.jpg");
		FormDetailsPage.enterValueByID("currentAddress", "H.No 123, 2nd cross, 3rd Street, MP");
		FormDetailsPage.selectDropdownValue("state","Haryana");
		FormDetailsPage.selectDropdownValue("city","Panipat");
		FormDetailsPage.clickOnSubmit("Submit");
		FormDetailsPage.verification("Abhi verma,abhi.verma@gmail.com,Male,1472583690");
		
	}
	
	//@Test(dataProvider = "getDataFromExcel")
	public void TC02(String firstName,
			String lastName,
			String email, 
			String gender, 
			String mobile, 
			String dob, 
			String subject, 
			String hobbies, 
			String picture,
			String address, 
			String state, 
			String city) {
		try {
		if(BasePage.findElementById("closeLargeModal").isDisplayed()) {
			BasePage.findElementById("closeLargeModal").click();
		}
		}catch(NoSuchElementException e) {
			System.out.println("inside catch");
		}
		FormDetailsPage.enterValueByID("firstName",firstName);
		FormDetailsPage.enterValueByID("lastName",lastName);
		FormDetailsPage.enterValueByXpath("userEmail", email);
		FormDetailsPage.enterValueByID("userNumber",mobile);
		FormDetailsPage.selectGender(gender);
		FormDetailsPage.selectDate(dob);
		FormDetailsPage.selectSubject(subject);
		FormDetailsPage.selectHobbies(hobbies);
		FormDetailsPage.enterValueByID("uploadPicture", picture);
		FormDetailsPage.enterValueByID("currentAddress", address);
		FormDetailsPage.selectDropdownValue("state",state);
		FormDetailsPage.selectDropdownValue("city",city);
	
		//From
		FormDetailsPage.clickOnSubmit("submit");
		//FormDetailsPage.verification("Abhi verma,abhi.verma@gmail.com,Male,1472583690");
		
	}
	
	@DataProvider
	public Object[][] getDataFromExcel(){
		Object[][] data = ExcelUtility.getExcelData("F:\\SSI\\PracticeForm\\src\\test\\resources\\FormDetails.xlsx","FormDetails");
		return data;
	}
	
	@Test
	public void TC03() {
		FormPage fp = new FormPage(Driver.getDriver());
		try {
		if(BasePage.findElementById("closeLargeModal").isDisplayed()) {
			BasePage.findElementById("closeLargeModal").click();
		}
		}catch(NoSuchElementException e) {
			System.out.println("inside catch");
		}
		FormDetailsPage.enterValueByWebelement(fp.firstName, "test");
		FormDetailsPage.enterValueByWebelement(fp.lastName, "test");
		FormDetailsPage.enterValueByWebelement(fp.email, "test.123@gmail.com");
		FormDetailsPage.enterValueByWebelement(fp.mobile, "1234567890");
		FormDetailsPage.selectGender("Male");
		FormDetailsPage.selectDate("27 Jun 1995");
		FormDetailsPage.selectSubject("Math");
		FormDetailsPage.selectHobbies("Reading,Sports");
		FormDetailsPage.enterValueByID("uploadPicture", "F:\\SSI\\Test.jpg");
		FormDetailsPage.enterValueByID("currentAddress", "H.No 123, 2nd cross, 3rd Street, MP");
		FormDetailsPage.selectDropdownValue("state","Haryana");
		FormDetailsPage.selectDropdownValue("city","Panipat");
		FormDetailsPage.clickOnSubmit("submit");
		FormDetailsPage.verification("Abhi verma,abhi.verma@gmail.com,Male,1472583690");
		
	}
	
}
