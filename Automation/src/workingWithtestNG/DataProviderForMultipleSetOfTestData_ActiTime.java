package workingWithtestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderForMultipleSetOfTestData_ActiTime{
	@DataProvider
	public String[][] registerUserData() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/dataProviderTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet dataSheet = workbook.getSheet("RegisterUser");
		int rowCount = dataSheet.getPhysicalNumberOfRows()-1;
		int colCount = dataSheet.getRow(0).getPhysicalNumberOfCells();
		
		String data[][]=new String[rowCount][colCount];
		for(int i=1,k=0;i<=rowCount;i++,k++) {
			for(int j=0;j<colCount;j++) {
				data[k][j]=dataSheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
		}
	@Test(dataProvider="registerUserData")
	public void createUser(String data[]) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
}
