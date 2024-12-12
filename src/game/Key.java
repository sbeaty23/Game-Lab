package game;

public class Key extends Item {
    public Key(String n, String d){
        super(n, d);
    }

    @Override
    public void use(){
        if(Game.find("freedomkey")!=null){
            if(Game.find("freedomkey").getDescription().split(" ")[2].equals(Game.currentRoom.getExit('e').getName())){
                Game.currentRoom.getExit('e').unlockRoom();
                Game.print("You unlock the door!");
                return;
            }
        }
        Game.print("You don't have the key!");
    }
}
