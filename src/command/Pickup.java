package command;

import important.Item;
import important.Player;
import world.WorldMap;

import java.util.Scanner;

public class Pickup extends Command {
    private WorldMap world = new WorldMap();

    //Picks up an item
    @Override
    public String execute() {
        Item items = new Item();
        Player p = new Player();
        Scanner sc = new Scanner(System.in);
        System.out.println(">> What would you like to pick up?");
        String item = sc.nextLine();
        int room = world.getCurrentId();
        //Goes through all the items in the game
        for (int i = 0; i < items.getItems().size(); i++) {
            //Checks if there's an item in this room
            if (room == items.getItems().get(i).getRoomId()) {
                //Checks if you want to pick up that item
                if (items.getItems().get(i).getName().equalsIgnoreCase(item)) {
                    p.addToInventory(items.getItems().get(i));
                    items.getItems().get(i).setRoomId(-1);
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
