package game;

public class ArcadeWorker extends NPC {

    public ArcadeWorker(String n, String d){
        super(n, d);
    }

    @Override
    public void talk() {
        switch(dialogNum){
            case 0:
                say("Hey, your game card is unlimited, No need to bother me.");
                String[] options = {
                    "Okay.",
                    "How do I get out of here? This place seems off!"
                };
                getResponse(options);
                break;
            default:
                say("Leave me alone! I'm busy!");

        }

    }
    @Override
    public void response(int option) {
        switch(dialogNum){
            case 0:
                switch(option) {
                case 1:
                    Game.print("The player walks away.");
                    break;
                case 2:
                    say("Talk to the hosuekeeper. She might feel generous and want to help. She's on the third floor.");
                    break;
                }
        }
    }
    
}
