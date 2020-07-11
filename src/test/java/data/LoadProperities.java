package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperities {
	public static Properties userData=loadProperities(System.getProperty("user.dir")+"\\src\\main\\java\\dataProperites\\userData.properties");
	private static Properties loadProperities(String path){
		Properties pro= new Properties();
		try {
		FileInputStream stream = new FileInputStream(path);
		try {
			pro.load(stream);
		} catch (IOException e) {
			System.out.println("error occurred"+e.getMessage());
		}	

		} catch (FileNotFoundException e) {
			System.out.println("error occurred"+e.getMessage());
		}
			
		return pro;
	}
	
		
		
		
	
}
