package javaScript_Executor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Clear_The_ContentIn_TextField {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://demo.actitime.com/login.do");
		WebElement textBox = driver.findElement(By.name("username"));
		textBox.sendKeys("admin");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0],value='';",textBox);
	}
}
