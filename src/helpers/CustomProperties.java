package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.ParseException;


public class CustomProperties {		
	
	public Properties LoadProperties(String xmlFile)  {
		try {
			
			Properties properties = new Properties();
			properties.loadFromXML(new FileInputStream(xmlFile));
			return properties;
			
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	public JsonObject loadFromJSon(String file) {
		
		try {
			
			java.io.FileReader rFile = new java.io.FileReader(file);			
			JsonObject jObject = Json.parse(rFile).asObject();
			return jObject;
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
		}catch (UnsupportedOperationException e) {
			e.printStackTrace();
		}
		return null;	      
	}
}
