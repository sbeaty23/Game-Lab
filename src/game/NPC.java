package game;

import javax.swing.*;


public class NPC {
    private String name; // NPC's name
    private String desc; // NPC's description
    static boolean knockedOut; 
    static boolean isBribed;
    int dialogNum;
    public NPC(String name, String desc) {
        knockedOut = false;
        isBribed = true;
        this.name = name;
        this.desc = desc;
        this.dialogNum = 0;
        
    }
    public String getName() {
        return name;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void say(String dialog) {
        Game.print(name+": "+dialog);
    }
    public void talk() {
        Game.print("You can't talk to "+name+".");
    }
    public void response(int option) {
        // This method intentionally left blank.
    }
    public void getResponse(String[] options) {
        String s = "";
        for (int i = 0; i < options.length; i++) {
        s += "Option " + (i + 1) + ": " + options[i] + "\n";
        }
        s += "Enter an option (1-" + options.length + "):";
        int option = Integer.parseInt(JOptionPane.showInputDialog(s));
        response(option);
    }
    public void knockOut(){
        Game.print("You try to knock out " + name+", but you can't!");
    }
    public void bribe(){
    }
}