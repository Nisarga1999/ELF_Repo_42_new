package dataDriven;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import genericLibrary.ToReadexcel;

public class ToReadDataFromXExcelThroughFunction {

	public static void main(String[] args) throws EncryptedDocumentException, IOException{
		System.out.println(ToReadexcel.fromExcel("Sheet1", 9, 5));
		System.out.println(ToReadexcel.fromExcel("sheet1", 9, 6));
	}
}
