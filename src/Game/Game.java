package game;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Game {
	static ArrayList<Item> inventory = new ArrayList<Item>();
	static HashMap<String,String> descriptions = new HashMap<String,String>();	
	static HashMap<String,Room> rooms = new HashMap<String, Room>();
	static Room currentRoom = World.buildWorld();
	public static void main(String[] args) {
		addDescriptions();
		runGame();
	}
	
	public static void runGame() {
		Scanner input = new Scanner(System.in);
		
		String[] commands;
		do {
			System.out.println(currentRoom);
			System.out.print("Where do you want to go? ");
			commands = input.nextLine().split(" ");
			
			switch(commands[0]) {
			case "e":
			case "w":
			case "n":
			case "s":
			case "u":
			case "d":
				try{
					if(currentRoom.getExit(commands[0].charAt(0))==null){
						throw new CantGoThatWayException("You can't go that way!");
					}
					if(currentRoom.getExit(commands[0].charAt(0)).getLocked()==true){
						System.out.println("This room is locked. You need the key!");
					}
					else{
						currentRoom = currentRoom.getExit(commands[0].charAt(0));
					}
				}
				catch(CantGoThatWayException e) {
					System.out.println("You can't go that way!");
				}
				break;
			case "take":
				if(currentRoom.getItem(commands[1])!=null) {
					inventory.add(currentRoom.takeItem(commands[1]));
				}
				else {
					System.out.println("No item found");
				}
				break;
			case "look":
				if(currentRoom.getItem(commands[1])!=null) {
					System.out.println(currentRoom.getItem(commands[1]).getDescription());
				}
				else if(currentRoom.getItem(commands[1])==null) {
					for(Item i:inventory) {
						if(i.getName().equals(commands[1])) {
							System.out.println(i.getDescription());
							break;
						}
				System.out.println("Item doesn't exist");
					}
				}
				break;
			case "i":
				if(inventory.isEmpty()) {
					System.out.println("Inventory is empty");
				}
				else {
					for (Item i: inventory) {
						System.out.println(i+ " ");
					}
				}
				break;
			case "use":
				for(Item i: inventory){
					if(i.getName().equals(commands[1])) {
						i.use();
						break;
					}
				System.out.println("Item doesn't exist");
				}
				break;
			case "open":
				if(currentRoom.getItem(commands[1])!=null){
					currentRoom.getItem(commands[1]).open();
				}
				else{
					System.out.println("Item doesn't exist");
				}
			break;
			case "save":
				System.out.println("Enter file name:");
				String name = input.nextLine();
				saveGame(name);
				break;
			case "load":
				System.out.println("Enter file name");
				String name2 = input.nextLine();
				loadGame(name2);
				break;
			case "x":
				System.out.print("Thanks for playing! \n");
				break;
			default:
				System.out.print("I don't know what that means \n");
			}
		} while(!commands[0].equals("x"));
		input.close();
	}
	public static void print(Object obj){
		System.out.println(obj.toString());
	}

	public static Room getCurrentRoom(){
		return currentRoom;
	}
	
	public static Item find(String n){
		for(Item i:inventory) {
			if(i.getName().equals(n)) {
				return i;
			}
		}
		return null;
	}

    public static void addDescriptions(){
		try{
			Scanner reader = new Scanner(new File("C:\\Users\\booms\\OneDrive\\Documents\\GitHub\\Game-Lab\\src\\game\\descriptions.txt"));
			while (reader.hasNextLine()){
				String key = reader.nextLine();
				String value = reader.nextLine();
				if(reader.hasNextLine()){
					String x = reader.nextLine();
				}
				descriptions.put(key, value);
			}
				reader.close();
		}
		catch (FileNotFoundException ex){
			System.out.println("File not found");
		}
	}
	public static void saveGame(String n){
		File f = new File(n);
		try{
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(currentRoom);
			oos.writeObject(inventory);
			oos.writeObject(rooms);
			oos.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File " + n +" not found");
		}
		catch(IOException ex){
			System.out.println("Error saving game");
		}
	}

	public static void loadGame(String n){
		try{
			File f  = new File(n);
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			currentRoom = (Room) ois.readObject();
			inventory = (ArrayList<Item>) ois.readObject();
			rooms = (HashMap<String,Room>) ois.readObject();
			ois.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File " + n + " not found");
		}
		catch (IOException ex){
			System.out.println("Error loading game");
		}
		catch (ClassNotFoundException ex){
			System.out.println("Error loading game");
		}

	}
}
