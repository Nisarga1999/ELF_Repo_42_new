package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToTestTheAllignmentUsingGetsizeGetLocationx {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
	/*	WebElement emailTextfield = driver.findElement(By.xpath("//div[@class='_6lux']"));
		WebElement passwordTextField = driver.findElement(By.xpath("//div[@id='passContainer']"));select whole area of the textfield*/
		
		WebElement emailTextfield = driver.findElement(By.id("email"));
		WebElement passwordTextField = driver.findElement(By.id("pass"));//select particular text area of the textfield
		
		
		Point emailTextfieldLocation = emailTextfield.getLocation();
		Point passwordTextfieldLocation = passwordTextField.getLocation();
		Dimension emailTextfieldSize = emailTextfield.getSize();
		Dimension passWordTextfieldsize = passwordTextField.getSize();
		
		int XLocationEmailTextField = emailTextfieldLocation.getX();
		int XLocationpasswordTextField = passwordTextfieldLocation.getX();
		int xLocationPlusWidthOfEmailTextField = emailTextfieldSize.getWidth()+XLocationEmailTextField;
		int xLocationPlusWidthOfPasswordTextField = passWordTextfieldsize.getWidth()+XLocationpasswordTextField;
		
		System.out.println("XLocationEmailTextField: "+XLocationEmailTextField);
		System.out.println("XLocationpasswordTextField: "+XLocationpasswordTextField);
		System.out.println("WidthOfEmailTextField: "+emailTextfieldSize.getWidth());
		System.out.println("WidthOfPasswordTextField: "+passWordTextfieldsize.getWidth());
		
		//Left Allignment check
		if(XLocationEmailTextField==XLocationpasswordTextField) {
			System.out.println("Email text field and password text field are properly alligned toward left");
		}
		else {
			System.out.println("Email text field and password text field are not inline toward left");
		}
		
		//Right allignment check
		if(xLocationPlusWidthOfEmailTextField==xLocationPlusWidthOfPasswordTextField) {
			System.out.println("Email text field and password text field are properly alligned toward right");
		}
		else {
			System.out.println("Email text field and password text field are not inline toward right");
		}
	}

}
