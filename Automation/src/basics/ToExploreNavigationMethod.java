package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToExploreNavigationMethod {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();//
		driver.get("https://www.zomato.com/");
		Thread.sleep(2000);
		driver.get("https://www.olacabs.com/");
		Thread.sleep(2000);
		
		Navigation navigate = driver.navigate();
		navigate.back();
		Thread.sleep(2000);
		navigate.forward();
		navigate.refresh();
		URL url=new URL("https://www.coursera.org/");
		navigate.to(url);
		}

}
