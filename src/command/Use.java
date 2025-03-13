package command;

import important.Item;
import important.Player;
import world.WorldMap;

import java.util.Scanner;

public class Use extends Command{
    private WorldMap world = new WorldMap();
    @Override
    public String execute() {
        Player p = new Player();
        Item items = new Item();
        Scanner sc = new Scanner(System.in);
        System.out.println(">> What item would you like to use?");
        String item = sc.nextLine();
        int room = world.getCurrentId();
        for (int i = 0; i < p.getInventory().size(); i++) {
            if(room == items.getItems().get(i).getUseWhere()){
                if(p.getInventory().get(i).getName().equalsIgnoreCase(item)){
                    for (int j = 0; j < world.getWorld().size(); j++) {
                        if(world.getWorld().get(j).getId() == room){
                            p.removeFromInventory(items.getItems().get(i).getId());
                            world.getWorld().get(j).setLocked(false);
                            return items.getItems().get(i).getUseDialogue();
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
