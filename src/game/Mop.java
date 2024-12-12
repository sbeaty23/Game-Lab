package game;
public class Mop extends Item {
    
    public Mop(String n, String d){
        super(n, d);
    }

    @Override
    public void use(){
        try{
            if(Game.commands.length==4){
                Game.currentRoom.getNPC(Game.commands[3]).knockOut();
                if(Game.currentRoom.getName().equals("casino")||Game.currentRoom.getName().equals("lobby")){
                    Game.currentRoom.setDescription(Game.currentRoom.getName()+"_A");
                    Game.print(Game.currentRoom);
                }
            }
            else{
                Game.print("You can't use the mop here.");
            }
        }
        catch(RuntimeException e){
            Game.print("Error doing action. Check your input.");
        }
    } 
}
