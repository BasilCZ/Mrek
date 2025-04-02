package command;

import important.Npc;
import world.WorldMap;

import java.util.Scanner;

public class Talk extends Command {
    private WorldMap world = new WorldMap();

    //Gives you npc dialogue
    @Override
    public String execute() {
        Npc npc = new Npc();
        int room = world.getCurrentId();
        //Goes through all the npcs
        for (int i = 0; i < npc.getNpcs().size(); i++) {
            //Checks if there's a npc in this room
            if (npc.getNpcs().get(i).getRoom() == room) {
                Scanner sc = new Scanner(System.in);
                String allKeys = npc.getNpcs().get(i).getDialogue().keySet().toString();
                allKeys = allKeys.replace("[", "");
                allKeys = allKeys.replace("]", "");
                String keys[] = allKeys.split(", ");
                System.out.println(">> There's the " + npc.getNpcs().get(i).getName());
                System.out.println(">> What would you like to ask them?");
                //Prints all the dialogue choices
                for (int j = 0; j < npc.getNpcs().get(i).getDialogue().size(); j++) {
                    System.out.println(keys[j]);
                }
                String input = sc.nextLine();
                //Checks if the user typed one of the dialogue choices
                if (npc.getNpcs().get(i).getDialogue().containsKey(input)) {
                    return npc.getNpcs().get(i).getDialogue().get(input);
                } else {
                    return "Invalid dialogue option!";
                }
            }
        }
        return "There's nobody to talk to!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
