package game;

public class Safe extends Item {
    
    public Safe(String n, String d) {
        super(n, d);
    }

    @Override
    public void open() {
        for(Item i: Game.inventory){
            if(i.getName().equals("combo")){
                Game.print("Using the combination, you open the safe and find the key to the casino door inside! Naturally, you pocket the key");
                Key freedomKey = new Key("freedomKey", "The key to freedom");
                Game.inventory.add(freedomKey);
                return;
            }
        }
        Game.print("The safe is locked and you don't have the combination");
    }
}
