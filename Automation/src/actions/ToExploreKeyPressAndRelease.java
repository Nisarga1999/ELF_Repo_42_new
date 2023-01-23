package actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToExploreKeyPressAndRelease {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.get("https://www.kalkifashion.com/");
		/*WebElement salWar = driver.findElement(By.linkText("Salwar Kameez "));
		WebElement saree = driver.findElement(By.linkText("Saree"));
		WebElement blouse = driver.findElement(By.linkText("Blouse"));
		WebElement Lehengas = driver.findElement(By.linkText("Lehengas"));
		WebElement indoWestern = driver.findElement(By.linkText("INDO WESTERN"));
		WebElement kurtis = driver.findElement(By.linkText("Kurtis"));
		WebElement Bridal = driver.findElement(By.linkText("Bridal"));*/
		
		Actions actions=new Actions(driver);
		List<WebElement> navElements = driver.findElements(By.xpath("//nav[not(@id='mobile-nav')]//div[@id='desktop-nav']//a[contains(@class,'menu')]"));
		for(WebElement menu:navElements) {
			actions.keyDown(Keys.CONTROL).click(menu).perform();
		}
		actions.keyUp(Keys.CONTROL);
		
	}

}
