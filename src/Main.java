import command.Console;
import important.Item;
import important.Npc;
import important.RoomDialogue;
import world.WorldMap;

public class Main {
    public static void main(String[] args) {
        WorldMap wm = new WorldMap();
        Item item = new Item();
        Npc npc = new Npc();
        RoomDialogue rd = new RoomDialogue();
        if(wm.loadMap()){
            if(rd.loadDialogue()){
                if(item.loadItems()){
                    if(npc.loadNpc()) {
                        Console c = new Console();
                        c.start();
                    } else {
                        System.out.println("Error: Couldn't load npcs");
                    }
                } else {
                    System.out.println("Error: Couldn't load items");
                }
            } else {
                System.out.println("Error: Couldn't load room dialogue");
            }
        } else {
            System.out.println("Error: World map could not be loaded");
        }
    }
}