package assignment1;

import org.openqa.selenium.chrome.ChromeDriver;

public class ToGetTheCurrentWindowIdOfFaceBook {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String WindowId=driver.getWindowHandle();
		System.out.println(WindowId);
		driver.quit();
	}
}
