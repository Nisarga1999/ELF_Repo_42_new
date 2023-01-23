package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToPerformDragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);
	
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(frameElement);
		WebElement image1 = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement image2 = driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));
		WebElement image3 = driver.findElement(By.xpath("//img[@alt='Planning the ascent']"));
		WebElement image4 = driver.findElement(By.xpath("//img[@alt='On top of Kozi kopka']"));
		WebElement trash = driver.findElement(By.id("trash"));
		WebElement gallery = driver.findElement(By.id("gallery"));
		
		Actions actions=new Actions(driver);
		actions.dragAndDrop(image1, trash).perform();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5['High Tatras']")));
		actions.dragAndDropBy(image2, 500, 0).perform();
		actions.clickAndHold(image3).moveToElement(trash).release().perform();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5['High Tatras']")));
		actions.moveToElement(image4).clickAndHold().clickAndHold(trash).release().perform();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5['High Tatras']")));

		
		actions.dragAndDrop(image1,gallery).perform();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5['High Tatras']")));
		actions.dragAndDrop(image2, gallery).perform();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5['High Tatras']")));
		actions.dragAndDrop(image3, gallery).perform();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5['High Tatras']")));
		actions.dragAndDrop(image4, gallery).perform();
		
		//Aceepted elements
		driver.switchTo().defaultContent();
		//Thread.sleep(2000);
		driver.findElement(By.id("Accepted Elements")).click();
		frameElement=driver.findElement(By.xpath("(//iframe[@class='demo-frame lazyloaded'])[2]"));
		driver.switchTo().frame(frameElement);
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		actions.dragAndDrop(draggable, droppable).perform();
		//Thread.sleep(2000);
		String text = driver.findElement(By.id("droppable")).getText();
		System.out.println(text);

		
		
		
		
		
		
		
	}

}
