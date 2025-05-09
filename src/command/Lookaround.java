package command;

import important.RoomDialogue;
import world.WorldMap;

public class Lookaround extends Command {
    private WorldMap world = new WorldMap();

    //Returns info about the room you're in
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
