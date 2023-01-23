package basics;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToSetTheSizeAndPositionOfTheBrowserWindow {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		Point positionOfTheBrowser=new Point(0,0);
		driver.manage().window().setPosition(positionOfTheBrowser);
		Thread.sleep(2000);
		
		Dimension sizeOfTheBrowser=new Dimension(600,600);
		driver.manage().window().setSize(sizeOfTheBrowser);
		
		driver.manage().window().fullscreen();
		
		
	}

}
