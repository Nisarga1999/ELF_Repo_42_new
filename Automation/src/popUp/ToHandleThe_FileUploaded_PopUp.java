package popUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ToHandleThe_FileUploaded_PopUp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		WebDriverWait explicitWait=new WebDriverWait(driver, 15);
		
		driver.get("https://www.freshersworld.com/user/register?src=homeheader");
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\DELL\\Desktop\\ScreenShot");
		//driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\DELL\\Desktop");

		
		 Alert alertObjref = driver.switchTo().alert();
		 System.out.println(alertObjref.getText());
		 alertObjref.accept();
		 
		 driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\DELL\\Desktop\\MK RESUME.pdf");
				
	}

}
