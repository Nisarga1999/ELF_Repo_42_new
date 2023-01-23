package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ToReadDataFromPropertiesFile{

	public static void main(String[] args) throws IOException {
		//srep1:creating input stream type object
		File absPath = new File("./testData/configaration.properties");
		FileInputStream fis = new FileInputStream(absPath);
		
		//step2:Creating object of file type
		Properties properties = new Properties();
		properties.load(fis);
		
		//step3:read method
		String name = properties.get("name").toString();
		System.out.println(name);
		
		System.out.println(properties.get("url").toString());
		
				
		
		
	}
	
}
