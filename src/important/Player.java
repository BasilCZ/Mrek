package important;

import java.util.ArrayList;

public class Player {
    private static ArrayList<Item> inventory = new ArrayList<>();

    public Player() {
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public void removeFromInventory(int id){
        //Goes through the inventory and finds an item with the same id and then removes it
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getId() == id){
                inventory.remove(i);
            }
        }
    }
}
