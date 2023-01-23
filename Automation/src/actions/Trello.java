package actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Trello {

	public static void main(String[] args) {
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
		driver.findElement(By.xpath("//div[text()='ELF43']")).click();
		WebElement manuall = driver.findElement(By.xpath("//span[text()='Manual']"));
		
		Actions actions=new Actions(driver);
		actions.contextClick(manuall).perform();
		List<WebElement> contextMenu= driver.findElements(By.xpath("//a[contains(@class,'quick-card-editor-buttons-item')]"));
		for(WebElement menu:contextMenu) {
			System.out.println(menu.getText());
		}
	}
}
