package market.data;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/**
 * @author Thiago
 *
 */
public class FileManager {

	public void teste() {
		JSONParser parser = new JSONParser();
		// String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		try {
			Object obj = parser.parse(new FileReader("items.JSON"));

			JSONArray array = (JSONArray) obj;

			System.out.println("The 2nd element of array");
			System.out.println(array.get(1));
			System.out.println();

		} catch (org.json.simple.parser.ParseException | IOException pe) {

			System.out.println("position: " + pe);
			System.out.println(pe);
		}
	}
}

// private String fileName;
// private String line;
// private BufferedReader bufferedReader;
//
// public FileManager(String fileName){
// this.fileName = fileName;
// try {
// this.bufferedReader = new BufferedReader(new FileReader(this.fileName));
// } catch (FileNotFoundException e) {
// System.out.println("Unable to open file '" + this.fileName + "'");
// }
// }
//
// public void printFile(){
// try {
// while ((this.line = this.bufferedReader.readLine()) != null) {
// System.out.println(line);
// }
// } catch (IOException e) {
// System.out.println("Error reading file '" + this.fileName + "'");
// }
// }
//
// public void closeBuffer(){
// try {
// this.bufferedReader.close();
// } catch (IOException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// }

// }
