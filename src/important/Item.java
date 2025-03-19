package important;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Item {
    private static HashMap<Integer,Item> items = new HashMap<>();
    private String name;
    private String description;
    private int id;
    private int roomId;
    private int useWhere;
    private int unlockWhat;
    private String useDialogue;

    public boolean loadItems(){
        Player p = new Player();
        try (BufferedReader br = new BufferedReader(new FileReader("items.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                Item item = new Item(
                        lines[0],
                        lines[1],
                        Integer.parseInt(lines[2]),
                        Integer.parseInt(lines[3]),
                        Integer.parseInt(lines[4]),
                        Integer.parseInt(lines[5]),
                        lines[6]
                );
                p.addToInventory(item);
                items.put(Integer.valueOf(lines[2]), item);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }


    public Item() {
    }

    public Item(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public Item(String name, String description, int id, int roomId, int useWhere, int unlockWhat, String useDialogue) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.roomId = roomId;
        this.useWhere = useWhere;
        this.unlockWhat = unlockWhat;
        this.useDialogue = useDialogue;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", roomId=" + roomId +
                ", useWhere=" + useWhere +
                ", useDialogue='" + useDialogue + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public HashMap<Integer, Item> getItems() {
        return items;
    }

    public int getUseWhere() {
        return useWhere;
    }

    public String getUseDialogue() {
        return useDialogue;
    }

    public int getUnlockWhat() {
        return unlockWhat;
    }
}