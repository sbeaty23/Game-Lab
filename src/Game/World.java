package game;

public class World {
	public static Room buildWorld(){
		Room lobby = new Room("You are in the lobby","lobby");
		Room ownerOffice = new Room("You are in the owner's office","office");
		Room arcade = new Room("You are in the arcade","arcade");
		Room casino = new Room("You are in the casino","casino");
		Room hallway1p1 = new Room("You are in the basement hallway, in front of the laundry room","Hall 1 Part 1");
		Room hallway1p2 = new Room("You are in the basement hallway, in front of the maintenance room","Hall 1 Part 2");
		Room laundry = new Room("You are in the laundry room","Laundry Room");
		Room maintenance = new Room("You are in the maintenance room","maintenance");
		Room hallway2p1 = new Room("You are in the second floor hallway, in front of room 201","Hall 2 Part 1");
		Room hallway2p2 = new Room("You are in the second floor hallway, in front of room 202","Hall 2 Part 2");
		Room hallway2p3 = new Room("You are in the second floor hallway, in front of room 203","Hall 2 Part 3");
		Room rm201 = new Room("You are in room 201","Room 201");
		Room rm202 = new Room("You are in room 202","Room 202");
		Room rm203 = new Room("You are in room 203","Room 203");
		Room hallway3p1 = new Room("You are in the third floor hallway, in front of room 301","Hall 3 Part 1");
		Room hallway3p2 = new Room("You are in the third floor hallway, in front of room 302","Hall 3 Part 2");
		Room hallway3p3 = new Room("You are in the third floor hallway, in front of room 303","Hall 3 Part 3");		
		Room rm301 = new Room("You are in room 301","Room 301");
		Room rm302 = new Room("You are in room 302","Room 302");
		Room rm303 = new Room("You are in room 303","Room 303");
		Room stairs0 = new Room("You are in the basement stairway","Basement stairs");
		Room stairs1 = new Room("You are in the first floor stairway","Lobby Stairs");
		Room stairs2 = new Room("You are in the second floor stairway","2nd Floor Stairs");
		Room stairs3 = new Room("You are in the thrid floor stairway", "3rd Floor Stairs" );
		Room freedom = new Room("Congratulations! You've escaped the hotel!","freedom");
		Item roomKey = new Item("Key201","To get into your room");
		Item coin = new Item("Coin", "It's your lucky day!");
		Item gameCard = new Item("GameCard", "To play all the games you want");
		Item soda = new Item("Soda","A refreshing beverage");
		Safe safe = new Safe("safe", "looks cool");
		Combination combo = new Combination("combo", "To get into the safe");
		Key freedomKey = new Key("Exit Key", "Key to freedom");
		Item note = new Item("note","Your ticket to freedom might be dirty. Go get some cleaning supplies!");
		Key maintenanceKey = new Key("key1-2","Key to maintenance");
		Mop mop = new Mop("mop","To clean. Or knock someone out. Maybe both. Your call");
		Item note3 = new Item("note3","This room is locked! Maybe you should play a game in the arcade.");
		Money money = new Money("money","To get casino chips. Or bribe someone. Your call");
		Ball ball = new Ball("ball","To throw around. Maybe to knock something down. Up to you");
		Box box = new Box("box", "Well, open it.");
		
		stairs3.addExit(stairs2, 'd');
		stairs3.addExit(hallway3p1, 'e');
		
		stairs2.addExit(stairs1, 'd');
		stairs2.addExit(stairs3, 'u');
		stairs2.addExit(hallway2p1, 'e');		
		
		stairs1.addExit(stairs2, 'u');
		stairs1.addExit(stairs0, 'd');
		stairs1.addExit(lobby, 'e');
		
		stairs0.addExit(stairs1, 'u');
		stairs0.addExit(hallway1p1, 'e');
		
		laundry.addExit(hallway1p1, 'u');
		
		maintenance.addExit(hallway1p2, 'w');
		maintenance.addItem(freedomKey, "exitKey");
		maintenance.addItem(mop, "mop");
		maintenance.lockRoom();
		
		lobby.addExit(arcade, 'e');
		lobby.addExit(ownerOffice, 's');
		lobby.addExit(stairs1, 'w');
		lobby.addItem(roomKey, "Key201");	
		
		ownerOffice.addExit(lobby, 'n');
		ownerOffice.addItem(safe,"safe");
		
		arcade.addExit(casino, 'e');
		arcade.addExit(lobby, 'w');
		arcade.addItem(coin,"Coin");
		arcade.addItem(gameCard, "GameCard");
		arcade.addItem(soda, "soda");
		
		
		casino.addExit(freedom,'e');
		casino.addExit(arcade, 'w');
		casino.addItem(combo, "combo");

		freedom.lockRoom();
		
		hallway1p1.addExit(laundry, 'd');
		hallway1p1.addExit(hallway1p2, 'e');
		hallway1p1.addExit(stairs0, 'w');
		hallway1p2.addExit(maintenance, 'e');
		hallway1p2.addExit(hallway1p1, 'w');
		hallway1p2.addItem(note3,"note3");
		
		hallway2p1.addExit(hallway2p2,'e');
		hallway2p1.addExit(stairs2,'w');
		hallway2p1.addExit(rm201,'d');
		hallway2p1.addItem(note, "note");
		hallway2p2.addExit(hallway2p3,'e');
		hallway2p2.addExit(hallway2p1,'w');
		hallway2p2.addExit(rm202,'d');
		hallway2p3.addExit(hallway2p2,'w');
		hallway2p3.addExit(rm203,'d');
		
		rm201.addExit(hallway2p1, 'u');
		rm201.addItem(money, "money");
		rm202.addExit(hallway2p2, 'u');
		rm203.addExit(hallway2p3, 'u');
		
		hallway3p1.addExit(hallway3p2,'e');
		hallway3p1.addExit(stairs3,'w');
		hallway3p1.addExit(rm301,'d');
		hallway3p2.addExit(hallway3p3,'e');
		hallway3p2.addExit(hallway3p1,'w');
		hallway3p2.addExit(rm302,'d');
		hallway3p3.addExit(hallway3p2,'w');
		hallway3p3.addExit(rm303,'d');
		
		rm301.addExit(hallway3p1, 'u');
		rm301.addItem(maintenanceKey, "maintenanceKey");
		rm302.addExit(hallway3p2, 'u');
		rm303.addExit(hallway3p3, 'u');
	
		return lobby;
	}
}
