package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLocateElementUsingIdInRegistrationPage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement registerLink=driver.findElement(By.linkText("Register"));
		registerLink.click();
		driver.findElement(By.id("gender-female")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("FirstName")).sendKeys("Nisarga");
		Thread.sleep(2000);
		driver.findElement(By.id("LastName")).sendKeys("GN");
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys("Nisarga12344@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("Password")).sendKeys("Nisarg@3");
		Thread.sleep(2000);
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Nisarg@3");
		driver.findElement(By.id("register-button")).click();
		driver.quit();
	}
}
