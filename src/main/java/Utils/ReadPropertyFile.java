package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	
	public static String env="dev";
	public static Properties prop;
	
	public void readPropertyFile() throws IOException
	{
		if(env=="dev")
		{
			
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/dev.properties");
		 prop= new Properties();
		prop.load(fis);
		}
		
		if(env=="qa")
		{
			
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/qa.properties");
		prop= new Properties();
		prop.load(fis);
		}
		
		
	}
	
	
	public String getProperty(String key)
	{
		String value= prop.getProperty(key);
		return value;
		
		}
	}


