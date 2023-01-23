package workingWithtestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderforMultiple_DemoWebShop {
	@DataProvider
	public String[][] data() throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("./testData/DemoShopTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet dataSheet = workbook.getSheet("demoSheet");
		int rowCount = dataSheet.getPhysicalNumberOfRows()-1;
		int colCount = dataSheet.getRow(0).getPhysicalNumberOfCells();
		
		String data[][]=new String[rowCount][colCount];
		for(int i=1,k=0;i<rowCount;i++,k++) {
			for(int j=0;j<colCount;j++) {
				data[k][j]=dataSheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
	@Parameters("browserName")
	@Test(dataProvider = "data")
	public void createUser(@Optional("chrome")String bname,String data[]) {
		WebDriver driver=null;
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		if(bname.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.id("gender-"+data[0]+"")).click();
		driver.findElement(By.id("FirstName")).sendKeys(data[1]);
		driver.findElement(By.id("LastName")).sendKeys(data[2]);
		driver.findElement(By.id("Email")).sendKeys(data[3]);
		driver.findElement(By.id("Password")).sendKeys(data[4]);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(data[5]);
		driver.findElement(By.id("register-button")).click();
		
		driver.quit();
	}
}
