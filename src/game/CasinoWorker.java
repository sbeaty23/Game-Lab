package game;

public class CasinoWorker extends NPC{
    
    public CasinoWorker(String n,String d){
        super(n,d);
    }
    @Override
    public void knockOut(){
        knockedOut = true;
        Game.print("Will is knocked out! Now is your chance to escape!");
    }
    @Override
    public void talk() {
        switch(dialogNum){
            case 0:
                say("What do you need, more chips?");
                String[] options = {
                    "Yes. More chips, please!",
                    "No. How do I get out of here?"
                };
                getResponse(options);
                dialogNum++;
                break;
            case 1:
                say( "More chips?");
                String[] options2 = {
                    "Yes!",
                    "No, thank you!"
                };
                getResponse(options2);
                dialogNum++;
                break;
            case 2:
                say("I don't know why you keep coming over here. Just stay away from the door!");  
                String[] options3 = {
                    "I'll try to stay away from the door.",
                    "I need more chips."
                };
                getResponse(options3);
                break;
            default:
                Game.print("Will doesn't want to talk. He just gives you more chips.");
                Game.chips.setAmount(Game.chips.getAmount()+50);
        }
    }

    @Override
    public void response(int option) {
        switch(dialogNum){
            case 0:
                switch(option) {
                case 1:
                    say("Here you go.");
                    Game.print("The player recieves more chips");
                    Game.chips.setAmount(Game.chips.getAmount()+50);
                    dialogNum-=1;
                    break;
                case 2:
                    say("Huh? What are you talking about? Nobody asks that. Get out of here!");
                    Game.print("Confused, the player walks away.");
                    break;
                }
            break;
            case 1:
                switch(option){
                    case 1:
                        say("Here you go.");
                        Game.print("The player recieves more chips");
                        Game.chips.setAmount(Game.chips.getAmount()+50);
                        dialogNum-=1;
                        break;
                    case 2:
                        say("Then stop wasting my time!");
                        Game.print("The player gets angry and walks away.");
                        break;
                }
            break;
            case 2:
                switch(option){
                    case 1:
                        say("Good, now I need to get back to work.");
                    case 2:
                        say("Here you go.");
                        Game.print("The player recieves more chips");
                        Game.chips.setAmount(Game.chips.getAmount()+50);
                        dialogNum-=1;
                }    
        }
    }
}
