package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLogin {

	public static void main(String[] args) throws InterruptedException {
		//Expected Data
		String expectedLoginPageTitle="Instagram - Login";
		String expectedHomePageTitle="Instagram ";
		String usernameData="nisarga_n_gowda17";
		String passwordData="Nisarga@_anitha@_58";
		
		//step1:open the browser and enter the test url
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Chrome browser is launched");
		driver.manage().window().maximize();
		System.out.println("Browser window is maximised");
		driver.get("https://www.instagram.com/");
		String actualLoginPageTitle=driver.getTitle();
		if(expectedLoginPageTitle.equals(actualLoginPageTitle)) {
			System.out.println("Login page is displayed");
		}
		else {
			System.out.println("Login page is not displayed");
		}
		//step 2=Enter valid credentials into username text field and passward text field
		WebElement usernameTextField = driver.findElement(By.xpath("//input[@type='text']"));
		usernameTextField.clear();
		usernameTextField.sendKeys(usernameData);
		String actualusernameEntered = usernameTextField.getAttribute("value");
		if(usernameData.equals(actualusernameEntered)) {
			System.out.println("sucessfully enterd username into username text field");
		}
		else {
			System.out.println("Username is not entered sucessfully");
		}
		
		 WebElement passwordTextField = driver.findElement(By.xpath("//input[@name='password']"));
		passwordTextField.clear();
		passwordTextField.sendKeys(passwordData);
		String actualPasswordEntered = passwordTextField.getAttribute("value");
		if(passwordData.equals(actualPasswordEntered)) {
			System.out.println("sucessfully enterd username into username text field");
		}
		else {
			System.out.println("Username is not entered sucessfully");
		}
		
		//step3=click on login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		String actualHomePageTitle=driver.getTitle();
		if(expectedHomePageTitle.equals(actualHomePageTitle)) {
			System.out.println("home page is displayed");
		}
		else {
			System.out.println("home page is not displayed");
		}
	}
}
