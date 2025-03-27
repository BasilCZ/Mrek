package saving_and_loading;

import important.Player;
import world.WorldMap;

import java.io.*;

public class SaveGame {
    public boolean save(){
        Player p = new Player();
        WorldMap wm = new WorldMap();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("save.txt"));
            stream.writeObject(wm.getWorld()); //All the rooms and their values
            stream.writeObject(p.getInventory()); //Player's inventory
            stream.writeInt(wm.getCurrentId()); //Player's current location
            stream.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
