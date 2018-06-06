package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class CustomProperties {	
	/*Driver's properties*/
	public static final String GENERIC_DRIVER_LOCATION = "C:\\testautomation\\libs\\drivers\\";
	public static final String CHROME_DRIVER_NAME = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_LOCATION = GENERIC_DRIVER_LOCATION + "chromedriver.exe";
	public static final String FIREFOX_DRIVER_NAME = "webdriver.gecko.driver";
	public static final String FIREFOX_DRIVER_LOCATION = GENERIC_DRIVER_LOCATION + "geckodriver.exe";
	
	/*WebPage URL*/
	public static final String MAIN_URL = "https://www.ebay.com/";
	
	public Properties LoadProperties(String xmlFile) throws InvalidPropertiesFormatException, FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.loadFromXML(new FileInputStream(xmlFile));
		return properties;
	}
}
