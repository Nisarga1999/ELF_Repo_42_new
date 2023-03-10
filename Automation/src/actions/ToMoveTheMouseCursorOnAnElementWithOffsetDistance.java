package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToMoveTheMouseCursorOnAnElementWithOffsetDistance {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.get("https://www.reliancedigital.in/");
		driver.findElement(By.xpath("//button[text()='No, don’t.']")).click();
		WebElement homeApplicancesNavBarElement = driver.findElement(By.xpath("//div[text()='Televisions']"));
		
		Actions actions=new Actions(driver);
		actions.moveToElement(homeApplicancesNavBarElement).perform();
		driver.findElement(By.linkText("Smart TVs")).click();
	}

}
