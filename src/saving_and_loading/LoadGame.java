package saving_and_loading;

import important.Item;
import important.Player;
import world.Location;
import world.WorldMap;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class LoadGame {
    //Loads the save file
    public boolean load() throws IOException, ClassNotFoundException {
        WorldMap wm = new WorldMap();
        //Checks if the player has a save file
        if (new File("save.txt").exists()) {
            //Loads the save file
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream("save.txt"));
            WorldMap.setWorld((HashMap<Integer, Location>) stream.readObject());
            Player.setInventory((ArrayList<Item>) stream.readObject());
            wm.setCurrentPosition(stream.readInt());
            stream.close();
            return true;
        } else {
            //Loads nothing
            return false;
        }
    }
}
