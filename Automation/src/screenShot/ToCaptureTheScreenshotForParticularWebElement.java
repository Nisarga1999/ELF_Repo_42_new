package screenShot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ToCaptureTheScreenshotForParticularWebElement {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/register");
		TakesScreenshot ts=(TakesScreenshot) driver;//type casting
		File Screenshot = driver.findElement(By.xpath("(//a[@href='/books'])[1]")).getScreenshotAs(OutputType.FILE);
		File targetScreenshot = new File("./errorshots/nisarga.jpg");
		FileHandler.copy(Screenshot, targetScreenshot);
		}
}
