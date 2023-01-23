package assignment1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCloseOnlyBarbequeNation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/DELL/Desktop/selenium%20classfiles/MultipleWindow%20(3).html");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@value='Open Food Sites']")).click();
		Thread.sleep(2000);
	
		Set<String> allWindowsIds = driver.getWindowHandles();
		for(String windowId:allWindowsIds) {
			driver.switchTo().window(windowId);
			String currentUrl=driver.getCurrentUrl();
			System.out.println(currentUrl);
			if(currentUrl.equals("https://www.barbequenation.com/")) {
				Thread.sleep(2000);
				driver.quit();
			}
		}
	}

}
