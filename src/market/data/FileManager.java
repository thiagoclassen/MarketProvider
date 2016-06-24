package market.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author Thiago
 *
 */
public class FileManager {
	
	private String fileName;
	private String line;
	private BufferedReader bufferedReader; 
	
	public FileManager(String fileName){
		this.fileName = fileName;
		try {
			this.bufferedReader = new BufferedReader(new FileReader(this.fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file '" + this.fileName + "'");
		}
	}
	
	public void printFile(){
		try {
			while ((this.line = this.bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("Error reading file '" + this.fileName + "'");
		}
	}
	
	public void closeBuffer(){
		try {
			this.bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
