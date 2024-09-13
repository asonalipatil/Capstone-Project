package CapstoneProject.CapstoneProject;

import org.testng.annotations.BeforeSuite;

public class TestSetup {

	public static String baseUrl;
	
	@BeforeSuite
	public void initialize() {
		baseUrl = "https://www.saucedemo.com/";
	}

}
