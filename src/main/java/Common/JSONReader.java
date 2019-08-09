package Common;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	static String data;
	public static String readJSONData(String keyword) throws IOException, ParseException{
	Reader reader = new FileReader("data/testdata.json");
	JSONParser parser = new JSONParser();
	JSONArray jsonArr = (JSONArray)parser.parse(reader);
	for(Object obj : jsonArr){
	JSONObject jo = (JSONObject)obj;			
	data = (String)jo.get(keyword);
	}
	return data;
	}
	public static void main(String[] args) throws IOException, ParseException{
	String a = JSONReader.readJSONData("Blog URL");
	System.out.println(a);
	}

}
