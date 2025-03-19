package world;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class WorldMap {

    private static HashMap<Integer, Location> world = new HashMap<>();
    private int start = 0;
    private static int currentPosition = 0;

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("map.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                Location location = new Location(
                        lines[1],
                        Integer.parseInt(lines[0]),
                        Arrays.copyOfRange(lines, 2, 6),
                        Boolean.parseBoolean(lines[6])
                );
                world.put(Integer.valueOf(lines[0]), location);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public Location getCurrentPosition(){
        return world.get(currentPosition);
    }
    public int getCurrentId(){
        return currentPosition;
    }

    public void setCurrentPosition(int newPosition){
        currentPosition = newPosition;
    }

    public HashMap<Integer, Location> getWorld() {
        return world;
    }

    public String getName(){
        return world.get(currentPosition).getName();
    }
}