package command;

import world.Location;
import world.WorldMap;

public class Lookaround extends Command {
    private WorldMap world = new WorldMap();
    @Override
    public String execute() {
        int currentLocation = world.getCurrentId();
        System.out.println(currentLocation);
        return switch (currentLocation) {
            case 0 -> "Prison";
            case 1 -> "Secret room";
            default -> "";
        };
    }

    @Override
    public boolean exit() {
        return false;
    }
}
