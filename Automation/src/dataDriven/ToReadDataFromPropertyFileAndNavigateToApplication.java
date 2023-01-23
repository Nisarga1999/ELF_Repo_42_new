package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToReadDataFromPropertyFileAndNavigateToApplication {

	public static void main(String[] args) throws IOException {
		//srep1:creating input stream type object
				File absPath = new File("./testData/SampleScriptData.properties");
				FileInputStream fis = new FileInputStream(absPath);
				
				//step2:Creating object of file type
				Properties properties = new Properties();
				properties.load(fis);
				
				//step3:Read methods
				String key = properties.get("ChromeBrowserKey").toString();
				String value = properties.get("ChromeDriverPath").toString();
				String url = properties.get("url").toString();
				
				System.setProperty(key, value);
				WebDriver driver=new ChromeDriver();
				driver.get(url);
	}

}
