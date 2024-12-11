package game;

public class LobbyWorker extends NPC{

    public LobbyWorker(String n, String d){
        super(n, d);
    }
    
    @Override
    public void bribe(){
        Game.print("You bribe the front desk worker and he decides to look the other way. How helpful!");
        isBribed = true;
    }

    @Override
    public void talk(){
        Game.print("The desk worker can't talk, he has to keep working so the owner doesn't get mad.");
    }


}
