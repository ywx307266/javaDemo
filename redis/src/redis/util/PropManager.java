package redis.util;

import java.io.IOException;
import java.util.Properties;

public class PropManager
{

	private static Properties pros=new Properties();
	
	private static String file="/redis/util/database.properties";
	static{
		try
		{
			pros.load(Object.class.getResourceAsStream(file));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key){
		
		if(pros.containsKey(key)){
			return pros.getProperty(key);
		}else{
			return null;
		}
	}
	
}
