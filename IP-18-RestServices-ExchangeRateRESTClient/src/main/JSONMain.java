package main;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.stream.JsonParser;

/**
 * Parses a JSON file containing  a USD to EUR exchange rate from
 * 
 * @author milan.latinovic
 *
 */
public class JSONMain {
	
	public static final String JSON_FILE_NAME = "rate-exchange.json";
	/**
	 * Parse and display JSON file
	 * 
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		JsonParser parser = Json.createParser(new FileReader (JSON_FILE_NAME));
		
		while (parser.hasNext()) {
			JsonParser.Event event = parser.next(); 				
			if (event.equals(JsonParser.Event.KEY_NAME)) {
				String key = parser.getString();
				parser.next();
				String value = parser.getString();
				System.out.printf(">> %s: %s\n", key, value);
			}
		}
	}

}
