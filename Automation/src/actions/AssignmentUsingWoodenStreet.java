package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentUsingWoodenStreet {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		WebDriverWait explicitWait=new WebDriverWait(driver, 15);
		
		driver.get("https://www.woodenstreet.com/");
		Thread.sleep(15000);
		driver.findElement(By.id("loginclose1")).click();
		Thread.sleep(2000);

//step2:select the 4th product
		Actions actions=new Actions(driver);

		WebElement furnitureApllicancesNavBar = driver.findElement(By.linkText("Dining"));
		actions.moveToElement(furnitureApllicancesNavBar).perform();

		WebElement FourthProduct = driver.findElement(By.xpath("//a[text()='8 Seater Dining Sets ']"));
		actions.moveToElement(FourthProduct).click().perform();
		
		driver.findElement(By.partialLinkText("Mcbeth")).click();
		
		//step3:fetch the cost of the 4th product
		//driver.findElement(null)
		


		
		
	}

}
