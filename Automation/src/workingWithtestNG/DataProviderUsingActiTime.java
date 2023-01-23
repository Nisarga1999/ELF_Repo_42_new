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
import org.testng.annotations.Test;

public class DataProviderUsingActiTime {

		@DataProvider
		public String[][] getCrendentials() throws EncryptedDocumentException, IOException{
			FileInputStream fis=new FileInputStream("./testData/actitimedata.xlsx");
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet datasheet = workbook.getSheet("actitimeData");
			int rowCount = datasheet.getPhysicalNumberOfRows()-1;
			int colCount = datasheet.getRow(0).getPhysicalNumberOfCells();
			
			String data[][]=new String[rowCount][colCount];
			for(int i=1,k=0;i<=rowCount;i++,k++) {
				for(int j=0;j<colCount;j++) {
					data[k][j]=datasheet.getRow(i).getCell(j).toString();
				}
			}
			return data;
				}
		@Test(dataProvider="getCrendentials")
		public void createUser(String data[]) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.get("https://demo.actitime.com/login.do");
			driver.findElement(By.id("username")).sendKeys(data[0]);
			driver.findElement(By.name("pwd")).sendKeys(data[1]);
			driver.findElement(By.id("loginButton")).click();;
			
			Thread.sleep(4000);
			driver.quit();
			
			
		}
}
