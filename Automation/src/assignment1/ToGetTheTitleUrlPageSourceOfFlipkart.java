package assignment1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GetPageSource;

public class ToGetTheTitleUrlPageSourceOfFlipkart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		String titleOfThePage = driver.getTitle();
		System.out.println(titleOfThePage);
		Thread.sleep(2000);
		String sourceCodeOfPage = driver.getPageSource();
		System.out.println(sourceCodeOfPage);
		driver.quit();
	}
}
