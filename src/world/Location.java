package world;

import java.util.Arrays;

public class Location {

    private String name;
    private int id;
    private int[] locations;

    public Location(){

    }

    public Location(String name, int id, String[] locations) {
        this.name = name;
        this.id = id;
        this.locations = new int[4];
        for (int i = 0; i < locations.length; i++) {
            this.locations[i] = Integer.parseInt(locations[i]);
        }
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", ID=" + id +
                ", locations=" + Arrays.toString(locations) +
                '}';
    }

    public Integer checkNeighbors(Location loc, int direction){
        return loc.getLocations()[direction];
    }

    public int[] getLocations() {
        return locations;
    }

    public String getName() {
        return name;
    }
}