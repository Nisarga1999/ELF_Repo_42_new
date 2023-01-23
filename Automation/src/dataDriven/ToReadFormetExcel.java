package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ToReadFormetExcel {

	public static void main(String[] args) throws IOException {
		//srep1:creating input stream type object
		File absPath = new File("./testData/testData.xlsx");
		FileInputStream fis = new FileInputStream(absPath);
		
		//step2:Creating object of file type
//		XSSFWorkbook workBook = new XSSFWorkbook(fis);(oR)
		Workbook workBook = WorkbookFactory.create(fis);
		
		//step3:read method
		String value = workBook.getSheet("sheet1").getRow(9).getCell(5).getStringCellValue();
		System.out.println(value);
		System.out.println(workBook.getSheet("sheet1").getRow(9).getCell(6).getStringCellValue());
		
		double number = workBook.getSheet("sheet1").getRow(10).getCell(5).getNumericCellValue();
		System.out.println(number);
		
		LocalDateTime LocalTime = workBook.getSheet("sheet1").getRow(10).getCell(5).getLocalDateTimeCellValue();
		System.out.println(LocalTime);
		
		boolean booleanValue = workBook.getSheet("sheet1").getRow(11).getCell(5).getBooleanCellValue();
		System.out.println(booleanValue);
		
		Date dateValue = workBook.getSheet("sheet1").getRow(13).getCell(5).getDateCellValue();
		System.out.println(dateValue);
	}
}

