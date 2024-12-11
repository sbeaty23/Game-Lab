package game;

public class Box extends Item{
    
    public Box(String n, String d){
        super(n, d);
    }


    public void openBox(){
        if(Game.find("ball")!=null){
            Game.print("You found a note in the box! It reads: "+Game.currentRoom.getItem("note").getDescription());
        }
        else{
            Game.print("The box is too high! Knock it down!");
        }
    }
}
