package basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCaptureSizeAndPositionOfTheBrowserWindow {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		Dimension sizeOfTheBrowse = driver.manage().window().getSize();
		System.out.println(sizeOfTheBrowse);
		int height = sizeOfTheBrowse.getHeight();
		int width = sizeOfTheBrowse.getWidth();
		System.out.println(height);
		System.out.println(width);
		
		Point positionOfTheBrowser = driver.manage().window().getPosition();
		System.out.println(positionOfTheBrowser.getX());
		System.out.println(positionOfTheBrowser.getY());
	}
}

