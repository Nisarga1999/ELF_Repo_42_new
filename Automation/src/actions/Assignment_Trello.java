package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_Trello {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		WebDriverWait explicitWait=new WebDriverWait(driver, 15);
		
		driver.get("https://trello.com/login");
		driver.findElement(By.id("user")).sendKeys("nisarga1751999@gmail.com");
		driver.findElement(By.id("login")).click();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit")));
		driver.findElement(By.id("password")).sendKeys("Nisargaanithasri58@");
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		driver.findElement(By.xpath("//div[text()='ELF']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//WebElement status = driver.findElement(By.xpath("(//div[@class='list-header-target js-editing-target'])[1]"));
		
		WebElement manualmock= driver.findElement(By.partialLinkText("Mock completed"));
		WebElement javamock = driver.findElement(By.partialLinkText("Mock Schedule"));
		WebElement seleniummock = driver.findElement(By.partialLinkText("Mock Pending"));
		WebElement manual = driver.findElement(By.xpath("(//div[@class='list-header-target js-editing-target'])[2]"));
		WebElement java = driver.findElement(By.xpath("(//div[@class='list-header-target js-editing-target'])[3]"));
		WebElement selenium = driver.findElement(By.xpath("(//div[@class='list-header-target js-editing-target'])[4]"));
		
		Actions actions=new Actions(driver);
		actions.dragAndDrop(manualmock,manual).perform();
		actions.dragAndDrop(javamock, java).perform();
		actions.dragAndDrop(seleniummock, selenium).perform();
	}

}