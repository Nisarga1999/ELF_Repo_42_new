package workingWithtestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderProblem {
	@DataProvider(parallel = false)
	public String[] getUrl() {
		String arr[]= {"https://demowebshop.tricentis.com/",
						"https://vtu.ac.in/",
						"https://www.kalkifashion.com/"
						};
		return arr;
	}
	@Test(dataProvider = "getUrl")
	public void test(String url) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get(url);
	}

}
