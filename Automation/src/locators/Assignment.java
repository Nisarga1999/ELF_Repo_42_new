package locators;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {
	public static WebDriver driver;
	
	static void main(String[] args) throws InterruptedException {
		/*System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	    driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("maclipstick");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@title='SUGAR POP Satin Matte Lipstick - 05 Lotus']")).click();
	    Thread.sleep(2000);

	   // driver.findElement(By.xpath("//svg[@class=\"_1KOMV2\"]")).click();
		Thread.sleep(2000);
	//	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowsIds = driver.getWindowHandles();
		allWindowsIds.remove(allWindowsIds);
		for(String WindowId:allWindowsIds) {
			driver.switchTo().window(WindowId);
		}
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		driver.switchTo().window(parentWindowId);*/
		
		//step1:open flipkart and navigate to flipkart
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
		//step2:
		
		}
	public static  void searchAndAddProduct() {
		
	}
}
