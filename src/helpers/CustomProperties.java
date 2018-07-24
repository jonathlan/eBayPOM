package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class CustomProperties {		
		
	public Properties LoadProperties(String xmlFile) throws InvalidPropertiesFormatException, FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.loadFromXML(new FileInputStream(xmlFile));
		return properties;
	}
}
