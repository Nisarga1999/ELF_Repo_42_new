package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCheckTheOverlappinfFOr_X {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement emailTextField = driver.findElement(By.xpath("//input[@id='email']/.."));
		Point emailTextFieldLocation = emailTextField.getLocation();
		int Locationemail_x = emailTextFieldLocation.getX();
		Dimension emailtextFieldSize = emailTextField.getSize();
		int WidthOfTheemail = emailtextFieldSize.getWidth();
		
		WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='pass']/.."));
		Point passwordLocation = passwordTextField.getLocation();
		int Locationpassword_x = passwordLocation.getX();
		Dimension passwordTextfieldSize = passwordTextField.getSize();
		int widthOfThepassword = passwordTextfieldSize.getWidth();
		
		System.out.println("Locationemail_x: "+Locationemail_x);
		System.out.println("WidthOfTheemail: "+WidthOfTheemail);
		System.out.println("Locationpassword_x: "+Locationpassword_x);
		System.out.println("widthOfThepassword: "+widthOfThepassword);
		
		if(Locationemail_x==Locationpassword_x) {
			System.out.println("towards left");
		}
		else {
			System.out.println("not toward left");
		}
		
		if(WidthOfTheemail==widthOfThepassword) {
			System.out.println("towards right");
		}
		else {
			System.out.println("not towards right");
		}
	}

}
