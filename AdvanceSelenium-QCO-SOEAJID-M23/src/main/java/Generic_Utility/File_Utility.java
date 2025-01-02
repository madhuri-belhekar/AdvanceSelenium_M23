package Generic_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
	/**
	 * This method is used to read data from properties file
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author ADMIN
	 */
	public String getKeyAndValuePair(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\propertiesfile.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
	}
	
}
