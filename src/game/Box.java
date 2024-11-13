package game;

public class Box extends Item{
    
    public Box(String n, String d){
        super(n, d);
    }

    public Item openBox(){
        if(Game.find("ball")!=null){
            Item note2 = new Item("note2","You're close! The key to the exit door is safely stored in the owner's office");
            return note2;
        }
        else{
            Game.print("The box is too high! Knock it down!");
        }
    return null;
    }
}
