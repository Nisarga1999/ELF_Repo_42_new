package locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2_woodenStreetPage {

	public static void main(String[] args) throws InterruptedException {
		
		int number = 2;
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait explicitWait=new WebDriverWait(driver, 15);
		Actions actions=new Actions(driver);
		
		//step1:open the wooden street
		driver.get("https://www.woodenstreet.com/");
		Thread.sleep(15000);
		driver.findElement(By.id("loginclose1")).click();
		Thread.sleep(2000);
		
	
		
		WebElement cursorMoveOnFourthProd = driver.findElement(By.xpath("//a[text()='Dining']"));
		actions.moveToElement(cursorMoveOnFourthProd).perform();

		/*//step2:select the study table
		driver.findElement(By.xpath("//p[text()='Study Tables']")).click();
		//Thread.sleep(20000);
		//
		Thread.sleep(5000);
		
		//step3:fetch the cost of the 2nd product 
			 String price = driver.findElement(By.xpath("(//div[contains(@id,'article')])["+number+"]//strong[contains(text(),'Rs')]")).getText();
			 System.out.println(price);
			 price=price.replaceAll("[^0-9]", "");
			 System.out.println(price);
			 
			 int cost = Integer.parseInt(price);
			 if(cost>10000) {
				 System.out.println("overpriced");
			 }
			 else {
				 driver.findElement(By.xpath("(//div[contains(@id,'article')])["+number+"]//a[contains(text(),'Study Table')]")).click();
				 Thread.sleep(3000);
				 driver.findElement(By.id("button-cart-buy-now")).click();
				 Thread.sleep(5000);
			 }
			 
			 driver.findElement(By.xpath("//a[@title='Cart']")).click();
			 Thread.sleep(4000);
			 driver.quit();*/

	}

}
