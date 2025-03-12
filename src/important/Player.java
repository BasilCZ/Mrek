package important;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private static ArrayList<Item> inventory = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public static Player makeNewPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = sc.next();
        return new Player(name);
    }

    public void removeFromInventory(int id){
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getId() == id){
                inventory.remove(i);
            }
        }
    }
}
