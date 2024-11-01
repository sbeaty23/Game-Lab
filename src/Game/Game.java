package game;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	static ArrayList<Item> inventory = new ArrayList<Item>();
	static Room currentRoom = World.buildWorld();
	public static void main(String[] args) {
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
				currentRoom = currentRoom.getExit(commands[0].charAt(0));
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
				for(Item i: inventory){
					if(i.getName().equals(commands[1])) {
						i.open();
						break;
					}
				System.out.println("Item doesn't exist");
				}
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
	
	public static Item find(String n){
		for(Item i:inventory) {
			if(i.getName().equals(n)) {
				return i;
			}
		}
		return null;
	}
}
