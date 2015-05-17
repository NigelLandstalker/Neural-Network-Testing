package generalTesting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;

public class JsonTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ParseException {
		JSONObject obj = new JSONObject();
		File json = new File("src/file.json");
		obj.put("test", new Integer(1));

		FileWriter fileWriter = new FileWriter(json.getAbsolutePath());
		fileWriter.write(obj.toJSONString());
		fileWriter.flush();
		fileWriter.close();

		// JSONParser parser = new JSONParser();
		System.out.println(obj.get("test"));
	}

}
