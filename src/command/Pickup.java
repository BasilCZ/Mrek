package command;

import important.Item;
import important.Player;
import world.WorldMap;

import java.util.Scanner;

public class Pickup extends Command {
    private WorldMap world = new WorldMap();
    @Override
    public String execute() {
        world.loadMap();
        Item items = new Item();
        items.loadItems();
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to pick up?");
        String item = sc.nextLine();
        int room = world.getCurrentId();
        for (int i = 0; i < items.getItems().size(); i++) {
            if(room == items.getItems().get(i).getRoomId()){
                if(items.getItems().get(i).getName().equalsIgnoreCase(item)){
                    Player p = new Player();
                    p.addToInventory(items.getItems().get(i));
                    return "You picked up " + items.getItems().get(i).getName();
                }
            }
        }
        return "You can't pick that up!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
