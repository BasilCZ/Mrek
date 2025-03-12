package command;

import important.Npc;
import world.WorldMap;

public class Talk extends Command {
    private WorldMap world = new WorldMap();

    @Override
    public String execute() {
        world.loadMap();
        Npc npc = new Npc();
        npc.loadNpc();
        int room = world.getCurrentId();
        for (int i = 0; i < npc.getNpcs().size(); i++) {
            if(npc.getNpcs().get(i).getRoom() == room){
                return npc.getNpcs().get(i).getDialogue();
            }
        }
        return "There's nobody to talk to!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
