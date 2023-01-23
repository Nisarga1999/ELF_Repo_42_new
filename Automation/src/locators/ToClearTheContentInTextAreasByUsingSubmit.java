package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToClearTheContentInTextAreasByUsingSubmit {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.vtiger.com/vtigercrm");
		
		Thread.sleep(2000);
		WebElement usernameTextField = driver.findElement(By.xpath("//input[@id='username']"));
		usernameTextField.clear();
		Thread.sleep(2000);
		usernameTextField.sendKeys("Nisarga");
		Thread.sleep(2000);
		WebElement passWordTextField = driver.findElement(By.name("password"));
		passWordTextField.clear();
		Thread.sleep(2000);
		passWordTextField.sendKeys("test@1234");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
	}
}
