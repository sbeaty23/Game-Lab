package game;

import java.util.HashMap;
import java.io.*;

public class Room  implements Serializable{
	private Room roomEast;
	private Room roomWest;
	private Room roomNorth;
	private Room roomSouth;
	private Room roomUp;
	private Room roomDown;
	private HashMap<String, Item> things = new HashMap<String,Item>();
	private HashMap<String, NPC> characters = new HashMap<String, NPC>();
	private boolean lock;
	private String name;
	private String descLabel;
	
	public Room(String n) {
		name = n;
		descLabel = n;
		Game.rooms.put(n, this);
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

	public void addNPC(String n, NPC c){
		characters.put(n,c);
	}

	public NPC getNPC(String s){
		return characters.get(s);
	}
	
	
	public Item takeItem(String s) {
		if(s.equals("box")||s.equals("note")){
			Game.print("You can't take that!");
			return null;
		}
		else{
			Item x = things.get(s);
			things.remove(s);
			return x;
		}
	}

	public String getDescription(String n){
		return Game.descriptions.get(n);
	}

	public void setDescription(String n){
		descLabel = n;
	}

	public String toString() {
		return this.getDescription(descLabel);
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
