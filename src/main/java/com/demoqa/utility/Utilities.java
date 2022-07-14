package com.demoqa.utility;

public class Utilities {

	public static String getMonth(String mon) {
	String month="";
	switch(mon) {
	case "Jan":
		month = "January";
		break;
	case "Feb":
		month = "February";
		break;
	case "Mar":
		month = "March";
		break;
	case "Apr":
		month = "April";
		break;
	case "May":
		month = "May";
		break;
	case "Jun":
		month = "June";
		break;
	case "Jul":
		month = "July";
		break;
	case "August":
		month = "August";
		break;
	case "Sep":
		month = "September";
		break;
	case "Oct":
		month = "October";
		break;
	case "Nov":
		month = "November";
		break;
	case "Dec":
		month = "December";
		break;
	default:
		System.out.println("Not a valid month : "+mon);
	}
	return month;
		
	}
}
