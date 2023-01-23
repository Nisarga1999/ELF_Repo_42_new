package popUp;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToHandleTheConformation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait explicitWait=new WebDriverWait(driver, 15);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		driver.get("https://licindia.in/");
		try {
			driver.findElement(By.xpath("//a[@title='Agents Portal']")).click();
		}catch(ElementClickInterceptedException e){
			js.executeScript("window.scrollBy(0,200);");
			driver.findElement(By.xpath("//a[@title='Agents Portal']")).click();
		}
		Alert conformationAlert = driver.switchTo().alert();
		System.out.println(conformationAlert.getText());
		conformationAlert.accept();
		
		explicitWait.until(ExpectedConditions.numberOfWindowsToBe(2));
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		windows.remove(parentWindow);
		for(String ele:windows) {
			driver.switchTo().window(ele);
		}
		
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		WebElement error1 = driver.findElement(By.xpath("(//li[contains(text(),'Please enter')])[1]"));
		System.out.println(error1.getText());
		Thread.sleep(2000);

		WebElement error2 = driver.findElement(By.xpath("(//li[contains(text(),'Please enter')])[2]"));
		System.out.println(error2.getText());
	}

}
