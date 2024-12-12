package game;

public class Safe extends Item {
    
    public Safe(String n, String d) {
        super(n, d);
    }

    @Override
    public void open() {
        if(Game.find("combo").getName().equals("combo")){
            Game.print("Using the combination, you open the safe and find the key to the casino door inside! The freedomkey! Naturally, you pocket the key");
            Key freedomkey = new Key("freedomkey", "key to freedom");
            Game.inventory.add(freedomkey);
        }
        else{
            Game.print("The safe is locked and you don't have the combination");
        }
    }    
}
