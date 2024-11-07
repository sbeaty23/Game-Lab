package game;

import java.util.HashMap;

public class Room {
	private String description;
	private Room roomEast;
	private Room roomWest;
	private Room roomNorth;
	private Room roomSouth;
	private Room roomUp;
	private Room roomDown;
	private HashMap<String, Item> things = new HashMap<String,Item>();
	private boolean lock;
	private String name;
	
	public Room(String d, String n) {
		description = d;
		name = n;
	}
	
	
	
	public Room getExit(char p) {
		if(p=='w') {
			return roomWest;
		}
		else if(p=='e') {
			return roomEast;
		}
		else if(p=='n') {
			return roomNorth;
		}
		else if(p=='s') {
			return roomSouth;
		}
		else if(p=='u') {
			return roomUp;
		}
		else if(p=='d') {
			return roomDown;
		}
		else {
			return null;
		}
	}
	
	
	
	public void addExit(Room r, char p ) {
		if(p=='w') {
			roomWest = r;
		}
		else if(p=='e') {
			roomEast = r;
		}
		else if(p=='n') {
			roomNorth = r;
		}
		else if(p=='s') {
			roomSouth = r;
		}
		else if(p=='u') {
			roomUp = r;
		}
		else if(p=='d') {
			roomDown = r;
		}
	}
	
	public void addItem(Item i,String s) {
		things.put(s,i);
	}
	
	public Item getItem(String s) {
		return things.get(s);
	}
	
	public Item takeItem(String s) {
		Item x = things.get(s);
		things.remove(s);
		return x;
	}
	
	public String toString() {
		String s = description;
		return s;
	}
	public void lockRoom(){
		lock = true;
	}

	public void unlockRoom(){
		lock = false;
	}

	public boolean getLocked(){
		return lock;
	}

	public void setName(String n){
		name = n;
	}

	public String getName(){
		return name;
	}
}
