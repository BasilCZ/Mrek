package important;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Npc {
    private static HashMap<Integer,Npc> npcs = new HashMap<>();
    private String name;
    private HashMap<String,String> dialogue;
    private int id;
    private int room;
    private int whatIWant;
    private int whatIGive;

    public Npc() {
    }

    public Npc(String name, HashMap<String, String> dialogue, int id, int room, int whatIWant, int whatIGive) {
        this.name = name;
        this.dialogue = dialogue;
        this.id = id;
        this.room = room;
        this.whatIWant = whatIWant;
        this.whatIGive = whatIGive;
    }

    public boolean loadNpc(){
        try (BufferedReader br = new BufferedReader(new FileReader("npc.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                HashMap<String,String> map = new HashMap<>();
                String[] talking = lines[1].split(",");
                for (int i = 0; i < talking.length; i++) {
                    String[] talking2 = talking[i].split("-");
                    map.put(talking2[0],talking2[1]);
                }
                Npc npc = new Npc(
                        lines[0],
                        map,
                        Integer.parseInt(lines[2]),
                        Integer.parseInt(lines[3]),
                        Integer.parseInt(lines[4]),
                        Integer.parseInt(lines[5])
                );
                npcs.put(Integer.parseInt(lines[2]),npc);
            }
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
                ", whatIWant=" + whatIWant +
                ", whatIGive=" + whatIGive +
                '}';
    }

    public HashMap<Integer, Npc> getNpcs() {
        return npcs;
    }

    public int getRoom() {
        return room;
    }

    public HashMap<String, String> getDialogue() {
        return dialogue;
    }

    public int getWhatIWant() {
        return whatIWant;
    }

    public int getWhatIGive() {
        return whatIGive;
    }

    public String getName() {
        return name;
    }
}
