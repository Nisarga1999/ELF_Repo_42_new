package dropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ToHandleDropDownInFaceBook_SingleSelect{

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create New Account")).click();
		
		WebElement daydropDown = driver.findElement(By.id("day"));
		WebElement monthdropDown = driver.findElement(By.id("month"));
		WebElement yeardropDown = driver.findElement(By.id("year"));
		
		Select daySelect=new Select(daydropDown);
		System.out.println("Day dropdown :"+daySelect.isMultiple());
		List<WebElement> dayDropDownOption = daySelect.getOptions();
		for(WebElement ele:dayDropDownOption) {
			System.out.print(ele.getText());
		}
		//daySelect.selectByIndex(16);
		daySelect.selectByValue("11");
		
		Select monthSelect=new Select(monthdropDown);
		monthSelect.selectByVisibleText("Jun");
		
		Select yearSelect=new Select(yeardropDown);
		//yearSelect.selectByVisibleText("1999");
		List<WebElement> yearDropDownOptions = yearSelect.getOptions();
		for(WebElement ele :yearDropDownOptions) {
			yearSelect.selectByVisibleText(ele.getText());
			Thread.sleep(500);
		}
	}
}      