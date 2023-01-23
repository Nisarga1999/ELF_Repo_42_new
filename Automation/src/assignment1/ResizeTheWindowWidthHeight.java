package assignment1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResizeTheWindowWidthHeight {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://fireflink.com/");
		driver.manage().window().maximize();
		Point PositionOfTheBrowser=new Point(0,0);
		driver.manage().window().setPosition(PositionOfTheBrowser);
		Thread.sleep(3000);
		Dimension sizeOfTheBrowser=new Dimension(100,200);
		driver.manage().window().setSize(sizeOfTheBrowser);
		Thread.sleep(3000);
		driver.quit();
	}
}
