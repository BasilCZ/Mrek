import command.Console;
import important.Item;
import important.Player;
import world.WorldMap;

public class Main {
    public static void main(String[] args) {
        WorldMap wm = new WorldMap();
        if(wm.loadMap()){
            //player.Player.makeNewPlayer();
            Player p = new Player("Debil");
            p.addToInventory(new Item("Mec",0));
            Console c = new Console();
            c.start();
            System.out.println(wm.getWorld());
        } else {
            System.out.println("Error: World map could not be loaded");
        }
    }
}