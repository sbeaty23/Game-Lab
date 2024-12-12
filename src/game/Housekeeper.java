package game;

public class Housekeeper extends NPC {
    
    public Housekeeper(String n, String d){
        super(n, d);
    }

    @Override 
    public void knockOut(){
        Game.print("You want clean sheets, don't you? Don't knock out the housekeeper!");
    }

    @Override
    public void bribe(){
        Game.print("I guess converation isn't your thing. Luckily, the housekeeper likes money.");
        dialogNum = 70;
    }
    @Override
    public void talk() {
        switch(dialogNum){
            case 0:
            case 7:
                say("Hi, How can I help you?");
                String[] options = {
                    "Hi! Can I have new blankets please?",
                    "Hi! Can I get some new towles, please?"
                };
                getResponse(options);
                dialogNum++;
                break;
            case 12:
            case 15:
            case 20:                say( "Hello again. How can I help?");
                String[] options2 = {
                    "Hi! Can I have another pillowcase, please?",
                    "Hi! Can I have another pillow, please?"
                };
                getResponse(options2);
                dialogNum++;
                break;
            case 70:
                say("There's a lot, so please, listen.");
                Game.print("You and the housekeeper go down to the maintenance room, where she tells you everything you need to know");
                say("This hotel distorts your perception of time to keep you here forever. The employees are immune to its effects, but the guests think they've only been here for a few days or hours. In reality, it's been years.");
                Game.print("The player is shocked, but listens.");
                say("The only way out of here is with the key in the Owner's office, but be warned, the casino worker will not let you leave, and the Owner obviously won't just let you in his office.");
                Game.print("The housekeeper gives you the combination needed to ge the key in the safe.");
                Game.inventory.add(new Combination("combo","To open the safe"));
                Game.print("The player asks the housekeeper about the key to the casino.");
                say("It's in the safe!");   
                Game.print("The player and the houekeeper walk back up to the 3rd floor.");
                say("Best of luck!");
        default:
            if (Game.find("mop")!=null){
                dialogNum = 70;
                Game.print("The housekeeper is busy, try again later.");
            }
            else{
                Game.print("The housekeeper is busy, you can't talk to her right now");
                dialogNum++;
            }        }

    }
    @Override
    public void response(int option) {
        switch(dialogNum){
            case 0:
            case 3:
                switch(option) {
                case 1:
                    say("Yes! I'll bring them right up to your room!");
                    Game.print("She is delighted by your manners. You might be able to get some useful information out of her.");
                    break;
                case 2:
                say("Yes! I'll bring them right up to your room!");
                break;
                }
            break;
            case 2:
            case 5:
            case 10:
                switch(option){
                    case 1:
                        say("Of course!");
                        Game.print("The housekeeper gets you a new pillowcase.");
                        break;
                    case 2:
                        say("Of course!");
                        Game.print("The housekeeper gets you a new pillow.");
                        break;
                }
                break;
        }
    }


}
