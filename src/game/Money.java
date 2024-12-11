package game;

public class Money extends Item {
    static int amount; 
    public Money(String n,String d){
        super(n,d);
        amount = 0;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int a){
        amount = a;
    }

    public void exchange(int x){
        Game.chips.setAmount(Game.chips.getAmount()+x);
        this.setAmount(amount-x);
    }
}
