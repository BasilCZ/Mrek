package command;

import important.Item;
import important.Npc;
import important.Player;
import world.WorldMap;

import java.util.Scanner;

public class Give extends Command {
    private WorldMap world = new WorldMap();

    @Override
    public String execute() {
        Player p = new Player();
        Npc npc = new Npc();
        Item item = new Item();
        Scanner sc = new Scanner(System.in);
        int room = world.getCurrentId();
        System.out.println(">> What would you like to give?");
        String give = sc.nextLine();
        //Goes through all the npcs
        for (int i = 0; i < npc.getNpcs().size(); i++) {
            //Check if there's a npc in the current room
            if (room == npc.getNpcs().get(i).getRoom()) {
                //Goes through the inventory
                for (int j = 0; j < p.getInventory().size(); j++) {
                    //Checks if you have an item that the npc wants and at the same time you wanna give it to them
                    if (npc.getNpcs().get(i).getWhatIWant() == p.getInventory().get(j).getId() && give.equalsIgnoreCase(p.getInventory().get(j).getName())) {
                        p.removeFromInventory(npc.getNpcs().get(i).getWhatIWant());
                        p.addToInventory(item.getItems().get(npc.getNpcs().get(i).getWhatIGive()));
                        return "You gave the " + item.getItems().get(npc.getNpcs().get(i).getWhatIWant()).getName() +
                                " to the " + npc.getNpcs().get(i).getName() +
                                " and they gave you " + item.getItems().get(npc.getNpcs().get(i).getWhatIGive()).getName() +
                                " in return!";
                    }
                }
            }
        }
        return "You cant give that!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
