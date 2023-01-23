package verificationUsingAseertions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginScript {
	/*@Test
	
	harda Assert
	public void loginAsAdmin() throws InterruptedException {
		String expectedLoginPageTitle="actiTIME - Login";
		String ExpectedHomePageTitle="";
		String usernamedata="admin";
		String passwordData="manager";
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.get("https://demo.actitime.com/login.do");
		String actualLoginPage = driver.getTitle();
		Assert.assertEquals(actualLoginPage, expectedLoginPageTitle,"Login page is not displayed");
		WebElement username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys(usernamedata);
		//Thread.sleep(2000);
		Assert.assertEquals(username.getAttribute("value"), usernamedata, "username is not displayed");
		
		WebElement password = driver.findElement(By.name("pwd"));
		password.clear();
		password.sendKeys(passwordData);
		Assert.assertEquals(password.getAttribute("value"),passwordData , "password is mismatched");
		driver.findElement(By.id("loginButton")).click();*/
		
	
	@Test
	public void loginAsAdmin() throws InterruptedException {
		String expectedLoginPageTitle="actiTIME  Login";
		String ExpectedHomePageTitle="";
		String usernamedata="admin";
		String passwordData="manager";
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		SoftAssert sa=new SoftAssert();
		
		driver.get("https://demo.actitime.com/login.do");
		String actualLoginPage = driver.getTitle();
		sa.assertEquals(actualLoginPage, expectedLoginPageTitle,"Login page is not displayed");
		WebElement username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys(usernamedata);
		//Thread.sleep(2000);
		Assert.assertEquals(username.getAttribute("value"), usernamedata, "username is not displayed");
		
		WebElement password = driver.findElement(By.name("pwd"));
		password.clear();
		password.sendKeys(passwordData);
		sa.assertEquals(password.getAttribute("value"),passwordData , "password is mismatched");
		driver.findElement(By.id("loginButton")).click();
		sa.assertAll();

	}

}

	

