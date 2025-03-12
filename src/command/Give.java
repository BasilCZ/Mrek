package command;

import important.Player;
import world.WorldMap;

import java.util.Scanner;

public class Give extends Command{
    private WorldMap world = new WorldMap();
    @Override
    public String execute() {
        world.loadMap();
        Player p = new Player();
        Scanner sc = new Scanner(System.in);
        int room = world.getCurrentId();
        System.out.println("What would you like to give?");
        String give = sc.nextLine();
        switch(room){
            case 2:
                for (int i = 0; i < p.getInventory().size(); i++) {
                    if(give.equals("Sausage") && p.getInventory().get(i).getId() == 2){
                        p.getInventory().remove(i);
                        //You get something in exchange
                        return "You gave the sausage to the prisoner and he gave you a ------";
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
