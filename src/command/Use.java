package command;

import important.Item;
import important.Player;
import world.WorldMap;

import java.util.Scanner;

public class Use extends Command {
    private WorldMap world = new WorldMap();

    //Uses an item
    @Override
    public String execute() {
        Player p = new Player();
        Item items = new Item();
        Scanner sc = new Scanner(System.in);
        System.out.println(">> What item would you like to use?");
        String item = sc.nextLine();
        int room = world.getCurrentId();
        //Goes through the whole inventory
        for (int i = 0; i < p.getInventory().size(); i++) {
            //Checks whether you have an item that you can use in this room
            if (room == items.getItems().get(p.getInventory().get(i).getId()).getUseWhere()) {
                //Checks if you want to use an item that you can use here
                if (p.getInventory().get(i).getName().equalsIgnoreCase(item)) {
                    //Goes through all the rooms
                    for (int j = 0; j < world.getWorld().size(); j++) {
                        //Checks what room you're in
                        if (world.getWorld().get(j).getId() == room) {
                            int id = p.getInventory().get(i).getId();
                            //Checks if the item is a key or not
                            if (items.getItems().get(id).getUnlockWhat() != -1) {
                                //Unlocks the door
                                world.getWorld().get(items.getItems().get(id).getUnlockWhat()).setLocked(false);
                                if (id == 7) {
                                    System.out.println("You can hear something opening somewhere..?");
                                    world.getWorld().get(1).setLocked(false);
                                }
                            } else {
                                if (id == 3) {
                                    p.addToInventory(items.getItems().get(5));
                                } else if (id == 5) {
                                    p.addToInventory(items.getItems().get(6));
                                }
                            }
                            //Removes the item you used from the inventory
                            p.removeFromInventory(id);
                            //Returns the use dialogue
                            return items.getItems().get(id).getUseDialogue();
                        }
                    }
                }
            }
        }
        return "You can't use that!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
