package locators;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3_Ajio {

	public static void main(String[] args) throws InterruptedException {
		int number=3;
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//Step1:open Ajio
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//step2:select Jackets 
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Jackets for women");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		//Step3:Fetch the cost of the product
		String costOfProduct = driver.findElement(By.xpath("(//div[contains(@class,'item rilrtl-products-list__item item')])["+number+"]//span[contains(@class,'price ')]")).getText();
		System.out.println("costOfProduct: "+costOfProduct);
		costOfProduct=	costOfProduct.replace("₹","");
		costOfProduct=costOfProduct.trim();
		System.out.println(costOfProduct);
		
		//Step4 & 5:check cost is greater than 1000 if not displayed error message
		int cost = Integer.parseInt(costOfProduct);
		if(cost>1000) {
			System.out.println("The cost is too high !!");
		}
		else {
			driver.findElement(By.xpath("//div[contains(@class,'item rilrtl-products-list__item item')]["+number+"]//a")).click();
			Thread.sleep(3000);

			String parentWindowId = driver.getWindowHandle();
			Set<String> allWindowsIds = driver.getWindowHandles();
			allWindowsIds.remove(allWindowsIds);
			for(String WindowId:allWindowsIds) {
				driver.switchTo().window(WindowId);
			}
			driver.findElement(By.xpath("(//div[@class='size-swatch'])[3]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[contains(text(),'ADD TO BAG')]")).click();
			Thread.sleep(5000);


		//	driver.findElement(By.xpath("//div[@class='pdp-addtocart-button']")).click();
		//driver.findElement(By.xpath("//div[@class='btn-gold']")).click();
			
		/*	driver.findElement(By.xpath("(//div[@class='size-swatch'])[3]")).click();
			Thread.sleep(3000);
d;.
			driver.findElement(By.xpath("//span[contains(text(),'ADD TO BAG')]")).click();
			Thread.sleep(5000);*/
			}
		driver.findElement(By.xpath("//div[@class='ic-cart ']")).click();
		Thread.sleep(5000);

		driver.quit();
	}

}
