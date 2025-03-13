import command.Console;
import important.Item;
import important.Npc;
import important.Player;
import world.WorldMap;

public class Main {
    public static void main(String[] args) {
        WorldMap wm = new WorldMap();
        Item item = new Item();
        Npc npc = new Npc();
        if(wm.loadMap()){
            if(item.loadItems()){
                if(npc.loadNpc()) {
                    Player p = new Player("Debil");
                    p.addToInventory(new Item("Key to the gate", "C", 7));
                    Console c = new Console();
                    c.start();
                } else {
                    System.out.println("Error: Couldn't load npcs");
                }
            } else {
                System.out.println("Error: Couldn't load items");
            }
        } else {
            System.out.println("Error: World map could not be loaded");
        }
    }
}