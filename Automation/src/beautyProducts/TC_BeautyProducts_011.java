package beautyProducts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import beautyProducts.TC_BeautyProducts_013.browserInvalidexception;

public class TC_BeautyProducts_011 {
	//@Parameters("browserName")
	//@Test//(invocationCount = 3)
	@Test(groups = "Funtionality",dependsOnGroups = "smoke")
	public void purple(@Optional("Chrome")String bname) {
			WebDriver driver=null;
			if(bname.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
			}
			else if(bname.equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
			}
			else {
				throw new browserInvalidexception();
				
				//Reporter.log("please pass a valid browser name",true );
			}

		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.purplle.com/");
		driver.quit();
	}

	class browserInvalidexception extends RuntimeException {
			browserInvalidexception() {
				super("please enter a valid browser");
		}
	}
}
