package locators;

import org.openqa.selenium.By;import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToUnderStandSendKeys {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@aria-label='Phone number, username, or email']")).sendKeys("Nisarga",Keys.CONTROL+"A");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@aria-label='Phone number, username, or email']")).sendKeys(Keys.CONTROL+"C");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys(Keys.CONTROL+"V");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Log in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Forgot')]")).click();
		
	}
}
