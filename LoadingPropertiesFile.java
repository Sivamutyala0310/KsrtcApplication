package com.automation.testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class LoadingPropertiesFile extends LoginDriver {
	@Test
	public static void loadingPropertiesFile() throws Exception {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\siva.mutyala\\eclipse-workspace\\com.automation\\Resources\\Data\\ksrtc.properties");
		Properties properties = new Properties();
		properties.load(fis);
	
	}
}
