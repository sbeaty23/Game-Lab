package game;

public class Owner  extends NPC{
    
    public Owner(String n, String d){
        super(n, d);
    }

    @Override
    public void knockOut(){
        Game.print("The owner is knocked out! Now is your chance to go into his office!");
        knockedOut = true;
        Game.currentRoom.getExit('s').unlockRoom();
    }

    @Override
    public void talk(){
        say("I hope you're enjoying your stay!");
    }
}
