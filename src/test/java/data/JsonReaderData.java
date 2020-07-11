package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReaderData {

	public String fname, lname, useremail, userpass;
	public void jsonReader() throws FileNotFoundException, IOException, ParseException {
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\dataFile.json";
		File srcFile= new File(filePath);
		JSONParser parser= new JSONParser();
		JSONArray myArray=(JSONArray)parser.parse(new FileReader(srcFile));

		for(Object jsonObject : myArray ){
			JSONObject person= (JSONObject) jsonObject;
			fname=(String) person.get(fname);
			lname=(String) person.get(lname);
			useremail=(String) person.get(useremail);
			userpass=(String) person.get(userpass);
		}
	}
}