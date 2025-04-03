import command.Console;
import important.Item;
import important.Npc;
import important.RoomDialogue;
import saving_and_loading.LoadGame;
import world.WorldMap;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        WorldMap wm = new WorldMap();
        Item item = new Item();
        Npc npc = new Npc();
        RoomDialogue rd = new RoomDialogue();
        //Nacist všechno přes metodu přístě!!!
        if (wm.loadMap()) {
            if (rd.loadDialogue()) {
                if (item.loadItems()) {
                    if (npc.loadNpc()) {
                        LoadGame load = new LoadGame();
                        try {
                            if (load.load()) {
                                System.out.println("The save file successfully loaded");
                            } else {
                                System.out.println("The save file couldn't have been loaded/There is no save file");
                            }
                        } catch (IOException | ClassNotFoundException e) {
                            //Nepoužívat throw new Runtime, protože ta hra spadne ---> používat e.getMessage()
                            //throw new RuntimeException(e);
                            System.out.println(e.getMessage());
                        }
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