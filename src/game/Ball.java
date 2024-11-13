package game;

public class Ball extends Item {
    
    public Ball(String n, String d){
        super(n, d);
    }

    @Override
    public void use(){
        if (Game.currentRoom.getName().equals("maintenance")){
            Game.print("You use the ball to knock down the box, inside, you find a note.");
        }
        else{
            Game.print("You throw the ball against the wall. It comes back to you and you catch it. Good job.");
        }
    }
}
