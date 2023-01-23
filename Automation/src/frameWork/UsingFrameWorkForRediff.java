package frameWork;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsingFrameWorkForRediff {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait explicitwait = new WebDriverWait(driver, 15);
		driver.get("https://www.rediff.com/");
		driver.findElement(By.xpath("//a[@title='Lightning fast free email']")).click();
		
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("sumanthElfBatch@rediffmail.com");
	

		driver.findElement(By.id("password")).sendKeys("Testing@123");
		

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//b[text()='Write mail']")).click();
		
		/*WebElement toTextField = driver.findElement(By.id("TO_IDcmp2"));
		toTextField.sendKeys("sumanthElfBatch@rediffmail.com",Keys.ENTER);*/
		
		//naveen
		/*WebElement ToTextField = driver.findElement(By.xpath("(//input[@placeholder='Enter name or email'])[1]"));
		ToTextField.sendKeys("sumanthElfBatch@rediffmail.com");
		Thread.sleep(2000);
		String subject = "Nisarga";
		driver.findElement(By.xpath("//input[@class='rd_inp_sub rd_subject_datacmp2']")).sendKeys(subject);
		
	
		WebElement bodyframe = driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, rdMailEditorcmp2']"));
		driver.switchTo().frame(bodyframe);
		
		driver.findElement(By.xpath("//body[@contenteditable='true']")).sendKeys("Message from Nisarga.");
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[text()='Send']")).click();	
		
		for(int i=1;i<3;i++) {
			driver.navigate().refresh();
		}
	
		driver.findElement(By.xpath("//span[@title='"+subject+"']/..//cite[@title='Select mail']")).click();
		
		driver.findElement(By.xpath("//span[@class=\"rd_fil_del\"]")).click();
		
		driver.findElement(By.id("jqi_state0_buttonOk")).click();
		
		
		Thread.sleep(1000);
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File tempScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
		File targetScreenshot = new File("./errorshots/rediff.png");
		System.out.println("Screenshot taken");
		FileHandler.copy(tempScreenshot, targetScreenshot);
		
		driver.quit();*/
		
		
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TO_IDcmp2")));
		WebElement userId = driver.findElement(By.id("TO_IDcmp2"));
		userId.sendKeys("sumanthElfBatch@rediffmail.com");
		

		driver.findElement(By.xpath("//input[@class='rd_inp_sub rd_subject_datacmp2']")).sendKeys("Nisarga");
	}

}
