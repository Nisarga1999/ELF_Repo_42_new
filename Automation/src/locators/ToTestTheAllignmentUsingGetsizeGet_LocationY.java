package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToTestTheAllignmentUsingGetsizeGet_LocationY {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		WebElement emailTextfield = driver.findElement(By.id("email"));
		WebElement passwordTextField = driver.findElement(By.id("pass"));
		
		Point emailTextFieldLocation = emailTextfield.getLocation();
		Point passwordTextfieldLocation = passwordTextField.getLocation();
		Dimension emailTextfieldSize = emailTextfield.getSize();
		Dimension passWordTextfieldsize = passwordTextField.getSize();
		
		int YlocationOfemailTextField = emailTextFieldLocation.getY();
		int YLocationOfPasswordTextField = passwordTextfieldLocation.getY();
		int YLocationPlusHeightOfTheEmailTestField = emailTextfieldSize.getHeight()+YlocationOfemailTextField+3;
		int YLocationPlusOftheThePasswordTextfield = passWordTextfieldsize.getHeight()+YLocationOfPasswordTextField;
		
		System.out.println("YlocationOfemailTextField: "+YlocationOfemailTextField);
		System.out.println("heightOfTheemailTextfield: "+emailTextfieldSize.getHeight());
		System.out.println("YLocationOfPasswordTextField: "+YLocationOfPasswordTextField);
		System.out.println("heightOfTheemailTextfield: "+ passWordTextfieldsize.getHeight());
		
		if(YlocationOfemailTextField==YLocationOfPasswordTextField) {
			System.out.println("it is alligned");
		}
		else {
			System.out.println("not alligned");
		}
	}

}
