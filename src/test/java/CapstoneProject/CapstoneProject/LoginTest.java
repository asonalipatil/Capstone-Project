package CapstoneProject.CapstoneProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dipga\\Downloads\\chromedriver-win64\\chromedriver-win64");
		driver = new ChromeDriver();
		driver.get(TestSetup.baseUrl);
	}
	
	@Test
	@Parameters({"uername","password"})
	public void loginTest(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
	
		if(username.equals("standard_users") && password.equals("secret_sauce")) {
			Assert.assertTrue(driver.findElement(By.id("inventory_container")).isDisplayed());
		}
		else {
			Assert.assertTrue(driver.findElement(By.cssSelector(".error-message-container")).isDisplayed());
		}
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver !=null) {
			driver.quit();
		}
	}

}
