package basics;

import org.openqa.selenium.chrome.ChromeDriver;

public class ToCaptureSourceCodeOfThePage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.apple.com/in/iphone-14/");
		String sourceCodeOfPage = driver.getPageSource();
		System.out.println(sourceCodeOfPage);
	}
}
