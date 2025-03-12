package command;

import important.Player;
import world.WorldMap;

import java.util.Scanner;

public class Use extends Command{
    private WorldMap world = new WorldMap();
    @Override
    public String execute() {
        world.loadMap();
        Player p = new Player();
        Scanner sc = new Scanner(System.in);
        System.out.println("What item would you like to use?");
        String item = sc.nextLine();
        int room = world.getCurrentId();
        switch(room){
            case 12:
                for (int i = 0; i < p.getInventory().size(); i++) {
                    if(item.equals("Key to the gate") && p.getInventory().get(i).getId() == 7){
                        p.removeFromInventory(7);
                        return "You unlocked the gate";
                    }
                }
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
