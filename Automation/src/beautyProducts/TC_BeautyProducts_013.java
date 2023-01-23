package beautyProducts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_BeautyProducts_013 {
	//@Parameters("browserName")
	@Test(groups = "Regression")
	public void maybellin(@Optional("chrome")String bname) {
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
		
		driver.get("https://mamaearth.in/");
		driver.quit();
	}

	 class browserInvalidexception extends RuntimeException {
		 browserInvalidexception(){
			super("please enter a valid browser");
		 }
	}
}
