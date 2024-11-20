package game;
//This file is solely to test methods and see if they work
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Test {
    private static HashMap <String, String> map = new HashMap<String, String>();
    // public static void main(String[] args) {
	// 	addDescriptions();
	// 	for(String s: map.keySet()){
	// 		System.out.println(s+" "+map.get(s));
	// 	}
    // }

    public static void addDescriptions(){
		try{
			Scanner reader = new Scanner(new File("C:\\Users\\booms\\OneDrive\\Documents\\GitHub\\Game-Lab\\src\\game\\descriptions.txt"));
			while (reader.hasNextLine()){
				String key = reader.nextLine();
				String value = reader.nextLine();
				if(reader.hasNextLine()){
					String x = reader.nextLine();
				}
				map.put(key, value);
			}
				reader.close();
		}
		catch (FileNotFoundException ex){
			System.out.println("File not found");
		}
	}
}