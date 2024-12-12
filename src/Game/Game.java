package game;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Game {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Item> inventory = new ArrayList<Item>();
	static HashMap<String,String> descriptions = new HashMap<String,String>();	
	static HashMap<String,Room> rooms = new HashMap<String, Room>();
	static Room currentRoom = World.buildWorld();
	static String[] commands;
	static int gameOver = 0;
	static GameWindow window = new GameWindow();
	static Money money = new Money("money", "For casino chips. Or bribery. Your call");
	static CasinoChips chips = new CasinoChips("chips", "For money and gambling");

	public static void main(String[] args) {
		addDescriptions();
		inventory.add(money);//Starts player with 0 dollars
		inventory.add(chips);//Starts player with 500 casino chips
		Game.print("Enjoy the game!");
		cutscene();	
		printHelpMenu();
		Game.print(currentRoom);
	}
	
	public static void runGame() {
		
		do {
			processCommand(input.nextLine());
		} while(gameOver==0);
		input.close();
	}

	public static void processCommand(String command){
		commands = command.split(" ");
		if(gameOver>0){
			if(gameOver==1){
				Game.print("The game is over, you cannot do anything else except save.");
				if(commands[0].equals("save")){
					saveGame(commands[1]);
				}
			}
			else if(gameOver==2){
				Game.print("The game is over. You must restart. Karma's a bitch.");
			}
			else if(gameOver==3){
				Game.print("You've already escaped! Celebrate your victory and close out!");
			}
		}
		else{
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
						else if(currentRoom.getExit(commands[0].charAt(0)).getLocked()==true){
							if(currentRoom.getExit(commands[0].charAt(0)).getName().equals("office")){
								Game.print("You can't go in there while the owner is looking. If only there was a way to change that...");
							}
							else{
								Game.print("This room is locked. You need the key!");
							}	
						}
						else if(currentRoom.getExit(commands[0].charAt(0)).getName().equals("freedom")&&!currentRoom.getExit(commands[0].charAt(0)).getNPC("Will").knockedOut){
							Game.print("The casino worker catches you trying to leave and sends you back to your room. Darn!");
							currentRoom = currentRoom.getExit('w').getExit('w').getExit('w').getExit('u').getExit('e').getExit('d');
						}
						else{
							currentRoom = currentRoom.getExit(commands[0].charAt(0));
							Game.print(currentRoom);
							if(currentRoom.getName().equals("freedom")){
								gameOver = 3;
							}
						}
					}
					catch(CantGoThatWayException e) {
						Game.print("You can't go that way!");
					}
					break;
				case "take":
					if(currentRoom.getItem(commands[1].toLowerCase())!=null) {
						if(commands[1].equals("safe")){
							Game.print("Don't take the safe! Just open it!");
						}
						else{
							Game.print("You pick up the "+commands[1]+"!");
							inventory.add(currentRoom.takeItem(commands[1]));
							Game.currentRoom.setDescription(Game.currentRoom.getName()+"_A");
							Game.print(currentRoom);
						}
						
					}
					else {
						Game.print("No item found");
					}
					break;
				case "look":
					if(currentRoom.getItem(commands[1].toLowerCase())!=null) {
						Game.print(currentRoom.getItem(commands[1].toLowerCase()).getDescription());
					}
					else if(currentRoom.getItem(commands[1].toLowerCase())==null) {
						if(Game.find(commands[1].toLowerCase())!=null){
							Game.print(Game.find(commands[1].toLowerCase()).getDescription());
						}
						else{
							Game.print("Item doesn't exist");
						}
					}
					break;
				case "i":
					if(inventory.isEmpty()) {
						Game.print("Inventory is empty");
					}
					else {
						for (Item i: inventory) {
							Game.print(i+ " ");
						}
					}
					break;
				case "use":
					try{
						if(Game.find(commands[1].toLowerCase())!=null){
							Game.find(commands[1].toLowerCase()).use();
						}
						else{
							Game.print("Item doesn't exist");
						}
					}
					catch (RuntimeException e) {
						Game.print("Error doing action, check your input");
					}	
					break;
				case "open":
					if(currentRoom.getItem(commands[1].toLowerCase())!=null){
						currentRoom.getItem(commands[1].toLowerCase()).open();
					}
					else{
						Game.print("Item doesn't exist");
					}
				break;
				case "talk":
					try{
						currentRoom.getNPC(commands[1].toLowerCase()).talk();
					}
					catch(RuntimeException e){
						Game.print("Erorr doing action. Check your input and try again.");
					}
					break;
				case "save":
					String name = commands[1];
					saveGame(name);
					break;
				case "load":
					String name2 = commands[1];
					loadGame(name2);
					break;
				case "x":
					Game.print("Thanks for playing!");
					gameOver = 1;
					break;
				case "h":
				case "help":
					printHelpMenu();
					break;
				case "bribe":
					if(find("money").getName().equals("money")&&currentRoom.getNPC(commands[1].toLowerCase()).isBribed==false){
						try{
							currentRoom.getNPC(commands[1].toLowerCase()).bribe();
							money.setAmount(money.getAmount()-100);
						}
						catch(RuntimeException e){
							Game.print("Error doing action. Check your input.");
						}
					}
					else{
						Game.print("You can't bribe "+currentRoom.getNPC(commands[1].toLowerCase()).getName()+"!");
					}
					break;
				case "gamble":
					if(currentRoom.getName().equals("casino")&&chips.getAmount()>50){
						int num = (1 + (int)(Math.random() * ((5 - 1) + 1)));    
						if(num>3){
							chips.setAmount(chips.getAmount()-50);
							Game.print("Loss! You lost 50 chips!");
						}
						else{
							chips.setAmount(chips.getAmount()+100);
							Game.print("Win! You gained 100 chips!");
						}
					}
					else{
						Game.print("Sorry, you can't gamble right now.");
					}
					break;
				case "exchange":
					int x = Integer.parseInt(commands[2]);
					if(x<=0){
						Game.print("You can't exchange zero or negative amount of currency.");
					}
					else if(commands[1].toLowerCase().equals("money")&&x>0){
						money.exchange(x);
					}
					else if(commands[1].toLowerCase().equals("chips")&&x>0){
						chips.exchange(x);
					}
					else{
						Game.print("Sorry, you can't exchange "+commands[1]+".");
					}
					break;
				case "balance":
					if(commands[1].toLowerCase().equals("chips")){
						Game.print(chips.getAmount());
					}
					else if(commands[1].toLowerCase().equals("money")){
						Game.print(money.getAmount());
					}
					else{
						Game.print("This item doesn't have a balance or doesn't exist");
					}
					break;
				default:
					Game.print("I don't know what that means.");
				}
			GameWindow.textF.setText(null);
		}
	}
	

	public static void printHelpMenu(){
		Game.print("Controls:");
		Game.print("To go in a direction, enter the letter of the direction");
		Game.print("Directions:");
		Game.print("\t n - North");
		Game.print("\t s - South");
		Game.print("\t e - East");
		Game.print("\t w - West");
		Game.print("\t u - Up");
		Game.print("\t d - Down");
		Game.print("To take an item, enter 'take' followed by the name of the item");
		Game.print("To look at an item, enter 'look' followed by the name of the item");
		Game.print("To use an item, enter 'use' followed by the name of the item");
		Game.print("To use an item on an NPC, enter 'use' followed by the name of the item, followed by 'on', followed by the name of the character.");
		Game.print("\t Format: 'use object on character'");
		Game.print("To open an item, enter 'open' followed by the name of the item");
		Game.print("To talk to an NPC, enter 'talk' followed by the name of the character");
		Game.print("To attempt to bribe an NPC, enter 'bribe' followed by the name of the character");
		Game.print("To gamble, enter 'gamble' when in the casino");
		Game.print("To exchange currency, enter 'exchange' followed by the type of currency and the amount when in the casino");
		Game.print("To check your balance of money or chips, enter 'balance' followed by the currency type");
		Game.print("To save the game, enter 'save' followed by the desired file name");
		Game.print("To load a saved game, enter 'load' followed by the desired file name");
		Game.print("To quit the game, enter 'x'");
		Game.print("To refer back to this menu, enter 'h' or 'help'");
	}

	public static void print(Object obj){
		window.textArea.append(obj.toString() + "\n");
	}

	public static void cutscene(){
		Game.print("Backstory:");
		Game.print("You walk into the hotel, greeted by the owner.");
		Game.print("'Hello! Welcome to the Lotus hotel!', he says. 'Let me give you a tour!");
		Game.print("He shows you around the lobby, and points out the arcade and casino to the east.");
		Game.print("You walk into the arcade and see a teenager playing a game, wearing a Chicago Cubs jersey.");
		Game.print("He notices you. 'I can't believe the Cubs finally won the World Series!' he exclaims excitedly.");
		Game.print("Maybe he's still really happy about it. You shrug it off and move forward.");
		Game.print("You notice another man, he seems upset.");
		Game.print("'I can't believe Jimmy Carter got elected president!', he says.");
		Game.print("'What? That was 47 years ago!' You exclaim. The man, puzzled, points out that it's 1977.");
		Game.print("The owner, worried, rushes you to the Casino.");
		Game.print("He shows you around, and keeps you from talking to the man gambling in the corner.");
		Game.print("You both walk back to the lobby, where he gives you  your room key, a card, and a slip of paper.");
		Game.print("'The card is unlimited play in the arcade, and the paper notes you have 2500 free chips from the casino. Enjoy your stay!");
		Game.print("Puzzled, you come to the conclusion that sticking around is a bad idea, and that you should get out of here.");
		inventory.add(new Item("key201","your room key"));
		inventory.add(new Item("card","For unlimited play at the arcade."));


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
			Game.print("File not found");
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
			Game.print("File " + n +" not found");
		}
		catch(IOException ex){
			Game.print("Error saving game");
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
			Game.print("File " + n + " not found");
		}
		catch (IOException ex){
			Game.print("Error loading game");
		}
		catch (ClassNotFoundException ex){
			Game.print("Error loading game");
		}

	}
}
