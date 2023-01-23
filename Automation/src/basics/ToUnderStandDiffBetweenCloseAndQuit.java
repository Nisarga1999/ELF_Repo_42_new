package basics;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToUnderStandDiffBetweenCloseAndQuit {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/DELL/Downloads/MultipleWindow%20(2).html");
		driver.findElement(By.xpath("//input[@value='Open Food Sites']")).click();
		Thread.sleep(2000);
		
		Set<String> allWindowIds = driver.getWindowHandles();
		System.out.println("size of set:"+allWindowIds.size());
		for(String windowId:allWindowIds) {
			System.out.println(windowId);
		}
		driver.close();
	}

}
