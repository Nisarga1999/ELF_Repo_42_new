package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByUsingCssSelector {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElementByCssSelector("a[href='/register']").click();
		Thread.sleep(2000);
		driver.findElementByCssSelector("input[id='gender-female']").click();
		Thread.sleep(2000);
		driver.findElementByCssSelector("input[id='FirstName']").sendKeys("Nisarga");
		Thread.sleep(2000);
		driver.findElementByCssSelector("input[id='LastName']").sendKeys("GN");
		Thread.sleep(2000);
		driver.findElementByCssSelector("input[id='Email']").sendKeys("Nisarga@56gmail.com");
		Thread.sleep(2000);
		driver.findElementByCssSelector("input[name='Password']").sendKeys("Nishu245");
		Thread.sleep(2000);
		driver.findElementByCssSelector("input[name='ConfirmPassword']").sendKeys("Nishu245");
		Thread.sleep(2000);
		driver.findElementByCssSelector("input[id='register-button']").click();
		Thread.sleep(2000);
		}
}