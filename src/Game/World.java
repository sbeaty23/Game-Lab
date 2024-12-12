package game;
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
		Safe safe = new Safe("safe", "looks cool");
		Combination combo = new Combination("combo", "To get into the safe");
		Note note = new Note("note","Getting out of here isn't as hard as it seems. Look in room 202 for something that'll help");
		Note note2 = new Note("note", "Maybe there's something useful on the third floor. Check out the rooms up there!");
		Mop mop = new Mop("mop","To clean. Or knock someone out. Maybe both. Your call");
		Note note3 = new Note("note","The mop  in room 302 is good for more than cleaning floors, you know. The housekeeper might also be able to give you some help.");
		Ball ball = new Ball("ball","To throw around. Maybe to knock something down. Up to you");
		Box box = new Box("box", "Well, open it.");
		Box box2 = new Box("box","well,open it.");
		Box box3 = new Box("box","well,open it.");
		Puppy puppy  = new Puppy();
		CasinoWorker casinoWorker = new CasinoWorker("will", "A pretty mean guy");
		Housekeeper housekeeper = new Housekeeper("katie", "A friendly housekeeper");
		LobbyWorker lobbyWorker = new LobbyWorker("derek", "The lobby's front desk worker");
		Owner owner = new Owner("alex", "The owner of the hotel");
		ArcadeGamer darrin = new ArcadeGamer("darrin", "A cool guy from 1977");
		ArcadeGamer allen = new ArcadeGamer("allen", "A sports superfan from 2016");
		ArcadeWorker arcadeWorker = new ArcadeWorker("sam", "The owner's daughter and arcade stand worker.");
		Gambler gambler = new Gambler("james", "A gambler from 1955");

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
		
		lobby.addExit(arcade, 'e');
		lobby.addExit(ownerOffice, 's');
		lobby.addExit(stairs1, 'w');	
		lobby.addNPC("derek", lobbyWorker);
		lobby.addNPC("alex", owner);

		ownerOffice.addExit(lobby, 'n');
		ownerOffice.addItem(safe,"safe");
		ownerOffice.lockRoom();
		
		arcade.addExit(casino, 'e');
		arcade.addExit(lobby, 'w');
		arcade.addNPC("puppy", puppy);
		arcade.addNPC("darrin", darrin);
		arcade.addNPC("allen", allen);
		arcade.addNPC("sam", arcadeWorker);
		arcade.addItem(ball,"ball");
		
		
		casino.addExit(freedom,'e');
		casino.addExit(arcade, 'w');
		casino.addItem(combo, "combo");
		casino.addNPC("will", casinoWorker);
		casino.addNPC("james", gambler);

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
		rm201.addItem(note, "note");
		rm201.addItem(box, "box");
		rm202.addExit(hallway2p2, 'u');
		rm202.addItem(note2, "note");
		rm202.addItem(box2, "box");
		rm203.addExit(hallway2p3, 'u');
		
		hallway3p1.addExit(hallway3p2,'e');
		hallway3p1.addExit(stairs3,'w');
		hallway3p1.addExit(rm301,'d');
		hallway3p1.addNPC("katie", housekeeper);
		hallway3p2.addExit(hallway3p3,'e');
		hallway3p2.addExit(hallway3p1,'w');
		hallway3p2.addExit(rm302,'d');
		hallway3p3.addExit(hallway3p2,'w');
		hallway3p3.addExit(rm303,'d');
		
		rm301.addExit(hallway3p1, 'u');
		rm302.addExit(hallway3p2, 'u');
		rm302.addItem(mop,"mop");
		rm303.addExit(hallway3p3, 'u');
		rm303.addItem(note3,"note");
		rm303.addItem(box3, "box");
	
		return lobby;
	}
}
