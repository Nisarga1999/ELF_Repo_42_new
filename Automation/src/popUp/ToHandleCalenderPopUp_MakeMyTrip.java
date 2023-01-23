package popUp;

import java.time.LocalDateTime;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToHandleCalenderPopUp_MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		LocalDateTime systemsDateTime = LocalDateTime.now().plusMonths(3);
		//System.out.println(systemsDateTime);
		String monthName = systemsDateTime.getMonth().name();
		//System.out.println(monthName);
		int year = systemsDateTime.getYear();
		//System.out.println(year);
		int day = systemsDateTime.getDayOfMonth();
		//System.out.println(day);
		String month = ""+monthName.charAt(0)+monthName.substring(1, monthName.length()).toLowerCase();
		System.out.println(day+" "+month+" "+year);
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		WebDriverWait explicitWait=new WebDriverWait(driver, 15);
		Actions actions=new Actions(driver);
		
		driver.get("https://www.makemytrip.com/");
		actions.click().perform();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		for(;;) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[text()='"+month+" "+year+"']/../..//p[text()='"+day+"']")).click();
				break;
			}catch(NoSuchElementException e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		driver.findElement(By.xpath("(//span[text()='Flights'])[1]")).click();
		//actions.click().perform();
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']"));
		driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
		driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		driver.findElement(By.id("departure"));
		actions.click().perform();
		driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1]//div[contains(@aria-label,'18 2023')]")).click();
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

		
		
		
		
		
	}
}
