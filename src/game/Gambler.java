package game;

public class Gambler extends NPC {
    
    public Gambler(String n, String d){
        super(n, d);
    }

    @Override
    public void talk() {
        switch(dialogNum){
            case 0:
                say("Hey there! What can I do for you?");
                String[] options = {
                    "Can I get some tips?",
                    "Do you know anything about this place?"
                };
                getResponse(options);
                dialogNum++;
                break;
            default:
                say("Go ahead and try your luck!");

        }
    }

    @Override
    public void response(int option) {
        switch(dialogNum){
            case 0:
                switch(option) {
                case 1:
                    say("I've only been doing this for a little bit, but from what I've experienced, it's all luck.");
                    break;
                case 2:
                    say("Nope. Sorry about that.");
                    break;
                }
            break;
        }
    }
}
