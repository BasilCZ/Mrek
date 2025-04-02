package command;

import important.Item;
import important.Player;

import java.util.Scanner;

public class Combine extends Command {
    @Override
    public String execute() {
        Player p = new Player();
        Item item = new Item();
        Scanner sc = new Scanner(System.in);
        System.out.println(">> Which items do you wanna combine? (Type it in this format: ItemName1,ItemName2)");
        String input = sc.nextLine();
        boolean foundFirst = false;
        boolean foundSecond = false;
        //Goes through the inventory
        for (int i = 0; i < p.getInventory().size(); i++) {
            int id = p.getInventory().get(i).getId();
            //Found the first part of the ladder
            if (id == 0) {
                foundFirst = true;
            }
            //Found the second part of the ladder
            if (id == 1) {
                foundSecond = true;
            }
        }
        //Checks if you want to combine the ladder parts and also if you have them
        if (foundFirst && foundSecond && input.equals("Ladder part 1,Ladder part 2")) {
            p.removeFromInventory(0);
            p.removeFromInventory(1);
            p.addToInventory(item.getItems().get(3));
            return "You sucessfully combined the parts into a fully working ladder!";
        } else {
            return "You can't combine that!";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
