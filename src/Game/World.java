package game;
//TODO: make all room names one word w/o spaces and add items and characters to descriptions
public class World {
	public static Room buildWorld(){
		Room lobby = new Room("lobby");
		Room ownerOffice = new Room("office");
		Room arcade = new Room("arcade");
		Room casino = new Room("casino");
		Room hallway1p1 = new Room("Hall 1 Part 1");
		Room hallway1p2 = new Room("Hall 1 Part 2");
		Room laundry = new Room("Laundry Room");
		Room maintenance = new Room("maintenance");
		Room hallway2p1 = new Room("Hall 2 Part 1");
		Room hallway2p2 = new Room("Hall 2 Part 2");
		Room hallway2p3 = new Room("Hall 2 Part 3");
		Room rm201 = new Room("Room 201");
		Room rm202 = new Room("Room 202");
		Room rm203 = new Room("Room 203");
		Room hallway3p1 = new Room("Hall 3 Part 1");
		Room hallway3p2 = new Room("Hall 3 Part 2");
		Room hallway3p3 = new Room("Hall 3 Part 3");		
		Room rm301 = new Room("Room 301");
		Room rm302 = new Room("Room 302");
		Room rm303 = new Room("Room 303");
		Room stairs0 = new Room("Basement stairs");
		Room stairs1 = new Room("Lobby Stairs");
		Room stairs2 = new Room("2nd Floor Stairs");
		Room stairs3 = new Room( "3rd Floor Stairs" );
		Room freedom = new Room("freedom");
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
		Puppy puppy  = new Puppy();
		CasinoWorker casinoWorker = new CasinoWorker("Will", "A pretty mean guy");
		Housekeeper housekeeper = new Housekeeper("Katie", "A friendly housekeeper");
		
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
		// maintenance.addItem(mop, "mop");
		maintenance.lockRoom();
		
		lobby.addExit(arcade, 'e');
		lobby.addExit(ownerOffice, 's');
		lobby.addExit(stairs1, 'w');
		lobby.addItem(roomKey, "Key201");
		lobby.addItem(mop, "mop");	
		lobby.addItem(ball,"ball");
		
		ownerOffice.addExit(lobby, 'n');
		ownerOffice.addItem(safe,"safe");
		
		arcade.addExit(casino, 'e');
		arcade.addExit(lobby, 'w');
		arcade.addItem(coin,"Coin");
		arcade.addItem(gameCard, "GameCard");
		arcade.addItem(soda, "soda");
		arcade.addNPC("Puppy", puppy);
		
		
		casino.addExit(freedom,'e');
		casino.addExit(arcade, 'w');
		casino.addItem(combo, "combo");
		casino.addNPC("Will", casinoWorker);

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
		hallway3p1.addNPC("Katie", housekeeper);
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
