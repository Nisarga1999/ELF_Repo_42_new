package assignment1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToMoveTheWindowToTheGivenCoordinates {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://fireflink.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Point positionOfTheBrowser=new Point(100,50);
		driver.manage().window().setPosition(positionOfTheBrowser);
		driver.quit();
		}
}
