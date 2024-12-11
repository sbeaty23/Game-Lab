package game;

public class Puppy extends NPC {
    private int num = 0;
    
public Puppy() {
    super("puppy", "A hideous puppy wags his tail.");
    }

    public static void playFetch(){
        Game.print("The player throws the ball.\nThe puppy happily runs after it, and brings it back to the player.\nThe puppy licks the player's hand");    
    }

    @Override
    public void knockOut(){
        if(num<4){
            Game.print("Really? You wanted to knock out the puppy? Really? What kind of person are you? You obviously can't knock out the puppy, you monster. Go to your room and think about what you've done.");
            Game.print("The player walks to their room to think about their despicable actions.");
            Game.currentRoom = Game.currentRoom.getExit('w').getExit('w').getExit('u').getExit('e').getExit('d');
            Game.print(Game.currentRoom);
            num++;
        }
        else{
            Game.print("Game Over. You're stuck here forever. Karma's a bitch.");
            Game.gameOver = true;
        }
    }

    @Override
    public void talk() {
        switch(dialogNum){
            case 0:
                say("Hi! I'm an adorable puppy!");
                String[] options = {
                    "Yes you are! Who's a good boy?",
                    "Ew, no. You're actually kinda hideous."
                };
                getResponse(options);
                dialogNum++;
                break;
            case 1:
                say( "Hey! Wanna play fetch? Say yes! Say yes!");
                String[] options2 = {
                    "Yes! I love fetch!",
                    "No. I am a horrible person and don't like playing with puppies."
                };
                getResponse(options2);
                dialogNum++;
                break;
            case 2:
                say("Yip!");  
                Game.print("The puppy wags his tail");  
        }
    }
    @Override
    public void response(int option) {
        switch(dialogNum){
            case 0:
                switch(option) {
                case 1:
                    say("I am! I'm a good boy!");
                    break;
                case 2:
                    say("I am adorable! Why are you so mean?");
                    Game.print("The puppy bites you. You deserve it.");
                    break;
                }
            break;
            case 1:
                switch(option){
                    case 1:
                        say("Yay! Fetch!");
                        Game.print("The puppy runs off and returns with a ball. The player receives the ball.");
                        Game.inventory.add(new Item("ball","to play fetch with"));
                        break;
                    case 2:
                        say("You're a bad person! I don't like you!");
                        Game.print("The puppy runs away and doesn't come back.");
                        break;
                }
            break;
        }
    }
}
