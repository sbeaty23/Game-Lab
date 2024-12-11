package game;

public class ArcadeGamer extends NPC{

    public ArcadeGamer(String n, String d){
        super(n, d);
    }

    @Override
    public void talk(){
        Game.print(this.getName()+"is too focused on their game to talk to you right now.");
    }
    
}
