package command;

import important.Item;
import important.Player;
import world.WorldMap;

import java.util.Scanner;

public class Use extends Command{
    private WorldMap world = new WorldMap();
    @Override
    public String execute() {
        world.loadMap();
        Player p = new Player();
        Item items = new Item();
        Scanner sc = new Scanner(System.in);
        System.out.println(">> What item would you like to use?");
        String item = sc.nextLine();
        int room = world.getCurrentId();
        for (int i = 0; i < items.getItems().size(); i++) {
            if(room == items.getItems().get(i).getUseWhere()){
                if(items.getItems().get(i).getName().equalsIgnoreCase(item)){
                    p.removeFromInventory(items.getItems().get(i).getId());
                    return items.getItems().get(i).getUseDialogue();
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
