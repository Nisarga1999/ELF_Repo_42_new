package assignmentWorks;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToAddAndRemoveTheItemsInFlipKart {
	public static WebDriver driver;
	public static WebDriverWait explicitWait;
	public static Map<Integer, String>productDetails=new TreeMap<>();
	public static JavascriptExecutor js;
	
	public static void main(String[] args) throws InterruptedException {
		
		//step1 & 2:open browser and navigate to FlipKart
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		 explicitWait = new WebDriverWait(driver,15);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		//Step3 & 4:Search and add 3 different products to cart

		searchAndAddTheProduct("mac lipstick");
		searchAndAddTheProduct("dazller lipstick");
		searchAndAddTheProduct("mat lipstick light");
		
		//step5:remove the least product

		
	}
	public static void searchAndAddTheProduct(String productName) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='q']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(productName,Keys.ENTER);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'"+productName+"')]")));
		Thread.sleep(3000);
	//	driver.findElement(By.xpath(""))
	}
}
