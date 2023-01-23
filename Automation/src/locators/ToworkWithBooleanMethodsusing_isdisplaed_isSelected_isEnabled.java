package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToworkWithBooleanMethodsusing_isdisplaed_isSelected_isEnabled {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		/*driver.get("https://demo.actitime.com/login.do");
		WebElement checkBox = driver.findElement(By.id("keepLoggedInCheckBox"));
		System.out.println(checkBox.isDisplayed());
		System.out.println(checkBox.isSelected());
		checkBox.click();
		System.out.println("after click");
		System.out.println(checkBox.isSelected());*/
		
		driver.get("https://demowebshop.tricentis.com/");
		//driver.findElement(By.xpath(""))
	}

}
