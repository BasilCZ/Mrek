package important;

import world.Location;

public class Item {
    private String name;
    private int id;
    private Location room;

    public Item(String name, int id) {
        this.name = name;
        this.id = id;

    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
