package game;

public class World {
	public static Room buildWorld(){
		Room lobby = new Room("You are in the lobby");
		Room ownerOffice = new Room("You are in the owner's office");
		Room arcade = new Room("You are in the arcade");
		Room casino = new Room("You are in the casino");
		Room hallway1p1 = new Room("You are in the basement hallway, in front of the laundry room");
		Room hallway1p2 = new Room("You are in the basement hallway, in front of the maintenance room");
		Room laundry = new Room("You are in the laundry room");
		Room maintenance = new Room("You are in the maintenance room");
		Room hallway2p1 = new Room("You are in the second floor hallway, in front of room 201");
		Room hallway2p2 = new Room("You are in the second floor hallway, in front of room 202");
		Room hallway2p3 = new Room("You are in the second floor hallway, in front of room 203");
		Room rm201 = new Room("You are in room 201");
		Room rm202 = new Room("You are in room 202");
		Room rm203 = new Room("You are in room 203");
		Room hallway3p1 = new Room("You are in the third floor hallway, in front of room 301");
		Room hallway3p2 = new Room("You are in the third floor hallway, in front of room 302");
		Room hallway3p3 = new Room("You are in the third floor hallway, in front of room 303");		
		Room rm301 = new Room("You are in room 301");
		Room rm302 = new Room("You are in room 302");
		Room rm303 = new Room("You are in room 303");
		Room stairs0 = new Room("You are in the basement stairway");
		Room stairs1 = new Room("You are in the first floor stairway");
		Room stairs2 = new Room("You are in the second floor stairway");
		Room stairs3 = new Room("You are in the thrid floor stairway");
		Room freedom = new Room("Congratulations! You've escaped the hotel!");
		Item roomKey = new Item("Key201","To get into your room");
		Item coin = new Item("Coin", "It's your lucky day!");
		Item gameCard = new Item("GameCard", "To play all the games you want");
		Item soda = new Item("Soda","A refreshing beverage");
		Safe safe = new Safe("safe", "looks cool");
		Combination combo = new Combination("combo", "To get into the safe");
		
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
		
		maintenance.addExit(hallway1p2, 'u');
		
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
		
		hallway1p1.addExit(laundry, 'd');
		hallway1p1.addExit(hallway1p2, 'e');
		hallway1p1.addExit(stairs0, 'w');
		hallway1p2.addExit(maintenance, 'd');
		hallway1p2.addExit(hallway1p1, 'w');
		
		hallway2p1.addExit(hallway2p2,'e');
		hallway2p1.addExit(stairs2,'w');
		hallway2p1.addExit(rm201,'d');
		hallway2p2.addExit(hallway2p3,'e');
		hallway2p2.addExit(hallway2p1,'w');
		hallway2p2.addExit(rm202,'d');
		hallway2p3.addExit(hallway2p2,'w');
		hallway2p3.addExit(rm203,'d');
		
		rm201.addExit(hallway2p1, 'u');
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
		rm302.addExit(hallway3p2, 'u');
		rm303.addExit(hallway3p3, 'u');
	
		return lobby;
	}
}
