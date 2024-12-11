package game;

public class CasinoChips extends Item {
    
    private int chips;
    public CasinoChips(String n, String d){
        super(n, d);
        chips = 0;
    }

    public int getAmount(){
        return chips;
    }

    public void setAmount(int c){
        chips = c;
    }

    public void exchange(int x){
        Game.money.setAmount(Game.money.getAmount()+x);
        this.setAmount(chips-x);
    }

}
