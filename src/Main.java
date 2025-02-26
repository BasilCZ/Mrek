import command.Console;
import world.WorldMap;

public class Main {
    public static void main(String[] args) {
        WorldMap wm = new WorldMap();
        wm.loadMap();
        Console c = new Console();
        c.start();
        System.out.println(wm.getWorld());
    }
}