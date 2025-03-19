package command;

import important.RoomDialogue;
import world.Location;
import world.WorldMap;

public class Lookaround extends Command {
    private WorldMap world = new WorldMap();
    @Override
    public String execute() {
        int currentLocation = world.getCurrentId();
        return RoomDialogue.getDialogue().get(currentLocation);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
