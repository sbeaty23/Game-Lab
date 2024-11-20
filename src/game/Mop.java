package game;
public class Mop extends Item {
    
    public Mop(String n, String d){
        super(n, d);
    }

    @Override
    public void use(){
        Game.print("You can't use the mop here");
    } //TODO: Add support for using the mop to knock out NPCs. The purpose of this will be to allow for an escape, as you can't leave while staff are watching. 
}
