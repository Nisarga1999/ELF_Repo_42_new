package verificationUsingAseertions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerificationOfFaceBookLoginPage {
		@Test
		public void FaceBookLoginPage() {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		Reporter.log("Empty Chrome browser is launched", true);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		WebDriverWait explicitWait=new WebDriverWait(driver, 15);
		SoftAssert sa=new SoftAssert();
		
		
		driver.get("https://www.facebook.com/login/");
		//explicitWait.until(ExpectedConditions.visibilityOfElementLocated(null))
		sa.assertEquals(driver.getTitle(), "Log in to Facebook","Login page is mismatched");
		
		driver.findElement(By.id("loginbutton")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=100","url is mismatched");
		WebElement emailTextField = driver.findElement(By.xpath("email"));
		sa.assertEquals(emailTextField.getCssValue("border"), "px solid rgb(240, 40, 73)","Border is mismatched");
		WebElement errorMessage = driver.findElement(By.xpath("//div[@id='email_container']/div[2]"));
		sa.assertEquals(errorMessage,"he email address or mobile number you entered isn't connected to an account. Find your account and log in.","error message is mismatched");
		sa.assertAll();
		
		}
}
