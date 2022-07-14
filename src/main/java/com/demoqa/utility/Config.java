package com.demoqa.utility;

import java.util.ResourceBundle;

public class Config {

	private static ResourceBundle resource = ResourceBundle.getBundle("Config");
	
	public static ResourceBundle getConfig() {
		return resource;
	}

}
