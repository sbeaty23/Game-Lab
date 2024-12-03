package game;

public class Housekeeper extends NPC {
    private int x;
    
    public Housekeeper(String n, String d){
        super(n, d);
    }

    @Override 
    public void knockOut(){
        Game.print("You want clean sheets, don't you? Don't knock out the housekeeper!");
    }

    @Override
    public void talk() {
        switch(dialogNum){
            case 0:
                say("Hi, How can I help you?");
                String[] options = {
                    "Hi! Can I have new blankets please?",
                    "I need blankets."
                };
                getResponse(options);
                dialogNum++;
                break;
            case 1:
                say( "Hello again. How can I help?");
                String[] options2 = {
                    "Hi! Can I have another pillowcase, please?",
                    "I need another pillowcase."
                };
                getResponse(options2);
                dialogNum++;
                break;
            case 5:
                switch(x){
                    case 0:
                        Game.print("You can't speak to the housekeeper. She seems very angry with you. \n Maybe there's something you can give her in exchange for forgiveness.");
                        break;
                    default:
                        say("Hello! What do you need?");
                        Game.print("The housekeeper is very friendly and helpful. Maybe she knows something.");
                        String[] options3 = {
                            "Do you know any way to get out of here?",
                            "Can I have another set of sheets, please?"
                        };
                        getResponse(options3);
                        break;
                }  

        }

    }
    @Override
    public void response(int option) {
        switch(dialogNum){
            case 0:
            case 3:
            case 6:
                switch(option) {
                case 1:
                    say("Yes! I'll bring them right up to your room!");
                    Game.print("She is delighted by your manners. You might be able to get some useful information out of her.");
                    break;
                case 2:
                    say("Yes.");
                    Game.print("Don't forget that she'll remember how you talk to her. You're trying to get out of here, NOT make enemies!");
                    break;
                }
            break;
            case 9:
            case 12:
            case 15:
                switch(option){
                    case 1:
                        x = 0;
                        say("Of course!");
                        Game.print("The housekeeper gets you a new pillowcase.");
                        break;
                    case 2:
                        x = 0;
                        say("Yes.");
                        Game.print("The housekeeper gets you a new pillowcase, but seems very angry.");
                        break;
                }
            break;
            case 70:
                switch(option){
                    case 1:
                        say("There's a lot, so please, listen.");
                        Game.print("You and the housekeeper go down to the maintenance room, where she tells you everything you need to know");
                        say("This hotel distorts your perception of time to keep you here forever. The employees are immune to its effects, but the guests think they've only been here for a few days or hours. In reality, it's been years.");
                        Game.print("The player is shocked, but listens.");
                        say("The only way out of here is with the key, but be warned, the casino will not let you leave.");
                        Game.print("The housekeeper gives you the mop needed to knock out the casino worker.");
                        Game.inventory.add(new Mop("mop","To clean. Or knock someone out. Maybe both. Your call"));
                        Game.print("The player asks the housekeeper about the key");
                        say("I don't know where it is! I'm sorry!");
                        Game.print("The player and the houekeeper walk back up to the 3rd floor.");
                }
            default:
                if (Game.find("mop")!=null && x==1){
                    dialogNum = 70;
                }
                else{
                    Game.print("The housekeeper is busy, you can't talk to her right now");
                    dialogNum++;
                }
        }
    }


}
