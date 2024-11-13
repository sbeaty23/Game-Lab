package game;

public class Money extends Item {
    
    public Money(String n,String d){
        super(n,d);
    }

    @Override
    public void use(){
        Game.print("You use the money to bribe them. Things just became a lot easier!");
    }
}
