package game;

public class Ball extends Item {
    
    public Ball(String n, String d){
        super(n, d);
    }

    @Override
    public void use(){
        try{
            if(Game.currentRoom.getName().equals("arcade")){
                Puppy.playFetch();
            }
            else if (Game.currentRoom.getItem("box").getName()!=null){
                Game.currentRoom.getItem("box").open();
            }
            else{
                Game.print("You throw the ball against the wall. It comes back to you and you catch it. Good job.");
            }
        }
        catch(NullPointerException e){
            Game.print("You throw the ball against the wall. It comes back to you and you catch it. Good job.");
        }
    }
}
