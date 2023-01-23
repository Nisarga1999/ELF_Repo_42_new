package assignment1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCloseAllTheChildWindows {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/DELL/Desktop/selenium%20classfiles/MultipleWindow%20(3).html");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@value='Open Food Sites']")).click();
		Thread.sleep(2000);
	
		String expectedPageTitle="Multiple popups";
		Set<String> allWindowIds = driver.getWindowHandles();
		
		for(String windowId:allWindowIds) {
			driver.switchTo().window(windowId);
			String actualPageTitle=driver.getTitle();
			if(expectedPageTitle.equals(actualPageTitle)) {
				driver.close();
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
