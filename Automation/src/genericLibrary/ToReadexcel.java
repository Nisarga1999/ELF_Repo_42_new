package genericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadexcel {
	public static String fromExcel(String sheetName,int rollNo,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=null;
		Workbook workbook=null;
		try {
		fis=new FileInputStream(new File("./testData/testData.xlsx"));
		workbook=WorkbookFactory.create(fis);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (EncryptedDocumentException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return workbook.getSheet(sheetName).getRow(rollNo).getCell(cellNo).getStringCellValue();
	}
}
