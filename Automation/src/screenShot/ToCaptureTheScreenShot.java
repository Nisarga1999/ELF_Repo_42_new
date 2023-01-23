package screenShot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ToCaptureTheScreenShot {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.thrillophilia.com/");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File tempScreenshot = ts.getScreenshotAs(OutputType.FILE);
		File targetScreenshot = new File("./errorshots/snap.png");
		FileHandler.copy(tempScreenshot, targetScreenshot);
	}

}
