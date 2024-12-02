package game;
public class Mop extends Item {
    
    public Mop(String n, String d){
        super(n, d);
    }

    @Override
    public void use(){
        if(Game.commands.length==4){
            Game.currentRoom.getNPC(Game.commands[3]).knockOut();
        }
        else{
            Game.print("You can't use the mop here.");
        }
        
    } 
}
