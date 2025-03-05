import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Item> inventory = new ArrayList<>();

    public ArrayList<Item> getInventory() {
        return inventory;
    }
}
