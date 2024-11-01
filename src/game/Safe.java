package game;

public class Safe extends Item {
    
    public Safe(String n, String d) {
        super(n, d);
    }

    @Override
    public void open() {
        for(Item i: Game.inventory){
            if(i.getName().equals("combo")){
                Game.print("Using the combination, you open the safe and find a diamond inside! Naturally, you povket the diamond");
                Item diamond = new Item("diamond", "A shiny gem!");
                Game.inventory.add(diamond);
                return;
            }
        }
        Game.print("The safe is locked and you don't have the combination");
    }
}
