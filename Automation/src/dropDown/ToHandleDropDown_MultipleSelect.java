package dropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ToHandleDropDown_MultipleSelect {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.get("file:///C:/Users/DELL/Downloads/dropDown.html");
		//check single selected or molti selected
		WebElement dropDown= driver.findElement(By.id("s1"));
		Select multiDropDown=new Select(dropDown);
		System.out.println(multiDropDown.isMultiple());
		
		WebElement multiSelectedDropDown= driver.findElement(By.id("m1"));
		Select multiSelect=new Select(multiSelectedDropDown);
		System.out.println(multiSelect.isMultiple());
		
		List<WebElement> allOption = multiSelect.getOptions();
		for(WebElement ele:allOption) {
			System.out.print(ele.getText());
		}
		System.out.println();
		
		multiSelect.selectByIndex(1);
		multiSelect.selectByValue("4");
		
		System.out.println("selected options");
		List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
		for(WebElement ele:selectedOptions) {
			System.out.print(ele.getText());
		}
		Thread.sleep(2000);
		multiSelect.deselectByIndex(1);
		multiSelect.selectByVisibleText("Grapes");
		multiSelect.deselectAll();
		
		
		
		
		
	}

}
