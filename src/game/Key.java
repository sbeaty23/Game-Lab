package game;

public class Key extends Item {
    public Key(String n, String d){
        super(n, d);
    }

    @Override
    public void use(){
        for(Item i: Game.inventory){
            if(i.getDescription().split(" ")[2].equals(Game.currentRoom.getExit('e').getName())){
                Game.currentRoom.getExit('e').unlockRoom();
                Game.print("You unlock the door!");
                break;
            }
        }
        Game.print("You don't have the key to this room!");
    }
}
