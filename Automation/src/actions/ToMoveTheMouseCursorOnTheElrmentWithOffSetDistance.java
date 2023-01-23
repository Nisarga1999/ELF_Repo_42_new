package actions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToMoveTheMouseCursorOnTheElrmentWithOffSetDistance {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		/*driver.get("https://yonobusiness.sbi/login/yonobusinesslogin");
		WebElement passwordTextField = driver.findElement(By.id("password"));
		Thread.sleep(2000);
		passwordTextField.sendKeys("Testing@12345");
		Actions actions=new Actions(driver);
		actions.moveToElement(passwordTextField,0,250).click().perform();*/
		
		driver.get("https://www.reliancedigital.in/");
		driver.findElement(By.xpath("//button[text()='No, don’t.']")).click();
		WebElement searchProduct = driver.findElement(By.id("suggestionBoxEle"));

		searchProduct.sendKeys("television");
		Actions actions=new Actions(driver);
		actions.moveToElement(searchProduct,0,240).click().perform();
	}
}
