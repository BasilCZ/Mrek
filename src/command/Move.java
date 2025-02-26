package command;

import world.Location;
import world.WorldMap;

import java.util.Scanner;

public class Move extends Command{

    private Scanner sc = new Scanner(System.in);
    private Location currentLocation = new Location();
    private WorldMap world = new WorldMap();

    @Override
    public String execute() {
        world.loadMap();
        currentLocation = world.getCurrentPosition();
        System.out.println("You are currently at: " + currentLocation.getName());
        System.out.println("Where would you like to move?");
        //System.out.println(world.getCurrentPosition());
        String direction = sc.next();
        int moveId = -1;
        switch (direction){
            case "up":
                moveId = currentLocation.checkNeighbors(currentLocation,0);
                break;
            case "down":
                moveId = currentLocation.checkNeighbors(currentLocation,1);
                break;
            case "left":
                moveId = currentLocation.checkNeighbors(currentLocation,2);
                break;
            case "right":
                moveId = currentLocation.checkNeighbors(currentLocation,3);
                break;
            default:
                System.out.println("Invalid direction!");
        }
        if(moveId == -1){
            return "You can't go in that direction!";
        } else {
            world.setCurrentPosition(moveId);
            return "You moved to: " + world.getName();
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}