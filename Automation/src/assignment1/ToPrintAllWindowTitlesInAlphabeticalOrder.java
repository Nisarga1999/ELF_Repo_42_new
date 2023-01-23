package assignment1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToPrintAllWindowTitlesInAlphabeticalOrder {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/DELL/Desktop/selenium%20classfiles/MultipleWindow%20(3).html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@value='Open Food Sites']")).click();
		Thread.sleep(2000);
	
		Set<String> allWindowsIds = driver.getWindowHandles();
		for(String windowId:allWindowsIds) {
			System.out.println(windowId);
			driver.switchTo().window(windowId);
			String TogetTheTitles = driver.getTitle();
			System.out.println(TogetTheTitles);
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
