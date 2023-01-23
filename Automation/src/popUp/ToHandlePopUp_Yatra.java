package popUp;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToHandlePopUp_Yatra {

	public static void main(String[] args) throws InterruptedException {
		
		//to get the departure date
		LocalDateTime systemsDateTime = LocalDateTime.now().plusMonths(2);
		//System.out.println(systemsDateTime);
		String monthName = systemsDateTime.getMonth().name();
		//System.out.println(monthName);
		int year = systemsDateTime.getYear();
		//System.out.println(year);
		int day = systemsDateTime.getDayOfMonth();
		//System.out.println(day);
		String month = ""+monthName.charAt(0)+monthName.substring(1, monthName.length()).toLowerCase();
		
		//to get returndate
		LocalDateTime returnDateTime = LocalDateTime.now().plusMonths(2).plusDays(4);
		String returnmonthName = returnDateTime.getMonth().name();
		int returnyear = returnDateTime.getYear();
		int returnday = returnDateTime.getDayOfMonth();
		String returnmonth = ""+returnmonthName.charAt(0)+returnmonthName.substring(1, returnmonthName.length()).toLowerCase();
		
		//to launch the browser and navigate to webpage
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		WebDriverWait explicitWait=new WebDriverWait(driver, 15);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Actions actions=new Actions(driver);
		
		
		//selecting the departure date
		driver.get("https://www.yatra.com/");
		driver.findElement(By.xpath("//label[@for='BE_flight_origin_date']")).click();
		//actions.moveToElement(departureDate).perform();
		driver.findElement
		(By.xpath("//div[@class='month-head BE_flight_origin_date']/..//td[contains(@title,'"+day+" "+month+" "+year+"')]")).click();
		
		//selecting the return date
		WebElement clickOnTheReturn = driver.findElement(By.xpath("//input[@name='flight_destination_date']"));
		actions.moveToElement(clickOnTheReturn).click().perform();
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[text()='Select Return Date']"))));
		driver.findElement(By.id("BE_flight_arrival_date")).click();
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Book Flights, Hotels and Holiday Packages']"))));
		//Thread.sleep(2000);
		WebElement returnDate = driver.findElement
				(By.xpath("//div[@class='month-head BE_flight_arrival_date']/..//td[contains(@title,'"+returnday+" "+returnmonth+" "+returnyear+"')]"));
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[text()='Select Return Date']"))));
		returnDate.click();
		
		
		//driver.quit();
	}

}
