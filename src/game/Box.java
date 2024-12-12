package game;

public class Box extends Item{
    
    public Box(String n, String d){
        super(n, d);
    }

    @Override
    public void open(){
        if(Game.find("ball")!=null){
            Game.print("You found a note in the box! It reads: "+Game.currentRoom.getItem("note").getDescription());
            Game.currentRoom.setDescription(Game.currentRoom.getName()+"_A");
            Game.print(Game.currentRoom);
        }
        else{
            Game.print("The box is too high! Knock it down!");
        }
    }
}
