package important;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Npc {
    private HashMap<Integer,Npc> npcs = new HashMap<>();
    private String name;
    private String dialogue;
    private int id;
    private int room;

    public Npc() {
    }

    public Npc(String name, String dialogue, int id, int room) {
        this.name = name;
        this.dialogue = dialogue;
        this.id = id;
        this.room = room;
    }

    public Npc(String name, String dialogue, int room) {
        this.name = name;
        this.dialogue = dialogue;
        this.room = room;
    }

    public boolean loadNpc(){
        try (BufferedReader br = new BufferedReader(new FileReader("npc.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                Npc npc = new Npc(
                        lines[0],
                        lines[1],
                        Integer.parseInt(lines[2]),
                        Integer.parseInt(lines[3])
                );
                npcs.put(Integer.parseInt(lines[2]),npc);
            }
            System.out.println(npcs);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Npc{" +
                "name='" + name + '\'' +
                ", dialogue='" + dialogue + '\'' +
                ", id=" + id +
                ", room=" + room +
                '}';
    }

    public HashMap<Integer, Npc> getNpcs() {
        return npcs;
    }

    public int getRoom() {
        return room;
    }

    public String getDialogue() {
        return dialogue;
    }
}
