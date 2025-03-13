package command;

import important.Item;
import important.Player;

import java.util.Scanner;

public class Combine extends Command {
    @Override
    public String execute() {
        Player p = new Player();
        Scanner sc = new Scanner(System.in);
        System.out.println(p.getInventory());
        System.out.println(">> Which items do you wanna combine? (Type it in this format: ItemName1,ItemName2)");
        String input = sc.nextLine();
        boolean foundFirst = false;
        boolean foundSecond = false;
        for(int i = 0; i < p.getInventory().size(); i++) {
            if(p.getInventory().get(i).getId() == 0){
                foundFirst = true;
            }
            if(p.getInventory().get(i).getId() == 1){
                foundSecond = true;
            }
        }
        if(foundFirst && foundSecond && input.equals("Ladder part 1,Ladder part 2")){
            p.removeFromInventory(0);
            p.removeFromInventory(1);
            p.addToInventory(new Item("Ladder","Test",3));
            return ">> You sucessfully combined the parts into a fully working ladder!";
        } else {
            return ">> You can't combine that!";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
