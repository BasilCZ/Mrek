import command.Console;
import important.Item;
import important.Npc;
import important.RoomDialogue;
import saving_and_loading.LoadGame;
import world.WorldMap;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WorldMap wm = new WorldMap();
        Item item = new Item();
        Npc npc = new Npc();
        RoomDialogue rd = new RoomDialogue();
        if (wm.loadMap()) {
            if (rd.loadDialogue()) {
                if (item.loadItems()) {
                    if (npc.loadNpc()) {
                        LoadGame load = new LoadGame();
                        ArrayList<Object> list = null;
                        try {
                            if (load.load()) {
                                System.out.println("The save file successfully loaded");
                            } else {
                                System.out.println("The save file couldn't have been loaded/There is no save file");
                            }
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
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