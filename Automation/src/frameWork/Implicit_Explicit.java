 package frameWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Implicit_Explicit {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.firelawn.com/");
		
		WebDriverWait explictWait = new WebDriverWait(driver,15);
		
		driver.findElement(By.xpath("//span[text() ='5.0']/../..//span[text()='APPLE iPhone 14 Pro']")).click();
		driver.findElement(By.xpath("//input[@placeholder='580023']")).sendKeys("560019");
		WebElement checkButton = driver.findElement(By.xpath("//button[@type='submit']"));
		explictWait.until(ExpectedConditions.elementToBeClickable(checkButton));
		checkButton.click();
	}
}
