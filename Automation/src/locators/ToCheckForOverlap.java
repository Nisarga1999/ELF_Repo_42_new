package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCheckForOverlap {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.facebook.com/");
				WebElement emailField = driver.findElement(By.id("email"));
				Point locationOfEmail = emailField.getLocation();
				int locationOfy = locationOfEmail.getY();
				Dimension sizeOfEmail = emailField.getSize();
				int heigthofEmail = sizeOfEmail.getHeight();
				int totalLength = locationOfy+heigthofEmail+3;
				WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='pass']/.."));
				Point locationOfPassword = passwordTextField.getLocation();
				int heigthOFPassword = locationOfPassword.getY();
				if(totalLength<=heigthOFPassword) {
					System.out.println("It is not overlaping");
				}
				else
					System.out.println("It is overlaping");
				
				
				driver.quit();

	}

}
